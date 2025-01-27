package atm.simulator;

import com.toedter.calendar.JDateChooser;// importing jdatechooser for clender class
import java.awt.*;
import javax.swing.*; //importing jframe
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
   
    
    JTextField panTextField,nationalidTextField;
    
    JButton next;
    
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox religion,occupation,category,income,education;
    String formno;       
    
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        
        
        JLabel additionalDetails= new JLabel("Page 2:Additional Details ");
        additionalDetails.setFont(new Font ("Raleway",Font.BOLD ,22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel Religion= new JLabel("Religion:");
        Religion.setFont(new Font ("Raleway",Font.BOLD ,20));
        Religion.setBounds(100, 140, 100, 30);
        add(Religion);
        
        String valReligion[]={"Muslim","Hindu","Christian","Buddhist","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
   
                  
        JLabel Category= new JLabel("Category:");
        Category.setFont(new Font ("Raleway",Font.BOLD ,20));
        Category.setBounds(100, 200, 200, 30);
        add(Category);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 200, 400, 30);
        category.setBackground(Color.white);
        add(category);
        
        
        
        JLabel Income= new JLabel("Income:");
        Income.setFont(new Font ("Raleway",Font.BOLD ,20));
        Income.setBounds(100, 260, 200, 30);
        add(Income);
        
        String valincome[]={"<50,000","<100000","<1000000",">1000000"};
        income = new JComboBox(valincome);
        income.setBounds(300, 260, 400, 30);
        income.setBackground(Color.white);
        add(income);
     
        
        JLabel Education= new JLabel("Education:");
        Education.setFont(new Font ("Raleway",Font.BOLD ,20));
        Education.setBounds(100, 320, 200, 30);
        add(Education);
        
        String valedu[]={"Non Graduate","Graduate","Post Graduate","Other"};
        education = new JComboBox(valedu);
        education.setBounds(300, 320, 400, 30);
        education.setBackground(Color.white);
        add(education);
        
        JLabel Occupation= new JLabel("Occupation Type:");
        Occupation.setFont(new Font ("Raleway",Font.BOLD ,20));
        Occupation.setBounds(100, 380, 200, 30);
        add(Occupation);
        
        String valocu[]={"Salaried","Self Employed","Businessman","Retired","Other"};
        occupation = new JComboBox(valocu);
        occupation.setBounds(300, 380, 400, 30);
        occupation.setBackground(Color.white);
        add(occupation);
        
        
        JLabel PAN= new JLabel("PAN number:");
        PAN.setFont(new Font ("Raleway",Font.BOLD ,20));
        PAN.setBounds(100, 440, 200, 30);
        add(PAN);
        
        panTextField = new JTextField();
        panTextField.setBounds(300, 440, 400, 30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(panTextField);
        
        JLabel Nationalid= new JLabel("National ID:");
        Nationalid.setFont(new Font ("Raleway",Font.BOLD ,20));
        Nationalid.setBounds(100, 490, 200, 30);
        add(Nationalid);
        
        nationalidTextField = new JTextField();
        nationalidTextField.setBounds(300, 490, 400, 30);
        nationalidTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(nationalidTextField);
        
        JLabel Senior= new JLabel("Senior Citizen:");
        Senior.setFont(new Font ("Raleway",Font.BOLD ,20));
        Senior.setBounds(100, 550, 200, 30);
        add(Senior);
        
        syes= new JRadioButton("YES");
        syes.setBounds(300, 550, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno= new JRadioButton("NO");
        sno.setBounds(450, 550, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup seniorcitizengroup= new ButtonGroup();
        seniorcitizengroup.add(syes);
        seniorcitizengroup.add(sno);
        
        JLabel Existing= new JLabel("Exisiting Account:");
        Existing.setFont(new Font ("Raleway",Font.BOLD ,20));
        Existing.setBounds(100, 610, 200, 30);
        add(Existing);
        
        eyes= new JRadioButton("YES");
        eyes.setBounds(300, 610, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno= new JRadioButton("NO");
        eno.setBounds(450, 610, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup existingaccountgroup= new ButtonGroup();
        existingaccountgroup.add(eyes);
        existingaccountgroup.add(eno);
        
        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        setSize(850, 800); // set the dimension of frame
        setVisible(true); // make the frame visible
        setLocation(350,10);// set the location of frame
        
        getContentPane().setBackground(Color.white);
    }

    SignupTwo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        String sreligion= (String) religion.getSelectedItem();
        String scategory= (String) category.getSelectedItem();
        String sincome= (String) income.getSelectedItem();
        String seducation= (String) education.getSelectedItem();
        String soccupation= (String) occupation.getSelectedItem();
        
        
        String seniorcitizen= null;
        if(syes.isSelected()){
            seniorcitizen="YES";
        }
        else if(sno.isSelected()){
            seniorcitizen="NO";
        }
        
        
        
        String existingaccount= null;
        
        if(eyes.isSelected()){
            existingaccount="YES";
        }
        else if(eno.isSelected())
        {
            existingaccount="NO";
        }
        
        
        String span = panTextField.getText();
        String snationalid = nationalidTextField.getText();
        
        try{
       
            
                Conn c = new Conn();
                
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+snationalid+"', '"+seniorcitizen+"', '"+existingaccount+"')";
                
                c.s.executeUpdate(query);
            
                //signup3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    
   public static void main(String args[]){
       new SignupTwo("");
   } 
}
