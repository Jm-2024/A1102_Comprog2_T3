package GradeCalculator;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Font;

public class GradeCalculator extends JFrame {
    // Declare private variables for the Swing components
    private JLabel lblStudentName, lblStudentNo, lblMs1, lblMs2, lblTa3;
    private JTextField txtStudentName, txtStudentNo, txtQuiz1, txtQuiz2, txtQuiz3;
    private JButton calculateButton;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeCalculator frame = new GradeCalculator();
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
	  public GradeCalculator() {
	        // Set up the frame
	        super("Grade Calculator");
	        setFont(new Font("Californian FB", Font.PLAIN, 13));
	        setTitle("Milestone Calculator");
	        setSize(450, 250);


	        // Create the components
	        // Create labels and textfields
	        lblStudentName = new JLabel("Student Name:");
	        txtStudentName = new JTextField(30);
	        lblStudentNo = new JLabel("Student No:");
	        txtStudentNo = new JTextField(30);
	        lblMs1 = new JLabel("Milestone	 1:");
	        txtQuiz1 = new JTextField(10);
	        lblMs2 = new JLabel("Milestone 2:");
	        txtQuiz2 = new JTextField(10);
	        lblTa3 = new JLabel("Terminal Assessment:");
	        txtQuiz3 = new JTextField(10);
	        calculateButton = new JButton("Calculate");
	        calculateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
	        calculateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
	        calculateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
	        calculateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
	        calculateButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
	       
	        // Define the panel to hold the components  
	        JPanel panel = new JPanel();
	        SpringLayout layout = new SpringLayout();
	        layout.putConstraint(SpringLayout.NORTH, calculateButton, 32, SpringLayout.SOUTH, txtQuiz3);
	        layout.putConstraint(SpringLayout.SOUTH, calculateButton, -28, SpringLayout.SOUTH, panel);
	        layout.putConstraint(SpringLayout.NORTH, txtQuiz3, -3, SpringLayout.NORTH, lblTa3);
	        layout.putConstraint(SpringLayout.WEST, txtQuiz3, 48, SpringLayout.EAST, lblTa3);
	        layout.putConstraint(SpringLayout.WEST, calculateButton, 177, SpringLayout.WEST, panel);
	        layout.putConstraint(SpringLayout.NORTH, txtQuiz1, -3, SpringLayout.NORTH, lblMs1);
	        layout.putConstraint(SpringLayout.WEST, txtQuiz1, 0, SpringLayout.WEST, txtQuiz2);
	        layout.putConstraint(SpringLayout.NORTH, txtQuiz2, -3, SpringLayout.NORTH, lblMs2);
	        layout.putConstraint(SpringLayout.EAST, txtQuiz2, -133, SpringLayout.EAST, panel);
	        layout.putConstraint(SpringLayout.WEST, txtStudentName, 10, SpringLayout.EAST, lblStudentName);
	        layout.putConstraint(SpringLayout.NORTH, txtStudentNo, -3, SpringLayout.NORTH, lblStudentNo);
	        layout.putConstraint(SpringLayout.WEST, txtStudentNo, 0, SpringLayout.WEST, txtStudentName);
	        layout.putConstraint(SpringLayout.NORTH, txtStudentName, -3, SpringLayout.NORTH, lblStudentName);
	        panel.setSize(300, 300);
	        panel.setLayout(layout);
	       
	        // Add the components to the frame
	        panel.add(lblStudentName);
	        panel.add(txtStudentName);
	        panel.add(lblStudentNo);
	        panel.add(txtStudentNo);
	        panel.add(lblMs1);
	        panel.add(txtQuiz1);
	        panel.add(lblMs2);
	        panel.add(txtQuiz2);
	        panel.add(lblTa3);
	        panel.add(txtQuiz3);
	        panel.add(calculateButton);
	 
	        // Put constraint on components
	        // Set label position: left
	        layout.putConstraint(SpringLayout.WEST, lblStudentName, 6, SpringLayout.WEST, panel);
	        layout.putConstraint(SpringLayout.WEST, lblStudentNo, 6, SpringLayout.WEST, panel);
	        layout.putConstraint(SpringLayout.WEST, lblMs1, 6, SpringLayout.WEST, panel);
	        layout.putConstraint(SpringLayout.WEST, lblMs2, 6, SpringLayout.WEST, panel);
	        layout.putConstraint(SpringLayout.WEST, lblTa3, 6, SpringLayout.WEST, panel);
	       
	        // Set label and textfield position: top and bottom
	        layout.putConstraint(SpringLayout.NORTH, lblStudentName, 6, SpringLayout.NORTH, panel);
	        layout.putConstraint(SpringLayout.NORTH, lblStudentNo, 10, SpringLayout.SOUTH, lblStudentName);
	        layout.putConstraint(SpringLayout.NORTH, lblMs1, 10, SpringLayout.SOUTH, lblStudentNo);
	        layout.putConstraint(SpringLayout.NORTH, lblMs2, 10, SpringLayout.SOUTH, lblMs1);
	        layout.putConstraint(SpringLayout.NORTH, lblTa3, 10, SpringLayout.SOUTH, lblMs2);
	        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, calculateButton, 0, SpringLayout.HORIZONTAL_CENTER, panel);


