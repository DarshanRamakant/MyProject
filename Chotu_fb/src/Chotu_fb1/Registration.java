package Chotu_fb1;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class Registration extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1724376660958829603L;
	GridBagConstraints gc = new GridBagConstraints();
	JLabel RN = new       JLabel("Roll No.");
	JLabel UN = new       JLabel("User Name");
	JLabel Eid = new      JLabel("Email Id ");
	JLabel Pwd = new      JLabel("Password");
	JLabel CnfPwd = new   JLabel("Confirm Password");
	JLabel ProPic = new   JLabel("Profile pic");
	JFileChooser ProPicChooser = new JFileChooser(); 
	JLabel Gen= new       JLabel("Gender");
	JLabel Course = new   JLabel("Course");
	JLabel Inte= new      JLabel("Interest");
	JLabel PhNo = new JLabel("Phone No.");
	JTextField RNT = new JTextField(20);
	JTextField UNT = new JTextField(20);
	JTextField EidT = new JTextField(20);
	JTextField PhNoT = new JTextField(20);
	JButton Browse = new JButton("Browse");
	JPasswordField PwdT=new JPasswordField(20);
	JPasswordField CnfPwdT=new JPasswordField(20);
	JRadioButton male = new JRadioButton("Male");
	JRadioButton female = new JRadioButton("Female");
	ButtonGroup bg = new ButtonGroup();
	
	Registration(){
	this.setLayout(new GridBagLayout());
	addComp(RN,1,0,1,1);
		addComp(new JLabel(":"),1,1,1,1);
			addComp(RNT,1,2,1,1);
	addComp(UN,2,0,1,1);
		addComp(new JLabel(":"),2,1,1,1);
			addComp(UNT,2,2,1,1);
	addComp(Eid,3,0,1,1);
		addComp(new JLabel(":"),3,1,1,1);
			addComp(EidT,3,2,1,1);
	addComp(Pwd,4,0,1,1);
		addComp(new JLabel(":"),4,1,1,1);
			addComp(PwdT,4,2,1,1);
	addComp(CnfPwd,5,0,1,1);
		addComp(new JLabel(":"),5,1,1,1);
			addComp(CnfPwdT,5,2,1,1);
	addComp(Gen,6,0,1,1);
		addComp(new JLabel(":"),6,1,1,1);
		bg.add(male);
		bg.add(female);
			addComp(male,6,2,1,1);
			addComp(female,7,2,1,1);
	addComp(Course,8,0,1,1);
		addComp(new JLabel(":"),8,1,1,1);
	
	addComp(Inte,9,0,1,1);
		addComp(new JLabel(":"),9,1,1,1);
	
	addComp(PhNo,10,0,1,1);
		addComp(new JLabel(":"),10,1,1,1);
			addComp(PhNoT,10,2,1,1);
	addComp(ProPic,11,0,1,1);
		addComp(new JLabel(":"),11,1,1,1);
			addComp(Browse,11,2,1,1);
	Browse.addActionListener(this);	
				
	}
	public void actionPerformed(ActionEvent ae)
	{

		
		if(ae.getSource()==Browse)
		{
			//System.out.println("hello");
			addComp(ProPicChooser, 12, 2, 1, 1);
			this.revalidate();
			this.repaint();
		}
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
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

}
