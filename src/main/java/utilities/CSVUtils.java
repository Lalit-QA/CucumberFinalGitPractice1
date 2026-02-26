package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static List<String[]> readCSV(String fileName) {
        List<String[]> records = new ArrayList<>();
        try (
                InputStream is = CSVUtils.class.getClassLoader().getResourceAsStream(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(is))
        ) {
            if (is == null) {
                throw new RuntimeException("❌ " + fileName + " not found in src/test/resources");
            }

            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                // Skip header
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",", -1); // -1 keeps empty strings
                records.add(values);
            }

        } catch (IOException e) {
            throw new RuntimeException("❌ CSV read failed: " + e.getMessage(), e);
        }
        return records;
    }

    public static String[] getRow(String fileName, int rowNum) {
        List<String[]> records = readCSV(fileName);
        if (rowNum < 0 || rowNum >= records.size()) {
            throw new RuntimeException("❌ Row " + rowNum + " not found in " + fileName);
        }
        return records.get(rowNum);
    }
}