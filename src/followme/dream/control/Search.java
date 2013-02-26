package followme.dream.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/search")
public class Search extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String friend=(String)request.getParameter("friend"); 
		System.out.println("here");
		HttpSession session=request.getSession();
		session.setAttribute("f_search", friend);   
			RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
	}

}
