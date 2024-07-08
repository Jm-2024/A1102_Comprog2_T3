package admin_portal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import adminaccess.adminlogin;
import createlogin.createportal;
import leavereq.fileleave;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;

public class adminportal {

	private JFrame frmAdminPortalSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminportal window = new adminportal();
					window.frmAdminPortalSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public adminportal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPortalSystem = new JFrame();
		frmAdminPortalSystem.getContentPane().setBackground(new Color(0, 0, 0));
		frmAdminPortalSystem.setTitle("Admin Portal System");
		frmAdminPortalSystem.setResizable(false);
		frmAdminPortalSystem.setBounds(100, 100, 517, 374);
		frmAdminPortalSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPortalSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 482, 313);
		frmAdminPortalSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnSalary = new JButton("Create Account");
		btnSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					createportal info = createportal();
					createportal.main(null);
					frmAdminPortalSystem.dispose();
									
			}

			private createportal createportal() {
				return null;
			}
		});
		btnSalary.setBounds(47, 170, 185, 43);
		btnSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnSalary);
		
		JButton btnNewButton_2 = new JButton("Log Out");
		btnNewButton_2.setBounds(375, 264, 97, 26);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (JOptionPane.showConfirmDialog(frmAdminPortalSystem, "Confirm if you want to Log Out", "Log Out System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {	
					
					adminlogin info = new adminlogin();
					adminlogin.main(null);
					info.setVisible(true);
					frmAdminPortalSystem.dispose();
					
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JLabel lblLabel = new JLabel("");
		lblLabel.setIcon(new ImageIcon("C:\\Users\\Dell_i5\\Downloads\\images (1).png"));
		lblLabel.setBounds(23, 11, 436, 148);
		lblLabel.setFont(new Font("Rockwell", Font.PLAIN, 15));
		panel.add(lblLabel);
		
		JButton btnCreateLogIn = new JButton("Employee Details");
		btnCreateLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeData info = new EmployeeData();
				EmployeeData.main(null);
				frmAdminPortalSystem.dispose();
				
			}
		});
		btnCreateLogIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreateLogIn.setBounds(274, 170, 185, 43);
		panel.add(btnCreateLogIn);
		
		JButton btnLeaveRequest = new JButton("Leave Request");
		btnLeaveRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fileleave info = new fileleave();
				fileleave.main(null);
				frmAdminPortalSystem.dispose();
			}
		});
		btnLeaveRequest.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLeaveRequest.setBounds(146, 224, 185, 43);
		panel.add(btnLeaveRequest);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
