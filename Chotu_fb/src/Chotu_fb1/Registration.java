package Chotu_fb1;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.*;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;

import model.Connection.ConnectionPool;
import model.model.*;

public class Registration extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1724376660958829603L;
	GridBagConstraints gc = new GridBagConstraints();
	int returnVal;
	private CourseController courseController;
	public CourseController getCourseController() {
		return courseController;
	}
	public void setCourseController(CourseController courseController) {
		this.courseController = courseController;
	}
	private InterestController interestController;
	public InterestController getInterestController() {
		return interestController;
	}
	public void setInterestController(InterestController interestController) {
		this.interestController = interestController;
	}
	private UserController userController;
	
	JLabel RN = new       JLabel("Roll No.");
	JLabel UN = new       JLabel("User Name");
	JLabel Eid = new      JLabel("Email Id ");
	JLabel Pwd = new      JLabel("Password");
	JLabel CnfPwd = new   JLabel("Confirm Password");
	JLabel ProPic = new   JLabel("Profile pic");
	JLabel Pic = new JLabel();
	JFileChooser ProPicChooser = new JFileChooser(); 
	JLabel Gen= new       JLabel("Gender");
	JLabel Courses = new   JLabel("Course");
	//String[] items={"","IT","ESD"};
	//JComboBox<String>scourse=new JComboBox<String>();
	JComboBox<String>scourse;
	JLabel Inte= new      JLabel("Interest");
	//String[] listdata={"Coding","Dancing","Sports","Drawing"};
	//JList<String> sinterests = new JList<String>(listdata);
	JList<String> sinterests;
	JLabel PhNo = new JLabel("Phone No.");
	JTextField RNT = new JTextField(20);
	JTextField UNT = new JTextField(20);
	JTextField EidT = new JTextField(20);
	JTextField PhNoT = new JTextField(20);
	JButton Browse = new JButton("Browse");
	JButton Submit =new JButton("Submit");
	JPasswordField PwdT=new JPasswordField(20);
	JPasswordField CnfPwdT=new JPasswordField(20);
	JRadioButton male = new JRadioButton("Male");
	JRadioButton female = new JRadioButton("Female");
	ButtonGroup bg = new ButtonGroup();
	File file = new File("images/DefaultUser.jpg");
	BufferedImage image =null;
    Image bimage=null;
	Registration(){
		
		ConnectionPool.createConnection();
		this.courseController = new CourseController();
		this.interestController = new InterestController();
		this.userController = new UserController();
		//scourse.
		List<Course> courses = this.getCourseController().listCourses();
		
		String[] items = new String[courses.size()+1];
		items[0] = "         --Select Course--";
		for(Course c : courses)
		{
			items[c.getCourseId()] = c.getCourseDesc();
		}
		
		scourse =new JComboBox<String>(items);
		
		List<Interest> interests = this.getInterestController().listInterests();
		
		items = new String[interests.size()+1];
		//items[0] = "--Select Interests--";
		for(Interest c : interests)
		{
			items[c.getInterestId()-1] = c.getInterstDesc();
		}
		
		//scourse =new JComboBox<String>(items);
		sinterests = new JList<String>(items);
		
	
		try
	        {
	          image = ImageIO.read(file);
	          bimage=image.getScaledInstance(100, 100, 0);
	        }
	        catch (Exception e)
	        {
	          e.printStackTrace();
	          System.exit(1);
	        }
		ImageIcon i=new ImageIcon(bimage);
		//changed the code hear
	this.setLayout(new GridBagLayout());
	addComp(Pic,0,1,2,1);
	//gc.gridx=0;
	//gc.gridy=2;
	//gc.gridwidth=1;
	//gc.gridheight=1;
	Pic.setIcon(i);
	//add(Pic,BorderLayout.CENTER);
	addComp(RN,1,0,1,1);
		addComp(new JLabel(":"),1,1,1,1);
			addComp(RNT,1,2,2,1);
	addComp(UN,2,0,1,1);
		addComp(new JLabel(":"),2,1,1,1);
			addComp(UNT,2,2,2,1);
	addComp(Eid,3,0,1,1);
		addComp(new JLabel(":"),3,1,1,1);
			addComp(EidT,3,2,2,1);
	addComp(Pwd,4,0,1,1);
		addComp(new JLabel(":"),4,1,1,1);
			addComp(PwdT,4,2,2,1);
	addComp(CnfPwd,5,0,1,1);
		addComp(new JLabel(":"),5,1,1,1);
			addComp(CnfPwdT,5,2,2,1);
	addComp(Gen,6,0,1,1);
		addComp(new JLabel(":"),6,1,1,1);
		bg.add(male);
		bg.add(female);
			addComp(male,6,2,1,1);
			addComp(female,7,2,1,1);
	addComp(Courses,8,0,1,1);
		addComp(new JLabel(":"),8,1,1,1);
			addComp(scourse,8,2,2,1);
	addComp(Inte,9,0,1,1);
		addComp(new JLabel(":"),9,1,1,1);
			addComp(sinterests,9,2,2,1);
	addComp(PhNo,10,0,1,1);
		addComp(new JLabel(":"),10,1,1,1);
			addComp(PhNoT,10,2,2,1);
	addComp(ProPic,11,0,1,1);
		addComp(new JLabel(":"),11,1,1,1);
			addComp(Browse,11,2,2,1);
			//addComp(new JLabel(""),12,2,2,2);
			addComp(Submit,12,1,2,1);
			
			//Pic.setHorizontalAlignment(34);
			
	Browse.addActionListener(this);	
	Submit.addActionListener(this);			
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{

		
		if(ae.getSource()==Browse)
		{
			//System.out.println("hello");
			//addComp(ProPicChooser, 12, 2, 1, 1);
			//this.revalidate();
			//this.repaint();
			returnVal=ProPicChooser.showOpenDialog(null);
			if(returnVal==JFileChooser.APPROVE_OPTION){
				file = ProPicChooser.getSelectedFile();
				// testing code
				//ImageIcon i=new ImageIcon(file.getPath());
				//addComp(Pic,0,2,1,1);
				
				//Pic.setIcon(i);
				try
		        {
		          image = ImageIO.read(file);
		          bimage=image.getScaledInstance(100, 100, 0);
		        }
		        catch (Exception e)
		        {
		          e.printStackTrace();
		          System.exit(1);
		        }
			ImageIcon i=new ImageIcon(bimage);
			addComp(Pic,0,1,2,1);
			
			Pic.setIcon(i);
			}
			Pic.revalidate();
			Pic.repaint();
			
		}else if(ae.getSource()==Submit)
		{
			Login l = new Login();
			User u = new User();
			
			l.setEMAILID( EidT.getText());
			l.setPASSWORD(PwdT.getText());
			// Problem can occur
			
			
			
			l.setROLL_NO(RNT.getText());			 
			String G = null;
			if(male.isSelected()){
				G="M";
			}
			else if(female.isSelected()){
				G="F";
			}
			u.setGENDER(G);
			Course c = new Course();
			c.setCourseId(scourse.getSelectedIndex());
			c.setCourseDesc(scourse.getSelectedItem().toString());
			u.setCourse(c);
			u.setPHONE_NO(PhNoT.getText());
			u.setUSER_NAME(UNT.getText());
			
			
			List<Interest> l1 = new ArrayList<Interest>(); 
			int[] si = sinterests.getSelectedIndices();
			Object[] st = sinterests.getSelectedValues();
			
			for(int i =0;i<st.length;i++){
				Interest inter = new Interest();
				inter.setInterestId(si[i]+1);
				inter.setInterstDesc((String)st[i]);
				l1.add(inter);
			}
			
			
			//i.setInterestId(sinterests.getSelectedIndex()+1);

			u.setUserInterests(l1);
			u.setPROFILE_PIC(null);
		
			this.getUserController().registration(l, u);
			
			
			 
			 
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
	public UserController getUserController() {
		return userController;
	}
	public void setUserController(UserController userController) {
		this.userController = userController;
	}
	
	//}

}
