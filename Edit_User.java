import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Edit_User extends JFrame implements ActionListener 
{
 JTextField id,name,dob,phone,email,address;
 JLabel id1,name1,dob1,gender1,phone1,email1,address1;
 JButton view,update,cancel;
 JRadioButton M,F;
 ButtonGroup G;
 JComboBox month,day,year;
 String S[]={"_SELECT_","1","2"};
 Connection con;
 PreparedStatement ps;
 Statement st;
 int c_id;
 String Gender;
 
 public Edit_User()
{
  super("Edit Registration");
  setLayout(null);
  setExtendedState(MAXIMIZED_BOTH);
  
  id1=new JLabel("CUSTOMER ID:");
  id1.setBounds(80,40,100,20);
  add(id1);
  id=new JTextField();
  id.setBounds(200,40,150,30);
  add(id);
  
  name1=new JLabel("FULL NAME:");
  name1.setBounds(80,80,100,20);
  add(name1);
  name=new JTextField();
  name.setBounds(200,80,150,30);
  add(name);
  
  dob1=new JLabel("DOB:");
  dob1.setBounds(80,120,100,20);
  add(dob1);
  String[] daylist=new String[31];
  for (int i=1;i<=31;i++)
  {
	  daylist[i-1]= Integer.toString(i);
  }
  day=new JComboBox(daylist);
  day.setBounds(200,120,50,30);
  day.setEditable(true);
  day.setSelectedIndex(0);
  add(day);

  String[] monthlist= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
  month =new JComboBox(monthlist);
  month.setBounds(280,120,50,30);
  month.setEditable(true);
  month.setSelectedIndex(0);
  add(month);

  String[] yearlist=new String[100];
  for (int i=1951;i<=2050;i++)
  {
	  yearlist[i-1951]= Integer.toString(i);
  }
  year=new JComboBox(yearlist);
  year.setBounds(360,120,50,30);
  year.setEditable(true);
  year.setSelectedIndex(0);
  add(year); 
  
  gender1=new JLabel("GENDER:");
  gender1.setBounds(80,160,100,20);
  add(gender1);
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
  add(phone1);
  phone=new JTextField();
  phone.setBounds(200,200,150,30);
  add(phone);

  email1=new JLabel("EMAIL ID");
  email1.setBounds(80,240,100,20);
  add(email1);
  email=new JTextField();
  email.setBounds(200,240,150,30);
  add(email);

  address1=new JLabel("ADDRESS:");
  address1.setBounds(80,280,100,20);
  add(address1);
  address=new JTextField();
  address.setBounds(200,280,150,30);
  add(address);
  
  JButton view=new JButton("VIEW");
  view.setBounds(80,360,80,40);
  view.setBackground(new Color(192,192,192));
  add(view);
  
  JButton update=new JButton("UPDATE");
  update.setBounds(200,360,80,40);
  update.setBackground(new Color(192,192,192));
  add(update);
    
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(320,360,80,40);
  cancel.setBackground(new Color(192,192,192));
  add(cancel);
 
  view.addActionListener(this);
  update.addActionListener(this);
  cancel.addActionListener(this);

        try 
        {
          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
          con = DriverManager.getConnection("jdbc:odbc:vr");
          st = con.createStatement();
        } 
	    catch (Exception ex) 
	    {
            JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
        }//outer try catch closed

}//constructor closed

public void actionPerformed(ActionEvent e) 
{
        if (e.getActionCommand().equalsIgnoreCase("Update")) 
		{
            try 
			{
                if(c_id!=Integer.parseInt(id.getText()))
				{
                    JOptionPane.showMessageDialog(null,"Customer Id  cannot be changed","Updation error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
				String sql = "UPDATE NewUser SET Customer_Name=?,Day=?,Month=?,Year=?,Gender=?,Phone_No=?,Email_ID=?,Address=?"+" WHERE Customer_ID="+ c_id;
               	ps=con.prepareStatement(sql);
				if(M.isSelected())
			    { Gender="M";
				}
                else
                { Gender="F";	
                }			
                   
                    ps.setString(1, name.getText());
					ps.setString(2, day.getSelectedItem().toString());
					ps.setString(3, month.getSelectedItem().toString());
					ps.setString(4, year.getSelectedItem().toString());
                    ps.setString(5, Gender);
                    ps.setString(6, phone.getText());
                    ps.setString(7, email.getText());
                    ps.setString(8, address.getText());
                    System.out.println("success");
					
					ps.executeUpdate();
					
                    JOptionPane.showMessageDialog(null, "Registration details successfully updated"+sql, "Success", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                    //update.setEnabled(false);
            } 
			catch (Exception x) 
			{
                JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
            }//inner try catch closed
        }//if closed
        
		
		if (e.getActionCommand().equalsIgnoreCase("View")) 
		{

            try 
			{
                ResultSet rs = st.executeQuery("SELECT * FROM NewUser WHERE Customer_ID=" + id.getText());
                if (rs.next()) 
				{
                    c_id = Integer.parseInt(id.getText());
                    name.setText(rs.getString("Customer_Name"));
		            day.setSelectedItem(rs.getString("Day"));
		            month.setSelectedItem(rs.getString("Month"));
		            year.setSelectedItem(rs.getString("Year"));
					if(rs.getString("Gender").equalsIgnoreCase("M"))
						M.setSelected(true);//rs.getString("Gender"),true);
					else
						F.setSelected(true);
                    phone.setText(rs.getString("Phone_No"));
                    email.setText(rs.getString("Email_ID"));
                    address.setText(rs.getString("Address"));
                    //update.setEnabled(true );
                } 
				else 	
				{
                    JOptionPane.showMessageDialog(null, "Customer ID is not found in database", "Not found", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                    //update.setEnabled(false);
              }//if else closed                
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
  Edit_User EU=new Edit_User();
  EU.setSize(500,500);
  EU.setVisible(true);
  EU.setResizable(false);
  EU.setLocation(250,100);
}
}//class closed