import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;


public class Booking extends JFrame implements ActionListener
{
 JTextField b_id,v_id,avail,id,name,book_date,book_time,due_date,due_time,booking_fee;
 JLabel b_id1,v_id1,avail1,id1,name1,book_date1,book_time1,due_date1,due_time1,booking_fee1;
 JButton save,cancel,view_avail,view_cust;
 Connection con;
 PreparedStatement ps;
 Statement st;
 int bid;
 int c_id;
 int vid;
 
 public Booking()
{
  super("Booking Details");
  setLayout(null);
  setExtendedState(MAXIMIZED_BOTH);
  
  b_id1=new JLabel("BOOKING ID:");
  b_id1.setBounds(80,5,150,20);
  add(b_id1);
  b_id=new JTextField();
  b_id.setBounds(250,5,150,30);
  add(b_id);

  v_id1=new JLabel("VEHICLE ID:");
  v_id1.setBounds(80,45,150,20);
  add(v_id1);
  v_id=new JTextField();
  v_id.setBounds(250,45,150,30);
  add(v_id);
  JButton view_avail=new JButton("View1");
  view_avail.setBounds(450,45,80,20);
  view_avail.setBackground(new Color(192,192,192));
  add(view_avail);
  
  avail1=new JLabel("AVAILABLE:");
  avail1.setBounds(80,80,150,20);
  add(avail1);
  avail=new JTextField();
  avail.setBounds(250,80,150,30);
  add(avail);

  id1=new JLabel("CUSTOMER ID:");
  id1.setBounds(80,120,150,20);
  add(id1);
  id=new JTextField();
  id.setBounds(250,120,150,30);
  add(id);
  JButton view_cust=new JButton("View2");
  view_cust.setBounds(450,120,80,20);
  view_cust.setBackground(new Color(192,192,192));
  add(view_cust);
  
  name1=new JLabel("CUSTOMER NAME:");
  name1.setBounds(80,160,150,20);
  add(name1);
  name=new JTextField();
  name.setBounds(250,160,150,30);
  add(name);

  book_date1=new JLabel("BOOKING DATE:");
  book_date1.setBounds(80,200,150,20);
  add(book_date1);
  book_date=new JTextField();
  book_date.setBounds(250,200,150,30);
  add(book_date);

  book_time1=new JLabel("BOOKING TIME:");
  book_time1.setBounds(80,240,150,20);
  add(book_time1);
  book_time=new JTextField();
  book_time.setBounds(250,240,150,30);
  add(book_time);

  due_date1=new JLabel("DUE DATE:");
  due_date1.setBounds(80,280,150,20);
  add(due_date1);
  due_date=new JTextField();
  due_date.setBounds(250,280,150,30);
  add(due_date);
   
  due_time1=new JLabel("DUE TIME:");
  due_time1.setBounds(80,320,150,20);
  add(due_time1);
  due_time=new JTextField();
  due_time.setBounds(250,320,150,30);
  add(due_time);
   
  JButton save=new JButton("SAVE");
  save.setBounds(80,380,80,40);
  save.setBackground(new Color(192,192,192));
  add(save);
  
  JButton clear=new JButton("CLEAR");
  clear.setBounds(200,380,80,40);
  clear.setBackground(new Color(192,192,192));
  add(clear);
   
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(320,380,80,40);
  cancel.setBackground(new Color(192,192,192));
  add(cancel);
  
  save.addActionListener(this);
  clear.addActionListener(this);
  cancel.addActionListener(this);
  view_avail.addActionListener(this);
  view_cust.addActionListener(this);
  
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
				
							
					String str = "insert into BookingD(Booking_ID,Vehicle_ID,Customer_ID,Book_Date,Book_Time,Due_Date,Due_Time,Availability,Customer_Name)"  +
                            " values((?,?,?,?,?,?,?,?,?)";		
                    PreparedStatement ps = con.prepareStatement(str);
						
                    ps.setString(1, b_id.getText());
                    ps.setString(2, v_id.getText());
					ps.setString(3, id.getText());
					ps.setString(4, book_date.getText());
					ps.setString(5, book_time.getText());
                    ps.setString(6, due_date.getText());
                    ps.setString(7, due_time.getText());
                    ps.setString(8, avail.getText());
                    ps.setString(9, name.getText());
				    
                    ps.executeUpdate();
					System.out.println("SUCCESS");
                    JOptionPane.showMessageDialog(null, "Booking details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                } 
				catch (Exception x) 
				{
                    //JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
                }//inner try catch closed
            } 
			catch (Exception ex) 
			{
                //JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
        }//if closed
		
		if (e.getActionCommand().equalsIgnoreCase("View1")) 
		{

            try 
			{    
                ResultSet rs = st.executeQuery("SELECT * FROM NewReg WHERE Vehicle_ID=" + v_id.getText());
                if (rs.next()) 
				{
                   vid = Integer.parseInt(v_id.getText());
				   avail.setText(rs.getString("Availability"));
		           
                } 
				else 	
				{
                    JOptionPane.showMessageDialog(null, "VEHICLE ID is not found in database", "Not found", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                    //update.setEnabled(false);
              }//if else closed                
            } 
			catch (Exception x) 
			{
                JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
            }//inner try catch closed

        }//if closed
		
		
        
		
		if (e.getActionCommand().equalsIgnoreCase("View2")) 
		{

            try 
			{   
                ResultSet rs1 = st.executeQuery("SELECT * FROM NewUser WHERE Customer_ID="+ id.getText());
                if (rs1.next()) 
				{
                    c_id = Integer.parseInt(id.getText());
                    name.setText(rs1.getString("Customer_Name"));
		            /*day.setSelectedItem(rs.getString("Day"));
		            month.setSelectedItem(rs.getString("Month"));
		            year.setSelectedItem(rs.getString("Year"));
					if(rs.getString("Gender").equalsIgnoreCase("M"))
						M.setSelected(true);//rs.getString("Gender"),true);
					else
						F.setSelected(true);
                    phone.setText(rs.getString("Phone_No"));
                    email.setText(rs.getString("Email_ID"));
                    address.setText(rs.getString("Address"));
                    //update.setEnabled(true );*/
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
	    b_id.setText("");
        v_id.setText("");
		avail.setText("");
		id.setText("");
		name.setText("");
		book_date.setText("");
		book_time.setText("");
		due_date.setText("");
		due_time.setText("");
		
		
    }//clearform() closed



    

public static void main(String args[])
{ 
  Booking Bk=new Booking();
  Bk.setSize(600,600);
  Bk.setVisible(true);
  Bk.setResizable(false);
  Bk.setLocation(250,100);
}
}


