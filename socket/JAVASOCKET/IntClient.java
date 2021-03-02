/* RIGGI LUIGI 5F JAVA SOCKET */
/* CLIENT CHE INVIA UN NUMERO INTERO (1-10) CON RICEZIONE DI QUEST'ULTIMO ELEVATO AL QUADRATO */

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class IntClient{
  String nomeServer = "localhost";       //indirizzo server locale
  int portaServer = 9999;                //numero porta 
  Socket miosocket;
  BufferedReader tastiera;               //buffer input da tastiera
  int valoreInserito;                    //valore inserito dall' utente
  int valoreRicevutoDalServer;           //valore ricevuto dal server
  DataOutputStream outVersoServer;       //stream di output
  BufferedReader inDalServer;            //stream di input
  public void comunica(){
    try
    {                                                                            
      System.out.println("INSERIRE NUMERO DA 1 A 10 DA INVIARE AL SERVER"+"\n"+"(in caso di input non valido riceverai il quadrato di 0)"+'\n');
      Scanner input=new Scanner(System.in);
      int nr_inserito=input.nextInt();
      for (int i=1;i<=10;i++ ) {
        if (nr_inserito==i) {
          valoreInserito = nr_inserito;
        }
      }      
      //lo spedisco al server
      System.out.println("INVIO NUMERO AL SERVER");
      outVersoServer.write(valoreInserito);
      //leggo la risposta dal server
      valoreRicevutoDalServer=inDalServer.read();
      System.out.println("RISPOSTA SERVER: NUMERO ELEVATO AL QUADRATO : "+valoreRicevutoDalServer);
      //chiudo la connessione
      System.out.println("CHIUSURA CONNESSIONE");
      miosocket.close();
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
      System.out.println("Errore durante la comunicazione col server");
      System.exit(1);      
    }
  }
  
  public Socket connetti(){
    System.out.println("CLIENT PARTITO IN ESECUZIONE");
    try
    {
      tastiera = new BufferedReader(new InputStreamReader(System.in));   //input da tastiera
      miosocket = new Socket(nomeServer,portaServer);
      //associazione oggetti al socket per effettuare scrittura e lettura
      outVersoServer = new DataOutputStream(miosocket.getOutputStream());
      inDalServer = new BufferedReader(new InputStreamReader(miosocket.getInputStream()));
    }
    catch(UnknownHostException e){
    System.err.println("Host sconosciuto");}
    catch (Exception e)
    {
      System.out.println(e.getMessage());
      System.out.println("Errore durante la connessione!");
      System.exit(1);  
    }
    return miosocket;
  }
  
  public static void main(String args[]){
    IntClient cliente = new IntClient();
    cliente.connetti();
    cliente.comunica();
  }
}
