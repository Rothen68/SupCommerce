<ul>
	<% if (session.getAttribute("username") == null)
	{
	%>
		<li><a href="login.html">Login</a></li>
	<%}
	else
	{
	%>
		<li><a href="listProduct">List all products</a></li>
		<li><a href="Auth/addProduct">Add a product</a></li>
		<li><a href="logout">Logout</a></li>
	<%} %>
</ul>