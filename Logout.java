import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Logout extends JFrame implements ActionListener
{
 JButton btnlogout,cancel;
 Connection con;
 PreparedStatement ps;
 Statement st;
 
 public Logout()
{
  super("Logout");
  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  setExtendedState(MAXIMIZED_BOTH);
  
  JButton btnlogout=new JButton("LOGOUT");
  btnlogout.setBounds(100,80,300,100);
  btnlogout.setBackground(new Color(192,192,192));
  add(btnlogout);
  
  /*JButton cancel=new JButton("CANCEL");
  cancel.setBounds(100,350,300,100);
  cancel.setBackground(new Color(192,192,192));
  add(cancel);*/
  
  btnlogout.addActionListener(this);
  //cancel.addActionListener(this);
  
}

public void actionPerformed(ActionEvent e) 
{ 

  if (e.getActionCommand().equalsIgnoreCase("Logout"))
    {   
        try 
	    {
	     dispose();	
         Login obj=new Login();
         obj.setVisible(true);
		 obj.setSize(900,600);
         obj.setVisible(true);
         obj.setResizable(false);
         obj.setLocation(150,100);
	     obj.setUndecorated(true);
	     obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 JOptionPane.showMessageDialog(null, "Successfully Logged Out", "Success", JOptionPane.INFORMATION_MESSAGE);
         		
		}
	    catch(Exception ex) 
        {
            //JOptionPane.showMessageDialog(null, "Sucessfully Logged Out","Sucess", JOptionPane.ERROR_MESSAGE);
        }
	}	   
  /*if (e.getActionCommand().equalsIgnoreCase("Cancel")) 
		{
            this.dispose();
        }//if closed */
}

public static void main(String args[])
{ 
  Logout L=new Logout();
  L.setSize(500,500);
  L.setVisible(true);
  L.setResizable(false);
  L.setLocation(250,100);
}
}//class closed		