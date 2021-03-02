import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;

public class XMLParser
{
  public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
  {
    //Get Document Builder
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      //costruisco istanza factory
    DocumentBuilder builder = factory.newDocumentBuilder();                     //costruisco istanza bilder con factory
    
    //Build Document
    Document document = builder.parse(new File("employees.xml"));               //chiamo metodo parse del documento
    
    //Normalize the XML Structure; It's just too important !!
    document.getDocumentElement().normalize();                                  //normalizzazione il documento(file xml),
                                                                                //tira fuori le informazioni dal file
    
    //Here comes the root node
    Element root = document.getDocumentElement();                               //prende elemento xml 
    System.out.println(root.getNodeName());                                     //e lo stampa
    
    //Get all employees                                                         //prende lista
    NodeList nList = document.getElementsByTagName("employee");
    System.out.println("============================");
    
    visitChildNodes(nList);
  }
  
  //This function is called recursively
  private static void visitChildNodes(NodeList nList)
  {
    for (int temp = 0; temp < nList.getLength(); temp++)
    {
      Node node = nList.item(temp);
      if (node.getNodeType() == Node.ELEMENT_NODE)
      {
        System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
        //Check all attributes
        if (node.hasAttributes()) {
          // get attributes names and values
          NamedNodeMap nodeMap = node.getAttributes();
          for (int i = 0; i < nodeMap.getLength(); i++)
          {
            Node tempNode = nodeMap.item(i);
            System.out.println("Attr name : " + tempNode.getNodeName()+ "; Value = " + tempNode.getNodeValue());
          }
          if (node.hasChildNodes()) {
            //We got more childs; Let's visit them as well
            visitChildNodes(node.getChildNodes());
          }
        }
      }
    }
  }
}