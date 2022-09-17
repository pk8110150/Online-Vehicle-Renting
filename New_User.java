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

public class New_User extends JFrame implements ActionListener
{

 JTextField id,name,dob,phone,email,address;
 JLabel id1,name1,dob1,gender1,phone1,email1,address1;
 JButton save,cancel,clear;
 JRadioButton M,F;
 ButtonGroup G;
 JComboBox month,day,year;
 Connection con;
 PreparedStatement ps;
 Statement st;
 JPanel panel;
 String Gender;
	
 public New_User()
{
  super("New Registration");
  this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  setExtendedState(MAXIMIZED_BOTH);
  
  panel=new JPanel();
  panel.setLayout(null);
  panel.setSize(500,500);
  panel.setVisible(true);
  //panel.setResizable(true);
  setLocation(250,100);
  
  id1=new JLabel("CUSTOMER ID:");
  id1.setBounds(80,40,100,20);
  panel.add(id1);
  id=new JTextField();
  id.setBounds(200,40,150,30);
  panel.add(id);
  
  name1=new JLabel("FULL NAME:");
  name1.setBounds(80,80,100,20);
  panel.add(name1);
  name=new JTextField();
  name.setBounds(200,80,150,30);
  panel.add(name);
 
  dob1=new JLabel("DOB:");
  dob1.setBounds(80,120,100,20);
    panel.add(dob1);
  String[] daylist=new String[31];
  for (int i=1;i<=31;i++)
  {
	  daylist[i-1]= Integer.toString(i);
  }
  day=new JComboBox(daylist);
  day.setBounds(200,120,50,30);
  day.setEditable(true);
  day.setSelectedIndex(0);
    panel.add(day);

  String[] monthlist= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
  month =new JComboBox(monthlist);
  month.setBounds(280,120,50,30);
  month.setEditable(true);
  month.setSelectedIndex(0);
    panel.add(month);

  String[] yearlist=new String[100];
  for (int i=1951;i<=2050;i++)
  {
	  yearlist[i-1951]= Integer.toString(i);
  }
  year=new JComboBox(yearlist);
  year.setBounds(360,120,50,30);
  year.setEditable(true);
  year.setSelectedIndex(0);
    panel.add(year); 
 
  gender1=new JLabel("GENDER:");
  gender1.setBounds(80,160,100,20);
    panel.add(gender1);
  G=new ButtonGroup();
  M=new JRadioButton("Male");
  M.setBounds(200,160,60,30);
  F=new JRadioButton("Female");
  F.setBounds(280,160,100,30);
  add(M);
  add(F);
  G.add(M);
  G.add(F);

  phone1=new JLabel("PHONE NO.:");
  phone1.setBounds(80,200,100,20);
    panel.add(phone1);
  phone=new JTextField();
  phone.setBounds(200,200,150,30);
    panel.add(phone);

  email1=new JLabel("EMAIL ID");
  email1.setBounds(80,240,100,20);
    panel.add(email1);
  email=new JTextField();
  email.setBounds(200,240,150,30);
    panel.add(email);

  address1=new JLabel("ADDRESS:");
  address1.setBounds(80,280,100,20);
    panel.add(address1);
  address=new JTextField();
  address.setBounds(200,280,150,30);
    panel.add(address);
  
  JButton save=new JButton("SAVE");
  save.setBounds(80,360,80,40);
  save.setBackground(new Color(192,192,192));
    panel.add(save);
   
  JButton clear=new JButton("CLEAR");
  clear.setBounds(200,360,80,40);
  clear.setBackground(new Color(192,192,192));
  panel.add(clear);
  
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(320,360,80,40);
  cancel.setBackground(new Color(192,192,192));
  panel.add(cancel);
  
  save.addActionListener(this);
  clear.addActionListener(this);
  cancel.addActionListener(this);
  
  add(panel, BorderLayout.CENTER);
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
					
                    String str = "insert into NewUser(Customer_ID,Customer_Name,Day,Month,Year,Gender,Phone_No,Email_ID,Address)"  +
                            " values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
					if(M.isSelected())
					{ Gender="M";
					}
                    else
                    { Gender="F";	
                    }			
                    ps.setString(1, id.getText());
                    ps.setString(2, name.getText());
					ps.setString(3, day.getSelectedItem().toString());
					ps.setString(4, month.getSelectedItem().toString());
					ps.setString(5, year.getSelectedItem().toString());
                    ps.setString(6, Gender);
                    ps.setString(7, phone.getText());
                    ps.setString(8, email.getText());
                    ps.setString(9, address.getText());
				
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Registration details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
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
        id.setText("");
        name.setText("");
		day.setSelectedIndex(0);
		month.setSelectedIndex(0);
		year.setSelectedIndex(0);
		G.setSelected(G.getSelection(),true);
        phone.setText("");
        email.setText("");
        address.setText("");
    }//clearform() closed
  

public static void main(String args[])
{ 
  New_User NU=new New_User();
  NU.setSize(500,500);
  NU.setVisible(true);
  NU.setResizable(false);
  NU.setLocation(250,100);
}
}//class closed


