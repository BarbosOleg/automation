package ex2;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class SaxParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("plants.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    boolean aPlantName = false;
    boolean bBotanical = false;
    boolean bZone = false;
    boolean bPrice = false;

    @Override
    public void startElement( String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("plant")) {
            String rollNo = attributes.getValue("plantID");
            System.out.println("plantID : " + rollNo);
        } else if (qName.equalsIgnoreCase("plantName")) {
            aPlantName = true;
        } else if (qName.equalsIgnoreCase("botanical")) {
            bBotanical = true;
        } else if (qName.equalsIgnoreCase("zone")) {
            bZone = true;
        }
        else if (qName.equalsIgnoreCase("price")) {
            bPrice = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("plant")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (aPlantName) {
            System.out.println("plant name: " + new String(ch, start, length));
            aPlantName = false;
        } else if (bBotanical) {
            System.out.println("botanical: " + new String(ch, start, length));
            bBotanical = false;
        } else if (bZone) {
            System.out.println("zone: " + new String(ch, start, length));
            bZone = false;
        } else if (bPrice) {
            System.out.println("price: " + new String(ch, start, length));
            bPrice = false;
        }
    }
}
