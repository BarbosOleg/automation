package ex1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CSVWriter {
    private static final String SAMPLE_CSV_FILE = "test_file.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Universitate", "Profesie","Hobby"));
        ) {
            csvPrinter.printRecord("1", "Andronic Roman", "USM", "student","Genshin Impact");
            csvPrinter.printRecord("2", "Barbos Oleg", "USM", "student","Genshin Impact");
            csvPrinter.printRecord("3", "Spinu Dan", "USM", "student","Genshin Impact");

            csvPrinter.printRecord(Arrays.asList("4", "Diminet Ion", "USM", "student","Genshin Impact"));

            csvPrinter.flush();
        }
    }
}