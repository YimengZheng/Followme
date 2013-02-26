package followme.dream.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import followme.dream.bean.User;
import followme.dream.model.UserDAO;
import followme.dream.model.UserDAOIm;
 

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDao;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		userDao=new UserDAOIm();
		User user=null;
		user=userDao.findUserByName(username);
		if(user==null){
			user=new User(username, email, password);
			if(userDao.addUser(username, email, password))
			{
				JOptionPane.showMessageDialog(null, "Welcome to FollowMe! please log in","welcome", 0);
				RequestDispatcher rd=request.getRequestDispatcher("./");
			    rd.forward(request, response); 
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Username exists","user exists", 0);
			response.sendRedirect("./");	
		}
	}
	
}
