package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber) {
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        mini.setVerticalAlignment(JLabel.TOP);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Raleway", Font.BOLD, 16));
        bank.setBounds(150, 20, 200, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setFont(new Font("Raleway", Font.PLAIN, 12));
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setFont(new Font("Raleway", Font.BOLD, 12));
        balance.setBounds(20, 450, 400, 30);
        add(balance);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            if (rs.next()) {
                String cardnumber = rs.getString("cardnumber");
                card.setText("Card Number: " + cardnumber.substring(0, 4) + "XXXXXXXX" + cardnumber.substring(12));
            }  
        } catch (Exception e) {
            System.out.println("Error fetching card number: " + e);
        }
        
        try {
            Conn conn = new Conn();
            int bal = 0;
            
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            
            StringBuilder statement = new StringBuilder("<html>");
            
            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                
                statement.append(date)
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                         .append(type)
                         .append("&nbsp;&nbsp;&nbsp;&nbsp;Rs ")
                         .append(amount)
                         .append("<br>");
                
                if (type.equals("Deposit")) {
                    bal += Integer.parseInt(amount);
                } else {
                    bal -= Integer.parseInt(amount);
                }
            }
            
            statement.append("</html>");
            mini.setText(statement.toString());
            balance.setText("Your Current Account Balance is Rs " + bal);
            
        } catch (Exception e) {
            System.out.println("Error fetching transactions: " + e);
            e.printStackTrace();
        }
        
        setSize(400, 600);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Could not set system look and feel: " + e.getMessage());
        }
        
        new MiniStatement("1234");  
    }
}
