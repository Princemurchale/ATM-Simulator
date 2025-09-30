package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    

    JTextField cardTextField;
    JButton login, clear, signup;
    Random random = new Random();
    Timer animationTimer;
    JPasswordField pinTextField;

    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(i2));
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 500, 40);
        add(text);

        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login = createAnimatedButton("SIGN IN", 300, 300, 110, 40);
        login.addActionListener(this);
        clear = createAnimatedButton("CLEAR", 430, 300, 100, 40);
        clear.addActionListener(this);
        signup = createAnimatedButton("SIGN UP", 300, 360, 230, 40);
        signup.addActionListener(this);
        
        add(login);
        add(clear);
        add(signup);

        ActionListener validateAction = e -> {
            if (cardTextField.getText().trim().isEmpty() || pinTextField.getText().trim().isEmpty()) {
                JButton btn = (JButton) e.getSource();
                btn.setLocation(random.nextInt(500) + 100, random.nextInt(300) + 100);
                shakeFrame();
            }
        };

        login.addActionListener(validateAction);
        clear.addActionListener(validateAction);
        signup.addActionListener(validateAction);

        getContentPane().setBackground(Color.WHITE);
        setSize(800, 500);
        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JButton createAnimatedButton(String text, int x, int y, int w, int h) {
        JButton btn = new JButton(text) {
            float hue = 0f;
            float scale = 1.0f;
            boolean growing = true;

            {
                animationTimer = new Timer(80, e -> {
                    hue += 0.02f;
                    if (hue > 1) hue = 0;

                    if (growing) {
                        scale += 0.02f;
                        if (scale >= 1.1f) growing = false;
                    } else {
                        scale -= 0.02f;
                        if (scale <= 0.9f) growing = true;
                    }
                    repaint();
                });
                animationTimer.start();
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int newW = (int) (getWidth() * scale);
                int newH = (int) (getHeight() * scale);
                int newX = (getWidth() - newW) / 2;
                int newY = (getHeight() - newH) / 2;

                Color c1 = Color.getHSBColor(hue, 0.8f, 0.8f);
                Color c2 = Color.getHSBColor((hue + 0.3f) % 1f, 0.8f, 0.8f);
                GradientPaint gp = new GradientPaint(0, 0, c1, getWidth(), getHeight(), c2, true);

                g2.setPaint(gp);
                g2.fillRoundRect(newX, newY, newW, newH, 20, 20);

                if (getModel().isRollover()) {
                    g2.setColor(new Color(255, 255, 255, 150));
                    g2.setStroke(new BasicStroke(3));
                    g2.drawRoundRect(newX + 2, newY + 2, newW - 4, newH - 4, 20, 20);
                }

                g2.dispose();
                super.paintComponent(g);
            }
        };

        btn.setBounds(x, y, w, h);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Raleway", Font.BOLD, 16));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setOpaque(false);

        return btn;
    }

    private void shakeFrame() {
        Point p = getLocation();
        int dx = 10;
        for (int i = 0; i < 6; i++) {
            setLocation(p.x + ((i % 2 == 0) ? dx : -dx), p.y);
            try { Thread.sleep(50); } catch (Exception ignored) {}
        }
        setLocation(p);
    }

    public void actionPerformed(ActionEvent ae) {
     
       if (ae.getSource() == clear) {
           cardTextField.setText("");
           pinTextField.setText("");
           
       } else if (ae.getSource() == login) {
           
           Conn conn = new Conn();
           String cardnumber = cardTextField.getText();
           String pinnumber = pinTextField.getText();
      String query = "select * from login where cardNumber='" + cardnumber + "' and pinNumber='" + pinnumber + "'";
       
      try{
      ResultSet rs = conn.s.executeQuery(query);
      if (rs.next()) {
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
      }else {
          JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
      }
       }   catch (Exception e) {
           System.out.println(e);
       } 
           
       } else if (ae.getSource() == signup) {
           
           setVisible(false);
           new SignupOne().setVisible(true);
           
       }
        
        
    }
    
    
    public static void main(String args[]) {
        new Login();
    }
}
