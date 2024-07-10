package createlogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import admin_portal.adminportal;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class createportal {

	private JFrame frmCreateLogIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createportal window = new createportal();
					window.frmCreateLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public createportal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreateLogIn = new JFrame();
		frmCreateLogIn.getContentPane().setBackground(new Color(230, 230, 230));
		frmCreateLogIn.setTitle("Create Log In");
		frmCreateLogIn.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmCreateLogIn.setResizable(false);
		frmCreateLogIn.setBounds(100, 100, 411, 264);
		frmCreateLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateLogIn.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 244, 244));
		panel.setBounds(10, 11, 375, 203);
		frmCreateLogIn.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame frmLoginSystem = new JFrame ("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login system",
						JOptionPane.OK_OPTION)== JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(276, 169, 89, 23);
		panel.add(btnExit);
		
		JButton btnNewButton_2_1 = new JButton("Menu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(frmCreateLogIn, "Confirm if you want proceed", "Menu System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {	
					
					adminportal info = new adminportal();
					adminportal.main(null);
					info.setVisible(true);
					frmCreateLogIn.dispose();
					
				}
			}
		});
		btnNewButton_2_1.setBounds(10, 169, 89, 23);
		panel.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("You Are Now Creating Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(51, 11, 272, 42);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2_1_1 = new JButton("Create New Login");
		btnNewButton_2_1_1.setFont(new Font("Dialog", Font.BOLD, 10));
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Logins info = new Logins();
				Logins.main(null);
				info.setVisible(false);
				frmCreateLogIn.dispose();			
			}
		});
		btnNewButton_2_1_1.setBounds(116, 83, 142, 36);
		panel.add(btnNewButton_2_1_1);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
