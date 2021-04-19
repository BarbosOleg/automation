package ex4;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.*;

public class APoi {

    public static void main(String[] argv) {

        ArrayList<String> plant     = new ArrayList<>();
        ArrayList<String> botanical = new ArrayList<>();
        ArrayList<String> zone      = new ArrayList<>();
        ArrayList<String> price     = new ArrayList<>();
        ArrayList<String> plantID   = new ArrayList<>();

        try {
            DocumentBuilderFactory docBuilderFactory    = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder                  = docBuilderFactory.newDocumentBuilder();
            Document doc                                = docBuilder.parse(new File("plants.xml"));
            doc.getDocumentElement().normalize();

            NodeList listOfPlants = doc.getElementsByTagName("plant");

            for (int s = 0; s < listOfPlants.getLength(); s++) {
                Node nNode = listOfPlants.item(s);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element idElement = (Element) nNode;
                    plantID.add(idElement.getAttribute("plantID"));

                    Element eElement = (Element) nNode;
                    NodeList plantList = eElement.getElementsByTagName("plantName");
                    Element plantElement = (Element) plantList.item(0);
                    NodeList txtPlantList = plantElement.getChildNodes();
                    plant.add(txtPlantList.item(0).getNodeValue());

                    NodeList botanicalList = eElement.getElementsByTagName("botanical");
                    Element botanicalElement = (Element) botanicalList.item(0);
                    NodeList txtBotanicalList = botanicalElement.getChildNodes();
                    botanical.add(txtBotanicalList.item(0).getNodeValue());

                    NodeList zoneList = eElement.getElementsByTagName("zone");
                    Element zoneElement = (Element) zoneList.item(0);
                    NodeList txtZoneList = zoneElement.getChildNodes();
                    zone.add(txtZoneList.item(0).getNodeValue());

                    NodeList priceList = eElement.getElementsByTagName("price");
                    Element priceElement = (Element) priceList.item(0);
                    NodeList txtPriceList = priceElement.getChildNodes();
                    price.add(txtPriceList.item(0).getNodeValue());


                }
            }
        } catch (SAXParseException err) {
            System.out.println("Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
            System.out.println(" " + err.getMessage());
        } catch (SAXException e) {
            Exception x = e.getException();
            ((x == null) ? e : x).printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("01");
        Sheet sheet1 = wb.createSheet("02");
        Map<String, Object[]> data = new HashMap<>();

        HSSFCellStyle style = wb.createCellStyle();
        HSSFFont font = wb.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        Row row0 = sheet.createRow(0);
        row0.createCell(0).setCellValue("plantID");
        row0.createCell(1).setCellValue("plantName");
        row0.createCell(2).setCellValue("botanical");
        row0.createCell(3).setCellValue("zone");
        row0.createCell(4).setCellValue("price");

        for (int temp = 0; temp < row0.getLastCellNum(); temp++) {
            row0.getCell(temp).setCellStyle(style);
        }

        Row row01 = sheet1.createRow(0);
        row01.createCell(0).setCellValue("plantID");
        row01.createCell(1).setCellValue("plantName");
        row01.createCell(2).setCellValue("botanical");
        row01.createCell(3).setCellValue("zone");
        row01.createCell(4).setCellValue("price");

        for (int temp = 0; temp < row01.getLastCellNum(); temp++) {
            row01.getCell(temp).setCellStyle(style);
        }

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 8));
        sheet1.addMergedRegion(new CellRangeAddress(0, 0, 6, 8));

        for (int i = 0; i < plant.size(); i++) {
            data.put(i + "", new Object[]{plantID.get(0), plant.get(0), botanical.get(0), zone.get(0), price.get(0)});
        }

        Set<String> keyset = data.keySet();
        int rownum = 1;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    sheet.autoSizeColumn(i);
                }
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }
        Map<String, Object[]> data1 = new HashMap<>();
        for (int i = 0; i < plant.size(); i++) {
            data1.put(i + "", new Object[]{plantID.get(1), plant.get(1), botanical.get(1), zone.get(1), price.get(1)});
        }

        Set<String> keyset1 = data1.keySet();
        int rownum1 = 2;
        for (String key : keyset1) {
            Row row1 = sheet.createRow(rownum1);
            Object[] objArr1 = data1.get(key);
            int cellnum = 0;
            for (Object obj : objArr1) {
                Cell cell = row1.createCell(cellnum++);
                for (int i = 0; i < row1.getLastCellNum(); i++) {
                    sheet.autoSizeColumn(i);
                }
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }

        Map<String, Object[]> data2 = new HashMap<>();
        for (int i = 0; i < plant.size(); i++) {
            data2.put(i + "", new Object[]{plantID.get(2), plant.get(2), botanical.get(2), zone.get(2), price.get(2)});
        }

        Set<String> keyset2 = data2.keySet();
        int rownum2 = 1;
        for (String key : keyset2) {
            Row row2 = sheet1.createRow(rownum2);
            Object[] objArr = data2.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row2.createCell(cellnum++);
                for (int i = 0; i < row2.getLastCellNum(); i++) {
                    sheet1.autoSizeColumn(i);
                }
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }

        try {
            FileOutputStream out = new FileOutputStream("plants.xls");
            wb.write(out);
            out.close();
            System.out.println("Excel written successfully...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}