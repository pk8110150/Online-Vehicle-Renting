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

public class FrmCustomerMDI extends JFrame //implements ActionListener 
{
	  

     JMenuBar menubar;
	 JMenu mnuCustomerDetails;
     JMenu mnuVehicleRegistration;
     JMenu mnuBookingDetails;
     JMenu mnuDriverDetails;
	 JMenu mnuBilling;
	 JMenu mnuView;
     JMenu mnuFeedback;
     JMenu mnuLogout;

     JMenuItem mnuNewUser;
     JMenuItem mnuEditUser;
     JMenuItem mnuDeleteUser;
     JMenuItem mnuNewReg;
     JMenuItem mnuEditReg;
     JMenuItem mnuDeleteReg;
    
    public static JDesktopPane desktop;
    
	public FrmCustomerMDI() 
	{

        super("VEHICAL RENTING AND BOOKING");
      //this.setSize(Settings.getScreenSize().width, Settings.getScreenSize().height - 30);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setIconImage(new ImageIcon(ClassLoader.getSystemResource("images/appicon.png")).getImage());
       //setExtendedState(MAXIMIZED_BOTH);
        desktop = new JDesktopPane();
        
        mnuCustomerDetails = new JMenu("CUSTOMER DETAILS");
        mnuVehicleRegistration = new JMenu("VEHICLE REGISTRATION");
        mnuBookingDetails=new JMenu("BOOKING DETAILS");
        mnuDriverDetails = new JMenu("DRIVER DETAILS");
		mnuBilling = new JMenu("BILLING DETAILS");
		mnuView = new JMenu("VIEW");
		mnuFeedback=new JMenu("FEEDBACK");
        mnuLogout = new JMenu("LOGOUT");

        mnuNewUser = new JMenuItem("NEW REGISTRATION");
        mnuEditUser = new JMenuItem("EDIT REGISTRATION");
        mnuDeleteUser = new JMenuItem("DELETE REGISTRATION");
        mnuNewReg = new JMenuItem("NEW VEHICLE REGISTRATION");
        mnuEditReg = new JMenuItem("EDIT VEHICLE REGISTRATION");
        mnuDeleteReg = new JMenuItem("DELETE VEHICLE REGISTRAT");
        
		
		
		/*JFrame f= new JFrame("MENU");
	      menubar = new JMenuBar();
	      f.setJMenuBar(menubar);  
          f.setSize(400,400);  
          f.setLayout(null);
          f.setResizable(false);		  
          f.setVisible(true); */
 }
		mnuCustomerDetails.add(mnuNewUser);
        //mnuNewUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, KeyEvent.ALT_MASK));
        //mnuNewUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));
       
    	mnuCustomerDetails.add(mnuEditUser);
        //mnuEditUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.ALT_MASK));
        //mnuEditUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("edit_user.png")));
        
		mnuCustomerDetails.add(mnuDeleteUser);
       // mnuDeleteUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
        //mnuDeleteUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("del_user.png")));
		
		//mnuCustomerDetails.addSeparator();
        
		mnuVehicleRegistration.add(mnuNewReg);
        //mnuNewReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        mnuNewReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_vehicle.jpg")));
        
		mnuVehicleRegistration.add(mnuEditReg);
        //mnuEditReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
        //mnuEditReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("edit_vehicle.png")));
        
		mnuVehicleRegistration.add(mnuDeleteReg);
        //mnuDeleteReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
        //mnuDeleteReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("del_vehicle.png")));
        
		mnuVehicleRegistration.addSeparator();
        
        menubar.add(mnuCustomerDetails);
        menubar.add(mnuVehicleRegistration);
        menubar.add(mnuBookingDetails);
		//mnuBookingDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));
        menubar.add(mnuDriverDetails);
		//mnuDriverDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));
        menubar.add(mnuBilling);
		//mnuBilling.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));
		menubar.add(mnuView);
		//mnuView.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));
		menubar.add(mnuFeedback);
		//mnuFeedback.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));
		menubar.add(mnuLogout);
		//mnuLogout.setIcon(new ImageIcon(ClassLoader.getSystemResource("add_user.png")));
        
		/*mnuNewUser.addActionListener(this);
        mnuEditUser.addActionListener(this);
        mnuDeleteUser.addActionListener(this);
        mnuNewReg.addActionListener(this);
        mnuEditReg.addActionListener(this);
        mnuDelDetails.addActionListener(this);
        mnuEditMark.addActionListener(this);
        mnuMarkList.addActionListener(this);
        mnuMemList.addActionListener(this);
        mnuViewStdDetails.addActionListener(this);
        mnuAddSubs.addActionListener(this);
        mnuEditSubs.addActionListener(this);
        mnuDelSubs.addActionListener(this);
        mnuSubAlloc.addActionListener(this);
        mnuCalc.addActionListener(this);        
        mnuNotepad.addActionListener(this);*/
        this.setJMenuBar(menubar);
        this.add(desktop);
    }
	
public static void main(String args[])
 {
 new FrmCustomerMDI();
}