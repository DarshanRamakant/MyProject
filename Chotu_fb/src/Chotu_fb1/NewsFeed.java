package Chotu_fb1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Dimension;



public class NewsFeed extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3157868702323870441L;
	GridBagConstraints gc;
    private JPanel content;
    JPanel panel1,panel3,panel4,panel5;
    JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10;
    JTabbedPane jtp;
    private JTabbedPane tabbedPane;
    private JPanel header;
    private JPanel panel,panel2;
    PreparedStatement ps1;

    
   
	public NewsFeed()
	{
		 
		//super("IIITB Social Network..");
		gc= new GridBagConstraints();
		
		
	        GridBagLayout grid = new GridBagLayout();
	        setLayout(grid);
	       // setResizable(false);

	        GridBagLayout gbl_header = new GridBagLayout();
	        header = new JPanel();
	        header.setLayout(gbl_header);
	       
	        header.setBackground(Color.lightGray);
	        // <=== add with constraints here
	        add(header, new GridBagConstraints(0, 0, 1, 1, 20, 1, GridBagConstraints.BASELINE, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	        //getContentPane().add(_header, new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady));
	        
	        content = new JPanel();
	        content.setSize(new Dimension(475, 700));
	        content.setPreferredSize(new Dimension(475, 700));
	        content.setBackground(Color.blue );
	        content.setLayout(new BorderLayout());
	        add(content, new GridBagConstraints(1, 0, 1, 1, 80, 1, GridBagConstraints.BASELINE, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	        
	        panel = new JPanel();
	        panel.setLayout( new BorderLayout() );

	        panel2 = new JPanel();
	        panel2.setAutoscrolls(true);
	        panel2.setLayout( new GridBagLayout() );	
	        
	        JScrollPane scrollPanel = new JScrollPane();
	        scrollPanel.setViewportView(panel2);
	        
	        panel1 = new JPanel();
	        panel1.setLayout( new BorderLayout() );

	        panel3 = new JPanel();
	        panel3.setAutoscrolls(true);
	        panel3.setLayout( new GridBagLayout() );	
	        
	        JScrollPane scrollPanel1 = new JScrollPane();
	        scrollPanel1.setViewportView(panel3);
	        
	        panel4 = new JPanel();
	        panel4.setLayout( new BorderLayout() );

	        panel5 = new JPanel();
	        panel5.setAutoscrolls(true);
	        panel5.setLayout( new GridBagLayout() );	
	        
	        JScrollPane scrollPanel2 = new JScrollPane();
	        scrollPanel2.setViewportView(panel5);
	        
	        
	        JLabel l1= new JLabel(" ");
	        addComponent(1,1, 3, 3, l1);
	        
	        JTextArea post = new JTextArea(5,36);
	        addComponent(4, 1, 3, 3, post);
	        
	        JLabel l2= new JLabel(" ");
	        addComponent(7,1, 3, 3, l2);
	        
	        JButton postbutton = new JButton("Post...");
	        addComponent(10, 1, 3, 3, postbutton);
	       /* try {
	        ps1 = ConnectionPool.getConnection().prepareStatement("select * from Posts where roll_number='17'");
			ResultSet rs=ps1.executeQuery();
				int i= 0;
			while(rs.next())
			{	i++;
				JLabel l_i= new JLabel(rs.getString(1)+" "+ rs.getString(2));
		        addComponent(13+6*i,1, 1, 3, l_i);
		        //java.sql.Timestamp  timestamp = rs.getTimestamp(4);
		        System.out.println(rs.getTimestamp(4));
		        JLabel l_ii= new JLabel(rs.getTimestamp(4).toString());
		        addComponent(13+6*i,3, 1, 3, l_ii);
	        	
		        JTextArea post_i = new JTextArea(3,36);
		        post_i.setText(rs.getString(3));
		        addComponent(16+(6*i),1, 3, 3, post_i);
			}
	        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	        }
	        */
	        
	        
	        
	        scrollPanel.setPreferredSize(new Dimension(475,700));
	        panel.add(scrollPanel,BorderLayout.CENTER);
	        tabbedPane = new JTabbedPane();
	        tabbedPane.setBounds(0, 0, 475, 700);
	        content.add(tabbedPane, BorderLayout.CENTER);
	        tabbedPane.addTab( "News Feed", panel );
	        
	        scrollPanel1.setPreferredSize(new Dimension(475,700));
	        panel1.add(scrollPanel1,BorderLayout.CENTER);
	        tabbedPane.addTab( "Search Friend", panel1 );
	       
	        scrollPanel2.setPreferredSize(new Dimension(475,700));
	        panel4.add(scrollPanel2,BorderLayout.CENTER);
	        tabbedPane.addTab( "View Friend", panel4 );
	       
	       /*tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex()==2){
					PreparedStatement ps1;
					try {
						ps1 = ConnectionPool.getConnection().prepareStatement("select friends from post where roll_number='17'");
						ResultSet rs=ps1.executeQuery();
							int i= 0;
						while(rs.next())
						{	i++;
							JLabel jl1= new JLabel(rs.getString(1));
							addComponent1(1+3*i, 1, 3, 3, jl1);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
				
			}
		});*/
	         
	         
	        
	 
	        JTextArea jta = new JTextArea(5,10);
	        header.add(jta, new GridBagConstraints(1,1,5,3,0,0,GridBagConstraints.NORTH, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	
	        
	        j1 =new JLabel("Roll Number : ");
	        header.add(j1, new GridBagConstraints(1,5,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	       // jb.setSize(100, 200);        

	        j2 =new JLabel("mt2015033 ");
	        header.add(j2, new GridBagConstraints(3,5,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	       // jb.setSize(100, 200);        

	        j3 =new JLabel("Full Name : ");
	        header.add(j3, new GridBagConstraints(1,8,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	       // jb.setSize(100, 200);        

	        j4 =new JLabel("Avinash Kumar");
	        header.add(j4, new GridBagConstraints(3,8,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	 
	       
	        j5 =new JLabel("Email : ");
	        header.add(j5, new GridBagConstraints(1,11,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	       // jb.setSize(100, 200);        

	        j6 =new JLabel("avinash0234@gmail.com");
	        header.add(j6, new GridBagConstraints(3,11,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	 
	        
	        j7 =new JLabel("Gender : ");
	        header.add(j7, new GridBagConstraints(1,14,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	       // jb.setSize(100, 200);        

	        j8 =new JLabel("Male");
	        header.add(j8, new GridBagConstraints(3,14,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7,7), 0, 0));	 
	        
	        j9 =new JLabel("Phone : ");
	        header.add(j9, new GridBagConstraints(1,17,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	       // jb.setSize(100, 200);        

	        j10 =new JLabel("1234566789");
	        header.add(j10, new GridBagConstraints(3,17,2,3,0,0,GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, new Insets(0, 0, 7, 7), 0, 0));	 
	          
	        JButton jb = new JButton("Logout");
	        header.add(jb, new GridBagConstraints(3,20,2,3,0,0,GridBagConstraints.BASELINE, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));	       // jb.setSize(100, 200);        
	               
	        //pack();
	        validate();
	
	        
	    //setLocationRelativeTo(null);
	    setSize(700,700);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	}
	
	
	public void addComponent(int r,int c,int w,int h,Component cc)
	{
		gc.gridx=c;
		gc.gridy=r;
		gc.gridheight=h;
		gc.gridwidth=w;
		panel2.add(cc,gc);
	}
	
	public void addComponent1(int r,int c,int w,int h,Component cc)
	{
		gc.gridx=c;
		gc.gridy=r;
		gc.gridheight=h;
		gc.gridwidth=w;
		panel5.add(cc,gc);
	}
	
	
	
	//public static void main(String a[])
	//{
	//new NewsFeed();
	
	//}
}

