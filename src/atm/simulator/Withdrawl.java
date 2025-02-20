
package atm.simulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener{
    
JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    
    Withdrawl(String pinnumber)
    {
        this.pinnumber=pinnumber;
        
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text= new JLabel("Enter the Amount You Want to Withdraw");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);
        
        
        amount= new JTextField();
        amount.setBounds(170, 350, 320, 25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        add(amount);
        
        withdraw= new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        //deposit.setBackground(Color.white);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back= new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        //deposit.setBackground(Color.white);
        back.addActionListener(this);
        image.add(back);
                
                
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== withdraw){
            String number= amount.getText();
            Date date= new Date();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter amount you want to withdraw!");
            }
            else{
                Conn conn= new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Tk "+number+" Withdraw Succesful");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
        }
        else if(ae.getSource()==back){
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }

    

    
}

