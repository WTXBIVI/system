<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="${pageContext.request.contextPath}/HomeServlet?method=logOut" >注销</a>
	<table>
		<tr>
<!-- 	回到home页-->
		<td><a href="${pageContext.request.contextPath}/HomeServlet?method=toHome">首页</a></td>
		</tr>
		<c:if test="${sessionScope.user.flag eq '1' }">
<!-- 	包含了对宿舍人员的增删改查 =====分页实现=====-->
		<tr>
			<td><a href="${pageContext.request.contextPath}/StudentServlet?method=toStudent&pageNum=1">宿管模块（学生）</a></td>
		</tr>
<!-- 	包含了对宿舍的增删改查  (点开展现出一共有哪些宿舍，点击宿舍号，弹出宿舍中的人员名字，人员sid)  =====分页实现=====-->
		<tr>
			<td><a href="${pageContext.request.contextPath}/DormitoryServlet?method=toDormitory">宿管模块（宿舍)</a></td>
		</tr>
		
<!-- 	包含了对宿舍卫生相关信息的增删改查  =====ajax,模态框实现===== -->
<!-- 		<tr> -->
<!-- 			<td>卫生管理模块</td> -->
<!-- 		</tr> -->
		</c:if>
<!-- 		包含了对宿舍账单的增删改查功能，不需要用到分页，因为宿舍数少   -->
		<tr>
			<td><a href="${pageContext.request.contextPath}/BillServlet?method=toBill">水电管理模块</a></td>
		</tr>
<!-- 	包含了对repair的增删改查  =====分页实现===== -->	
		<tr>
			<td><a href="${pageContext.request.contextPath}/RepairServlet?method=toRepairIndex">维修管理模块</a></td>
		</tr>
	</table>