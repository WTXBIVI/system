<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
		<p style="color: red;">${msg}</p>
		<input type="hidden" name="method" value="doLogin" /><br>
		<label for="select">身份:&nbsp;&nbsp;&nbsp;</label>
            <select id="select" name="type" >
                <option value="0" selected="selected" >学生</option>
                <option value="1" >管理员</option>
            </select><br>
		<label for="username">用户名</label>
		<input id="username" name="username" type="text" /><br>
		<label for="password">密码&nbsp;&nbsp;&nbsp;</label>
		<input id="password" name="password" type="password" /><br>
		<input type="submit" value="提交" />
	</form>
	
</body>
</html>