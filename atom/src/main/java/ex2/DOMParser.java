package ex2;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMParser {
    public static void main(String[] args) {
        try {
            File inputFile = new File("plants.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("plant");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Plant ID: " + eElement.getAttribute("plantID"));
                    System.out.println("Plant name: " + eElement.getElementsByTagName("plantName").item(0).getTextContent());
                    System.out.println("Botanical : "   + eElement.getElementsByTagName("botanical").item(0).getTextContent());
                    System.out.println("Zone: " + eElement.getElementsByTagName("zone").item(0).getTextContent());
                    System.out.println("Price: " + eElement.getElementsByTagName("price").item(0).getTextContent());

                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}