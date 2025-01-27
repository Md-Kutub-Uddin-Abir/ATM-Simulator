
package atm.simulator;

import java.awt.*; 
import javax.swing.*;
import java.sql.*;
        
public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini=new JLabel();
        add(mini);//dynamically value install
        
        JLabel bank= new JLabel("CSTE Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        
        JLabel card= new JLabel("");
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        
        try {
            Conn conn = new Conn();//connection class
            ResultSet rs=conn.s.executeQuery("select * from login where pin= '"+pinnumber+"'");//query to database
            
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"xxxxxxxx"+rs.getString("cardnumber").substring(12));
                
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try {
            
            
            Conn conn = new Conn();//connection class object
            ResultSet rs=conn.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");//query to database
            
            while(rs.next()){
                mini.setText(mini.getText()+ "<html>" + rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+ "<br> <br><html>");//using html type for space
                
            }
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            
            Conn conn = new Conn();
            
            int bal= 0;
            
            ResultSet rs= conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            
            while(rs.next()){
                
                
                 if(rs.getString("type").equals("Deposit")){
                     bal+=Integer.parseInt(rs.getString("amount")); 
                 }else{
                     bal-= Integer.parseInt(rs.getString("amount"));
                 }
             }
            
            balance.setText("Your current Account Balance is Tk "+ bal);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);//frame size
        setLocation(20,20);//20 from left 20 from right
        getContentPane().setBackground(Color.WHITE);
       // setUndecorated(true);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new MiniStatement("");
    }
}
