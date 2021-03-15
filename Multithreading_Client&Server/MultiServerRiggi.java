/**
* 
* Server multithreading,prende le stringhe che inviano i client e restituisce
* la loro grandezza(intesa come numero di caratteri),se il client invia la stringa
* "fine" o "FINE" la connessione tra il client e questo server si chiude
*
* @author  Riggi Luigi
*  
*/
import java.net.*; 
import java.io.*; 
class ServerThread extends Thread {    
  ServerSocket server = null;
  Socket client = null;
  public ServerThread (Socket socket){ 
    this.client = socket; 
  } 
  
  public void run(){ 
    try{
      comunica();  
    }catch (Exception e){ 
      e.printStackTrace(System.out);  
    } 
  } 
  
  public void comunica ()throws Exception{ 
    BufferedReader inDalClient = new BufferedReader(new InputStreamReader (client.getInputStream()));
    DataOutputStream outVersoClient = new DataOutputStream(client.getOutputStream());
    for (;;){ 
      String stringaRicevuta = inDalClient.readLine();
      //String stringaModificata = stringaRicevuta.toUpperCase();
      int length = stringaRicevuta.length();
      String lunghezza = ("Lunghezza stringa pari a " + length + " caratteri");
      if (stringaRicevuta == null || stringaRicevuta.equals("fine") || stringaRicevuta.equals("FINE")){ 
        outVersoClient.writeBytes(" [server in chiusura] " + '\n'); 
        System.out.println("Stringa ricevuta sul server in chiusura  :" + stringaRicevuta); 
        break;
      }
      else{
        outVersoClient.writeBytes(lunghezza + '\n'); 
        System.out.println("6 Arrivato al server :" + stringaRicevuta); 
      }
    } 
    outVersoClient.close(); 
    inDalClient.close(); 
    System.out.println("(9) Chiusura socket" + client); 
    client.close(); 
  } 
} 
  
public class MultiServerRiggi{ 
  public void start(){ 
    try{
      ServerSocket serverSocket = new ServerSocket(7777); 
      for (;;) 
      { 
        System.out.println("(1) Server in attesa ... "); 
        Socket socket = serverSocket.accept(); 
        System.out.println("(3) Server socket  " + socket); 
        ServerThread serverThread = new ServerThread(socket); 
        serverThread.start();                                        // invoca automaticamente il metodo run()
      }                                                              //START
    }
    catch (Exception e){
      System.out.println(e.getMessage());
      System.out.println("Errore durante l'istanza del server !");
      System.exit(1);
    }
  } 
  
  public static void main (String[] args){ 
    MultiServerRiggi tcpMultithreadServer = new MultiServerRiggi(); 
    tcpMultithreadServer.start();    
  } 
}
