import java.io.*;
import java.net.*; 

public class RiggiClient{                   
  public static void main(String args[]){
    //CONNESSIONE SENZA INVIO MESSAGGIO
    try
    { //Creazione del socket
      Socket socketClient = new Socket (InetAddress.getLocalHost().getHostAddress(), 7777);
      System.out.println("Socket creato");
      
      //INVIO MESSAGGIO AL SERVER
      //socketClient.getOutputStream().write(10);
      DataOutputStream out= new DataOutputStream(socketClient.getOutputStream());
      System.out.println("Stream passato: "+out);
      
      //RISPOSTA DEL SERVER
      //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
      BufferedReader in=new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
      System.out.println("Messaggio ricevuto dal server: "+/*bufferedReader*/in/*.readLine()*/);
      
      //CHIUSURA CANALI
      //bufferedReader.close();
      out.close();
      in.close();
      socketClient.close();
      
    }
    catch (ConnectException connExc) 
    { 
      System.err.println("Errore nella connessione "); 
    } 
    catch(IOException e)
    {
      e.printStackTrace();
    }  
    
    //CONNESSIONE CON INVIO STRINGA
    try
    { 
      Socket client = new Socket(InetAddress.getLocalHost().getHostAddress(),7777);
      System.out.println("SOCKET2 CREATO");
      
      DataOutputStream out=new DataOutputStream(client.getOutputStream());
      String messaggio="Sono il client!";
      out.writeBytes(messaggio);
      System.out.println("MESSAGGIO INVIATO DAL CLIENT AL SERVER");
      
      BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
      System.out.println("Messaggio ricevuto dal server: "+in.readLine());
      
      System.out.println("CHIUSURA CONNESSIONE");
      out.close();
      in.close();
      client.close();
    }
    catch (ConnectException connExc) 
    { 
      System.err.println("Errore nella connessione "); 
    } 
    catch(IOException e)
    {
      e.printStackTrace();
    }  
  }
}

//BufferedReader in=new BufferedReader(new InputStreamReader(client,getInputStream()));
//DataOutputStream out= new DataOutputStream(client, getOutputStream());