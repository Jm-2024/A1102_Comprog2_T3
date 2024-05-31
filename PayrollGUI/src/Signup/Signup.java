package Signup;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import login_sys.Login_system;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Signup {

	private JFrame frame;
	private JTextField txtnewUser;
	private JTextField txtNewpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 0, 255));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(10, 11, 364, 227);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(133, 5, 98, 25);
		panel.add(lblNewLabel);
		
		txtnewUser = new JTextField();
		txtnewUser.setBounds(95, 100, 247, 25);
		panel.add(txtnewUser);
		txtnewUser.setColumns(10);
		
		JLabel lblnewuser = new JLabel("Username");
		lblnewuser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnewuser.setBounds(10, 100, 75, 25);
		panel.add(lblnewuser);
		
		JLabel lblnewPassword = new JLabel("Password");
		lblnewPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnewPassword.setBounds(10, 141, 75, 25);
		panel.add(lblnewPassword);
		
		txtNewpassword = new JTextField();
		txtNewpassword.setColumns(10);
		txtNewpassword.setBounds(95, 136, 247, 25);
		panel.add(txtNewpassword);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String uname = txtnewUser.getText();
				 String npass = txtNewpassword.getText();
				 
				 try {
					FileWriter writer = new FileWriter("C:\\Users\\Dell_i5\\Desktop\\MMDC File\\T3CSV\\EmployeeData.txt", true);
					writer.write(""+uname+","+npass);
					writer.write(System.getProperty("line.separator"));
					writer.close();
					JOptionPane.showMessageDialog(null, "Success");
					
				} catch (IOException e1) {
				}
			}
		});
		btnSignup.setBounds(253, 172, 89, 23);
		panel.add(btnSignup);
		
		JButton btnLogin = new JButton("Log In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Login_system info = new Login_system();
					Login_system.main(null);
					dispose();
			}
		});
		btnLogin.setBounds(95, 172, 89, 23);
		panel.add(btnLogin);
		frame.setBounds(100, 100, 400, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
