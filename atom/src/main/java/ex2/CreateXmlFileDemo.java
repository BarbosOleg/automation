package ex2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateXmlFileDemo {
    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // tag0 - catalog
            Element rootElement = doc.createElement("catalog");
            doc.appendChild(rootElement);

                    // tag1 - category
                    Element category = doc.createElement("category");
                    rootElement.appendChild(category);

                    Attr attr = doc.createAttribute("section");
                    attr.setValue("plants");
                    category.setAttributeNode(attr);

                        //tag2 - plant
                        Element plant = doc.createElement("plant");
                        category.appendChild(plant);

                        Attr attr1 = doc.createAttribute("plantID");
                        attr1.setValue("101");
                        plant.setAttributeNode(attr1);
                            //t1 - plantName
                            Element plantName = doc.createElement("plantName");
                            plantName.appendChild(doc.createTextNode("Bloodroot"));
                            plant.appendChild(plantName);
                            //t2 - botanical
                            Element botanical = doc.createElement("botanical");
                            botanical.appendChild(doc.createTextNode("Sanguinaria canadensis"));
                            plant.appendChild(botanical);
                            //t3 - zone
                            Element zone = doc.createElement("zone");
                            zone.appendChild(doc.createTextNode("3"));
                            plant.appendChild(zone);
                            //t4 - price
                            Element price = doc.createElement("price");
                            price.appendChild(doc.createTextNode("$2.44"));
                            plant.appendChild(price);

                        //tag2 - plant
                        Element plant2 = doc.createElement("plant");
                        category.appendChild(plant2);

                        Attr attr2 = doc.createAttribute("plantID");
                        attr2.setValue("102");
                        plant2.setAttributeNode(attr2);
                            //t1 - plantName
                            Element plantName2 = doc.createElement("plantName");
                            plantName2.appendChild(doc.createTextNode("Columbine"));
                            plant2.appendChild(plantName2);
                            //t2 - botanical
                            Element botanical2 = doc.createElement("botanical");
                            botanical2.appendChild(doc.createTextNode("Aquilegia canadensis"));
                            plant2.appendChild(botanical2);
                            //t3 - zone
                            Element zone2 = doc.createElement("zone");
                            zone2.appendChild(doc.createTextNode("4"));
                            plant2.appendChild(zone2);
                            //t4 - price
                            Element price2 = doc.createElement("price");
                            price2.appendChild(doc.createTextNode("$9.37"));
                            plant2.appendChild(price2);
                        //tag2 - plant
                        Element plant3 = doc.createElement("plant");
                        category.appendChild(plant3);

                        Attr attr3 = doc.createAttribute("plantID");
                        attr3.setValue("103");
                        plant3.setAttributeNode(attr3);
                            //t1 - plantName
                            Element plantName3 = doc.createElement("plantName");
                            plantName3.appendChild(doc.createTextNode("Marsh Marigold"));
                            plant3.appendChild(plantName3);
                            //t2 - botanical
                            Element botanical3 = doc.createElement("botanical");
                            botanical3.appendChild(doc.createTextNode("Caltha palustris"));
                            plant3.appendChild(botanical3);
                            //t3 - zone
                            Element zone3 = doc.createElement("zone");
                            zone3.appendChild(doc.createTextNode("4"));
                            plant3.appendChild(zone3);
                            //t4 - price
                            Element price3 = doc.createElement("price");
                            price3.appendChild(doc.createTextNode("$6.81"));
                            plant3.appendChild(price3);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("plants.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