	        //Add panel to frame
	        getContentPane().add(panel);
	        
	        
	     // Add an ActionListener to the button
	        JButton btnClose = new JButton("Close");
	        layout.putConstraint(SpringLayout.EAST, calculateButton, -108, SpringLayout.WEST, btnClose);
	        btnClose.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                   dispose();
	        	}
	        });
	        layout.putConstraint(SpringLayout.SOUTH, btnClose, -10, SpringLayout.SOUTH, panel);
	        layout.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, panel);
	        panel.add(btnClose);


	        // Add an ActionListener to the button
	        calculateButton.addActionListener((ActionListener) new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	try {
	                    // Read input values
	                    double milestone1 = Double.parseDouble(txtQuiz1.getText());
	                    double milestone2 = Double.parseDouble(txtQuiz2.getText());
	                    double terminalAssessment = Double.parseDouble(txtQuiz3.getText());

	                    // Validate input values
	                    if (milestone1 < 0 || milestone1 > 25) {
	                        throw new IllegalArgumentException("Milestone 1 must be between 0 and 25.");
	                    }
	                    if (milestone2 < 0 || milestone2 > 40) {
	                        throw new IllegalArgumentException("Milestone 2 must be between 0 and 40.");
	                    }
	                    if (terminalAssessment < 0 || terminalAssessment > 35) {
	                        throw new IllegalArgumentException("Terminal Assessment must be between 0 and 35.");
	                    }
	                    
	                }
	                    
	                    
	            		catch (NumberFormatException ex) {
	            			JOptionPane.showMessageDialog(GradeCalculator.this, "Please enter valid numerical values.","Input Error", JOptionPane.ERROR_MESSAGE);
	            			throw ex;
	            		}
	            		catch (IllegalArgumentException ex) {
	            			JOptionPane.showMessageDialog(GradeCalculator.this, ex.getMessage(),"Input Error", JOptionPane.ERROR_MESSAGE);
	            			throw ex;
	                	}
	            
	                Student stud = new Student();
	               
	                // Assign textfield values to stud object
	                stud.setStudentName(txtStudentName.getText());
	                stud.setStudentNumber(txtStudentNo.getText());
	                stud.setQuiz1(Float.parseFloat(txtQuiz1.getText()));
	                stud.setQuiz2(Float.parseFloat(txtQuiz2.getText()));
	                stud.setQuiz3(Float.parseFloat(txtQuiz3.getText()));
	               
	                // Instantiate and call GradeOutput class
	                GradeOutput output = new GradeOutput(stud);
	                output.setVisible(true);
	                
	                
	            }
	        });
	    }
	}