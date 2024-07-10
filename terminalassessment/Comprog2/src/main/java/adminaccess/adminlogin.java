package adminaccess;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import admin_portal.adminportal;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class adminlogin {

	private JFrame frmMotorphPayrollSystem;
	private JTextField txtusername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin window = new adminlogin();
					window.frmMotorphPayrollSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMotorphPayrollSystem = new JFrame();
		frmMotorphPayrollSystem.setResizable(false);
		frmMotorphPayrollSystem.setTitle("MotorPh Login System");
		frmMotorphPayrollSystem.getContentPane().setBackground(new Color(0, 0, 0));
		frmMotorphPayrollSystem.setBounds(100, 100, 542, 350);
		frmMotorphPayrollSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMotorphPayrollSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 506, 289);
		frmMotorphPayrollSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPassword.setBounds(200, 151, 70, 14);
		panel.add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setBackground(new Color(255, 255, 255));
		txtusername.setBounds(200, 115, 296, 25);
		panel.add(txtusername);
		txtusername.setColumns(10);
		
		JLabel lblWelcome = new JLabel("Welcome to your admin portal");
		lblWelcome.setBounds(55, 5, 396, 42);
		lblWelcome.setFont(new Font("Script MT Bold", Font.BOLD, 30));
		panel.add(lblWelcome);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblusername.setBounds(200, 101, 70, 14);
		panel.add(lblusername);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(200, 164, 296, 25);
		panel.add(passwordField);
		
		JButton btnlogin = new JButton("Log In");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// this will be getting the text input from the text field
				
				String username = txtusername.getText();
				String password = passwordField.getText();
				
				//this will be the reading the data from csv file
				try {
					File txt = new File ("C:\\Users\\Dell_i5\\Desktop\\MMDC File\\TA\\adminacess.csv");
					Scanner scan = new Scanner(txt);
					scan.useDelimiter(""+username+","+password+"" );
						
			if (txtusername.getText().equals("") && passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "USER OR PASS ARE EMPTY", "LOG IN ERROR", JOptionPane.ERROR_MESSAGE);
			}
										
			else if (scan.hasNext())
				{
					String user = scan.next();
					String pass = scan.next();
					
				if (username.equals(user.trim()) && password.equals(pass.trim()));
				
				{
					JOptionPane.showMessageDialog(null, "Successfully Logged In");
					
					admin_portal.adminportal info = new admin_portal.adminportal();
					admin_portal.adminportal.main(null);
					info.setVisible(true);
					frmMotorphPayrollSystem.dispose();
					
				}  
					
				}
					
				}
								
					catch (Exception e1) 
				{
						
						JOptionPane.showMessageDialog(null, "INVALID CREDENTIALS","LOG IN ERROR", JOptionPane.ERROR_MESSAGE);
				}
								
				}

				private void dispose() {	
				}
						
		});
		btnlogin.setBackground(new Color(255, 255, 255));
		btnlogin.setBounds(394, 214, 102, 23);
		panel.add(btnlogin);
				
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				JFrame frmLoginSystem = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login system",
						JOptionPane.OK_OPTION)== JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		btnexit.setBackground(new Color(255, 255, 255));
		btnexit.setBounds(394, 255, 102, 23);
		panel.add(btnexit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dell_i5\\Pictures\\images (1).png"));
		lblNewLabel.setBounds(0, -13, 270, 313);
		panel.add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
