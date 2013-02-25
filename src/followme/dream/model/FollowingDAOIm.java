package followme.dream.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import followme.dream.bean.User;

public class FollowingDAOIm implements FollowingDAO{
	
	private Connection conn=null;
	ResultSet rs;
	
	public FollowingDAOIm()
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
	public List<User> findFollowing(int userid) {
		List<User> list =new ArrayList<User>();
		User user=new User();
		try
		   {
		    String sql="SELECT * from User where userID in (SELECT followingID from following where following.userID=?)"; 
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
	public void deleteFollowing(int userid, int followingid) {
		// TODO Auto-generated method stub
		try
		   {
		    String sql="DELETE * from following where userID=? and followingID=?";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    stmt.setInt(1, userid);
		    stmt.setInt(2, followingid);
		    stmt.executeQuery();
		    
		    String sql1="DELETE * from follower where followerID=? and userID=?";
		    PreparedStatement stmt1=conn.prepareStatement(sql1);
		    stmt1.setInt(1, userid);
		    stmt1.setInt(2, followingid);
		    stmt1.executeUpdate();
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		
	}

	@Override
	public void addFollowing(int userid, int followingid) {
		// TODO Auto-generated method stub
		try
		   {
		    String sql="INSERT INTO following VALUES(?,?)";
		    PreparedStatement stmt=conn.prepareStatement(sql);
		    stmt.setInt(1, userid);
		    stmt.setInt(2, followingid);
		    stmt.executeUpdate();
		    
		    String sql1="INSERT INTO follower VALUES(?,?)";
		    PreparedStatement stmt1=conn.prepareStatement(sql1);
		    stmt1.setInt(1, userid);
		    stmt1.setInt(2, followingid);
		    stmt1.executeUpdate();
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
	}
  
	@Override
	public int countFollowingByUser(int userid) {
		// TODO Auto-generated method stub
        int n=0;		
		try
		   {
			  String sql="SELECT COUNT(followingID) from Following where userID=?";
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
