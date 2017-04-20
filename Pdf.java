package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf implements IReport{
	
	private static final String FILE_NAME = "report.pdf";
	private Document document = new Document();
	private Font f = new Font();
	public void build()
	{
		try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            //open
            document.open();
            Paragraph p = new Paragraph();
           // p.add(s);
            p.setAlignment(Element.ALIGN_CENTER);
            
            f.setStyle(Font.BOLD);
            f.setSize(18);

	        } catch (FileNotFoundException | DocumentException e) {
	            e.printStackTrace();
	        } catch (@SuppressWarnings("hiding") IOException e) {
	            e.printStackTrace();
	        }
	}
	public void save()
	{
		String[] s=Book.searchByQuantity();
		for(int i=0;i<s.length;i++)
			try {
				document.add(new Paragraph(s[i], f));
				
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 //close
        document.close();
	}
}

