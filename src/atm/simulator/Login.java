package atm.simulator;

import javax.swing.*; //importing jframe
import java.awt.*;// importing awt
import java.awt.event.*; //importing awt event
import java.sql.*; 
public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login() //constructor
    {
        setTitle("AUTOMATED TELLER MACHINE");//set the title of frame
        
        //for custom layout
        setLayout(null);
        
        //iamge icon class for loading image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(170, 10,100, 100);
        add(label);
        
        //for adding text using JLabel class
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(270, 50, 400, 40);
        add(text);
        
        JLabel cardno= new JLabel("Card NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        //adding box using Jtextfield
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        //change colur
        //backgroung colour
        getContentPane().setBackground(Color.white);
        
        
        setSize(800, 480); // set the dimension of frame
        setVisible(true); // make the frame visible
        setLocation(350,200);// set the location of frame
    }
    
    //to perform action action event class
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()== clear){
          cardTextField.setText("");
          pinTextField.setText("");
      }
      else if(ae.getSource()== login){
          Conn conn =new Conn();
          
          String cardnumber = cardTextField.getText();
          String pinnumber= pinTextField.getText();
          
          String query= "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
          
          try{
            ResultSet r = conn.s.executeQuery(query);
            
            if(r.next()){
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null,"Incorrect Card number or Pin");
              }
          }
          catch(Exception e){
              System.out.println(e);
          }
          
      }
      else if(ae.getSource()==signup){
          setVisible(false);
          new SignupOne().setVisible(true); //to get into signup form(login frame close signup frame open)
      }
    }
    public static void main(String args[]){
        new Login();
    }

}
