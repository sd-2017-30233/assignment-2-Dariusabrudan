package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Book;
import model.User;
import view.AdministratorFrame;
import view.EmployeeFrame;
import view.StartupFrame;
public class Controller {
	
	@SuppressWarnings("unused")
	private User u;
	private StartupFrame view;
	Controller(User uu,StartupFrame v)
	{
		this.u=uu;
		this.view=v;
	// ... Add listeners to the view.
	
	view.addLogInListener(new LogInListener());
	}
	class LogInListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			String username=view.getTf();
	        String pass=view.getTf1();
	        if(cmd.equals("Open"))
	        {
	            if(User.existsUser(username))
		            {if(User.checkPassword(username, pass))
			            {view.windowClosing();
			           if(User.getType(username).equals("administrator"))
			             	new AdministratorController(new Book(),new User(),new AdministratorFrame());
			           else {new EmployeeController(new Book(),new EmployeeFrame());
					          }
			            }
		            else view.setMesaj("Incorrect password");
		            }
	            else view.setMesaj("Invalid username");
		        }
		    }
		}

public static void main(String[] args)
{
	User u=new User();
	StartupFrame v=new StartupFrame();
	@SuppressWarnings("unused")
	Controller c=new Controller(u, v);
}
}
