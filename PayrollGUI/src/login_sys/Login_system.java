package login_sys;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = txtpassword.getText();
				String username = txtusername.getText();
				
				if (password.contains("king") && username.contains("one")) {
					txtpassword.setText(null);
					txtusername.setText(null);
					
					EData info = new EData();
					EData.main(null);
					dispose();
					
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Invalid Log In Details","Log In error", JOptionPane.ERROR_MESSAGE);
					txtpassword.setText(null);
					txtusername.setText(null);
				}
				
			}
		});
		btnLogIn.setBackground(new Color(255, 255, 255));
		btnLogIn.setBounds(147, 163, 89, 26);
		contentPane.add(btnLogIn);
		
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
		btnExit.setBounds(296, 163, 89, 26);
		contentPane.add(btnExit);
	}
}
