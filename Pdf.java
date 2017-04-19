package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class Pdf implements IReport{
	
	private static final String FILE_NAME = "report.pdf";
	public void generate()
	{
        Document document = new Document();
        try {
        	String[] s=Book.searchByQuantity();
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            //open
            document.open();
            Paragraph p = new Paragraph();
           // p.add(s);
            p.setAlignment(Element.ALIGN_CENTER);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(18);
            for(int i=0;i<s.length;i++)
            	document.add(new Paragraph(s[i], f));

            //close
            document.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (@SuppressWarnings("hiding") IOException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args)
	{
		Pdf p=new Pdf();
		p.generate();
	}
}

