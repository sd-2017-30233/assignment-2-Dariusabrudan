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

public class EmployeeFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSearchBookBy = new JButton("Search book by genre");
	private JButton btnSearchBookBy_1 = new JButton("Search book by title");
	private JButton btnSearchBookBy_2 = new JButton("Search book by author");
	private JButton btnSellBook = new JButton("Sell book");
	private JButton btnLogOut = new JButton("Log out");
	
	
	public EmployeeFrame() {
		super("Employee user");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 352);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSearchBookBy.setBounds(56, 38, 165, 23);
		btnSearchBookBy.setActionCommand("Open");
		contentPane.add(btnSearchBookBy);
		
		btnSearchBookBy_1.setBounds(56, 72, 165, 23);
		btnSearchBookBy_1.setActionCommand("Open");
		contentPane.add(btnSearchBookBy_1);
		
		btnSearchBookBy_2.setBounds(56, 106, 165, 23);
		btnSearchBookBy_2.setActionCommand("Open");
		contentPane.add(btnSearchBookBy_2);
		
		btnSellBook.setBounds(56, 140, 165, 23);
		btnSellBook.setActionCommand("Open");
		contentPane.add(btnSellBook);
		
		btnLogOut.setBounds(56, 174, 165, 23);
		btnLogOut.setActionCommand("Open");
		contentPane.add(btnLogOut);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(276, 42, 46, 14);
		contentPane.add(lblGenre);
		
		textField = new JTextField();
		textField.setBounds(371, 39, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(276, 76, 46, 14);
		contentPane.add(lblTitle);
		
		textField_1 = new JTextField();
		textField_1.setBounds(371, 73, 134, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(276, 110, 46, 14);
		contentPane.add(lblAuthor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(371, 107, 134, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblExemplar = new JLabel("Copy numbers");
		lblExemplar.setBounds(276, 144, 88, 14);
		contentPane.add(lblExemplar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(371, 141, 134, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		setVisible(true);
		}
	
public void windowClosing(){
	    dispose();
	}
public void addSearchBookListener(ActionListener mal) {
	btnSearchBookBy.addActionListener(mal);
	}
public void addSearchBook1Listener(ActionListener mal) {
	btnSearchBookBy_1.addActionListener(mal);
	}
public void addSearchBook2Listener(ActionListener mal) {
	btnSearchBookBy_2.addActionListener(mal);
	}
public void addSellBookListener(ActionListener mal) {
	btnSellBook.addActionListener(mal);
	}
public void addLogOutListener(ActionListener mal) {
	btnLogOut.addActionListener(mal);
	}
public void setMesaj(String s){
	JOptionPane.showMessageDialog(null,s);
}
public String getTf() {    return textField.getText();}
public String getTf1() {    return textField_1.getText();}
public String getTf2() {    return textField_2.getText();}
public String getTf3() {    return textField_3.getText();}

}

