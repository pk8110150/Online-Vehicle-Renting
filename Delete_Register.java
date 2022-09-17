import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


public class Delete_Register extends JFrame implements ActionListener
{
 JTextField v_id;
 JLabel v_id1;
 JButton delete,cancel;
 Connection con;
 Statement st;
 
 public Delete_Register()
{
  super("Delete Registration");
  setLayout(null);
  setExtendedState(MAXIMIZED_BOTH);
  
  v_id1=new JLabel("VEHICLE ID:");
  v_id1.setBounds(80,40,100,20);
  add(v_id1);
  v_id=new JTextField();
  v_id.setBounds(200,40,150,30);
  add(v_id);
  
  JButton delete=new JButton("DELETE");
  delete.setBounds(150,100,80,40);
  delete.setBackground(new Color(192,192,192));
  add(delete);
   
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(280,100,80,40);
  cancel.setBackground(new Color(192,192,192));
  add(cancel);
  
  delete.addActionListener(this);
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
}

public void actionPerformed(ActionEvent e) 
{
        if (e.getActionCommand().equalsIgnoreCase("Delete")) 
		{
			             
				
				try 
				{
					st=con.createStatement();
                    String str = "DELETE FROM NewReg WHERE Vehicle_ID=" + v_id.getText();
                    st.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Record successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();	
                    
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
        v_id.setText("");

    }//clearform() closed

public static void main(String args[])
{ 
  Delete_Register DR=new Delete_Register();
  DR.setSize(500,200);
  DR.setVisible(true);
  DR.setResizable(false);
  DR.setLocation(450,200);
}
}


