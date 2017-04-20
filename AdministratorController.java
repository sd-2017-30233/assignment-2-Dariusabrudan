package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import model.Book;
import model.Csv;
import model.CsvFactory;
import model.Factory;
import model.Pdf;
import model.PdfFactory;
import model.User;
import view.AdministratorFrame;
import view.StartupFrame;

public class AdministratorController {

	private User u;
	private Book b;
	private AdministratorFrame view;
	AdministratorController(Book bb,User uu,AdministratorFrame v)
	{
		this.b=bb;
		this.u=uu;
		this.view=v;
	// ... Add listeners to the view.
	
	view.addAddUserListener(new AddUserListener());
	view.addUpdateUserListener(new UpdateUserListener());
	view.addDeleteUserListener(new DeleteUserListener());
	view.addLogOutListener(new LogOutListener());
	view.addAddBookListener(new AddBookListener());
	view.addUpdateBookListener(new UpdateBookListener());
	view.addDeleteBookListener(new DeleteBookListener());
	view.addPdfReportListener(new AddPdfListener());
	view.addCsvReportListener(new AddCsvListener());
	}
	   
	class AddUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf6().equals("")|| !Pattern.matches("[0-9]+", view.getTf6()))
				view.setMesaj("Invalid employee id");
			else if(view.getTf7().equals(""))
				view.setMesaj("Invalid username");
			else if(view.getTf8().equals(""))
				view.setMesaj("Invalid password");
			else {
					String id=view.getTf6();
			        String username=view.getTf7();
			        String pass=view.getTf8();
			        u=new User(id,username,pass,"employee");
			        if(cmd.equals("Open"))
			        {
			        	if(!User.existsUser(username))
			            {u.addUser();
			            view.setMesaj("Employee inserted");
			            }
			    		else view.setMesaj("Employee exists");
			        }
			}
		}
	}    
	class UpdateUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf6().equals("")|| !Pattern.matches("[0-9]+", view.getTf6()))
				view.setMesaj("Invalid user id");
			else if(view.getTf7().equals(""))
				view.setMesaj("Invalid username");
			else if(view.getTf8().equals(""))
				view.setMesaj("Invalid password");
			else {
					String id=view.getTf6();
			        String username=view.getTf7();
			        String pass=view.getTf8();
			        if(cmd.equals("Open"))
			        {
			        	if(User.existsUserByID(id))
			    		{ User.updateUser(id,username,pass);
			    		view.setMesaj("Employee updated");
			    		}
			    		else view.setMesaj("Employee don't exist");	     
			        }
			}
		}
	}    
	class DeleteUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf7().equals(""))
				view.setMesaj("Invalid username");
			else {
					String username=view.getTf7();
			        if(cmd.equals("Open"))
			        {
			        	try{
			   	         {User.deleteUser(username);
			   	      view.setMesaj("Employee deleted");
			               }
			          }
			          catch(Exception ee){
			        	  view.setMesaj("Employee don't exist");
			          }
			        }
	        }
		}
	}    
	class AddBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf().equals("")|| !Pattern.matches("[0-9]+", view.getTf()))
				view.setMesaj("Invalid book id");
			else if(view.getTf1().equals(""))
				view.setMesaj("Invalid title");
			else if(view.getTf2().equals(""))
				view.setMesaj("Invalid author");
			else if(view.getTf3().equals(""))
				view.setMesaj("Invalid genre");
			else if(view.getTf4().equals("") || !Pattern.matches("[0-9]+", view.getTf4()))
				view.setMesaj("Invalid quantity");
			else if(view.getTf5().equals("")|| !Pattern.matches("[0-9]+", view.getTf5()))
				view.setMesaj("Invalid price");
			else {
					String id=view.getTf();
			        String title=view.getTf1();
			        String author=view.getTf2();
			        String genre=view.getTf3();
			        String quantity=view.getTf4();
			        String price=view.getTf5();
			        b=new Book(id,title,author,genre,quantity,price);
			        if(cmd.equals("Open"))
			        {
			        	if(Book.existsBook(title)==false)
						{b.addBook();
						view.setMesaj("Book added");     
				         }
			        else view.setMesaj("Book exists"); 
			       }
			}
	}    
	}
	class UpdateBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
		    if(view.getTf1().equals(""))
		    	view.setMesaj("Invalid title"); 
		    if(view.getTf4().equals("") || !Pattern.matches("[0-9]+", view.getTf4()))
				view.setMesaj("Invalid quantity"); 
			else if(view.getTf5().equals("")|| !Pattern.matches("[0-9]+", view.getTf5()))
				view.setMesaj("Invalid price");
			else {
			        String title=view.getTf1();
			        String quantity=view.getTf4();
			        String price=view.getTf5();
			        if(cmd.equals("Open"))
			        {
			        	if(Book.existsBook(title)==true)
						{Book.updateBook(title,quantity,price);
						view.setMesaj("Book updated");   
				         }
			        else view.setMesaj("Book don't exist"); 
			       }
			}
		}
	}    
	class DeleteBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf1().equals(""))
				view.setMesaj("Invalid title"); 
			else {
				String title=view.getTf1();			       
		        if(cmd.equals("Open"))
		        {
		        	if(Book.existsBook(title)==true)
		            {
		        		Book.deleteBook(title);
		        		view.setMesaj("Book deleted");
		            }
		       	 else view.setMesaj("Book don't exist");
		        }
			}
		}
	} 
	
	class AddPdfListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Factory f=new Factory();
			PdfFactory pf=(PdfFactory) f.getFactory("PDF");
			Pdf pdf=(Pdf) pf.build();
			pdf.save();
	}
}
	
	class AddCsvListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Factory f=new Factory();
			CsvFactory cf=(CsvFactory) f.getFactory("CSV");
			Csv csv=(Csv) cf.build();
			csv.save();
	}    
}
	
	class LogOutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			 if(cmd.equals("Open"))
		        {
				 view.windowClosing();
				 new Controller(new User(),new StartupFrame());
		        }
		}
	}
}

