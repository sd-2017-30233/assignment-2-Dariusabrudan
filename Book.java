package model;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Book {
	private String id;
	private String title;
    private String author;
    private String genre;
    private String quantity;
    private String price;
    
    public Book()
    {
    	
    }
    public Book(String id,String title,String author,String genre,String quantity,String price)
    {
    	this.id=id;
    	this.title=title;
    	this.author=author;
    	this.genre=genre;
    	this.quantity=quantity;
    	this.price=price;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public void read()
	{
		try{
			
			File fXmlFile = new File("book.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	
			NodeList nList = doc.getElementsByTagName("book");
	
			System.out.println("----------------------------");
	
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					System.out.println("Book id : " + eElement.getAttribute("id"));
					System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
					System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
					System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
					System.out.println("Quantity : " + eElement.getElementsByTagName("quantity").item(0).getTextContent());
					System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
				}
			}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	  }
	public void addBook()
	{
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("book.xml");
		       
		       //root 
		       Element root=document.getDocumentElement();
		       
    		   Element newElement = document.createElement("book");
    		   root.appendChild(newElement);
    		   
    		   newElement.setAttribute("id",this.getId());
    		   
    		   Element title = document.createElement("title");
    		   title.setTextContent(this.getTitle());
    		   
    		   Element author = document.createElement("author");
    		   author.setTextContent(this.getAuthor());
    		   
    		   Element genre = document.createElement("genre");
    		   genre.setTextContent(this.getGenre());
    		   
    		   Element quantity = document.createElement("quantity");
    		   quantity.setTextContent(this.getQuantity());
    		   
    		   Element price= document.createElement("price");
    		   price.setTextContent(this.getPrice());
		    		   
    		   newElement.appendChild(title);	
    		   newElement.appendChild(author);	
    		   newElement.appendChild(genre);
    		   newElement.appendChild(quantity);
    		   newElement.appendChild(price);
		  	       
		       TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("book.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }
	public static void updateBook(String title,String quantity,String price)
	{
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("book.xml");
		       
		       
		       NodeList nList = document.getElementsByTagName("book");
		
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("title").item(0).getTextContent().equals(title))
						{
							 eElement.getElementsByTagName("quantity").item(0).setTextContent((quantity));
							 eElement.getElementsByTagName("price").item(0).setTextContent((price));
						}
					}
		       }
		       TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("book.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	}
	public static void deleteBook(String title) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("book.xml");
		       NodeList nList = document.getElementsByTagName("book");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("title").item(0).getTextContent().equals(title))
						{
							eElement.getParentNode().removeChild(eElement);
						}
					}
		       }   
		  
		    TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("book.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
}
	public static boolean existsBook(String title) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("book.xml");
		       NodeList nList = document.getElementsByTagName("book");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("title").item(0).getTextContent().equals(title))
						{
							return true;
						}
					}
		       }   
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		return false;
}
	public static void sellBook(String title,int nr )
	{
		try
		{
			   Book b=Book.searchByTitle(title);
			   if(Integer.parseInt(b.getQuantity())>=nr)
				   {b.setQuantity(Integer.toString((Integer.parseInt(b.getQuantity())-nr)));
				   	Book.updateBook(b.getTitle(),b.getQuantity() , b.getPrice());
				   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			       DocumentBuilder db = dbf.newDocumentBuilder();
			       Document document = db.parse("selling.xml");
			       
			       //root 
			       Element root=document.getDocumentElement();
			       
	    		   Element newElement = document.createElement("book");
	    		   root.appendChild(newElement);
	    		   
	    		   newElement.setAttribute("id",b.getId()+nr);
	    		   
	    		   Element title1 = document.createElement("title");
	    		   title1.setTextContent(b.getTitle());
	    		   
	    		   Element author = document.createElement("author");
	    		   author.setTextContent(b.getAuthor());
	    		   
	    		   Element genre = document.createElement("genre");
	    		   genre.setTextContent(b.getGenre());
	    		   
	    		   Element quantity = document.createElement("copy_numbers");
	    		   quantity.setTextContent(Integer.toString(nr));
	    		   
	    		   Element price= document.createElement("price");
	    		   price.setTextContent(b.getPrice());
	    		   
	    		   Element total_price= document.createElement("total_price");
	    		   total_price.setTextContent(Integer.toString(Integer.parseInt(b.getPrice())*nr));
			    		   
	    		   newElement.appendChild(title1);	
	    		   newElement.appendChild(author);	
	    		   newElement.appendChild(genre);
	    		   newElement.appendChild(quantity);
	    		   newElement.appendChild(price);
	    		   newElement.appendChild(total_price);
			  	       
			       TransformerFactory tff  = TransformerFactory.newInstance();
			       Transformer transformer = tff.newTransformer();
			       
			       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
			       
			       DOMSource xmlSource = new DOMSource(document);
			       StreamResult outputTarget = new StreamResult("selling.xml");
			       
			       transformer.transform(xmlSource, outputTarget);  
			   
				   }
			   else JOptionPane.showMessageDialog(null, "Insufficient number of books");
				}
			   catch(Exception e)
			   {
				   e.printStackTrace();
			   }
	   }
	public static void searchByGenre(String genre)
	{
		try{
			
			File fXmlFile = new File("book.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("book");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Book id");
	        model.addColumn("Title");
	        model.addColumn("Author");
	        model.addColumn("Genre");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	        JTable table = new JTable(model);
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("genre").item(0).getTextContent().equals(genre))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("title").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("author").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("genre").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  ((DefaultTableModel) table.getModel()).addRow(new Object[]{st[0], st[1], st[2], st[3],st[4],st[5]});	
						}
				}
			}
			table.setPreferredScrollableViewportSize(new Dimension(800,400));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			 JOptionPane.showMessageDialog(null, new JScrollPane(table));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
}
	public static String[] searchByQuantity()
	{
		try{
			String[] result=new String[100];
			int i=0;
			File fXmlFile = new File("book.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("book");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Book id");
	        model.addColumn("Title");
	        model.addColumn("Author");
	        model.addColumn("Genre");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	       
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("quantity").item(0).getTextContent().equals("0"))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("title").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("author").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("genre").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  result[i]="The book "+st[1]+" written by "+st[2]+" is out of stock.";
						  i++;
						}
				}
			}
			return result;
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return null;
}
	public static String[][] searchByQuantityCsv()
	{
		try{
			String[][] result=new String[20][100];
			int i=0;
			File fXmlFile = new File("book.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("book");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Book id");
	        model.addColumn("Title");
	        model.addColumn("Author");
	        model.addColumn("Genre");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	       
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("quantity").item(0).getTextContent().equals("0"))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("title").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("author").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("genre").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  result[i][0]=st[0];
						  result[i][1]=st[1];
						  result[i][2]=st[2];
						  result[i][3]=st[3];
						  result[i][4]=st[4];
						  i++;
						}
				}
			}
			return result;
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return null;
}
	public static Book searchByTitle(String title)
	{
		try{
			
			File fXmlFile = new File("book.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("book");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Book id");
	        model.addColumn("Title");
	        model.addColumn("Author");
	        model.addColumn("Genre");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	        JTable table = new JTable(model);
	        Book b=new Book();
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("title").item(0).getTextContent().equals(title))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("title").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("author").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("genre").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  ((DefaultTableModel) table.getModel()).addRow(new Object[]{st[0], st[1], st[2], st[3],st[4],st[5]});
						  b=new Book(st[0],st[1],st[2],st[3],st[4],st[5]);
						}
				}
			}
			table.setPreferredScrollableViewportSize(new Dimension(800,400));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			 JOptionPane.showMessageDialog(null, new JScrollPane(table));
			 return b;
	    } catch (Exception e) {
		e.printStackTrace();
	    }
		return null;
}
	public static void searchByAuthor(String author)
	{
		try{
			
			File fXmlFile = new File("book.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
	
			NodeList nList = doc.getElementsByTagName("book");
			String[] st = new String[6];
			DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("Book id");
	        model.addColumn("Title");
	        model.addColumn("Author");
	        model.addColumn("Genre");
	        model.addColumn("Quantity");
	        model.addColumn("Price");
	        JTable table = new JTable(model);
			for (int temp = 0; temp < nList.getLength(); temp++) {
	
				Node nNode = nList.item(temp);
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					
					if(eElement.getElementsByTagName("author").item(0).getTextContent().equals(author))
						{ 
						  st[0] = eElement.getAttribute("id");
						  st[1]= eElement.getElementsByTagName("title").item(0).getTextContent();
						  st[2]=eElement.getElementsByTagName("author").item(0).getTextContent();
						  st[3]=eElement.getElementsByTagName("genre").item(0).getTextContent();
						  st[4]=eElement.getElementsByTagName("quantity").item(0).getTextContent();
						  st[5]=eElement.getElementsByTagName("price").item(0).getTextContent();
						  ((DefaultTableModel) table.getModel()).addRow(new Object[]{st[0], st[1], st[2], st[3],st[4],st[5]});	
						}
				}
			}
			table.setPreferredScrollableViewportSize(new Dimension(800,400));
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
			table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
			 JOptionPane.showMessageDialog(null, new JScrollPane(table));
	    } catch (Exception e) {
		e.printStackTrace();
	    }
}
}
