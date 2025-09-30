package bank.management.system;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JComboBox<String> religionCombo, categoryCombo, incomeCombo, occupationCombo;
    JTextField panTextField, adharTextField;
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;
    JCheckBox tenthCheck, twelfthCheck, graduationCheck, postGradCheck;
    JTextField tenthYearField, tenthGradeField, twelfthYearField, twelfthGradeField;
    JTextField graduationYearField, graduationGradeField, postGradYearField, postGradGradeField;
    JButton next;
    long formNumber;
    private Timer pulseTimer;

    SignupTwo(long formNumber) {
        this.formNumber = formNumber;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel personalDetails = new JLabel("Page 2: Additional Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        personalDetails.setBounds(280, 30, 400, 40);
        add(personalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 22));
        religion.setBounds(100, 90, 200, 30);
        add(religion);
        String[] religionValues = {"Select", "Hinduism", "Islam", "Christianity", "Sikh", "Buddhism", "Jainism", "Other"};
        religionCombo = new JComboBox<>(religionValues);
        religionCombo.setBounds(300, 90, 400, 30);
        religionCombo.setBackground(Color.WHITE);
        religionCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(religionCombo);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 22));
        category.setBounds(100, 140, 200, 30);
        add(category);
        String[] categoryValues = {"Select", "General", "OBC", "SC", "ST"};
        categoryCombo = new JComboBox<>(categoryValues);
        categoryCombo.setBounds(300, 140, 400, 30);
        categoryCombo.setBackground(Color.WHITE);
        categoryCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(categoryCombo);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 22));
        income.setBounds(100, 190, 200, 30);
        add(income);
        String[] incomeValues = {"Select", "Below 1 Lakh", "1-2.5 Lakh", "2.5-5 Lakh", "5-10 Lakh", "Above 10 Lakh"};
        incomeCombo = new JComboBox<>(incomeValues);
        incomeCombo.setBounds(300, 190, 400, 30);
        incomeCombo.setBackground(Color.WHITE);
        incomeCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(incomeCombo);

        JLabel education = new JLabel("Education:");
        education.setFont(new Font("Raleway", Font.BOLD, 22));
        education.setBounds(100, 240, 200, 30);
        add(education);

        tenthCheck = new JCheckBox("10th Secondary");
        tenthCheck.setBounds(300, 240, 150, 30);
        tenthCheck.setBackground(Color.WHITE);
        tenthCheck.setFont(new Font("Raleway", Font.BOLD, 14));
        add(tenthCheck);

        JLabel tenthYear = new JLabel("Year:");
        tenthYear.setFont(new Font("Raleway", Font.PLAIN, 12));
        tenthYear.setBounds(460, 248, 40, 15);
        add(tenthYear);
        tenthYearField = new JTextField();
        tenthYearField.setBounds(500, 245, 60, 25);
        tenthYearField.setFont(new Font("Arial", Font.PLAIN, 12));
        add(tenthYearField);

        JLabel tenthGrade = new JLabel("Grade:");
        tenthGrade.setFont(new Font("Raleway", Font.PLAIN, 12));
        tenthGrade.setBounds(570, 248, 40, 15);
        add(tenthGrade);
        tenthGradeField = new JTextField();
        tenthGradeField.setBounds(610, 245, 60, 25);
        tenthGradeField.setFont(new Font("Arial", Font.PLAIN, 12));
        add(tenthGradeField);

        twelfthCheck = new JCheckBox("12th/Higher Secondary");
        twelfthCheck.setBounds(300, 275, 200, 30);
        twelfthCheck.setBackground(Color.WHITE);
        twelfthCheck.setFont(new Font("Raleway", Font.BOLD, 14));
        add(twelfthCheck);

        JLabel twelfthYear = new JLabel("Year:");
        twelfthYear.setFont(new Font("Raleway", Font.PLAIN, 12));
        twelfthYear.setBounds(510, 283, 40, 15);
        add(twelfthYear);
        twelfthYearField = new JTextField();
        twelfthYearField.setBounds(550, 280, 60, 25);
        twelfthYearField.setFont(new Font("Arial", Font.PLAIN, 12));
        add(twelfthYearField);

        JLabel twelfthGrade = new JLabel("Grade:");
        twelfthGrade.setFont(new Font("Raleway", Font.PLAIN, 12));
        twelfthGrade.setBounds(620, 283, 40, 15);
        add(twelfthGrade);
        twelfthGradeField = new JTextField();
        twelfthGradeField.setBounds(660, 280, 60, 25);
        twelfthGradeField.setFont(new Font("Arial", Font.PLAIN, 12));
        add(twelfthGradeField);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 22));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        String[] occupationValues = {"Select", "Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationCombo = new JComboBox<>(occupationValues);
        occupationCombo.setBounds(300, 390, 400, 30);
        occupationCombo.setBackground(Color.WHITE);
        occupationCombo.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(occupationCombo);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 22));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setBounds(300, 440, 400, 30);
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 22));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);
        adharTextField = new JTextField();
        adharTextField.setBounds(300, 490, 400, 30);
        adharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        add(adharTextField);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 22));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300, 540, 100, 30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);
        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(450, 540, 100, 30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);
        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 22));
        existing.setBounds(100, 590, 200, 30);
        add(existing);
        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300, 590, 100, 30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);
        existingNo = new JRadioButton("No");
        existingNo.setBounds(450, 590, 100, 30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);
        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingYes);
        existingGroup.add(existingNo);

        next = new JButton("NEXT →");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(320, 680, 200, 50);  
        next.setBorder(new LineBorder(Color.decode("#007AFF"), 3));  
        next.setFocusPainted(false);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));  
        next.addActionListener(this);
        add(next);

        final Color primaryColor = Color.decode("#007AFF");
        final Color secondaryColor = Color.BLACK;

        pulseTimer = new Timer(500, new ActionListener() {
            private boolean colorToggle = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                if (colorToggle) {
                    next.setBackground(primaryColor);
                    next.setForeground(Color.WHITE);
                    next.setBorder(new LineBorder(Color.BLACK, 3));
                } else {
                    next.setBackground(secondaryColor);
                    next.setForeground(Color.WHITE);
                    next.setBorder(new LineBorder(primaryColor, 3));
                }
                colorToggle = !colorToggle;
            }
        });
        pulseTimer.start();

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 850); 
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
             String religion = (String) religionCombo.getSelectedItem();
             String category = (String) categoryCombo.getSelectedItem();
             String income = (String) incomeCombo.getSelectedItem();
             String occupation = (String) occupationCombo.getSelectedItem();
             String pan = panTextField.getText();
             String aadhar = adharTextField.getText();
             
             String senior = null;
             if (seniorYes.isSelected()) {
                 senior = "Yes";
             } else if (seniorNo.isSelected()) {
                 senior = "No";
             }
             
             String existing = null;
             if (existingYes.isSelected()) {
                 existing = "Yes";
             } else if (existingNo.isSelected()) {
                 existing = "No";
             }

             if (pan.equals("")) {
                 JOptionPane.showMessageDialog(null, "PAN Number is Required");
                 return;
             }
             if (aadhar.equals("")) {
                 JOptionPane.showMessageDialog(null, "Aadhar Number is Required");
                 return;
             }

             try {
                 Conn c = new Conn();
                 String query = "INSERT INTO signup2 VALUES('" + formNumber + "', '" + religion + "', '" + category + "', '" + income + "', 'Some Education', '" + occupation + "', '" + pan + "', '" + aadhar + "', '" + senior + "', '" + existing + "')";
                 c.s.executeUpdate(query);
                 
                 if (pulseTimer != null) {
                     pulseTimer.stop();
                 }
                 
                 setVisible(false);
                 new SignupThree(String.valueOf(formNumber)).setVisible(true);

             } catch (Exception e) {
                 System.out.println(e);
             }
        }
    }

    public static void main(String[] args) {
        new SignupTwo(12345L); 
    }
}
