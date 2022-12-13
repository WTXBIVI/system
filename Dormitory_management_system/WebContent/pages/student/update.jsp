<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.method eq 'toUpdate' }">
	<h1>修改Student信息</h1>
	</c:if>
	<c:if test="${param.method eq 'toAdd' }">
	<h1>添加Student信息</h1>
	</c:if>
	<form action="StudentServlet">
		<c:if test="${param.method eq 'toUpdate' }">
			<input type="hidden" name="method" value="doUpdate"/>
		</c:if>
		<c:if test="${param.method eq 'toAdd' }">
			<input type="hidden" name="method" value="doAdd"/>
		</c:if>
		<input type="hidden" name="pageNum" value="${param.pageNum}"/>
		<input type="hidden" name="condition" value="${param.condition }"/>
		<c:if test="${param.method eq 'toUpdate' }">
			<input type="hidden" name="sidback" value="${requestScope.student.sid}"/>
		</c:if>
		<label for="sid">学号</label>
		<input type="text" id="sid" name="sid" value="${requestScope.student.sid}"/><br>
		<label for="name">姓名</label>
		<input type="text" id="name" name="name" value="${requestScope.student.name}"/><br>
		<label for="gender">性别</label>
		<input type="text" id="gender" name="gender" value="${requestScope.student.gender}"/><br>
		<label for="telephone">电话</label>
		<input type="text" id="telephone" name="telephone" value="${requestScope.student.telephone}"/><br>
		<label for="did">宿舍</label>
		<input type="text" id="did" name="did" value="${requestScope.student.did}"/><br>
		<label for="password">密码</label>
		<input type="text" id="password" name="password" value="${requestScope.student.password}"/><br>
		<input type="submit" value="确定" /><br>
		<button type="button" onclick="window.location.href='StudentServlet?method=toStudent&pageNum=${param.pageNum}&condition=${param.condition }'" >取消</button>
	</form>
</body>
</html>