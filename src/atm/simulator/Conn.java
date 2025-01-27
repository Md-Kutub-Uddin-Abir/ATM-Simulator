package atm.simulator;

import java.sql.*;

class Conn {
    Connection c;
    Statement s;
   public Conn(){
       try{
         
           c= DriverManager.getConnection("jdbc:mysql:///atmsimulatorsystem1","root","234510kutub");
           s=c.createStatement();
       }
       catch(Exception e){
           System.out.println(e);
       }
   } 
}
