package followme.dream.control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
				RequestDispatcher rd=request.getRequestDispatcher("/news");
			    rd.forward(request, response); 
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Post failed","user exists", 0);
			response.sendRedirect("./");	  
		}
	}

}
