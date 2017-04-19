package model;

import java.io.FileWriter;
import java.io.IOException;


public class Csv implements IReport{
		
   private static final String COMMA_DELIMITER = ",";
   private static final String NEW_LINE_SEPARATOR = "\n";
   private static final String FILE_HEADER = "Book id,title,author,genre,price";
   private static final String fileName= "report.csv";

     public void generate() {
  
    	  String[][] s=Book.searchByQuantityCsv();
          FileWriter fileWriter = null;
      try {
	          fileWriter = new FileWriter(fileName);
	          //Write the CSV file header
 
              fileWriter.append(FILE_HEADER.toString());
              //Add a new line separator after the header

          fileWriter.append(NEW_LINE_SEPARATOR);  
          	for(int i=0;i<s.length;i++)
          	{
          	  if(s[i][0]!=null)
          	  {
              fileWriter.append(s[i][0]);               
              fileWriter.append(COMMA_DELIMITER); 
              fileWriter.append(s[i][1]);  
              fileWriter.append(COMMA_DELIMITER); 
              fileWriter.append(s[i][2]);  
              fileWriter.append(COMMA_DELIMITER); 
              fileWriter.append(s[i][3]);  
              fileWriter.append(COMMA_DELIMITER); 
              fileWriter.append(s[i][4]);  
              fileWriter.append(COMMA_DELIMITER); 
              fileWriter.append(NEW_LINE_SEPARATOR);  
          	  }
          	}
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          try {
              fileWriter.flush();
              fileWriter.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    }
     public static void main(String[] args)
 	{
 		Csv c=new Csv();
 		c.generate();
 	}
}
