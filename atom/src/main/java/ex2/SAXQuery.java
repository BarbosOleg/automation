package ex2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXQuery{
    public static void main(String[] args) {

        try {
            File inputFile = new File("plants.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler2 userhandler = new UserHandler2();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class UserHandler2 extends DefaultHandler {

    boolean aPlantName = false;
    boolean bBotanical = false;
    boolean bZone = false;
    boolean bPrice = false;
    String plantId = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("plant")) {
            plantId = attributes.getValue("plantID");
        }
        if(("101").equals(plantId) && qName.equalsIgnoreCase("plant")) {
            System.out.println("Start Element :" + qName);
        }
        if (qName.equalsIgnoreCase("plantName")
        ) {
            aPlantName = true;
        } else if (qName.equalsIgnoreCase("botanical")   ) {
            bBotanical = true;
        } else if (qName.equalsIgnoreCase("zone")) {
            bZone = true;
        }
        else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;

        }
    }

    @Override
    public void endElement(
            String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("plant")) {

            if(("101").equals(plantId)
                    && qName.equalsIgnoreCase("plant"))
                System.out.println("End Element :" + qName);
        }
    }


    @Override
    public void characters(
            char ch[], int start, int length) throws SAXException {

        if (aPlantName && ("101").equals(plantId)) {
            //age element, set Employee age
            System.out.println("plant: " + new String(ch, start, length));
            aPlantName = false;
        } else if (bBotanical && ("101").equals(plantId)) {
            System.out.println("botanical: " + new String(ch, start, length));
            bBotanical = false;
        } else if (bZone && ("101").equals(plantId)) {
            System.out.println("zone: " + new String(ch, start, length));
            bZone = false;
        } else if (bPrice && ("101").equals(plantId)) {
            System.out.println("price: " + new String(ch, start, length));
            bPrice = false;
        }
    }
}