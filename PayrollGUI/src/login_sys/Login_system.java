package login_sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Signup.Signup;
import employee_Details.EData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.awt.event.ActionEvent;
import java.awt.Canvas;

public class Login_system extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JFrame JFrame;
	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;
	private JFrame frmLoginSystem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_system frame = new Login_system();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_system() {
		setForeground(new Color(0, 0, 0));
		setTitle("MotorPh Payroll System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToYour = new JLabel("WELCOME TO YOUR PORTAL");
		lblWelcomeToYour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcomeToYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToYour.setBounds(123, 37, 238, 39);
		contentPane.add(lblWelcomeToYour);
		
		txtusername = new JTextField();
		txtusername.setBounds(147, 105, 238, 26);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(147, 132, 238, 26);
		contentPane.add(txtpassword);
		
		JLabel lbluser = new JLabel("Username");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbluser.setBounds(81, 111, 65, 14);
		contentPane.add(lbluser);
		
		JLabel lblpass = new JLabel("Password");
		lblpass.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblpass.setBounds(81, 138, 65, 14);
		contentPane.add(lblpass);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login system",
						JOptionPane.OK_OPTION)== JOptionPane.OK_OPTION) {
					System.exit(0);;
				}
			}
		});
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBounds(385, 224, 89, 26);
		contentPane.add(btnExit);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Signup info = new Signup();
				Signup.main(null);
				dispose();
			}
		});
		btnRegister.setBounds(147, 165, 89, 26);
		contentPane.add(btnRegister);
		
		JButton btnlogin = new JButton("Log In");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					File fr = new File ("C:\\Users\\Dell_i5\\Desktop\\MMDC File\\T3CSV\\EmployeeData.txt");
					Scanner scan = new Scanner(fr);
					scan.useDelimiter(",");
					
					while(scan.nextLine() !=null){
				        String username = scan.next();
				        String password = scan.next();
				        scan.next();
					
					if (txtusername.getText().equals(username)) {
				        JOptionPane.showMessageDialog(null, "Username Field is empty");
				    } else if (txtpassword.getText().equals(password)) {
				        JOptionPane.showMessageDialog(null, "Password Field is empty");
				    }
					
				               JOptionPane.showMessageDialog(null,"Username and Password is not correct");
				
					}
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnlogin.setBackground(new Color(255, 255, 255));
		btnlogin.setBounds(296, 165, 89, 26);
		contentPane.add(btnlogin);
	}
}