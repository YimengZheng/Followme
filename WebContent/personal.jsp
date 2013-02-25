<%@include file="head.jsp"  %>

<div id="p_up">
<fieldset id="person" style="border:none" >
  <table width="670" border="0">
    <tr>
      <td colspan="3" rowspan="2" align="center"><img src="image/default_head.jpg" width="130" height="130" /></td>
      <td width="288" rowspan="3">
        <h4>About Me:</h4>
        <p style="color:#2B7BA2;"><%=user.getUsername() %></p>
        <p><%=user.getEmail() %></p>
        <p><%=user.getCountry() %></p></td>
      <td width="48">&nbsp;</td>
      <td width="66">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <%
    	int nc=0; int fl=0; int flr=0;
    	NewsDAOIm newDao=new NewsDAOIm();
    	nc=newDao.accountNewsBy(user.getUserID());	
    %>
    <tr>
      <td width="50">News:&nbsp;<%=nc%></td>
      <td width="70">Following:&nbsp;<%=fl %></td>
      <td width="60">Follower:&nbsp;<%=flr %></td>
      <td><form id="form2" name="form2">
        <input type="submit" name="p_edit" id="button" value="edit" style="background:#2B7BA2; color:#fff;"  />
      </form></td>
      <td><form id="form2" name="form2">
        <input type="submit" name="d_mess" id="d_mess" value="Message" style="background:#2B7BA2; color:#fff;" />
      </form></td>
    </tr>
  </table>
</fieldset>
</div>

<div id="p_down_l">
<p style="font-size:1px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:16px"><strong>&nbsp;&nbsp;&nbsp;Following</strong></p>
<fieldset id="p_following" >
  <form id="form3" name="form3" method="post" action="">
    <ul>   
    <%
        FollowingDAOIm follow=new FollowingDAOIm();
    	List<User> followings=follow.findFollowing(user.getUserID());
    	if(followings!=null)
    	{
    		for(int i=0; i<followings.size();i++)
    		{
    			String url=followings.get(i).getHeadURL();
    			if(url==null)
    				url="image/default_head.jpg";
    		%>
			<li >
			   <p>
				<img src=<%=url%> height="40px">&nbsp;&nbsp;<%=followings.get(i).getUsername() %>
			   </p>
			</li>
			<%
			}
    	}
    %>
    </ul> 
    <p align="right"><input type="submit" name="m_following" id="m_following" value="More" style="background:#2B7BA2; color:#fff; border-style:hidden" /></p>
  </form>
</fieldset>
<p style="font-size:1px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:16px"><strong>&nbsp;&nbsp;&nbsp;Follower</strong></p>
<fieldset id="p_follower" >
<form id="form3" name="form3" method="post" action="">
	<ul>   
    <%
        FollowerDAOIm follower=new FollowerDAOIm();
    	List<User> followers=follower.findFollower(user.getUserID());
    	if(followers!=null)
    	{
    		for(int i=0; i<followers.size();i++)
    		{
    			String url=followers.get(i).getHeadURL();
    			if(url==null)
    				url="image/default_head.jpg";
    		%>
    		<li >
			   <p>
				<img src=<%=url%> height="40px">&nbsp;&nbsp;<%=followers.get(i).getUsername() %>
			   </p>
			</li>
			<%
			}
    	}
    %>
    </ul> 
    <p align="right"><input type="submit" name="p_follower" id="p_follower" value="More" style="background:#2B7BA2; color:#fff; border-style:hidden" /></p>
  </form>
</fieldset>
</div>

<div id="p_down_r">
<p style="font-size:1px; ">&nbsp;</p>
<p style="color:#2B7BA2; font-size:18px"><strong>&nbsp;&nbsp;&nbsp;NEWS</strong></p>
<fieldset id="p_news" >
<ul>   
    <%
    	List<News> news=newDao.getNewsByUser(user.getUserID());
    	if(news!=null)
    	{
    		for(int i=0; i<news.size();i++)
    		{
    			String url=news.get(i).getHeadURL();
    			if(url==null)
    				url="image/default_head.jpg";
    		%>
			<li >		
				<img src=<%=url %> height="32px" width="32" />&nbsp;
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