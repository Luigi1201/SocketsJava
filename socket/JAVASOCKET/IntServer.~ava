/* RIGGI LUIGI 5F JAVA SOCKET */
/* SERVER CHE RICEVE NUMERO INTERO,LO MOLTIPLICA AL QUADRATO E LO RISPEDISCE AL CLIENT*/

import java.io.*;
import java.net.*;
import java.util.*;
public class IntServer
{
  ServerSocket server = null;
  Socket client = null;
  int valoreRicevuto;
  int valoreModificato;
  BufferedReader inDalClient;
  DataOutputStream outVersoClient;
  public Socket attendi(){
    try
    {
      System.out.println("SERVER PARTITO IN ESECUZIONE");
      //creo un server sulla porta 9999
      server = new ServerSocket(9999);
      //rimane in attesta di un client
      client = server.accept();
      //chiudo il server per inibire altri clienti
      server.close();
      //associo due oggetti al socket del client per effettuare la scrittura e la lettura
      inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
      outVersoClient = new DataOutputStream(client.getOutputStream()) ;
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      System.out.println("Errore durante l'istanza del server!");
      System.exit(1);
    }
    return client;         
  }
  public void comunica(){
    try
    {
      //rimango in attesa del valore trasmesso dal client
      System.out.println("SCRIVI UN NUMERO DA 1 A 10 E RICEVERAI QUEST'ULTIMO ELEVATO AL QUADRATO");
      valoreRicevuto = inDalClient.read();
      System.out.println("RICEVUTO DAL CLIENT: " +valoreRicevuto);
      
      //calcolo il quadrato e lo rispedisco al client
      valoreModificato=(int)Math.pow(valoreRicevuto, 2);
      System.out.println("INVIO DEL NUMERO ELEVATO AL QUADRATO AL CLIENT");
      outVersoClient.write(valoreModificato);
      
      //termina elaborazione sul server : chiudo la connessione del client
      System.out.println("CHIUSURA CONNESSIONE");
      client.close();
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      System.out.println("SERVER : errore nella comunicazione ");
      System.exit(1);
    }
  }
  public static void main(String args[]){
    IntServer servente = new IntServer();
    servente.attendi();
    servente.comunica();
  }
}
