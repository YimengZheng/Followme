/*package followme.dream.model;
import java.sql.*;

public class JDBCCon{
	
	static Connection conn;
	static String conURL=null;
	public static Connection getConnection() throws SQLException
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conURL="jdbc:mysql://arlia.computing.dundee.ac.uk:3306/yimengzheng";
			Connection conn=DriverManager.getConnection(conURL, "YiMengZheng", "ac31004");
			System.out.println("connect successfully");
		
	    }catch(ClassNotFoundException e){
		e.printStackTrace();
	    }
	return  conn;
	}
}*/
