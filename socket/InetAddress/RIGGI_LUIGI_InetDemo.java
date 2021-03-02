import java.io.*;  
import java.net.*;  
public class RIGGI_LUIGI_InetDemo
{  
  public static void main(String[] args)
  {  
    try
    {  
      InetAddress ip;
      ip=InetAddress.getByName("www.itisvallauri.net");  
      System.out.println("Host Name: "+ip.getHostName());  
      System.out.println("IP Address: "+ip.getHostAddress()); 
      String indirizzo = InetAddress.getLocalHost().getHostAddress(); 
      System.out.println("Host Address: "+indirizzo);
    }
    catch(Exception e)
    {
      System.out.println(e);
    }  
    try
    {
      System.out.println("\nINIZIO PEZZO AGGIUNTO PER PROVARE classe InetAddress");
      System.out.println("mio local host: " +InetAddress.getLocalHost());  //indirizzo locale della mia macchina
      System.out.println("mio indirizzo loopback: "+InetAddress.getLoopbackAddress()); //indirizzo locale di loopback
      System.out.println("qual'� l'indirizzo di amazon?");
      InetAddress ipAmazon=InetAddress.getByName("www.amazon.it");
      System.out.println("nome host: "+ipAmazon.getHostName()+"  indirizzo: "+ipAmazon.getHostAddress()); 
      //Alcuni siti hanno pi� indirizzi ip come oggetti,ecco come catturarli 
      System.out.println("Google");
      InetAddress[] google = InetAddress.getAllByName("www.google.com");
      for (InetAddress end : google) {
        System.out.println(end);
      } // end of for
    }
    catch(Exception e)
    {
      System.out.println(e);
    }      
  }  
} 