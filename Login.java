import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{ 
  
  JLabel name,background;
  JTextField username;
  JPasswordField password;
  JButton signin,cancel;
  JPanel heading,L;
  Font F;
  ImageIcon background_img;
  Image img,temp_img;
  public Login()
  {
   //font
   F=new Font("Serif",Font.BOLD,50);
   
   //header
   heading=new JPanel();
   heading.setBackground(new Color(0,0,0,80));
   heading.setBounds(0,0,900,100);
   name=new JLabel("LOGIN");
   name.setForeground(Color.WHITE);
   name.setBounds(200,25,400,50);
   name.setFont(F);
   heading.add(name);
   
   //Login Panel
   L=new JPanel();
   L.setLayout(null);
   L.setSize(400,350);
   L.setBounds(250,175,400,350);
   L.setBackground(new Color(0,0,0,90));
   
   username=new JTextField("admin");
   username.setBounds(50,50,300,50);
   username.setOpaque(false);
   username.setForeground(Color.WHITE);
   username.setBackground(new Color(210,180,140));
   L.add(username);
   
   password=new JPasswordField("ap");
   password.setBounds(50,150,300,50);
   password.setOpaque(false);
   password.setForeground(Color.WHITE);
   password.setBackground(new Color(210,180,140));
   L.add(password);
   
   signin=new JButton("SIGN IN");
   signin.setBounds(50,250,100,50);
   signin.setBackground(new Color(160,182,45));
   L.add(signin);
   
   cancel=new JButton("CANCEL");
   cancel.setBounds(250,250,100,50);
   cancel.setBackground(new Color(160,182,45));
   L.add(cancel);
   
   
   
   
   setLayout(null);
   
   //background
   background_img=new ImageIcon("Car.png"); 
   
   img=background_img.getImage();
   temp_img=img.getScaledInstance(900,600,img.SCALE_SMOOTH);
   background_img=new ImageIcon(temp_img);
   background=new JLabel("",background_img,JLabel.CENTER);
   
   background.add(L);
   background.add(heading);
   background.setBounds(0,0,900,600);
   add(background);

  signin.addActionListener(this);
  cancel.addActionListener(this);
}  

public void actionPerformed(ActionEvent e)
                   {
                                if (e.getSource() == signin)
                                    {
                                       
                                             try 
                                                  {
                                                           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                                           Connection con = DriverManager.getConnection("jdbc:odbc:VR");
                                                            try                                      
                                                                  {
                                                                        Statement st = con.createStatement();
                                                                        ResultSet rs = st.executeQuery("SELECT * FROM Login WHERE USER_NAME='" + username.getText() +
                                                                         "' and PASSWORD='" + password.getText() + "'");
                                                                             if (rs.next()) 
                                                                              {
                                                                                       if (rs.getString(3).equals("Admin")) 
                                                                                          {
                                                                                              MDI form = new MDI();
                                                                                              form.setVisible(true);
                                                                                           } 
                                                                                         /*else 
                                                                                          {                            
                                                                                               new MDI().setVisible(true);
                                                                                           }*/
                                                                                          this.dispose();
                                                                                 }
                                                                              else
                                                                                 {
                                                                                    JOptionPane.showMessageDialog(null,"Invalid username or password","Invalid",JOptionPane.ERROR_MESSAGE);
                                                                                  }
                                                                            con.close();
                    
                                                                       }//close try block1
                                         catch (Exception ex)
                                         {
                                            JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid", JOptionPane.ERROR_MESSAGE);
                                             username.setText("");
                                             password.setText("");
                                         }//inner try catch closed
                              } //close try block2
catch (Exception x) 
           {
                JOptionPane.showMessageDialog(null, "Unable to connect to the database", "Connection error", JOptionPane.ERROR_MESSAGE);
            }
//outer try catch closed
     }   //if closed

        if (e.getSource() == cancel)
          {
            System.exit(0);
         }//if closed
    }//actionPerformed() closed
  
  public static void main(String args[])
  { 
    Login L=new Login();
    L.setSize(900,600);
    L.setVisible(true);
    L.setResizable(false);
    L.setLocation(150,100);
	L.setUndecorated(true);
	//L.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    L.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}


