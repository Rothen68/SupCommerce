<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new product</title>
</head>
<body>
<h2>Add a new product</h2>
	<form method="post" action="addProduct">
        <table>
            <tr>
                <td>Product Name :</td><td><input type="text" name="name" value="" />
                </td>
            </tr>
            <tr>
                <td >Product Content :</td><td><input type="text" name="content" value="" />
                </td>
            </tr>
            <tr>
                <td>Product Price :</td><td><input type="text" name="price" value="0" />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Add" style="font-size:18px; " />
                </td>
            </tr>
        </table>
    </form> 

</body>
</html>