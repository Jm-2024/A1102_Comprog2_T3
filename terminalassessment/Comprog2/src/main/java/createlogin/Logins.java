package createlogin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import admin_portal.adminportal;
import adminaccess.adminlogin;

public class Logins extends JFrame {
    private JTextField user, pass, name;
    private JTable table;
    private DefaultTableModel model;
    private int selectedRow = -1;
    private static final String CSV_FILE = "C:\\Users\\Dell_i5\\Desktop\\MMDC File\\TA\\adminacess.csv";

    public Logins() {
        // Frame settings
        setTitle("Create Log in");
        setSize(600, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create column names
        String[] columns = {"Username", "Password", "Name"};

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
                    user.setText(model.getValueAt(selectedRow, 0).toString());
                    pass.setText(model.getValueAt(selectedRow, 1).toString());
                    name.setText(model.getValueAt(selectedRow, 2).toString());
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

        user = new JTextField();
        pass = new JTextField();
        name = new JTextField();
 
       
        fieldsPanel.add(new JLabel("Username:"));
        fieldsPanel.add(user);
        fieldsPanel.add(new JLabel("Password:"));
        fieldsPanel.add(pass);
        fieldsPanel.add(new JLabel("Name:"));
        fieldsPanel.add(name);

        inputPanel.add(fieldsPanel);

        // Sub-panel for buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        JButton Menu = new JButton("Back");
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
                Back();
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
    
    private void Back() {
    	
    	if (JOptionPane.showConfirmDialog(null, "Confirm if you want to Continue", "Confirm System",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {	
    	
    		createportal info = new createportal();   	
    		createportal.main(null);		
    		info.setVisible(true);    		
    		this.dispose();
    	}
    }
    
    private void addRow() {
        String userr = user.getText();
        String pasw = pass.getText();
        String names = name.getText();

      

        if (!userr.isEmpty() && !pasw.isEmpty() && !((CharSequence) names).isEmpty()) {
            model.addRow(new Object[]{userr, pasw, names,});
            saveCSV();
            clearFields();
            JOptionPane.showMessageDialog(null, "Successfully Added");
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
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRow() {
        if (selectedRow != -1) {
            String userr = user.getText();
            String pasw = pass.getText();
            String names = name.getText();

            if (!userr.isEmpty() && !pasw.isEmpty() && !names.isEmpty()) {
               
            	model.setValueAt(userr, selectedRow, 0);
                model.setValueAt(pasw, selectedRow, 1);
                model.setValueAt(names, selectedRow, 2);
                saveCSV();
                clearFields();
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        user.setText("");
        pass.setText("");
        name.setText("");

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
                String[] header = {"Username", "Password", "Name"};
                writer.writeNext(header);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Logins().setVisible(true);
            }
        });
    }
}
