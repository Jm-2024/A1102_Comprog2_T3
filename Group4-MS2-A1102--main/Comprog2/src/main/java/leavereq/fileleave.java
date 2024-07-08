package leavereq;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import admin_portal.adminaccess;
import adminaccess.adminlogin;

public class fileleave extends JFrame {
    private JTextField empNumField, lastNameField, firstNameField, reasonfield ;
    private JTable table;
    private DefaultTableModel model;
    private int selectedRow = -1;
    private static final String CSV_FILE = "C:\\Users\\Dell_i5\\Desktop\\MMDC File\\TA\\leaverequest.csv";

    public fileleave() {
        // Frame settings
        setTitle("Employee Table");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create column names
        String[] columns = {"Employee Number", "Last Name", "First Name", "Reason"};

        // Create table model and table
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        // Ensure CSV file exists
        initializeCSV();

        loadCSV();

        // Add mouse listener to the table for row selection
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    empNumField.setText(model.getValueAt(selectedRow, 0).toString());
                    lastNameField.setText(model.getValueAt(selectedRow, 1).toString());
                    firstNameField.setText(model.getValueAt(selectedRow, 2).toString());
                    reasonfield.setText(model.getValueAt(selectedRow, 3).toString());

                }
            }
        });

        // Add table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));

        // Sub-panel for input fields
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new GridLayout(2, 7));

        empNumField = new JTextField();
        lastNameField = new JTextField();
        firstNameField = new JTextField();
        reasonfield = new JTextField();
        

        fieldsPanel.add(new JLabel("Employee No.:"));
        fieldsPanel.add(empNumField);
        fieldsPanel.add(new JLabel("Last Name:"));
        fieldsPanel.add(lastNameField);
        fieldsPanel.add(new JLabel("First Name:"));
        fieldsPanel.add(firstNameField);
        fieldsPanel.add(new JLabel("Reason:"));
        fieldsPanel.add(reasonfield);

        inputPanel.add(fieldsPanel);

        // Sub-panel for buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        JButton Menu = new JButton("Menu");
        JButton Logout = new JButton("Log Out");

        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(Menu);
        buttonsPanel.add(Logout);

        inputPanel.add(buttonsPanel);

        // Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateRow();
            }
        });
       
        Menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu();
            }
        });
        
        Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
            	 Logout();
            }
        });
        add(inputPanel, BorderLayout.SOUTH);
    }
 
    private void Logout() {
    	if (JOptionPane.showConfirmDialog(null, "Confirm if you want to Log Out", "Log Out System",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {	
			
			adminlogin info = new adminlogin();
			adminlogin.main(null);
			info.setVisible(true);
			this.dispose();
			
		}
	
    }
    
    private void Menu() {
    	
    	if (JOptionPane.showConfirmDialog(null, "Confirm if you want Continue", null,
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
    		
    		adminaccess info = new adminaccess();
	    	adminaccess.main(null);
			info.setVisible(true);
			this.dispose();
		
    	}
    }
    
    private void addRow() {
    	
        String empNum = empNumField.getText();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String reas = reasonfield.getText();
        

        if (!empNum.isEmpty() && !lastName.isEmpty() && !firstName.isEmpty() && !reas.isEmpty()) {
            model.addRow(new Object[]{empNum, lastName, firstName, reas });
            saveCSV();
            clearFields();
            
            JOptionPane.showMessageDialog(this, "Successfully Added", "Add", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteRow() {
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
            saveCSV();
            clearFields();
            selectedRow = -1;
            
            JOptionPane.showMessageDialog(this, "Successfully Deleted", "Delete", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRow() {
        if (selectedRow != -1) {
            String empNum = empNumField.getText();
            String lastName = lastNameField.getText();
            String firstName = firstNameField.getText();
            String reas = reasonfield.getText();

            if (!empNum.isEmpty() && !lastName.isEmpty() && !firstName.isEmpty() && !reas.isEmpty()) {
               
            	model.setValueAt(empNum, selectedRow, 0);
                model.setValueAt(lastName, selectedRow, 1);
                model.setValueAt(firstName, selectedRow, 2);
                model.setValueAt(reas, selectedRow, 3);
                
                
                
                saveCSV();
                clearFields();
                
                JOptionPane.showMessageDialog(this, "Successfully Updated", "Update", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        empNumField.setText("");
        lastNameField.setText("");
        firstNameField.setText("");
        reasonfield.setText("");
    }

    private void saveCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            Vector<Vector> data = model.getDataVector();
            for (Vector row : data) {
                String[] rowData = new String[row.size()];
                for (int i = 0; i < row.size(); i++) {
                    rowData[i] = row.get(i).toString();
                }
                writer.writeNext(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                model.addRow(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeCSV() {
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
                String[] header = {"Employee Number", "Last Name", "First Name", "Birthday", "Gender", "Email", "Phone No.", "Address","SSS No.", "Pag-Ibig No.", "Philhealth No.", "TIN No.", "Status", "Position",
                		"Department","Supervisor","Date Hired", "Job Title", "Basic Salary"};
                writer.writeNext(header);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new fileleave().setVisible(true);
            }
        });
    }
}
