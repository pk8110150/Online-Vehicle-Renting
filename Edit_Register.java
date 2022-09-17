import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Edit_Register extends JFrame implements ActionListener 
{
 JTextField v_id,v_name;
 JLabel v_id1,v_type1,v_name1,avail1,rent_fee1;
 JButton save,clear,cancel;
 JComboBox v_type,avail,per_hr,per_day,pkm1,pkm2;
 String S1[]={"_SELECT_","BICYCLE","BIKE","SCOOTER","4 SEATER","6 SEATER"};
 String S2[]={"_SELECT_","YES","NO"};
 String S3[]={"_PER HOUR_","Null","Rs15/-","Rs20/-","Rs36/-","Rs60","Rs80/-"};
 String S4[]={"_PER DAY_","Null","Rs250/-","Rs20/-","Rs50/-","Rs600/-","Rs800/-"};
 String S5[]={"_Per 150 kms_","Null","Rs4830/-","Rs5660/-","Rs5050/-"};
 String S6[]={"_Per 375 kms_","Null","Rs5640/-","Rs5800/-","Rs5890/-"};
 Connection con;
 PreparedStatement ps;
 Statement st;
 int vid;

 
 public Edit_Register()
{
  super("New Registration");
  setLayout(null);
  setExtendedState(MAXIMIZED_BOTH);
  
  v_id1=new JLabel("VEHICLE ID:");
  v_id1.setBounds(80,40,100,20);
  add(v_id1);
  v_id=new JTextField();
  v_id.setBounds(200,40,150,30);
  add(v_id);
  
  v_type1=new JLabel("VEHICLE TYPE:");
  v_type1.setBounds(80,80,100,20);
  add(v_type1);
  v_type=new JComboBox(S1);
  v_type.setBounds(200,80,150,30);
  add(v_type);
 
  v_name1=new JLabel("VEHICLE NAME:");
  v_name1.setBounds(80,120,100,20);
  add(v_name1);
  v_name=new JTextField();
  v_name.setBounds(200,120,150,30);
  add(v_name);
  
  avail1=new JLabel("AVAILABILITY:");
  avail1.setBounds(80,160,100,20);
  add(avail1);
  avail=new JComboBox(S2);
  avail.setBounds(200,160,150,30);
  add(avail);
 
  rent_fee1=new JLabel("RENTING FEE:");
  rent_fee1.setBounds(80,200,100,20);
  add(rent_fee1);
  per_hr=new JComboBox(S3);
  per_hr.setBounds(200,200,100,30);
  add(per_hr);
  per_day=new JComboBox(S4);
  per_day.setBounds(320,200,100,30);
  add(per_day);
  pkm1=new JComboBox(S5);
  pkm1.setBounds(440,200,100,30);
  add(pkm1);
  pkm2=new JComboBox(S6);
  pkm2.setBounds(560,200,100,30);
  add(pkm2); 
  
  JButton view=new JButton("VIEW");
  view.setBounds(80,300,80,40);
  view.setBackground(new Color(192,192,192));
  add(view);
  
  JButton update=new JButton("UPDATE");
  update.setBounds(200,300,80,40);
  update.setBackground(new Color(192,192,192));
  add(update);
   
  JButton cancel=new JButton("CANCEL");
  cancel.setBounds(320,300,80,40);
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
                if(vid!=Integer.parseInt(v_id.getText()))
				{
                    JOptionPane.showMessageDialog(null,"Customer Id  cannot be changed","Updation error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
				String sql = "UPDATE NewReg SET Vehicle_Type=?,Vehicle_Name=?,Availability=?,Per_Hour=?,Per_Day=?,Per_150kms=?,Per_375kms=?"
				+" WHERE Vehicle_ID="+ vid;
               	ps=con.prepareStatement(sql);
				
                    ps.setString(1, v_type.getSelectedItem().toString());
					ps.setString(2, v_name.getText());
					ps.setString(3, avail.getSelectedItem().toString());
					ps.setString(4, per_hr.getSelectedItem().toString());
                    ps.setString(5, per_day.getSelectedItem().toString());
					ps.setString(7, pkm1.getSelectedItem().toString());
                    ps.setString(8, pkm2.getSelectedItem().toString());
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
                ResultSet rs = st.executeQuery("SELECT * FROM NewReg WHERE Vehicle_ID=" + v_id.getText());
                if (rs.next()) 
				{
                    vid = Integer.parseInt(v_id.getText());
                    v_type.setSelectedItem(rs.getString("Vehicle_Type"));
		            v_name.setText(rs.getString("Vehicle_Name"));
		            avail.setSelectedItem(rs.getString("Availability"));
		            per_hr.setSelectedItem(rs.getString("Per_Hour"));
                    per_day.setSelectedItem(rs.getString("Per_Day"));
					pkm1.setSelectedItem(rs.getString("Per_150kms"));
                    pkm2.setSelectedItem(rs.getString("Per_375kms"));
                    //update.setEnabled(true );
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
        
		
		if (e.getActionCommand().equalsIgnoreCase("Cancel")) 
		{
            this.dispose();
        }//if closed
    }
 private void ClearForm() 
    {
        v_id.setText("");
		v_type.setSelectedIndex(0);
		v_name.setText("");
		avail.setSelectedIndex(0);
		per_hr.setSelectedIndex(0);
		per_day.setSelectedIndex(0);
		pkm1.setSelectedIndex(0);
		pkm2.setSelectedIndex(0);
    }//clearform() closed

public static void main(String args[])
{ 
  Edit_Register ER=new Edit_Register();
  ER.setSize(600,400);
  ER.setVisible(true);
  ER.setResizable(false);
  ER.setLocation(250,100);
}
}


