<%@include file="head.jsp"  %>

<div id="left">
<h8>&nbsp;</h8>

<fieldset id="h_person" >
  <p style="color:#2B7BA2;"><img src=<%=user.getHeadURL() %> width="120" height="120" /><%=user.getUsername() %>
  </p>
  
  <%   	int nc=0; int fl=0; int flr=0;
    	
    	NewsDAOIm newDao=new NewsDAOIm();
    	FollowingDAOIm foll=new FollowingDAOIm();
    	FollowerDAOIm foller=new FollowerDAOIm();
    	
    	nc=newDao.accountNewsBy(user.getUserID());	
    	fl=foll.countFollowingByUser(user.getUserID());
    	flr=foller.countFollowerByuser(user.getUserID());   	
  %>
  <p>News:<%=nc%>&nbsp;
  Following:<%=fl %>&nbsp; 
  Follower:<%=flr %></p>
</fieldset>
</div>

<div id="right_up">
<h8>&nbsp;</h8>
<fieldset id="h_post" >
  <form id="new_post" action="news" method="post" >
    <textarea name="new_message" id="new_message" cols="56" rows="6"></textarea>
    <p align="right" style="font-size:5px;">
    <input type="submit" name="n_post" value="post" style="background:#2B7BA2; color:#FFF; font-size:18px;" />
    </p>
  </form>
</fieldset>
</div>

<div id="right_down">
<p style="font-size:5px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:18px"><strong>&nbsp;&nbsp;&nbsp;NEWS</strong></p>
<fieldset id="h_new" > 
   <ul>   
    <%
    	List<News> news=newDao.getAllNews(user.getUserID());
    	if(news!=null)
    	{
    		for(int i=0; i<news.size();i++)
    		{
    			String url=news.get(i).getHeadURL();
    			if(url==null)
    				url="image/default_head.jpg";
    		%>
			<li >		
				<img src=<%=url%> height="32px" width="32" />&nbsp;
				<%=news.get(i).getUsername()%>&nbsp;:<%=news.get(i).getContent()%>
				<p align="right"><%=news.get(i).getPostdate().toString() %></p>		
			</li>
			<%
			}
    	}
    %>
    </ul> 
</fieldset>
</div>

</body>
</html>