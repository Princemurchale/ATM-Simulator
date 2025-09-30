package bank.management.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "1874prin");
            
            
            s = c.createStatement();
            
            System.out.println("Database Connected Successfully!");
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Driver not found: " + e);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e);
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e);
        }
    }
    
    
    public void closeConnection() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
    }
}
