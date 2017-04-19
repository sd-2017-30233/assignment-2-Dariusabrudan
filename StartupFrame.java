package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class StartupFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnOk = new JButton("OK");

	public StartupFrame() {
		super("Book Store");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log in");
		lblLogIn.setBounds(145, 39, 424, 14);
		contentPane.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 87, 65, 14);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(145, 85, 121, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 113, 65, 17);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 110, 121, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		btnOk.setBounds(145, 161, 89, 23);
        btnOk.setActionCommand("Open");
		contentPane.add(btnOk);
		
		setVisible(true);
	}
	public void addLogInListener(ActionListener mal) {
	    btnOk.addActionListener(mal);
	}
	public void windowClosing(){
	     dispose();
	}
	public void setMesaj(String s){
			JOptionPane.showMessageDialog(null,s);
	}
	public String getTf() {    return textField.getText();}
	public String getTf1() {    return textField_1.getText();}
	  
public String getUserName()
	{
		String username=textField.getText();
		return username;
	}

}
