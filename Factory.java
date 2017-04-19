package model;

public class Factory {
	public IReportFactory getFactory(String reportType){
	      if(reportType == null){
	         return null;
	      }		
	      if(reportType.equalsIgnoreCase("PDF")){
	         return new PdfFactory();
	         
	      } else if(reportType.equalsIgnoreCase("CSV")){
	         return new CsvFactory();
	      }	      
	      return null;
	   }
}
