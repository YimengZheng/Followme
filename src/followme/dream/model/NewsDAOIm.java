package followme.dream.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import followme.dream.bean.News;

public class NewsDAOIm implements NewsDAO{
	
	 private Connection conn=null;
	 ResultSet rs;

	public NewsDAOIm() {
		// TODO Auto-generated constructor stub
		try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			 conn = DriverManager.getConnection("jdbc:mysql://arlia.computing.dundee.ac.uk:3306/yimengzheng", "YimengZheng", "ac31004");
			 
		 } catch (Exception e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	}

	@Override
	public News findNewsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<News> getAllNews(int id) {
		// TODO Auto-generated method stub 
			List<News> list=new ArrayList<News>();
			News news=new News();
			try
			{		
				String sql="SELECT * from News where News.userID IN (SELECT followingID from Following where Following.userID=?) UNION (SELECT * from News where News.userID=?)";
				PreparedStatement stmt=conn.prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.setInt(2, id);
				rs=stmt.executeQuery();
				while(rs.next())  
				{
					news=new News();
					news.setNewsID(rs.getInt(1));
					news.setContent(rs.getString(2));
					news.setHeadURL(rs.getString(3));
					news.setUsername(rs.getString(4));
					news.setPostdate(rs.getDate(5));
					news.setUserID(rs.getInt(6));
					news.setBaseID(rs.getInt(7));		
					list.add(news);				
				}
			}
			catch(SQLException e)
			{
			    e.printStackTrace();
			}
			return list;
		}

	@Override
	public List<News> getNewsByUser(int id)  {
		// TODO Auto-generated method stub
		List<News> list=new ArrayList<News>();
		News news=new News();
		try
		{		
			String sql="SELECT * from News where userID=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				news=new News();
				news.setNewsID(rs.getInt(1));
				news.setContent(rs.getString(2));
				news.setHeadURL(rs.getString(3));
				news.setUsername(rs.getString(4));
				news.setPostdate(rs.getDate(5));
				news.setUserID(rs.getInt(6));
				news.setBaseID(rs.getInt(7));		
				list.add(news);			
			}
		}
		catch(SQLException e)  
		{
		    e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addNews(String content,int userid) {
		long time = System.currentTimeMillis(); 
		String username=null;
		String headURL = null;
		boolean b=true;
		// TODO Auto-generated method stub
		  try
		   {
			  String sql="SELECT username, headURL from User where userID=?";
			  PreparedStatement stmt=conn.prepareStatement(sql);
			  stmt.setInt(1, userid);
			  rs=stmt.executeQuery();
			  if(rs.next())
			  {
				  username=rs.getString(1);
				  headURL=rs.getString(2);	 
			   
				  sql="INSERT INTO News(content,headURL,username,postdate,userID) VALUES(?,?,?,?,?)";
				  stmt=conn.prepareStatement(sql);
				  stmt.setString(1, content);
				  stmt.setString(2, headURL);
				  stmt.setString(3, username);
				  stmt.setTimestamp(4, new Timestamp(time));
			      stmt.setInt(5, userid);    
			      stmt.executeUpdate();  
			  }
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		  return b;		
	}

	@Override
	public void removeNewsById(int msgid) {
		// TODO Auto-generated method stub
		 try
		   {
			  String sql="DELETE * from News where newID=?";
			  PreparedStatement stmt=conn.prepareStatement(sql);
			  stmt.setInt(1, msgid);
			  stmt.executeQuery();
		   }
		   catch(SQLException e)
		   {
		    e.printStackTrace();
		   }
		
	}

	@Override
	public int accountNewsBy(int userid) {
		// TODO Auto-generated method stub
		int n=0;
		
		try
		   {
			  String sql="SELECT COUNT(newID) from News where userID=?";
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
