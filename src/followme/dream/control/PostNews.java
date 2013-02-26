package followme.dream.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import followme.dream.bean.User;
import followme.dream.model.*;

@WebServlet("/news")
public class PostNews extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NewsDAOIm newsDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String content=(String) request.getParameter("new_message");	
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		
		newsDao= new NewsDAOIm();
		
		if(newsDao.addNews(content, user.getUserID()))
		{				
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			    rd.forward(request, response); 
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Post failed","Post failed", 0);
			response.sendRedirect("./");	  
		}
	}

}
