/**
* 
* Client che invia una stringa al server multithreagind e riceve come risposta la grandezza
* della stringa inviata(intesa come numero di caratteri da cui è composta),
* se questo client invia la stringa "fine" o "FINE" la connessione con il server si chiude
*
* @author  Riggi Luigi
*  
*/
import java.io.*;
import java.net.*;
public class MultiClientRiggi {
  String nomeServer ="localhost";                  // indirizzo server locale  
  int portaServer   = 7777;                        
  Socket miosocket;                                
  BufferedReader tastiera;                         // buffer per l'input da tastiera  
  DataOutputStream outVersoServer;                 // stream di output
  BufferedReader inDalServer;                      // stream di input   
  
  public void comunica() {
    for (;;)                                     // ciclo infinito, termina con 'FINE' o 'fine'
    try{
      System.out.println("(4) utente, inserisci la stringa da trasmettere al server:"); 
      String stringaUtente = tastiera.readLine();
      //la spedisco al server 
      System.out.println("(5) CLIENT invia stringa al server e attendo ");
      outVersoServer.writeBytes( stringaUtente+'\n');
      //leggo la risposta dal server 
      String stringaRicevutaDalServer=inDalServer.readLine();
      System.out.println("(7) CLIENT attende risposta dal server "+'\n'+"Risposta server : "+stringaRicevutaDalServer );
      if  (stringaUtente.equals("FINE")|| stringaUtente.equals("fine")) { 
        System.out.println("(8) il CLIENT termina l'elaborazione e chiude la connessione" );
        miosocket.close();                             // chiudo la connessione
        break; 
      }
    } 
    catch (Exception e){
      System.out.println(e.getMessage());
      System.out.println("Errore durante la comunicazione col server!");
      System.exit(1);
    }
  }
  
  public Socket connetti(){
    System.out.println("(2) CLIENT partito in esecuzione ...");
    try{
      // input da tastiera
      tastiera = new BufferedReader(new InputStreamReader(System.in));
      //  miosocket = new Socket(InetAddress.getLocalHost(), 7777);
      miosocket = new Socket(nomeServer,portaServer);
      // associo due oggetti al socket per effettuare la scrittura e la lettura 
      outVersoServer = new DataOutputStream(miosocket.getOutputStream());
      inDalServer    = new BufferedReader(new InputStreamReader (miosocket.getInputStream()));
    } 
    catch (UnknownHostException e){
    System.err.println("Host sconosciuto"); } 
    catch (Exception e){
      System.out.println(e.getMessage());
      System.out.println("Errore durante la connessione!");
      System.exit(1);
    }
    return miosocket;
  }
  
  public static void main(String args[]) {
    MultiClientRiggi cliente = new MultiClientRiggi();
    cliente.connetti();
    cliente.comunica();
  }   
}


