package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {

    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, otherGender;
    JRadioButton married, unmarried, otherMarital;
    JButton next;
    Random random = new Random();
    long formNumber;

    int nextBtnX = 600, nextBtnY = 650;

    SignupOne() {
        setLayout(null);

        formNumber = Math.abs(random.nextLong() % 9000L + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + formNumber);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        // Name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        // Father's Name
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        // DOB
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        otherGender = new JRadioButton("Other");
        otherGender.setBounds(600, 290, 100, 30);
        otherGender.setBackground(Color.WHITE);
        add(otherGender);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(otherGender);

        // Email
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);

        // Marital Status
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        otherMarital = new JRadioButton("Other");
        otherMarital.setBounds(600, 390, 100, 30);
        otherMarital.setBackground(Color.WHITE);
        add(otherMarital);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(otherMarital);

        // Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);

        // City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);

        // State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 22));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);

        // Pin Code
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);

        // Enhanced Next button with advanced animations
        next = createAdvancedAnimatedButton("NEXT", nextBtnX, nextBtnY, 140, 45);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 750); // Adjusted window size
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createAdvancedAnimatedButton(String text, int x, int y, int w, int h) {
        JButton btn = new JButton(text) {
            private boolean isHovered = false;
            private boolean isPressed = false;
            private float animationProgress = 0.0f;
            private Color currentColor = new Color(25, 25, 25);
            
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Dynamic colors based on state
                Color bgColor1, bgColor2, borderColor, textColor;
                
                if (isPressed) {
                    bgColor1 = new Color(15, 15, 15);
                    bgColor2 = new Color(35, 35, 35);
                    borderColor = new Color(0, 150, 255);
                    textColor = new Color(200, 200, 200);
                } else if (isHovered) {
                    bgColor1 = new Color(30, 144, 255);
                    bgColor2 = new Color(0, 100, 200);
                    borderColor = new Color(100, 200, 255);
                    textColor = Color.WHITE;
                } else {
                    bgColor1 = new Color(25, 25, 25);
                    bgColor2 = new Color(50, 50, 50);
                    borderColor = new Color(80, 80, 80);
                    textColor = Color.WHITE;
                }
                
                // Animated gradient background
                GradientPaint gradient = new GradientPaint(
                    0, 0, bgColor1, 
                    0, getHeight(), bgColor2
                );
                g2d.setPaint(gradient);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
                
                // Glow effect when hovered
                if (isHovered && animationProgress > 0) {
                    int glowSize = (int)(8 * animationProgress);
                    for (int i = 0; i < glowSize; i++) {
                        int alpha = (int)(40 * animationProgress * (1.0f - (float)i/glowSize));
                        g2d.setColor(new Color(100, 200, 255, alpha));
                        g2d.drawRoundRect(-i, -i, getWidth() + 2*i, getHeight() + 2*i, 12 + i, 12 + i);
                    }
                }
                
                // Animated border
                g2d.setColor(borderColor);
                g2d.setStroke(new BasicStroke(2.0f));
                g2d.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 12, 12);
                
                // Inner highlight
                if (isHovered) {
                    g2d.setColor(new Color(255, 255, 255, 30));
                    g2d.setStroke(new BasicStroke(1.0f));
                    g2d.drawRoundRect(2, 2, getWidth()-4, getHeight()-4, 10, 10);
                }
                
                // Animated text with slight movement effect
                g2d.setColor(textColor);
                g2d.setFont(getFont());
                FontMetrics fm = g2d.getFontMetrics();
                int textX = (getWidth() - fm.stringWidth(getText())) / 2;
                int textY = (getHeight() + fm.getAscent()) / 2 - 2;
                
                // Add slight bounce effect on hover
                if (isHovered) {
                    textY += (int)(Math.sin(animationProgress * 6) * 1);
                }
                
                g2d.drawString(getText(), textX, textY);
                
                // Add arrow indicator
                if (isHovered) {
                    g2d.setColor(new Color(255, 255, 255, (int)(150 * animationProgress)));
                    int arrowX = textX + fm.stringWidth(getText()) + 8;
                    int arrowY = textY - 3;
                    g2d.fillPolygon(new int[]{arrowX, arrowX + 6, arrowX}, 
                                   new int[]{arrowY - 3, arrowY, arrowY + 3}, 3);
                }
                
                g2d.dispose();
            }
        };
        
        btn.setBounds(x, y, w, h);
        btn.setFont(new Font("Raleway", Font.BOLD, 16));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Advanced mouse animations
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                
                // Set hover state using reflection
                try {
                    java.lang.reflect.Field hoverField = button.getClass().getDeclaredField("isHovered");
                    hoverField.setAccessible(true);
                    hoverField.set(button, true);
                } catch (Exception ex) {}
                
                // Scale up animation
                Timer scaleTimer = new Timer(15, new ActionListener() {
                    int step = 0;
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        step++;
                        double scale = 1.0 + (0.08 * Math.sin(step * 0.2));
                        int newW = (int)(w * scale);
                        int newH = (int)(h * scale);
                        button.setBounds(x - (newW-w)/2, y - (newH-h)/2, newW, newH);
                        
                        // Update animation progress
                        try {
                            java.lang.reflect.Field progressField = button.getClass().getDeclaredField("animationProgress");
                            progressField.setAccessible(true);
                            progressField.set(button, Math.min(1.0f, step * 0.1f));
                        } catch (Exception ex) {}
                        
                        button.repaint();
                        
                        if (step >= 15) {
                            ((Timer)ae.getSource()).stop();
                        }
                    }
                });
                scaleTimer.start();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                
                // Remove hover state
                try {
                    java.lang.reflect.Field hoverField = button.getClass().getDeclaredField("isHovered");
                    hoverField.setAccessible(true);
                    hoverField.set(button, false);
                } catch (Exception ex) {}
                
                // Scale down animation
                Timer scaleTimer = new Timer(15, new ActionListener() {
                    int step = 15;
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        step--;
                        double scale = 1.0 + (0.08 * Math.sin(step * 0.2));
                        int newW = (int)(w * scale);
                        int newH = (int)(h * scale);
                        button.setBounds(x - (newW-w)/2, y - (newH-h)/2, newW, newH);
                        
                        // Update animation progress
                        try {
                            java.lang.reflect.Field progressField = button.getClass().getDeclaredField("animationProgress");
                            progressField.setAccessible(true);
                            progressField.set(button, Math.max(0.0f, step * 0.1f));
                        } catch (Exception ex) {}
                        
                        button.repaint();
                        
                        if (step <= 0) {
                            button.setBounds(x, y, w, h);
                            ((Timer)ae.getSource()).stop();
                        }
                    }
                });
                scaleTimer.start();
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                
                // Set pressed state
                try {
                    java.lang.reflect.Field pressedField = button.getClass().getDeclaredField("isPressed");
                    pressedField.setAccessible(true);
                    pressedField.set(button, true);
                } catch (Exception ex) {}
                
                // Quick press animation
                Timer pressTimer = new Timer(20, new ActionListener() {
                    int step = 0;
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        step++;
                        double scale = step <= 3 ? 0.95 : 1.0 + (0.15 * Math.sin((step-3) * 0.8));
                        int newW = (int)(w * scale);
                        int newH = (int)(h * scale);
                        button.setBounds(x - (newW-w)/2, y - (newH-h)/2, newW, newH);
                        button.repaint();
                        
                        if (step >= 10) {
                            button.setBounds(x, y, w, h);
                            // Remove pressed state
                            try {
                                java.lang.reflect.Field pressedField = button.getClass().getDeclaredField("isPressed");
                                pressedField.setAccessible(true);
                                pressedField.set(button, false);
                            } catch (Exception ex) {}
                            ((Timer)ae.getSource()).stop();
                        }
                    }
                });
                pressTimer.start();
            }
        });
        
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = male.isSelected() ? "Male" :
                            female.isSelected() ? "Female" :
                            otherGender.isSelected() ? "Other" : "";
            String email = emailTextField.getText();
            String marital = married.isSelected() ? "Married" :
                             unmarried.isSelected() ? "Unmarried" :
                             otherMarital.isSelected() ? "Other" : "";
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String pin = pinTextField.getText();

            // Limit long inputs to avoid database error
            if(fname.length() > 100) fname = fname.substring(0, 100);
            if(address.length() > 200) address = address.substring(0, 200);

            if(name.equals("")) { JOptionPane.showMessageDialog(null, "Name Fill Karo Yaar"); return; }
            if(fname.equals("")) { JOptionPane.showMessageDialog(null, "Father's Name Fill Karo Yaar"); return; }
            if(dob.equals("")) { JOptionPane.showMessageDialog(null, "DOB Daalna Zaroori Hai"); return; }
            if(gender.equals("")) { JOptionPane.showMessageDialog(null, "Gender Select Karo Yaar"); return; }
            if(email.equals("")) { JOptionPane.showMessageDialog(null, "Email Bharna Mat Bhoolo"); return; }
            if(marital.equals("")) { JOptionPane.showMessageDialog(null, "Marital Status Choose Karo"); return; }
            if(address.equals("")) { JOptionPane.showMessageDialog(null, "Address Fill Karo"); return; }
            if(city.equals("")) { JOptionPane.showMessageDialog(null, "City Daalna Bhool Gaye"); return; }
            if(state.equals("")) { JOptionPane.showMessageDialog(null, "State Bharna Zaroori Hai"); return; }
            if(pin.equals("")) { JOptionPane.showMessageDialog(null, "Pin Code Daalna Mat Bhoolo"); return; }

            Conn c = new Conn();
            String query = "INSERT INTO signup VALUES('"+formNumber+"', '"+name+"','"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"','"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "✅ Form Submitted Successfully!");
            
            // Navigate to SignupTwo
            setVisible(false);
            new SignupTwo(formNumber).setVisible(true);
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignupOne::new);
    }
}
