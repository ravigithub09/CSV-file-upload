package com.java.spring.files.csv.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.files.csv.model.CSVFile;

public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "code", "name", "batch", "stock", "deal", "free", "mrp", "rate", "exp", "company", "supplier" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<CSVFile> csvConverter(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<CSVFile> csvFile = new ArrayList<CSVFile>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
	     String startDate=csvRecord.get("exp"),
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); // New Pattern
        java.util.Date date = sdf1.parse(startDate); // Returns a Date format object with the pattern
        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
        CSVFile csv = new CSVFile(
			  
			  csvRecord.get("code"),
			  csvRecord.get("name"),
			  csvRecord.get("batch"),
			  csvRecord.get("stock"),
			  csvRecord.get("deal"),
			  csvRecord.get("free"),
			  Double.parseDouble(csvRecord.get("mrp"));
			  Double.parseDouble(csvRecord.get("rate"));
			  sqlStartDate,
			  csvRecord.get("company"),
              csvRecord.get("supplier"),
              
            );

        csvFile.add(csv);
      }

      return csvFile;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  
}
