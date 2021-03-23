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
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("tag0");
            doc.appendChild(rootElement);

            // supercars element
            Element supercar = doc.createElement("tag1");
            rootElement.appendChild(supercar);

            // setting attribute to element
            Attr attr = doc.createAttribute("company");
            attr.setValue("Ferrari");
            supercar.setAttributeNode(attr);


            Element a = doc.createElement("tag2");
            supercar.appendChild(a);

            Attr attr1 = doc.createAttribute("company");
            attr1.setValue("ff");
            a.setAttributeNode(attr1);

            Element cc = doc.createElement("t1");
            Attr at2 = doc.createAttribute("type");
            at2.setValue("formula one");
            cc.setAttributeNode(at2);
            cc.appendChild(doc.createTextNode("Ferrari 101"));
            a.appendChild(cc);

            Element cc1 = doc.createElement("t2");
            Attr at22 = doc.createAttribute("type");
            at22.setValue("formula one");
            cc1.setAttributeNode(at22);
            cc1.appendChild(doc.createTextNode("Ferrari 102"));
            a.appendChild(cc1);


            Element c = doc.createElement("list");

            a.appendChild(c);

            Element l1 = doc.createElement("t3");
            Attr al = doc.createAttribute("type");
            al.setValue("one");
            l1.setAttributeNode(al);
            l1.appendChild(doc.createTextNode("Ferrari 103"));
            c.appendChild(l1);

            Element l2 = doc.createElement("t4");
            Attr a2 = doc.createAttribute("type");
            a2.setValue("one");
            l2.setAttributeNode(a2);
            l2.appendChild(doc.createTextNode("Ferrari 104"));
            c.appendChild(l2);


            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("ttds.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
