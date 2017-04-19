package model;

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

public class User {

	private String id;
	private String username;
	private String password;
	private String type;
	
	public User()
	{
		
	}
	public User(String id,String un,String pass,String t)
	{
		this.id=id;
		this.username=un;
		this.password=pass;
		this.type=t;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void addUser()
	{
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("user.xml");
		       
		       //root 
		       Element root=document.getDocumentElement();
		       
    		   Element newElement = document.createElement("user");
    		   root.appendChild(newElement);
    		   
    		   newElement.setAttribute("id",this.getId());
    		   
    		   Element username = document.createElement("username");
    		   username.setTextContent(this.getUsername());
    		   
    		   Element password = document.createElement("password");
    		   password.setTextContent(this.getPassword());
    		   
    		   Element type = document.createElement("type");
    		   type.setTextContent("employee");
    		   
    		   newElement.appendChild(username);	
    		   newElement.appendChild(password);	
    		   newElement.appendChild(type);
    		
		       TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("user.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }
	public static void updateUser(String id,String newun,String newpass)
	{
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("user.xml");
		       
		       
		       NodeList nList = document.getElementsByTagName("user");
		
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getAttribute("id").equals(id))
						{
							 eElement.getElementsByTagName("username").item(0).setTextContent((newun));
							 eElement.getElementsByTagName("password").item(0).setTextContent((newpass));
						}
					}
		       }
		       TransformerFactory tff  = TransformerFactory.newInstance();
		       Transformer transformer = tff.newTransformer();
		       
		       transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
		       
		       DOMSource xmlSource = new DOMSource(document);
		       StreamResult outputTarget = new StreamResult("user.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	}
	public static void deleteUser(String username) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("user.xml");
		       NodeList nList = document.getElementsByTagName("user");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("username").item(0).getTextContent().equals(username))
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
		       StreamResult outputTarget = new StreamResult("user.xml");
		       
		       transformer.transform(xmlSource, outputTarget);  
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
}
	public static boolean existsUser(String username) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("user.xml");
		       NodeList nList = document.getElementsByTagName("user");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("username").item(0).getTextContent().equals(username))
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
	public static boolean existsUserByID(String id) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("user.xml");
		       NodeList nList = document.getElementsByTagName("user");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getAttribute("id").equals(id))
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
	
	public static boolean checkPassword(String username,String password) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("user.xml");
		       NodeList nList = document.getElementsByTagName("user");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("username").item(0).getTextContent().equals(username))
						{
							if(eElement.getElementsByTagName("password").item(0).getTextContent().equals(password))
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
	public static String getType(String username) {
		try
		{
			   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		       DocumentBuilder db = dbf.newDocumentBuilder();
		       Document document = db.parse("user.xml");
		       NodeList nList = document.getElementsByTagName("user");
				
		       for (int temp = 0; temp < nList.getLength(); temp++) {
		
		    	   	Node nNode = nList.item(temp);
		
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
						Element eElement = (Element) nNode;
						if(eElement.getElementsByTagName("username").item(0).getTextContent().equals(username))
						{
							return eElement.getElementsByTagName("type").item(0).getTextContent();
						}
					}
		       }   
		       }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		return "";
}
}
