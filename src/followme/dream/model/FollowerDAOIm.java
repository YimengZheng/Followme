package followme.dream.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import followme.dream.bean.User;

public class FollowerDAOIm implements FollowerDAO{
	
	private Connection conn=null;
	ResultSet rs;
	
	public FollowerDAOIm()
	 {	 
		 try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 conn = DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk:3306/yimengzheng", "YimengZheng", "ac31004");
			 
		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }

	@Override
	public List<User> findFollower(int userid) {
		// TODO Auto-generated method stub
		List<User> list =new ArrayList<User>();
		User user=new User();
		try
		   {
		    String sql="SELECT * from User where userID in (SELECT followerID from follower where follower.userID=?)";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    stmt.setInt(1, userid);
		    rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	user=new User();
		    	user.setUserID(rs.getInt(1));
		    	user.setUsername(rs.getString(2));
		    	user.setPassword(rs.getString(3));
		    	user.setGender(rs.getString(4));
		    	user.setBirthday(rs.getDate(5));
		    	user.setEmail(rs.getString(6));
		    	user.setHeadURL(rs.getString(7));
		    	user.setCity(rs.getString(8));
		    	user.setCountry(rs.getString(9));
		    	list.add(user);	  
		    }	    
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		return list;	
	}

	@Override
	public int countFollowerByuser(int userid) {
		// TODO Auto-generated method stub
        int n=0;
		
		try
		   {
			  String sql="SELECT COUNT(followerID) from Follower where userID=?";
			  PreparedStatement stmt=conn.prepareStatement(sql);
			  stmt.setInt(1, userid);
			  rs=stmt.executeQuery();
			  if(rs.next())
			     n=rs.getInt(1);
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		return n;
	}

}
