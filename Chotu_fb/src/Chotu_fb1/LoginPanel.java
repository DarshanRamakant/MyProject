package Chotu_fb1;

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
	JButton Login = new JButton("Login");
	JButton Signup = new JButton("Signup");
	JLabel Un = new JLabel("Rollno/Email :");
	JLabel Pw = new JLabel("Password     :");
	JTextField UnT=new JTextField(20);
	JPasswordField PwT=new JPasswordField(20);
	LoginPanel(){
				
				
				setLayout(new GridBagLayout());


				addComp(Un,1,1,1,1);
				addComp(UnT,1,3,2,1);
				addComp(Pw,2,1,1,1);
				addComp(PwT,2,3,2,1);
				addComp(Signup,3,1,1,1);
				addComp(Login,3,4,1,1);
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
		NewsFeed NF = new NewsFeed();
		if(ae.getSource()==Signup)
		{
			this.setVisible(false);
			FriendZone.friend.add(s);
			
		}
		if(ae.getSource()==Login){
			this.setVisible(false);
			//FriendZone.friend.removeNotify();
			FriendZone.friend.add(NF);
		
		}
	}
}
