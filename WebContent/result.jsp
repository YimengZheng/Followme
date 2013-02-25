<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="head.jsp"  %>

<div id="left">
<h8>&nbsp;</h8>
<fieldset id="h_person" >
  <p><img src=<%=user.getHeadURL() %> width="100" height="100" />
  <%=user.getUsername() %></p>
   <%
    	int nc=0; int fl=0; int flr=0;
    	NewsDAOIm newDao=new NewsDAOIm();
    	nc=newDao.accountNewsBy(user.getUserID());	
  %>
  <p>News:<%=nc%>&nbsp;
  Following:<%=fl %>&nbsp; 
  Follower:<%=flr %></p>
</fieldset>
</div>

<div id="f_right">
<h8>&nbsp;</h8>
<p style="color:#2B7BA2; font-size:20px"><strong>&nbsp;&nbsp;&nbsp;Search:</strong></p>
<fieldset id="h_new" >
<ul>  
		<%  String f_search=(String)session.getAttribute("f_search");
        UserDAOIm userDao=new UserDAOIm();
    	List<User> friends=userDao.findFriendByName(f_search);
    	if(friends!=null)
    	{
    		for(int i=0; i<friends.size();i++)
    		{
    			String url=friends.get(i).getHeadURL();
    			if(url==null)
    				url="image/default_head.jpg";
    		%>
			<li >	
			    <form id="add_friends" action="follow" method="post">
				<p><img src=<%=url%> height="32px" width="32" />&nbsp;&nbsp;<%=friends.get(i).getUsername()%>
				<% session=request.getSession();
				   session.setAttribute("fid",friends.get(i).getUserID());%>
				<input type="submit" value="follow" style="color:#fff; background-color:#2B7BA2; font-size:12px; border-radius: 10px;" />
				</p>
				<p>Email:&nbsp;<%=friends.get(i).getEmail()%>&nbsp; &nbsp;
				City:&nbsp;<%=friends.get(i).getCity() %>&nbsp;&nbsp;&nbsp;Country:&nbsp;<%=friends.get(i).getCountry() %></p>
				
				</form>			
			</li>
			<%
			}
    	}
    %>
    </ul> 
</fieldset>
</div>

</body>
<% session.removeAttribute("f_search");%>
</html>