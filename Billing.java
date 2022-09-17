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


public class Billing extends JFrame implements ActionListener

{
 JTextField bill_id,b_id,booking_fee,tot_amt,return_dt,return_t,fine,bal,
            book_date,book_time,due_date,due_time,v_id,per_hr,per_day,pkm1,pkm2,rent_fee;
 JLabel  head,bill_id1,b_id1,booking_fee1,dep1,tot_amt1,return_dt1,return_t1,fine1,
          book_date1,book_time1,due_date1,due_time1,v_id1,per_hr1,per_day1,lblpkm1,lblpkm2,rent_fee1;
 JComboBox dep;
 String S[]={"_Select_","Bicycle(Rs15: Rs5)","Bicycle(Rs20: Rs 7)","Scooter(Rs36- Rs10)","Bike(Rs60: Rs20)","Bike(Rs80: Rs30)","5&7 Seat(Rs2000)"}; 
 JButton view,update,save,cancel,view1,view2;
 JPanel heading;
 Font F;
 Connection con;
 PreparedStatement ps;
 Statement st;
 int billid;
 int bid;
 int vid;
 
 public Billing()
{
  super("Billing and Return Details");
  setLayout(null);
  setExtendedState(MAXIMIZED_BOTH);
   
  F=new Font("Serif",Font.BOLD,40);
  heading=new JPanel();
  heading.setBackground(new Color(0,0,0,80));
  heading.setBounds(0,0,1000,60);
  head=new JLabel("BILLING AND RETURN");
  head.setForeground(Color.WHITE);
  head.setBounds(0,25,400,50);
  head.setFont(F);
  heading.add(head);
  add(heading);
  
 
  //Billing 
  bill_id1=new JLabel("BILL ID :");
  bill_id1.setBounds(80,80,100,20);
  add(bill_id1);
  bill_id=new JTextField();
  bill_id.setBounds(220,80,150,20);
  add(bill_id);
  
  b_id1=new JLabel("BOOK ID:");
  b_id1.setBounds(80,120,100,20);
  add(b_id1);
  b_id=new JTextField();  
  b_id.setBounds(220,120,150,20);
  add(b_id);
  
  JButton view1=new JButton("VIEW1");
  view1.setBounds(380,120,80,30);
  view1.setBackground(new Color(192,192,192));
  add(view1);
  
  book_date1=new JLabel("BOOK DATE:");  
  book_date1.setBounds(80,160,100,20);
  add(book_date1);
  book_date=new JTextField();  
  book_date.setBounds(80,200,100,30);
  add(book_date);
  
  book_time1=new JLabel("BOOK TIME:");  
  book_time1.setBounds(200,160,100,30);
  add(book_time1);
  book_time=new JTextField();  
  book_time.setBounds(200,200,100,30);
  add(book_time);
  
  due_date1=new JLabel("DUE DATE:");  
  due_date1.setBounds(80,240,100,30);
  add(due_date1); 
  due_date=new JTextField();  
  due_date.setBounds(80,280,100,30);
  add(due_date);
  
  due_time1=new JLabel("DUE TIME:");  
  due_time1.setBounds(200,240,100,30);
  add(due_time1); 
  due_time=new JTextField();  
  due_time.setBounds(200,280,100,30);
  add(due_time);
  
  v_id1=new JLabel("VEHICLE ID :");
  v_id1.setBounds(80,320,100,20);
  add(v_id1);
  v_id=new JTextField();
  v_id.setBounds(220,320,150,30);
  add(v_id);
  
  JButton view2=new JButton("VIEW2");
  view2.setBounds(380,320,80,30);
  view2.setBackground(new Color(192,192,192));
  add(view2);
  
  per_hr1=new JLabel("PER HOUR :");
  per_hr1.setBounds(80,360,100,20);
  add(per_hr1);
  per_hr=new JTextField();
  per_hr.setBounds(80,400,100,30);
  add(per_hr);
  
  per_day1=new JLabel("PER DAY :");
  per_day1.setBounds(200,360,100,20);
  add(per_day1);
  per_day=new JTextField();
  per_day.setBounds(200,400,100,30);
  add(per_day);
  
  lblpkm1=new JLabel("Per 150 kms:");
  lblpkm1.setBounds(80,440,100,20);
  add(lblpkm1);
  pkm1=new JTextField();
  pkm1.setBounds(80,480,100,30);
  add(pkm1);
  
  lblpkm2=new JLabel(" Per 375 kms :");
  lblpkm2.setBounds(200,440,100,20);
  add(lblpkm2);
  pkm2=new JTextField();
  pkm2.setBounds(200,480,100,30);
  add(pkm2);
  
  rent_fee1=new JLabel("RENT FEE :");
  rent_fee1.setBounds(80,520,100,20);
  add(rent_fee1);
  rent_fee=new JTextField();
  rent_fee.setBounds(220,520,150,30);
  add(rent_fee);
  
  dep1=new JLabel("DEPOSIT:");
  dep1.setBounds(80,560,100,20);
  add(dep1);
  dep=new JComboBox(S);
  dep.setBounds(220,560,150,30);
  add(dep);
  
  tot_amt1=new JLabel("TOTAL AMOUNT :");
  tot_amt1.setBounds(80,600,100,20);
  add(tot_amt1);
  tot_amt=new JTextField();
  tot_amt.setBounds(220,600,150,30);
  add(tot_amt);
  
  //Return
  return_dt1=new JLabel("RETURN DATE :");
  return_dt1.setBounds(600,80,150,20);
  add(return_dt1);
  return_dt=new JTextField();
  return_dt.setBounds(770,80,150,30);
  add(return_dt);
  
  return_t1=new JLabel("RETURN TIME:");
  return_t1.setBounds(600,120,150,20);
  add(return_t1);
  return_t=new JTextField();
  return_t.setBounds(770,120,150,30);
  add(return_t);
  
  fine1=new JLabel("FINE AMOUNT :");
  fine1.setBounds(600,160,150,20);
  add(fine1);
  fine=new JTextField();  
  fine.setBounds(770,160,150,30);
  add(fine);
   
  JButton view=new JButton("VIEW");
  view.setBounds(80,640,80,40);
  view.setBackground(new Color(192,192,192));
  add(view);
  
  JButton update=new JButton("UPDATE");
  update.setBounds(240,640,80,40);
  update.setBackground(new Color(192,192,192));
  add(update);
  
  JButton save=new JButton("SAVE");
  save.setBounds(400,640,80,40);
  save.setBackground(new Color(192,192,192));
  add(save);
  
  JButton clear=new JButton("CLEAR");
  clear.setBounds(560,640,80,40);
  clear.setBackground(new Color(192,192,192));
  add(clear);
   
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(720,640,80,40);
  cancel.setBackground(new Color(192,192,192));
  add(cancel);

  save.addActionListener(this);
  cancel.addActionListener(this);
  view.addActionListener(this);
  update.addActionListener(this);
  view1.addActionListener(this);
  view2.addActionListener(this);
  clear.addActionListener(this);
  
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
					
                    String str = "insert into Billing(Bill_ID,Book_ID,Book_Date,Book_Time,Due_Date,Due_Time,Vehicle_ID,Rent_Fee,Deposit,Total_Amount,Return_Date,Return_Time,Fine_Amount)"  +
                            " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
						
                    ps.setString(1, bill_id.getText());
                    ps.setString(2, b_id.getText());
					ps.setString(3, book_date.getText());
                    ps.setString(4, book_time.getText());
					ps.setString(5, due_date.getText());
                    ps.setString(6, due_time.getText());
					ps.setString(7, v_id.getText());
                    ps.setString(8, rent_fee.getText());
				    ps.setString(9, dep.getSelectedItem().toString());
				    ps.setString(10, tot_amt.getText());
                    ps.setString(11, return_dt.getText());
                    ps.setString(12, return_t.getText());
					ps.setString(13, fine.getText());
              
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Billing details successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
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
		
		if (e.getActionCommand().equalsIgnoreCase("VIEW1")) 
		{

            try 
			{    
                ResultSet rs = st.executeQuery("SELECT * FROM BookingD WHERE Booking_ID=" + b_id.getText());
                if (rs.next()) 
				{
                   bid = Integer.parseInt(b_id.getText());
				   book_date.setText(rs.getString("Book_Date"));
				   book_time.setText(rs.getString("Book_Time"));
				   due_date.setText(rs.getString("Due_Date"));
				   due_time.setText(rs.getString("Due_Time"));
		           
                } 
				else 	
				{
                    JOptionPane.showMessageDialog(null, "BOOKIND ID is not found in database", "Not found", JOptionPane.INFORMATION_MESSAGE);
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
                ResultSet rs1 = st.executeQuery("SELECT * FROM NewReg WHERE Vehicle_ID="+ v_id.getText());
                if (rs1.next()) 
				{
                    vid = Integer.parseInt(v_id.getText());
                    per_hr.setText(rs1.getString("Per_Hour"));
					per_day.setText(rs1.getString("Per_Day"));
					pkm1.setText(rs1.getString("Per_150kms"));
					pkm2.setText(rs1.getString("Per_375kms"));
		           
		            
                } 
				else 	
				{
                    JOptionPane.showMessageDialog(null, "Vehicle ID is not found in database", "Not found", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                    //update.setEnabled(false);
              }//if else closed                
            } 
			catch (Exception x) 
			{
                JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
            }//inner try catch closed

        }//if closed
		
		
		
		if (e.getActionCommand().equalsIgnoreCase("Update")) 
		{
            try 
			{
                if(billid!=Integer.parseInt(bill_id.getText()))
				{
                    JOptionPane.showMessageDialog(null,"Customer Id  cannot be changed","Updation error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
				String sql = "UPDATE Billing SET Book_ID=?,Book_Date=?,Book_Time=?,Due_Date=?,Due_Time=?,Vehicle_ID=?"+
				               "Rent_Fee=?,Deposit=?,Total_Amount=?,Return_Date=?,Return_Time=?,Fine_Amount=?"+ " WHERE bill_id_ID=" +  billid;
               	ps=con.prepareStatement(sql);
				
                   
                    ps.setString(1, b_id.getText());
					ps.setString(2, book_date.getText());
					ps.setString(3, book_time.getText());
					ps.setString(4, due_date.getText());
                    ps.setString(5, due_time.getText());
                    ps.setString(6, v_id.getText());
                    /*ps.setString(7, per_hr.getText());
                    ps.setString(8, per_day.getText());
					ps.setString(9, pkm1.getText());
					ps.setString(10, pkm2.getText());*/
					ps.setString(7, rent_fee.getText());
					ps.setString(8, dep.getSelectedItem().toString());
				    ps.setString(9, tot_amt.getText());
                    ps.setString(10, return_dt.getText());
                    ps.setString(11, return_t.getText());
                    ps.setString(12, fine.getText());
   
					
					ps.executeUpdate();
					
                    JOptionPane.showMessageDialog(null, "Billing details successfully updated"+sql, "Success", JOptionPane.INFORMATION_MESSAGE);
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
                ResultSet rs = st.executeQuery("SELECT * FROM Billing WHERE Bill_ID=" + bill_id.getText());
                if (rs.next()) 
				{
                    billid = Integer.parseInt(bill_id.getText());
                    b_id.setText(rs.getString("Book_ID"));
					book_date.setText(rs.getString("Book_Date"));
					book_time.setText(rs.getString("Book_Time"));
					due_date.setText(rs.getString("Due_Date"));
					due_time.setText(rs.getString("Due_Time"));
					v_id.setText(rs.getString("Vehicle_ID"));
		            /*per_hr.setText(rs.getString("Per_Hour"));
					per_day.setText(rs.getString("Per_Day"));					
		            pkm1.setText(rs.getString("Per_150_kms"));
                    pkm2.setText(rs.getString("Per_375_kms"));*/										
                    rent_fee.setText(rs.getString("Rent_Fee"));										
                    dep.setSelectedItem(rs.getString("Deposit"));									
                    tot_amt.setText(rs.getString("Total_Amount"));										
                    return_dt.setText(rs.getString("Return_Date"));											
					return_t.setText(rs.getString("Return_Time"));	


					
		            
                } 
				else 	
				{
                    JOptionPane.showMessageDialog(null, "Bill_ID is not found in database", "Not found", JOptionPane.INFORMATION_MESSAGE);
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
	    bill_id.setText("");
		b_id.setText("");
		book_date.setText("");
		book_time.setText("");
		due_date.setText("");
		due_time.setText("");
        v_id.setText("");
		per_hr.setText("");
		per_day.setText("");
		pkm1.setText("");
        pkm2.setText("");
		rent_fee.setText("");
		dep.setSelectedIndex(0);;
		tot_amt.setText("");
		return_dt.setText("");
		return_t.setText("");
		fine.setText("");
		
		
    }//clearform() closed */


 public static void main(String args[])
 { 
  Billing B=new Billing();
  B.setSize(1000,1000);
  B.setVisible(true);
  B.setResizable(false);
  B.setLocation(200,100);
 }
}


