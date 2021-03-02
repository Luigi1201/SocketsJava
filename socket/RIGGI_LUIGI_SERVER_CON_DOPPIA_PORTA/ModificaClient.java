import java.net.*; 
import java.io.*;

public class ModificaClient 
{ 
  public static void main(String args[]) 
  { 
    try 
    { 
      System.out.println("Apertura connessione"); 
      Socket s1 = new Socket ("127.0.0.1", 7777);
      Socket s2 = new Socket ("127.0.0.1", 7778);
      InputStream is = s1.getInputStream();
      InputStream is2 = s2.getInputStream(); 
      BufferedReader dis = new BufferedReader(new InputStreamReader(is));
      BufferedReader dis2 = new BufferedReader(new InputStreamReader(is2));
      
      System.out.println("Risposta del server: " + dis.readLine());
      System.out.println("Risposta del server: " + dis2.readLine());      
      dis.close(); 
      s1.close(); 
      dis2.close(); 
      s2.close(); 
      System.out.println("Chiusura connessioni effettuata"); 
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