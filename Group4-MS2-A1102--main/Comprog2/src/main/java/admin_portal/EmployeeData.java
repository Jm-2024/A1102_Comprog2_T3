package admin_portal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import adminaccess.adminlogin;

public class EmployeeData extends JFrame {
    private JTextField empNumField, lastNameField, firstNameField, BirthField, GenderField, EmailField, phoneField, addressField, sssFields, pagibigFields, Philhealth, Tinfields, status, position
    , department, supervisor, datehired, job, salary;
    private JTable table;
    private DefaultTableModel model;
    private int selectedRow = -1;
    private static final String CSV_FILE = "C:\\Users\\Dell_i5\\Desktop\\MMDC File\\TA\\FinalTA.csv";

    public EmployeeData() {
        // Frame settings
        setTitle("Employee Table");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create column names
        String[] columns = {"Employee Number", "Last Name", "First Name", "Birthday", "Gender", "Email", "Phone No.", "Address","SSS No.", "Pag-Ibig No.", "Philhealth No.", "TIN No.", "Status", "Position",
        		"Department","Supervisor","Date Hired", "Job Title", "Basic Salary"};

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
                    BirthField.setText(model.getValueAt(selectedRow, 3).toString());
                    GenderField.setText(model.getValueAt(selectedRow, 4).toString());
                    EmailField.setText(model.getValueAt(selectedRow, 5).toString());
                    phoneField.setText(model.getValueAt(selectedRow, 6).toString());
                    addressField.setText(model.getValueAt(selectedRow, 7).toString());
                    sssFields.setText(model.getValueAt(selectedRow, 8).toString());
                    pagibigFields.setText(model.getValueAt(selectedRow, 9).toString());
                    Philhealth.setText(model.getValueAt(selectedRow, 10).toString());
                    Tinfields.setText(model.getValueAt(selectedRow, 11).toString());
                    status.setText(model.getValueAt(selectedRow, 12).toString());
                    position.setText(model.getValueAt(selectedRow, 13).toString());
                    department.setText(model.getValueAt(selectedRow, 14).toString());
                    supervisor.setText(model.getValueAt(selectedRow, 15).toString());
                    datehired.setText(model.getValueAt(selectedRow, 16).toString());
                    job.setText(model.getValueAt(selectedRow, 17).toString());
                    salary.setText(model.getValueAt(selectedRow, 18).toString());
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
        BirthField = new JTextField();
        GenderField = new JTextField();
        EmailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        sssFields = new JTextField();
        pagibigFields = new JTextField();
        Philhealth = new JTextField();
        Tinfields = new JTextField();
        status = new JTextField();
        position = new JTextField();
        department = new JTextField();
        supervisor = new JTextField();
        datehired = new JTextField();
        job = new JTextField();
        salary = new JTextField();
        

        fieldsPanel.add(new JLabel("Employee No.:"));
        fieldsPanel.add(empNumField);
        fieldsPanel.add(new JLabel("Last Name:"));
        fieldsPanel.add(lastNameField);
        fieldsPanel.add(new JLabel("First Name:"));
        fieldsPanel.add(firstNameField);
        fieldsPanel.add(new JLabel("Birthday:"));
        fieldsPanel.add(BirthField);
        fieldsPanel.add(new JLabel("Gender:"));
        fieldsPanel.add(GenderField);
        fieldsPanel.add(new JLabel("Email"));
        fieldsPanel.add(EmailField);
        fieldsPanel.add(new JLabel("Phone No.:"));
        fieldsPanel.add(phoneField);
        fieldsPanel.add(new JLabel("Address:"));
        fieldsPanel.add(addressField);
        fieldsPanel.add(new JLabel("SSS No.:"));
        fieldsPanel.add(sssFields);
        fieldsPanel.add(new JLabel("Pag-Ibig No.:"));
        fieldsPanel.add(pagibigFields);
        fieldsPanel.add(new JLabel("Phil-Health No.:"));
        fieldsPanel.add(Philhealth);
        fieldsPanel.add(new JLabel("TIN No.:"));
        fieldsPanel.add(Tinfields);
        fieldsPanel.add(new JLabel("Status:"));
        fieldsPanel.add(status);
        fieldsPanel.add(new JLabel("Position:"));
        fieldsPanel.add(position);
        fieldsPanel.add(new JLabel("Department:"));
        fieldsPanel.add(department);
        fieldsPanel.add(new JLabel("Supervisor:"));
        fieldsPanel.add(supervisor);
        fieldsPanel.add(new JLabel("Date Hired:"));
        fieldsPanel.add(datehired);
        fieldsPanel.add(new JLabel("Job Title:"));
        fieldsPanel.add(job);
        fieldsPanel.add(new JLabel("Basic Salary:"));
        fieldsPanel.add(salary);
        
        
       

        inputPanel.add(fieldsPanel);

        // Sub-panel for buttons
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 4));

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");
        JButton viewButton = new JButton("View Employee");
        JButton Menu = new JButton("Menu");
        JButton Logout = new JButton("Log Out");

        buttonsPanel.add(addButton);
        buttonsPanel.add(deleteButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(viewButton);
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

        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewEmployee();
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
    	adminaccess info = new adminaccess();
		adminaccess.main(null);
		info.setVisible(true);
		this.dispose();
    }
    
    private void addRow() {
        String empNum = empNumField.getText();
        String lastName = lastNameField.getText();
        String firstName = firstNameField.getText();
        String birth = BirthField.getText();
        String gender = GenderField.getText();
        String email = EmailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        String sss = sssFields.getText();
        String pagibig = pagibigFields.getText();
        String philhealth = Philhealth.getText();
        String tin = Tinfields.getText();
        String stat= status.getText();
        String pos = position.getText();
        String dep = department.getText();
        String sup = supervisor.getText();
        String date= datehired.getText();
        String jobtitle = job.getText();
        String sal = salary.getText();
        

        if (!empNum.isEmpty() && !lastName.isEmpty() && !firstName.isEmpty() && !birth.isEmpty() && !gender.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !sss.isEmpty()
        && !pagibig.isEmpty() && !philhealth.isEmpty() && !tin.isEmpty() && !stat.isEmpty() && !pos.isEmpty() && !dep.isEmpty() && !sup.isEmpty() && !date.isEmpty() && !jobtitle.isEmpty() && !sal.isEmpty()) {
            model.addRow(new Object[]{empNum, lastName, firstName, birth, gender, email, phone, address, sss, pagibig, philhealth, tin, stat, pos, dep, sup, date, jobtitle, sal });
            saveCSV();
            clearFields();
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
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateRow() {
        if (selectedRow != -1) {
            String empNum = empNumField.getText();
            String lastName = lastNameField.getText();
            String firstName = firstNameField.getText();
            String birth = BirthField.getText();
            String gender = GenderField.getText();
            String email = EmailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();
            String sss = sssFields.getText();
            String pagibig = pagibigFields.getText();
            String philhealth = Philhealth.getText();
            String tin = Tinfields.getText();
            String stat= status.getText();
            String pos = position.getText();
            String dep = department.getText();
            String sup = supervisor.getText();
            String date= datehired.getText();
            String jobtitle = job.getText();
            String sal = salary.getText();

            if (!empNum.isEmpty() && !lastName.isEmpty() && !firstName.isEmpty() && !birth.isEmpty() && !gender.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty() && !sss.isEmpty()
                    && !pagibig.isEmpty() && !philhealth.isEmpty() && !tin.isEmpty() && !stat.isEmpty() && !pos.isEmpty() && !dep.isEmpty() && !sup.isEmpty() && !date.isEmpty() && !jobtitle.isEmpty() && !sal.isEmpty()) {
               
            	model.setValueAt(empNum, selectedRow, 0);
                model.setValueAt(lastName, selectedRow, 1);
                model.setValueAt(firstName, selectedRow, 2);
                model.setValueAt(birth, selectedRow, 3);
                model.setValueAt(gender, selectedRow, 4);
                model.setValueAt(email, selectedRow, 5);
                model.setValueAt(phone, selectedRow, 6);
                model.setValueAt(address, selectedRow, 7);
                model.setValueAt(sss, selectedRow, 8);
                model.setValueAt(pagibig, selectedRow, 9);
                model.setValueAt(philhealth, selectedRow, 10);
                model.setValueAt(tin, selectedRow, 11);
                model.setValueAt(stat, selectedRow, 12);
                model.setValueAt(pos, selectedRow, 13);
                model.setValueAt(dep, selectedRow, 14);
                model.setValueAt(sup, selectedRow, 15);
                model.setValueAt(date, selectedRow, 16);
                model.setValueAt(jobtitle, selectedRow, 17);
                model.setValueAt(sal, selectedRow, 18);
                
                
                
                saveCSV();
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to update", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewEmployee() {
        if (selectedRow != -1) {
            String empNum = model.getValueAt(selectedRow, 0).toString();
            String lastName = model.getValueAt(selectedRow, 1).toString();
            String firstName = model.getValueAt(selectedRow, 2).toString();
            String birth = model.getValueAt(selectedRow, 3).toString();
            String gender = model.getValueAt(selectedRow, 4).toString();
            String email = model.getValueAt(selectedRow, 5).toString();
            String phone = model.getValueAt(selectedRow, 6).toString();
            String address = model.getValueAt(selectedRow, 7).toString();
            String sss = model.getValueAt(selectedRow, 8).toString();
            String pagibig = model.getValueAt(selectedRow, 9).toString();
            String philhealth = model.getValueAt(selectedRow, 10).toString();
            String tin = model.getValueAt(selectedRow, 11).toString();
            String stat= model.getValueAt(selectedRow, 12).toString();
            String pos = model.getValueAt(selectedRow, 13).toString();
            String dep = model.getValueAt(selectedRow, 14).toString();
            String sup = model.getValueAt(selectedRow, 15).toString();
            String date= model.getValueAt(selectedRow, 16).toString();
            String jobtitle = model.getValueAt(selectedRow, 17).toString();
            String sal = model.getValueAt(selectedRow, 18).toString();
            
            
            
            
            
            JFrame detailsFrame = new JFrame("Employee Details");
            detailsFrame.setSize(600, 600);
            detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            detailsFrame.setLayout(new GridLayout(16, 2));

            detailsFrame.add(new JLabel("Employee Number:"));
            JTextField empNumField = new JTextField(empNum);
            empNumField.setEditable(false);
            detailsFrame.add(empNumField);

            detailsFrame.add(new JLabel("Last Name:"));
            JTextField lastNameField = new JTextField(lastName);
            lastNameField.setEditable(false);
            detailsFrame.add(lastNameField);

            detailsFrame.add(new JLabel("First Name:"));
            JTextField firstNameField = new JTextField(firstName);
            firstNameField.setEditable(false);
            detailsFrame.add(firstNameField);

            detailsFrame.add(new JLabel("Birthday:"));
            JTextField BirthField = new JTextField(birth);
            BirthField.setEditable(false);
            detailsFrame.add(BirthField);

            detailsFrame.add(new JLabel("Gender:"));
            JTextField genderField = new JTextField(gender);
            genderField.setEditable(false);
            detailsFrame.add(genderField);

            detailsFrame.add(new JLabel("Email:"));
            JTextField EmailField = new JTextField(email);
            EmailField.setEditable(false);
            detailsFrame.add(EmailField);

            detailsFrame.add(new JLabel("Phone No.:"));
            JTextField PhoneField = new JTextField(phone);
            PhoneField.setEditable(false);
            detailsFrame.add(PhoneField);
            
            detailsFrame.add(new JLabel("Address:"));
            JTextField addressField = new JTextField(address);
            addressField.setEditable(false);
            detailsFrame.add(addressField);
            
            
            detailsFrame.add(new JLabel("SSS No.:"));
            JTextField sssField = new JTextField(sss);
            sssField.setEditable(false);
            detailsFrame.add(sssField);

            detailsFrame.add(new JLabel("Pag-Ibig No.:"));
            JTextField pagibigFields = new JTextField(pagibig);
            pagibigFields.setEditable(false);
            detailsFrame.add(pagibigFields);

            detailsFrame.add(new JLabel("Phil-Health no.:"));
            JTextField Philhealth = new JTextField(philhealth);
            Philhealth.setEditable(false);
            detailsFrame.add(Philhealth);

            detailsFrame.add(new JLabel("TIN No.:"));
            JTextField Tinfields = new JTextField(tin);
            Tinfields.setEditable(false);
            detailsFrame.add(Tinfields);

            detailsFrame.add(new JLabel("Status:"));
            JTextField status = new JTextField(stat);
            status.setEditable(false);
            detailsFrame.add(status);

            detailsFrame.add(new JLabel("Position:"));
            JTextField position = new JTextField(pos);
            position.setEditable(false);
            detailsFrame.add(position);

            detailsFrame.add(new JLabel("Department:"));
            JTextField department = new JTextField(dep);
            department.setEditable(false);
            detailsFrame.add(department);
            
            
            detailsFrame.add(new JLabel("Supervisor:"));
            JTextField supervisor = new JTextField(sup);
            supervisor.setEditable(false);
            detailsFrame.add(supervisor);
            
            detailsFrame.add(new JLabel("Hired Date:"));
            JTextField datehired = new JTextField(date);
            datehired.setEditable(false);
            detailsFrame.add(datehired);
            
            detailsFrame.add(new JLabel("Job Title:"));
            JTextField job = new JTextField(jobtitle);
            job.setEditable(false);
            detailsFrame.add(job);
            
            detailsFrame.add(new JLabel("Basic Salary:"));
            JTextField salary = new JTextField(sal);
            salary.setEditable(false);
            detailsFrame.add(salary);         

            detailsFrame.add(new JLabel("Basic Salary:"));
            JTextField basicSalaryField = new JTextField();
            detailsFrame.add(basicSalaryField);

            detailsFrame.add(new JLabel("Month:"));
            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            JComboBox<String> monthComboBox = new JComboBox<>(months);
            detailsFrame.add(monthComboBox);

            JButton computeButton = new JButton("Compute");
            detailsFrame.add(computeButton);

            JTextField totalSalaryField = new JTextField();
            totalSalaryField.setEditable(false);
            detailsFrame.add(totalSalaryField);

            detailsFrame.add(new JLabel("PagIbig Deduction:"));
            JTextField pagibigDeductionField = new JTextField();
            pagibigDeductionField.setEditable(false);
            detailsFrame.add(pagibigDeductionField);

            detailsFrame.add(new JLabel("SSS Deduction:"));
            JTextField sssDeductionField = new JTextField();
            sssDeductionField.setEditable(false);
            detailsFrame.add(sssDeductionField);

            detailsFrame.add(new JLabel("PhilHealth Deduction:"));
            JTextField philHealthDeductionField = new JTextField();
            philHealthDeductionField.setEditable(false);
            detailsFrame.add(philHealthDeductionField);

            detailsFrame.add(new JLabel("Withholding Tax Deduction:"));
            JTextField withholdingTaxField = new JTextField();
            withholdingTaxField.setEditable(false);
            detailsFrame.add(withholdingTaxField);

            computeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        double basicSalary = Double.parseDouble(basicSalaryField.getText());

                        // Calculating deductions
                        double pagibigDeduction = basicSalary * 0.02;
                        double sssDeduction = 1125;
                        double philHealthDeduction = (basicSalary * 0.03) / 50;
                        double totalDeductions = pagibigDeduction + sssDeduction + philHealthDeduction;

                        // Calculating withholding tax
                        double taxableIncome = basicSalary - totalDeductions;
                        double withholdingTax = 0;
                        if (taxableIncome > 20833) {
                            withholdingTax = (taxableIncome - 20833) * 0.20;
                        }

                        // Total deductions including withholding tax
                        totalDeductions += withholdingTax;

                        // Calculating final salary
                        double finalSalary = basicSalary - totalDeductions;

                        // Displaying results
                        pagibigDeductionField.setText(String.format("%.2f", pagibigDeduction));
                        sssDeductionField.setText(String.format("%.2f", sssDeduction));
                        philHealthDeductionField.setText(String.format("%.2f", philHealthDeduction));
                        withholdingTaxField.setText(String.format("%.2f", withholdingTax));
                        totalSalaryField.setText(String.format("%.2f", finalSalary));

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(detailsFrame, "Please enter a valid basic salary.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            detailsFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to view", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        empNumField.setText("");
        lastNameField.setText("");
        firstNameField.setText("");
        BirthField.setText("");
        GenderField.setText("");
        EmailField.setText("");
        phoneField.setText("");
        addressField.setText("");
        sssFields.setText("");
        pagibigFields.setText("");
        Philhealth.setText("");
        Tinfields.setText("");
        status.setText("");
        position.setText("");
        department.setText("");
        supervisor.setText("");
        datehired.setText("");
        job.setText("");
        salary.setText("");
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
                new EmployeeData().setVisible(true);
            }
        });
    }
}
