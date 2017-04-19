package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import model.Book;
import model.User;
import view.EmployeeFrame;
import view.StartupFrame;

public class EmployeeController {
	
	@SuppressWarnings("unused")
	private Book b;
	private EmployeeFrame view;
	public EmployeeController(Book bb,EmployeeFrame v)
	{
		this.b=bb;
		this.view=v;
	// ... Add listeners to the view.
	view.addSearchBookListener(new SearchBookListener());
	view.addSearchBook1Listener(new SearchBook1Listener());
	view.addSearchBook2Listener(new SearchBook2Listener());
	view.addSellBookListener(new SellBookListener());
	view.addLogOutListener(new LogOutListener());
	}
	class SearchBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf().equals("") ||( !view.getTf().equals("epic") && !view.getTf().equals("lyric")&& !view.getTf().equals("dramatic")) )
				view.setMesaj("Invalid book genre");
			else {String genre=view.getTf();
			        if(cmd.equals("Open"))
			        {
			        Book.searchByGenre(genre);			     
			        }
				}
		}
	}
	class SearchBook1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf1().equals(""))
				view.setMesaj("Invalid book title");
			else {String title=view.getTf1();
			        if(cmd.equals("Open"))
			        {
			        	if(Book.existsBook(title)==true)
			        		Book.searchByTitle(title);
			        	else view.setMesaj("Book don't exist");     
			        }
				}
		}
		}
	class SearchBook2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf2().equals(""))
				view.setMesaj("Invalid book author"); 
			else {String author=view.getTf2();
			        if(cmd.equals("Open"))
			        {
			        Book.searchByAuthor(author);     
			        }
				}
		}
		}
	class SellBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(view.getTf1().equals(""))
				view.setMesaj("Invalid book title");
			else if(view.getTf3().equals("") || !Pattern.matches("[0-9]+", view.getTf3()))
				view.setMesaj("Invalid number of copies");
			else {String title=view.getTf1();
			      int nr=Integer.parseInt(view.getTf3());
			        if(cmd.equals("Open"))
			        {
			        Book.sellBook(title,nr);     
			        }
				}
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
