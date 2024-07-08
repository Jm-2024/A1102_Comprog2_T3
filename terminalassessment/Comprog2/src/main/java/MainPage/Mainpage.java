package MainPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import adminaccess.adminlogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainpage {

	private JFrame main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage window = new Mainpage();
					window.main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		main = new JFrame();
		main.setResizable(false);
		main.setTitle("Main System");
		main.getContentPane().setBackground(Color.WHITE);
		main.getContentPane().setLayout(null);
		
		JLabel lblYourPayrollPortal = new JLabel("Your Payroll Portal");
		lblYourPayrollPortal.setVerticalAlignment(SwingConstants.TOP);
		lblYourPayrollPortal.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		lblYourPayrollPortal.setBounds(161, 55, 263, 49);
		main.getContentPane().add(lblYourPayrollPortal);
		
		JLabel lblNewLabel = new JLabel("Welcome To ");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(211, 11, 156, 49);
		main.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell_i5\\Pictures\\images (1).png"));
		lblNewLabel_1.setBounds(-20, 12, 191, 239);
		main.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Click Here To Access");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//This button will go to aadmin log in page
				
				if (JOptionPane.showConfirmDialog(main, "Confirm if you want to Proceed", "Main System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {	
					
					adminlogin info = new adminlogin();
					adminlogin.main(null);
					info.setVisible(true);
					main.dispose();
					
					
				}
			}
		});
		btnNewButton.setBounds(228, 160, 156, 23);
		main.getContentPane().add(btnNewButton);
		main.setForeground(Color.WHITE);
		main.setBounds(100, 100, 450, 300);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
