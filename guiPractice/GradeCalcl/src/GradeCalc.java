import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalc extends JFrame implements ActionListener{
    JTextField ms1Input, ms2Input, taInput;
    JButton calculateButton;

    GradeCalc(){
        //Labels
        JLabel ms1Label, ms2Label, taLabel;
        ms1Label = new JLabel();
        ms1Label.setText("MS1");
        ms2Label = new JLabel();
        ms2Label.setText("MS2");
        taLabel = new JLabel();
        taLabel.setText("TA");
        //Textfields
        ms1Input = new JTextField();
        ms1Input.setPreferredSize(new Dimension(200, 25));
        ms2Input = new JTextField();
        ms2Input.setPreferredSize(new Dimension(200, 25));
        taInput = new JTextField();
        taInput.setPreferredSize(new Dimension(200, 25));
        //Calculate Button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        //Frame
        this.setVisible(true);
        this.setTitle("Grade Calculator");
        this.setLayout(new FlowLayout());
        this.pack();
        this.setSize(250,200);
        this.add(ms1Label);
        this.add(ms1Input);
        this.add(ms2Label);
        this.add(ms2Input);
        this.add(taLabel);
        this.add(taInput);
        this.add(calculateButton);
        this.setResizable(false);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        int ms1Grade, ms2Grade, taGrade;
        if(e.getSource()==calculateButton){
            try {
                ms1Grade = Integer.parseInt(ms1Input.getText());
                ms2Grade = Integer.parseInt(ms2Input.getText());
                taGrade = Integer.parseInt(taInput.getText());

                //Calculation
                int finalGrade = ms1Grade + ms2Grade + taGrade;

                if(ms1Grade > 25){
                    JOptionPane.showMessageDialog(this,"MS1 Grade must not exceed 25");
                }else if(ms2Grade > 40){
                    JOptionPane.showMessageDialog(this,"MS2 Grade must not exceed 25");
                }else if(taGrade > 35){
                    JOptionPane.showMessageDialog(this,"TA Grade must not exceed 25");
                }else if(ms1Grade < 0 || ms2Grade < 0 || taGrade < 0){
                    JOptionPane.showMessageDialog(this,"A grade must not be less than zero!");
                }else{
                    JOptionPane.showMessageDialog(this, "Final Grade: " + finalGrade);
                }
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(this, "Integer input only!");
            }
        }
    }
}
