import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Delete_User extends JFrame implements ActionListener
{
 JTextField id;
 JLabel id1;
 JButton btndelete,cancel;
 Connection con;
 Statement st;
 
 public Delete_User()
{
  super("Delete Registration");
  setLayout(null);
  setExtendedState(MAXIMIZED_BOTH);
  
  id1=new JLabel("CUSTOMER ID:");
  id1.setBounds(80,40,100,20);
  add(id1);
  id=new JTextField();
  id.setBounds(200,40,150,30);
  add(id);
  
  JButton btndelete=new JButton("DELETE");
  btndelete.setBounds(150,100,80,40);
  btndelete.setBackground(new Color(192,192,192));
  add(btndelete);
   
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(280,100,80,40);
  cancel.setBackground(new Color(192,192,192));
  add(cancel);
  
  btndelete.addActionListener(this);
  cancel.addActionListener(this);
  
       try 
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:vr");
        } 
	  catch (Exception ex) 
	    {
            JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
        }
}//constructor closed
	
    public void actionPerformed(ActionEvent e) 
{
        if (e.getActionCommand().equalsIgnoreCase("Delete")) 
		{
			             
				
				try 
				{
					st=con.createStatement();
                    String str = "DELETE FROM NewUser WHERE Customer_ID=" + id.getText();
                    st.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Record successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
				
                  //btndelete.setEnabled(false);
                    
					
                    
                } 
				catch (Exception x) 
				{
                    JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
				
        }//if closed
		
		if (e.getActionCommand().equalsIgnoreCase("Cancel")) 
		{
            this.dispose();
        }//if closed
}		
		
		
	
    

	private void ClearForm() 
    {
        id.setText("");

    }//clearform() closed

public static void main(String args[])
{ 
  Delete_User DU=new Delete_User();
  DU.setSize(500,200);
  DU.setVisible(true);
  DU.setResizable(false);
  DU.setLocation(450,200);
}
}


