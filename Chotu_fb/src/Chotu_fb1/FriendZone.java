package Chotu_fb1;


import javax.swing.JFrame;

import model.Connection.ConnectionPool;

public class FriendZone extends JFrame{

	static FriendZone friend;	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4994229467377926139L;
	
	FriendZone()
	{
		ConnectionPool.createConnection();
		this.setTitle("FriendZone");
		LoginPanel LP1 = new LoginPanel();
		add(LP1);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public  FriendZone getInstance(){
		
		return this;
	}
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	friend = new FriendZone();
	friend.setSize(1000,750);
	}
}
