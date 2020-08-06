<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>
</head>
<body>
<%
	String str = "Hello Everyone";
	String str1 = "Hi";
%>
<h1><%= str %> <%= str1 %></h1>
<center>
	<%
		for(int i=1; i<=6; i++) {
	%>
		<font size="<%= i %>">Hello World!</font> <br />
	<%
		}
	%>
</center>
</body>
</html>