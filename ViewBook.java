
package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewBook extends JFrame  {
    String x[]={"ID","Book Number","Book Name","Author","Publisher","Quantity","Issued","Date"};
    JButton bt;
    String y[][]=new String[20][8];
    int i=0,j=0;
    JTable t;
    Font f,f1;
   
    ViewBook(){
        super("Book Information");
        setLocation(1,1);
        setSize(1000,400);
        
        f=new Font("Arial",Font.BOLD,15);
        try{
           ConnectionClass obj=new ConnectionClass();
           String q="Select * from addbook";
           ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next()){
               y[i][j++]=rest.getString("ID");
               y[i][j++]=rest.getString("Book Number");
               y[i][j++]=rest.getString("Book Name");
               y[i][j++]=rest.getString("Author");
               y[i][j++]=rest.getString("Publisher");
               y[i][j++]=rest.getString("Quantity");
               y[i][j++]=rest.getString("Issued");
               y[i][j++]=rest.getString("Date");
               i++;
               j=0;
           }
           t=new JTable(y,x);
           t.setFont(f);
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);
        add(sp);
    }
    public static void main(String[] args){
        new ViewBook().setVisible(true);
    }
    
}
    

