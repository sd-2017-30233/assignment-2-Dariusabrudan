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

	
public class AdministratorFrame extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		private JTextField textField_3;
		private JTextField textField_4;
		private JTextField textField_5;
		private JTextField textField_6;
		private JTextField textField_7;
		private JTextField textField_8;
		private JButton btnNewButton = new JButton("Insert book");
		private JButton btnUpdateBook = new JButton("Update book");
		private JButton btnDeleteBook = new JButton("Delete book");
		private JButton btnInsertEmployee = new JButton("Insert employee");
		private JButton btnUpdateEmployee = new JButton("Update employee");
		private JButton btnDeleteEmployee = new JButton("Delete employee");
		private JButton btnNewButton_1 = new JButton("Generate pdf report");
		private JButton btnGenerateCsvReport = new JButton("Generate csv report");
		private JButton btnLogOut = new JButton("Log out");
			
public AdministratorFrame() {
	
		super("Administrator user");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton.setBounds(56, 33, 150, 23);
		btnNewButton.setActionCommand("Open");
		contentPane.add(btnNewButton);
		
		btnUpdateBook.setBounds(56, 67, 150, 23);
		btnUpdateBook.setActionCommand("Open");
		contentPane.add(btnUpdateBook);
		
		btnDeleteBook.setBounds(56, 101, 150, 23);
		btnDeleteBook.setActionCommand("Open");
		contentPane.add(btnDeleteBook);
		
		btnInsertEmployee.setBounds(56, 135, 150, 23);
		btnInsertEmployee.setActionCommand("Open");
		contentPane.add(btnInsertEmployee);
		
		btnUpdateEmployee.setBounds(56, 169, 150, 23);
		btnUpdateEmployee.setActionCommand("Open");
		contentPane.add(btnUpdateEmployee);
		
		btnDeleteEmployee.setBounds(56, 203, 150, 23);
		btnDeleteEmployee.setActionCommand("Open");
		contentPane.add(btnDeleteEmployee);
		
		btnNewButton_1.setBounds(56, 237, 150, 23);
		btnNewButton_1.setActionCommand("Open");
		contentPane.add(btnNewButton_1);
		
		btnGenerateCsvReport.setBounds(56, 271, 150, 23);
		btnGenerateCsvReport.setActionCommand("Open");
		contentPane.add(btnGenerateCsvReport);
		
		btnLogOut.setBounds(56, 305, 150, 23);
		btnLogOut.setActionCommand("Open");
		contentPane.add(btnLogOut);
		
		JLabel lblBookId = new JLabel("Book id");
		lblBookId.setBounds(240, 37, 46, 14);
		contentPane.add(lblBookId);
		
		textField = new JTextField();
		textField.setBounds(351, 34, 129, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(240, 71, 46, 14);
		contentPane.add(lblTitle);
		
		textField_1 = new JTextField();
		textField_1.setBounds(351, 68, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(240, 105, 46, 14);
		contentPane.add(lblAuthor);
		
		textField_2 = new JTextField();
		textField_2.setBounds(351, 102, 129, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(240, 139, 46, 14);
		contentPane.add(lblGenre);
		
		textField_3 = new JTextField();
		textField_3.setBounds(351, 136, 129, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(240, 173, 49, 14);
		contentPane.add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setBounds(351, 170, 129, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(240, 207, 46, 14);
		contentPane.add(lblPrice);
		
		textField_5 = new JTextField();
		textField_5.setBounds(351, 204, 129, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee id");
		lblEmployeeId.setBounds(240, 241, 70, 14);
		contentPane.add(lblEmployeeId);
		
		textField_6 = new JTextField();
		textField_6.setBounds(351, 238, 129, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(240, 275, 70, 14);
		contentPane.add(lblUsername);
		
		textField_7 = new JTextField();
		textField_7.setBounds(351, 272, 129, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(240, 309, 59, 14);
		contentPane.add(lblPassword);
		
		textField_8 = new JTextField();
		textField_8.setBounds(351, 306, 129, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
			
	        setVisible(true);
		}
public void windowClosing(){
    dispose();
}
public void addAddBookListener(ActionListener mal) {
    btnNewButton.addActionListener(mal);
}
public void addUpdateBookListener(ActionListener mal) {
    btnUpdateBook.addActionListener(mal);
}
public void addDeleteBookListener(ActionListener mal) {
    btnDeleteBook.addActionListener(mal);
}
public void addAddUserListener(ActionListener mal) {
    btnInsertEmployee.addActionListener(mal);
}
public void addUpdateUserListener(ActionListener mal) {
    btnUpdateEmployee.addActionListener(mal);
}
public void addDeleteUserListener(ActionListener mal) {
    btnDeleteEmployee.addActionListener(mal);
}
public void addPdfReportListener(ActionListener mal) {
    btnNewButton_1.addActionListener(mal);
}
public void addCsvReportListener(ActionListener mal) {
    btnGenerateCsvReport.addActionListener(mal);
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
public String getTf4() {    return textField_4.getText();}
public String getTf5() {    return textField_5.getText();}
public String getTf6() {    return textField_6.getText();}
public String getTf7() {    return textField_7.getText();}
public String getTf8() {    return textField_8.getText();}

}
