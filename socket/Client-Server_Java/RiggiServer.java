import java.io.*;
import java.net.*;
public class RiggiServer
{   
  public void GoServer(){ 
    try{       
      
      //CREAZIONE SERVER
      ServerSocket server = new ServerSocket(7777);
      System.out.println("Server socket creato");
      while(true){   
        
        //SOCKET CLIENT SI CONNETTE
        Socket connessione = server.accept();
        System.out.println("Un client si è connesso");
        
        //MESSAGGIO DAL CLIENT (INPUT)
        BufferedReader in=new BufferedReader(new InputStreamReader(connessione.getInputStream()));
        //InputStream messaggioClient = connessione.getInputStream();
        //InputStreamReader readerMessaggioClient = new InputStreamReader(messaggioClient); 
        //BufferedReader bufferMessaggioClient = new BufferedReader(readerMessaggioClient);
        System.out.println("Messaggio ricevuto dal client :"+in.readLine());
        
        //MESSAGGIO AL CLIENT (OUTPUT)     
        //OutputStream outputPerClient = connessione.getOutputStream(); 
        //BufferedWriter bufferOutputPerClient = new BufferedWriter(new OutputStreamWriter(outputPerClient));
        //bufferOutputPerClient.write("Benvenuto sul server!");
        DataOutputStream out= new DataOutputStream(connessione.getOutputStream());
        String messaggio="CONNESSIONE E TRASMISSIONE ANDATA A BUON FINE CON IL CLIENT";
        out.writeBytes(messaggio+'\n');
        System.out.println("Messaggio di risposta inviato al client: "+out);  
        
        //CHIUSURA CANALI
        System.out.println("Chiusura connessione");
        //bufferOutputPerClient.close();
        out.close();
        //bufferMessaggioClient.close();
        in.close();
        connessione.close();
        System.out.println("OK!");
        
      }        
    }catch(IOException ex){
      ex.printStackTrace();
    }    
  }          
    public static void main (String args[]){
     RiggiServer server = new RiggiServer();
     server.GoServer();
   }
}

//BufferedReader in=new BufferedReader(new InputStreamReader(client,getInputStream()));
//DataOutputStream out= new DataOutputStream(client, getOutputStream());
