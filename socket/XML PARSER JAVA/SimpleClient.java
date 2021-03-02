import java.net.*; 
import java.io.*;

public class SimpleClient 
{ 
  public static void main(String args[]) 
  {  
    try 
    { 
      System.out.println("Apertura connessione…"); 
      Socket s1 = new Socket ("10.10.3.35", 7777);
                    
      FileInputStream is = new FileInputStream("employees.xml");
      BufferedReader dis = new BufferedReader(new InputStreamReader(is));
      
      
      System.out.println("Risposta del server: " + dis.readLine());
      
      // Al termine, chiude lo stream di comunicazione e il socket. 
      dis.close(); 
      s1.close(); 
      System.out.println("Chiusura connessione effettuata"); 
    } 
    catch (ConnectException connExc) 
    { 
      System.err.println("Errore nella connessione "); 
    } 
    catch (IOException ex) 
    { 
      ex.printStackTrace(); 
    } 
  } 
}