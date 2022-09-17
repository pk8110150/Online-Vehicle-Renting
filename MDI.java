import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.*;  
public class MDI extends JFrame implements ActionListener
{  
     JMenuBar mb;
	 JFrame f;
	 
     JMenu CustomerDetails;
     JMenu VehicleRegistration;
     JMenu BookingDetails;
     JMenu DriverDetails;
	 JMenu BillingDetails;
	 //JMenu View;
     JMenu Logout;

     JMenuItem NewUser;
     JMenuItem EditUser;
     JMenuItem DeleteUser;
     JMenuItem NewReg;
     JMenuItem EditReg;
     JMenuItem DeleteReg;
	 JMenuItem BookDetails;
	 JMenuItem DriveDetails;
	 JMenuItem Bill;
     JMenuItem Out;
	 
	 public static JDesktopPane desktop;
	 
public MDI()
    {   
          f=new JFrame("VEHICLE RENTAL AND BOOKING"); 
		  mb=new JMenuBar();
		  setExtendedState(MAXIMIZED_BOTH);
          desktop = new JDesktopPane();		  
          
		  CustomerDetails=new JMenu("CUSTOMER DETAILS");  
		  VehicleRegistration=new JMenu("VEHICLE REGISTRATION");  
		  BookingDetails=new JMenu("BOOKING DETAILS");  
		  DriverDetails=new JMenu("DRIVER DETAILS");  
		  BillingDetails=new JMenu("BILLING & RETURN");
          //View=new JMenu("VIEW");    
		  Logout=new JMenu("LOGOUT");  
		    
          NewUser=new JMenuItem("New User");  
          EditUser=new JMenuItem("Edit User");  
          DeleteUser=new JMenuItem("Delete User");  
          NewReg=new JMenuItem("New Registration");  
		  EditReg=new JMenuItem("Edit Registration");  
          DeleteReg=new JMenuItem("Delete Registration");
          BookDetails=new JMenuItem(" ");
          DriveDetails=new JMenuItem(" ");		  
		  Bill=new JMenuItem(" ");
		  Out=new JMenuItem(" ");
           
		  CustomerDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("customer.png")));		  
          CustomerDetails.add(NewUser);
		  NewUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));		  
          CustomerDetails.addSeparator();
		  CustomerDetails.add(EditUser);
		  EditUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("edit_user.png")));		  
		  CustomerDetails.addSeparator();		  
		  CustomerDetails.add(DeleteUser);
		  DeleteUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("del_user.png")));		  
          		  
		  
		  VehicleRegistration.setIcon(new ImageIcon(ClassLoader.getSystemResource("vehicle.png")));		  
		  VehicleRegistration.add(NewReg); 
          NewReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_vehicle.jpg")));		  
		  VehicleRegistration.addSeparator();
		  VehicleRegistration.add(EditReg);
		  EditReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("edit_vehicle.png")));
          VehicleRegistration.addSeparator();
          VehicleRegistration.add(DeleteReg);
          DeleteReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("del_vehicle.png"))); 	  
		      
		  BookingDetails.add(BookDetails);
		  BookDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("book.jpg")));
		  DriverDetails.add(DriveDetails);
		  DriveDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("driver_icon.jpg")));
		  BillingDetails.add(Bill);
		  Bill.setIcon(new ImageIcon(ClassLoader.getSystemResource("bill.png"))); 
		  Logout.add(Out);
		  Out.setIcon(new ImageIcon(ClassLoader.getSystemResource("logout_icon.png")));
		  
		  
		  BookingDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("booking.png")));		    
		  DriverDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("driver_icon.jpg")));	
          Logout.setIcon(new ImageIcon(ClassLoader.getSystemResource("logout_icon.png")));		  
          BillingDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("bill.png")));		  		  	  
		  //View.setIcon(new ImageIcon(ClassLoader.getSystemResource("view.png")));		  
		 
		  BookingDetails.add(BookDetails);
		  NewReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("book.jpg")));
		  
          mb.add(CustomerDetails);  
		  mb.add(VehicleRegistration);  
		  mb.add(BookingDetails);  
		  mb.add(DriverDetails);  
		  mb.add(BillingDetails);
          //mb.add(View);    		  
	      mb.add(Logout); 
		  
          f.setJMenuBar(mb);
          f.setLayout(null);  
          f.setVisible(true); 
		  f.setExtendedState(MAXIMIZED_BOTH);
		  
		  
           NewUser.addActionListener(this);
		   EditUser.addActionListener(this);
		   DeleteUser.addActionListener(this);
		   NewReg.addActionListener(this);
		   EditReg.addActionListener(this);
		   DeleteReg.addActionListener(this);
		   BookDetails.addActionListener(this);
		   DriveDetails.addActionListener(this);
		   Bill.addActionListener(this);
		   Out.addActionListener(this);
		   
		   
    }
    
	public void actionPerformed(ActionEvent e) 
	{
      try
	    {
            if (e.getSource() == NewUser) 
			{
                New_User frm = new New_User();
                //desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == EditUser) 
			{
                Edit_User frm = new Edit_User();
               // desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == DeleteUser) 
			{
                Delete_User frm = new Delete_User();
               // desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == NewReg) 
			{
                New_Register frm = new New_Register();
                //desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == EditReg) 
			{
                Edit_Register frm = new Edit_Register();
                //desktop.add(frm);
                frm.setVisible(true);

            }
           if (e.getSource() == DeleteReg) 
		   {
                Delete_Register frm = new Delete_Register();
                //desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == BookDetails) 
			{
                Booking frm = new  Booking();
               // desktop.add(frm);
                frm.setVisible(true);
				//break();
            }
            if (e.getSource() == DriveDetails) 
			{
                Driver frm = new Driver();
                //desktop.add(frm);
                frm.setVisible(true);
				//break();
            }
			if (e.getSource() == Bill)
			{
                Billing frm = new Billing();
                //desktop.add(frm);
                frm.setVisible(true);
				//break();
			}
			if (e.getSource() == Out)
			{    
                Logout frm = new Logout();
                //desktop.add(frm);
                frm.setVisible(true);
			
				//break();
			}
		}
            
		catch (Exception ex) 
	    {
            JOptionPane.showMessageDialog(new JFrame(), "Error, Cannot load window" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }//try catch closed
    }//actionPerformed() closed

  
public static void main(String args[])  
{  
  new MDI();
  	     
}
}  