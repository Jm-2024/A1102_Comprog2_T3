package createlogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import admin_portal.adminaccess;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class createadmin {

	private JFrame frmMotorph;
	private JTextField txtnewUser;
	private JTextField txtNewpassword;
	private JTextField txtname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createadmin window = new createadmin();
					window.frmMotorph.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public createadmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMotorph = new JFrame();
		frmMotorph.setResizable(false);
		frmMotorph.setTitle("MotorPh Sign Up Page");
		frmMotorph.getContentPane().setBackground(new Color(0, 0, 0));
		frmMotorph.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 364, 227);
		frmMotorph.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Login for Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(61, 5, 241, 25);
		panel.add(lblNewLabel);
		
		txtnewUser = new JTextField();
		txtnewUser.setToolTipText("Username");
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
		txtNewpassword.setToolTipText("Password");
		txtNewpassword.setColumns(10);
		txtNewpassword.setBounds(95, 136, 247, 25);
		panel.add(txtNewpassword);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String name  = txtname.getText();
				 String uname = txtnewUser.getText();
				 String npass = txtNewpassword.getText();
				 
				 try {
					FileWriter writer = new FileWriter("C:\\Users\\Dell_i5\\Desktop\\MMDC File\\TA\\adminacess.csv", true);
					writer.write(""+uname+","+npass+","+name );
					writer.write(System.getProperty("line.separator"));
					writer.close();
					JOptionPane.showMessageDialog(null, "Success");
					dispose();
										
				} catch (Exception e1) {
				}
			}
		});
		btnSignup.setBounds(253, 172, 89, 23);
		panel.add(btnSignup);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adminaccess info = new adminaccess();
				adminaccess.main(null);
				info.setVisible(true);
				frmMotorph.dispose();					
			}

			private void dispose() {				
			}
		});
		btnMenu.setBounds(95, 172, 89, 23);
		panel.add(btnMenu);
		
		txtname = new JTextField();
		txtname.setToolTipText("Username");
		txtname.setColumns(10);
		txtname.setBounds(95, 64, 247, 25);
		panel.add(txtname);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(10, 64, 75, 25);
		panel.add(lblName);
		frmMotorph.setBounds(100, 100, 400, 288);
		frmMotorph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
