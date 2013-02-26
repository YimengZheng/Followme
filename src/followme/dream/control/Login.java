package followme.dream.control;

import followme.dream.bean.*;
import followme.dream.model.UserDAOIm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
            
/**
 * Servlet implementation class UserControl
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");  
		
		System.out.println(username);
		System.out.println(password);
		UserDAOIm userIm=new UserDAOIm();  
		User user=null;
		user=userIm.findUserByNameAndPass(username, password);
		if(user!=null)  
		{  
			HttpSession session=request.getSession();
			session.setAttribute("user", user);    
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");    
			rd.forward(request, response);
		}    
		else{
			System.out.println("User doesn't exist!");
			JOptionPane.showMessageDialog(null,"Wrong username or password!");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);		
	}
  
}
