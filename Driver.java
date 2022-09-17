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

public class Driver extends JFrame implements ActionListener
{
 JTextField dri_id,id,name,ph_no,email_id,address ;
 JLabel dri_id1,id1,av_st1,name1,gender1,ph_no1,email_id1,address1;
 JComboBox av_st;
 String S[]={"YES","NO"};
 JButton save,clear,cancel;
 JRadioButton M,F;
 ButtonGroup G;
 Connection con;
 PreparedStatement ps;
 Statement st;
 String Gender;
 
 public Driver()
{
  super("Driver Details");
  setLayout(null);
  setExtendedState(MAXIMIZED_BOTH);
  
  dri_id1=new JLabel("DRIVER ID:");
  dri_id1.setBounds(80,40,150,20);
  add(dri_id1);
  dri_id=new JTextField();
  dri_id.setBounds(250,40,150,30);
  add(dri_id);
  
  id1=new JLabel("CUSTOMER ID:");
  id1.setBounds(80,80,150,20);
  add(id1);
  id=new JTextField();
  id.setBounds(250,80,150,30);
  add(id);

  av_st1=new JLabel("AVAILABILITY STATUS:");
  av_st1.setBounds(80,120,150,20);
  add(av_st1);
  av_st=new JComboBox(S);
  av_st.setBounds(250,120,150,30);
  add(av_st);
  
  name1=new JLabel("NAME:");
  name1.setBounds(80,160,150,20);
  add(name1);
  name=new JTextField();
  name.setBounds(250,160,150,30);
  add(name);
  
  gender1=new JLabel("GENDER:");
  gender1.setBounds(80,200,150,20);
  add(gender1);
  G=new ButtonGroup();
  M=new JRadioButton("Male");
  M.setBounds(250,200,60,30);
  F=new JRadioButton("Female");
  F.setBounds(320,200,100,30);
  add(M);
  add(F);
  G.add(M);
  G.add(F);


  ph_no1=new JLabel("PHONE NO.:");
  ph_no1.setBounds(80,240,150,20);
  add(ph_no1);
  ph_no=new JTextField();
  ph_no.setBounds(250,240,150,30);
  add(ph_no);

  email_id1=new JLabel("EMAIL ID:");
  email_id1.setBounds(80,280,150,20);
  add(email_id1);
  email_id=new JTextField();
  email_id.setBounds(250,280,150,30);
  add(email_id);
   
  address1=new JLabel("ADDRESS:");
  address1.setBounds(80,320,150,20);
  add(address1);
  address=new JTextField();
  address.setBounds(250,320,150,30);
  add(address);
  
  JButton save=new JButton("SAVE");
  save.setBounds(80,360,80,40);
  save.setBackground(new Color(192,192,192));
  add(save);
  
  JButton clear=new JButton("CLEAR");
  clear.setBounds(200,360,80,40);
  clear.setBackground(new Color(192,192,192));
  add(clear);
  
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(320,360,80,40);
  cancel.setBackground(new Color(192,192,192));
  add(cancel);
  
  save.addActionListener(this);
  clear.addActionListener(this);
  cancel.addActionListener(this);
  
}

public void actionPerformed(ActionEvent e) 
{
        if (e.getActionCommand().equalsIgnoreCase("Save")) 
		{
            try 
			{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                con = DriverManager.getConnection("jdbc:odbc:vr");
                try 
				{
					
                    String str = "insert into DriverD(Driver_ID,Customer_ID,Avail,D_Name,Gender,Ph_No,Email_ID,Address)"  +
                           " values(?,?,?,?,?,?,?,?)";
							//String str = "insert into DriverD(Driver_ID,Customer_ID,Avail)" + " values(?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
					
					if(M.isSelected())
					{ Gender="M";
					}
                    else
                    { Gender="F";	
                    }		
                    					
                    ps.setString(1, dri_id.getText());
                    ps.setString(2, id.getText());
					ps.setString(3, av_st.getSelectedItem().toString());
				    ps.setString(4, name.getText());
					ps.setString(5, Gender);
					ps.setString(6, ph_no.getText());
                    ps.setString(7, email_id.getText());
                    ps.setString(8, address.getText());
				   
                    ps.executeUpdate();
					System.out.println("SUCCESS");
                    JOptionPane.showMessageDialog(null, "Driver details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                } 
				catch (Exception x) 
				{
                   JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
            } 
			catch (Exception ex) 
			{
                JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
        }//if closed
         
		 
		if (e.getActionCommand().equalsIgnoreCase("Clear")) 
		{
            ClearForm();
        }//if closed
        
		
		if (e.getActionCommand().equalsIgnoreCase("Cancel")) 
		{
            this.dispose();
        }//if closed
    }
	
	
	private void ClearForm() 
	{
        dri_id.setText("");
        id.setText("");
        av_st.setSelectedIndex(0);
		name.setText("");
		G.setSelected(G.getSelection(),true);
        ph_no.setText("");
        email_id.setText("");
        address.setText("");
		
    }//clearform() closed
  


public static void main(String args[])
{ 
  Driver D=new Driver();
  D.setSize(500,500);
  D.setVisible(true);
  D.setResizable(false);
  D.setLocation(250,100);
}
}//class closed


