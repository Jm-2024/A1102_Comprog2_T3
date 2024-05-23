package employee_Details;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login_sys.Login_system;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class EData extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame frmLoginSystem;
	private JTextField txtDailyRate;
	private JTextField txtHpay;
	private JTextField txtHpay2;
	private JTextField txtOpay;
	private JTextField txtOpay2;
	private JTextField txtEarnings;
	private JTextField txttotaldeduct;
	private JTextField txtnetpay;
	private JTextField txttax;
	private JTextField txtxssscontri;
	private JTextField pagibigcontri;
	private JTextField txtphealth;
	private JTextField txtsssdeduct;
	private JTextField txtpagibigdeduct;
	private JTextField txtphealthdeduct;
	private JTextField txtmonthlyrate;
	private JTextField txtweekly;
	private JTextField txtyearly;
	private JTextField txttotalcontri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EData frame = new EData();
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
	public EData() {
		setTitle("MotorPh Payroll System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLabel = new JLabel("Great! Welcome to your payroll portal");
		lblLabel.setBounds(10, 11, 344, 35);
		lblLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 753, 2);
		contentPane.add(separator);
		
		JLabel lblename = new JLabel("Employee No.");
		lblename.setBounds(10, 70, 84, 25);
		lblename.setBackground(new Color(64, 0, 64));
		lblename.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		contentPane.add(lblename);
		
		JLabel lblemployeeName = new JLabel("Employee Name:");
		lblemployeeName.setBounds(10, 93, 102, 25);
		lblemployeeName.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblemployeeName.setBackground(new Color(64, 0, 64));
		contentPane.add(lblemployeeName);
		
		JLabel lblbirthday = new JLabel("Birthday:");
		lblbirthday.setBounds(10, 115, 102, 27);
		lblbirthday.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblbirthday.setBackground(new Color(64, 0, 64));
		contentPane.add(lblbirthday);
		
		JLabel lbladdress = new JLabel("Address:");
		lbladdress.setBounds(10, 136, 102, 25);
		lbladdress.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lbladdress.setBackground(new Color(64, 0, 64));
		contentPane.add(lbladdress);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("1");
		textPane.setEditable(false);
		textPane.setBounds(104, 70, 137, 20);
		contentPane.add(textPane);
		
		JTextPane txtpnSampleLastName = new JTextPane();
		txtpnSampleLastName.setText("John Sample");
		txtpnSampleLastName.setEditable(false);
		txtpnSampleLastName.setBounds(104, 93, 137, 20);
		contentPane.add(txtpnSampleLastName);
		
		JTextPane txtpnJune = new JTextPane();
		txtpnJune.setEditable(false);
		txtpnJune.setText("June 10, 2002");
		txtpnJune.setBounds(104, 115, 137, 20);
		contentPane.add(txtpnJune);
		
		JTextPane txtpnBrgyMoises = new JTextPane();
		txtpnBrgyMoises.setText("Brgy. 7, Moises Padilla Negros Occidental");
		txtpnBrgyMoises.setEditable(false);
		txtpnBrgyMoises.setBounds(104, 138, 375, 25);
		contentPane.add(txtpnBrgyMoises);
		
		JLabel lblSssNo = new JLabel("SSS No.");
		lblSssNo.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblSssNo.setBackground(new Color(64, 0, 64));
		lblSssNo.setBounds(256, 70, 84, 25);
		contentPane.add(lblSssNo);
		
		JLabel lblpagibig = new JLabel("Pag-ibig No.");
		lblpagibig.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblpagibig.setBackground(new Color(64, 0, 64));
		lblpagibig.setBounds(256, 96, 84, 25);
		contentPane.add(lblpagibig);
		
		JLabel lblphealth = new JLabel("Philhealth No.");
		lblphealth.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblphealth.setBackground(new Color(64, 0, 64));
		lblphealth.setBounds(256, 119, 84, 25);
		contentPane.add(lblphealth);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setText("123456789");
		textPane_3.setEditable(false);
		textPane_3.setBounds(342, 70, 137, 20);
		contentPane.add(textPane_3);
		
		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setText("987654321");
		textPane_1_1.setEditable(false);
		textPane_1_1.setBounds(342, 93, 137, 20);
		contentPane.add(textPane_1_1);
		
		JTextPane textPane_2_2 = new JTextPane();
		textPane_2_2.setText("147896523");
		textPane_2_2.setBounds(342, 115, 137, 20);
		contentPane.add(textPane_2_2);
		
		JButton btnlogout = new JButton("Log Out");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLoginSystem = new JFrame ("Log Out");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to Log Out", "Log Out System",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {				
					Login_system info = new Login_system();
					Login_system.main(null);
					dispose();
				}
			}
		});
		btnlogout.setBounds(661, 14, 102, 27);
		contentPane.add(btnlogout);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 174, 753, 2);
		contentPane.add(separator_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setForeground(new Color(0, 255, 255));
		layeredPane.setBackground(new Color(0, 255, 255));
		layeredPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		layeredPane.setBounds(10, 187, 239, 347);
		contentPane.add(layeredPane);
		
		JLabel lblearnings = new JLabel("Earnings");
		lblearnings.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblearnings.setBounds(85, 11, 69, 14);
		layeredPane.add(lblearnings);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(116, 49, 46, 14);
		layeredPane.add(lblHours);
		
		JLabel lblTaxable = new JLabel("Taxable");
		lblTaxable.setBounds(172, 49, 46, 14);
		layeredPane.add(lblTaxable);
		
		JLabel lblDailyrate = new JLabel("Daily Rate:");
		lblDailyrate.setBounds(10, 83, 63, 14);
		layeredPane.add(lblDailyrate);
		
		txtDailyRate = new JTextField();
		txtDailyRate.setBackground(new Color(255, 255, 255));
		txtDailyRate.setEditable(false);
		txtDailyRate.setBounds(91, 83, 79, 14);
		layeredPane.add(txtDailyRate);
		txtDailyRate.setColumns(10);
		
		JLabel lblHolidayPay = new JLabel("Holiday Pay:");
		lblHolidayPay.setBounds(10, 147, 78, 14);
		layeredPane.add(lblHolidayPay);
		
		txtHpay = new JTextField();
		txtHpay.setEditable(false);
		txtHpay.setColumns(10);
		txtHpay.setBackground(Color.WHITE);
		txtHpay.setBounds(91, 147, 63, 14);
		layeredPane.add(txtHpay);
		
		txtHpay2 = new JTextField();
		txtHpay2.setEditable(false);
		txtHpay2.setColumns(10);
		txtHpay2.setBackground(Color.WHITE);
		txtHpay2.setBounds(158, 147, 71, 14);
		layeredPane.add(txtHpay2);
		
		JLabel lblOvertimepay = new JLabel("Overtime\r\nPay:");
		lblOvertimepay.setBounds(10, 201, 96, 14);
		layeredPane.add(lblOvertimepay);
		
		txtOpay = new JTextField();
		txtOpay.setEditable(false);
		txtOpay.setColumns(10);
		txtOpay.setBackground(Color.WHITE);
		txtOpay.setBounds(91, 198, 63, 14);
		layeredPane.add(txtOpay);
		
		txtOpay2 = new JTextField();
		txtOpay2.setEditable(false);
		txtOpay2.setColumns(10);
		txtOpay2.setBackground(Color.WHITE);
		txtOpay2.setBounds(158, 198, 71, 14);
		layeredPane.add(txtOpay2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 36, 215, 2);
		layeredPane.add(separator_2);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(10, 293, 215, 2);
		layeredPane.add(separator_2_2);
		
		JLabel lblTotalEarnings = new JLabel("Total Earnings");
		lblTotalEarnings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalEarnings.setBounds(10, 311, 96, 14);
		layeredPane.add(lblTotalEarnings);
		
		txtEarnings = new JTextField();
		txtEarnings.setBackground(new Color(255, 255, 255));
		txtEarnings.setEditable(false);
		txtEarnings.setBounds(101, 306, 128, 30);
		layeredPane.add(txtEarnings);
		txtEarnings.setColumns(10);
		layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblearnings, lblHours, lblTaxable, lblDailyrate, txtDailyRate, lblHolidayPay, txtHpay, txtHpay2, lblOvertimepay, txtOpay, txtOpay2, separator_2, separator_2_2, lblTotalEarnings, txtEarnings}));
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		layeredPane_1.setBounds(259, 187, 247, 347);
		contentPane.add(layeredPane_1);
		
		JLabel lblDeductions = new JLabel("Deductions");
		lblDeductions.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDeductions.setBounds(88, 11, 71, 14);
		layeredPane_1.add(lblDeductions);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 36, 227, 2);
		layeredPane_1.add(separator_2_1);
		
		JSeparator separator_2_1_2 = new JSeparator();
		separator_2_1_2.setBounds(10, 293, 227, 2);
		layeredPane_1.add(separator_2_1_2);
		
		JLabel lblTotalDeductions = new JLabel("Total Deductions");
		lblTotalDeductions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalDeductions.setBounds(10, 311, 96, 14);
		layeredPane_1.add(lblTotalDeductions);
		
		txttotaldeduct = new JTextField();
		txttotaldeduct.setEditable(false);
		txttotaldeduct.setColumns(10);
		txttotaldeduct.setBackground(Color.WHITE);
		txttotaldeduct.setBounds(109, 306, 128, 30);
		layeredPane_1.add(txttotaldeduct);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(183, 49, 54, 14);
		layeredPane_1.add(lblAmount);
		
		JLabel lblWithholdingTax = new JLabel("Withholding Tax");
		lblWithholdingTax.setBounds(10, 80, 128, 14);
		layeredPane_1.add(lblWithholdingTax);
		
		txttax = new JTextField();
		txttax.setEditable(false);
		txttax.setColumns(10);
		txttax.setBackground(Color.WHITE);
		txttax.setBounds(148, 77, 89, 14);
		layeredPane_1.add(txttax);
		
		JLabel lblContribution = new JLabel("Contribution");
		lblContribution.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContribution.setBounds(10, 106, 90, 14);
		layeredPane_1.add(lblContribution);
		
		JLabel lblSss = new JLabel("SSS");
		lblSss.setBounds(10, 131, 128, 14);
		layeredPane_1.add(lblSss);
		
		JLabel lblPagibig = new JLabel("Pagibig");
		lblPagibig.setBounds(10, 148, 128, 14);
		layeredPane_1.add(lblPagibig);
		
		JLabel lblPhilhealth = new JLabel("PhilHealth");
		lblPhilhealth.setBounds(10, 165, 128, 14);
		layeredPane_1.add(lblPhilhealth);
		
		JLabel lblLoanDeductions = new JLabel("Loan Deductions");
		lblLoanDeductions.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoanDeductions.setBounds(10, 190, 128, 14);
		layeredPane_1.add(lblLoanDeductions);
		
		JLabel lblWithholdingTax_1_1 = new JLabel("SSS deduction");
		lblWithholdingTax_1_1.setBounds(10, 215, 128, 14);
		layeredPane_1.add(lblWithholdingTax_1_1);
		
		JLabel lblWithholdingTax_1_2 = new JLabel("PhilHealth deduction");
		lblWithholdingTax_1_2.setBounds(10, 260, 128, 14);
		layeredPane_1.add(lblWithholdingTax_1_2);
		
		JLabel lblWithholdingTax_1_3 = new JLabel("Pagibig deduction");
		lblWithholdingTax_1_3.setBounds(10, 235, 128, 14);
		layeredPane_1.add(lblWithholdingTax_1_3);
		
		txtxssscontri = new JTextField();
		txtxssscontri.setEditable(false);
		txtxssscontri.setColumns(10);
		txtxssscontri.setBackground(Color.WHITE);
		txtxssscontri.setBounds(148, 128, 89, 14);
		layeredPane_1.add(txtxssscontri);
		
		pagibigcontri = new JTextField();
		pagibigcontri.setEditable(false);
		pagibigcontri.setColumns(10);
		pagibigcontri.setBackground(Color.WHITE);
		pagibigcontri.setBounds(148, 145, 89, 14);
		layeredPane_1.add(pagibigcontri);
		
		txtphealth = new JTextField();
		txtphealth.setEditable(false);
		txtphealth.setColumns(10);
		txtphealth.setBackground(Color.WHITE);
		txtphealth.setBounds(148, 162, 89, 14);
		layeredPane_1.add(txtphealth);
		
		txtsssdeduct = new JTextField();
		txtsssdeduct.setEditable(false);
		txtsssdeduct.setColumns(10);
		txtsssdeduct.setBackground(Color.WHITE);
		txtsssdeduct.setBounds(148, 215, 89, 14);
		layeredPane_1.add(txtsssdeduct);
		
		txtpagibigdeduct = new JTextField();
		txtpagibigdeduct.setEditable(false);
		txtpagibigdeduct.setColumns(10);
		txtpagibigdeduct.setBackground(Color.WHITE);
		txtpagibigdeduct.setBounds(148, 232, 89, 14);
		layeredPane_1.add(txtpagibigdeduct);
		
		txtphealthdeduct = new JTextField();
		txtphealthdeduct.setEditable(false);
		txtphealthdeduct.setColumns(10);
		txtphealthdeduct.setBackground(Color.WHITE);
		txtphealthdeduct.setBounds(148, 257, 89, 14);
		layeredPane_1.add(txtphealthdeduct);
		
		JLayeredPane layeredPane_1_1 = new JLayeredPane();
		layeredPane_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		layeredPane_1_1.setBounds(516, 187, 247, 347);
		contentPane.add(layeredPane_1_1);
		
		JLabel lblearnings_1_1 = new JLabel("Net, Gross Income");
		lblearnings_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblearnings_1_1.setBounds(65, 11, 116, 14);
		layeredPane_1_1.add(lblearnings_1_1);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setBounds(10, 36, 227, 2);
		layeredPane_1_1.add(separator_2_1_1);
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setBounds(10, 293, 227, 2);
		layeredPane_1_1.add(separator_2_1_1_1);
		
		JLabel lblTotalEarnings_1_1 = new JLabel("Net Pay");
		lblTotalEarnings_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalEarnings_1_1.setBounds(10, 311, 96, 14);
		layeredPane_1_1.add(lblTotalEarnings_1_1);
		
		txtnetpay = new JTextField();
		txtnetpay.setEditable(false);
		txtnetpay.setColumns(10);
		txtnetpay.setBackground(Color.WHITE);
		txtnetpay.setBounds(109, 306, 128, 30);
		layeredPane_1_1.add(txtnetpay);
		
		JLabel lblAmount_1 = new JLabel("Amount");
		lblAmount_1.setBounds(183, 49, 54, 14);
		layeredPane_1_1.add(lblAmount_1);
		
		JLabel lblMonthlyRate = new JLabel("Monthly Rate");
		lblMonthlyRate.setBounds(10, 76, 128, 14);
		layeredPane_1_1.add(lblMonthlyRate);
		
		JLabel lblGrossIncome = new JLabel("Gross Income");
		lblGrossIncome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGrossIncome.setBounds(20, 111, 90, 14);
		layeredPane_1_1.add(lblGrossIncome);
		
		txtmonthlyrate = new JTextField();
		txtmonthlyrate.setEditable(false);
		txtmonthlyrate.setColumns(10);
		txtmonthlyrate.setBackground(Color.WHITE);
		txtmonthlyrate.setBounds(148, 73, 89, 14);
		layeredPane_1_1.add(txtmonthlyrate);
		
		JLabel lblWeekly = new JLabel("Weekly");
		lblWeekly.setBounds(30, 136, 128, 14);
		layeredPane_1_1.add(lblWeekly);
		
		JLabel lblYearly = new JLabel("Yearly");
		lblYearly.setBounds(30, 161, 128, 14);
		layeredPane_1_1.add(lblYearly);
		
		txtweekly = new JTextField();
		txtweekly.setEditable(false);
		txtweekly.setColumns(10);
		txtweekly.setBackground(Color.WHITE);
		txtweekly.setBounds(147, 133, 90, 14);
		layeredPane_1_1.add(txtweekly);
		
		txtyearly = new JTextField();
		txtyearly.setEditable(false);
		txtyearly.setColumns(10);
		txtyearly.setBackground(Color.WHITE);
		txtyearly.setBounds(147, 158, 90, 14);
		layeredPane_1_1.add(txtyearly);
		
		JLabel lblT = new JLabel("Total Contribution");
		lblT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblT.setBounds(20, 192, 161, 14);
		layeredPane_1_1.add(lblT);
		
		txttotalcontri = new JTextField();
		txttotalcontri.setEditable(false);
		txttotalcontri.setColumns(10);
		txttotalcontri.setBackground(Color.WHITE);
		txttotalcontri.setBounds(147, 217, 90, 14);
		layeredPane_1_1.add(txttotalcontri);
	}
}
