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
		<li><a href="cheaperProducts">List cheaper products</a>
		<li><a href="Auth/addProduct">Add a product</a></li>
		<li><a href="Auth/addCategory">Add a category</a></li>
		
		<li><a href="logout">Logout</a></li>
	<%} %>
</ul>