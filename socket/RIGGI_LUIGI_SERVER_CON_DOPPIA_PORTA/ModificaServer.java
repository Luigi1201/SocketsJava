import java.net.*; 
import java.io.*;

public class ModificaServer
{ 
  private int port; 
  private ServerSocket server;
  
  public ModificaServer(int port) 
  { 
    this.port = port; 
    if(!startServer()) 
    System.err.println("Errore durante la creazione del Server"); 
  }  
  private boolean startServer() 
  { 
    try 
    { 
      server = new ServerSocket(port); 
    } 
    catch (IOException ex) 
    { 
      ex.printStackTrace(); 
      return false; 
    } 
    return true; 
  }
  
  public void runServer() 
  { 
    boolean notreceived=true;     
    while (notreceived) 
    { 
      try 
      { 
        System.out.println("Server in attesa di richieste"); 
        Socket s1 = server.accept(); 
        System.out.println("Client connesso sulla porta "+this.port);
        notreceived=false;           
        OutputStream s1out = s1.getOutputStream(); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1out));    
        bw.write("Client connesso con successo, feedback ricevuto");
        bw.close(); 
        s1.close(); 
        System.out.println("Chiusura connessione effettuata."); 
      } 
      catch (IOException ex) 
      { 
        ex.printStackTrace(); 
      } 
    } 
  }
  
  public static void main (String args[]) 
  { 
    ModificaServer ss = new ModificaServer(7777); 
    ModificaServer ss2 = new ModificaServer(7778); 
    ss.runServer();
    ss2.runServer(); 
  } 
}