package Chotu_fb1;
import model.model.*;
import controller.*;

//import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JButton;
import javax.swing.*;
public class LoginPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5411663284975460080L;
	GridBagConstraints gc = new GridBagConstraints();
	//JPanel LP1 = new JPanel();
	private LoginController loginController;
	private UserController userController;
	JButton Login = new JButton("Login");
	JButton Signup = new JButton("Signup");
	JLabel Un = new JLabel("Rollno/Email :");
	JLabel Pw = new JLabel("Password     :");
	JTextField UnT=new JTextField(20);
	JLabel lf = new JLabel("Login Failed");
	JPasswordField PwT=new JPasswordField(20);
	LoginPanel(){
				
				this.loginController = new LoginController();
				this.userController = new UserController();
				setLayout(new GridBagLayout());


				addComp(Un,2,1,1,1);
				addComp(UnT,2,3,2,1);
				addComp(Pw,3,1,1,1);
				addComp(PwT,3,3,2,1);
				addComp(Signup,4,1,1,1);
				addComp(Login,4,4,1,1);
				Login.addActionListener(this);	
				Signup.addActionListener(this);
		}
	
	public void addComp(Component cc,int r,int c,int w,int h)
	{	
		gc.gridx=c;
		gc.gridy=r;
		gc.gridwidth=w;
		gc.gridheight=h;
		gc.fill=GridBagConstraints.BOTH;
		gc.insets=new Insets(5,5,5,5);
		add(cc,gc);
	}
	public void actionPerformed(ActionEvent ae)
	{

		Registration s= new Registration();
		
		if(ae.getSource()==Signup)
		{
			this.setVisible(false);
			FriendZone.friend.add(s);
			
		}
		if(ae.getSource()==Login){
			this.setVisible(false);
			//FriendZone.friend.removeNotify();
			Login l = new Login();
			l.setEMAILID(UnT.getText());
			l.setROLL_NO(UnT.getText());
			l.setPASSWORD(PwT.getText());
			try{
					User u = this.getLoginController().login(l);		
					u = this.getUserController().getUserPostContent(u);
					NewsFeed NF = new NewsFeed(u);
					FriendZone.friend.add(NF);
			
			}catch(Exception e)
			{
				this.setVisible(true);
				
				JOptionPane j = new JOptionPane();
				j.showMessageDialog(this, "Login Failed");
				UnT.setText("");
				PwT.setText("");
				

				//addComp(lf,5,3,2,1);
				System.out.println("Login Failed");
			}
		}
	}
	public LoginController getLoginController() {
		return loginController;
	}
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}
}
