<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<title>Student</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/pages/common/menu.jsp"></jsp:include>
	
	<div >
            <table >
              <thead>
                <tr>
                  <th>#</th>
				  <th width="66" align="center">学号</th>
				  <th width="66" align="center">姓名</th>
                  <th width="66" align="center">性别</th>
                  <th width="66" align="center">电话</th>
                  <th width="66" align="center">宿舍号</th>
                   <th width="66" align="center">操作</th>
                </tr>
              </thead>
              <tbody>
             <c:forEach items="${page}" var = "student" varStatus="status">
                <tr>
                  <td>${status.count}</td>
				  <td>${student.sid }</td>
                  <td>${student.name}</td>
                  <td>${student.gender}</td>
                  <td>${student.telephone}</td>
                  <td>${student.did}</td>
                  <td>
				      <button type="button" onclick="window.location.href='StudentServlet?method=toUpdate&sid=${student.sid}&pageNum=${requestScope.pageNum }&condition=${requestScope.condition }'">改</button>
				      <button type="button" class="del_Btn" value="${student.sid }">删</button>
				  </td>
                </tr>
              </c:forEach>
           
              </tbody>
			  </table>
			    <div>
				<a href="StudentServlet?method=toStudent&pageNum=1&condition=${requestScope.condition}">首页</a>
				<c:if test="${requestScope.pageNum > 1}">
					<a href="StudentServlet?method=toStudent&pageNum=${requestScope.pageNum-1}&condition=${requestScope.condition}">上一页</a>
				</c:if>
				<c:if test="${requestScope.pageNum<requestScope.totalPage}">
					<a href="StudentServlet?method=toStudent&pageNum=${requestScope.pageNum+1}&condition=${requestScope.condition}">下一页</a>
				</c:if>
				<a href="StudentServlet?method=toStudent&pageNum=${requestScope.totalPage}&condition=${requestScope.condition}">末页</a>
				共${requestScope.pageNum}/${requestScope.totalPage}页，${requestScope.total}条记录 
				到第<input value="${requestScope.pageNum}" name="pn" id="pn_input"/>页
				<input id = "sub_page" type="button" value="确定">
				</div>
			  
            <form action="StudentServlet">
            	<input type="hidden" name="method" value="toStudent" />
            	<input type="hidden" name="pageNum" value="1" />
            	<input type="text" name="condition" value="${condition }" />
            	<input type="submit" value="查询" />
            </form>
          </div>
          <button type="button" onclick="window.location.href='StudentServlet?method=toAdd&pageNum=${requestScope.pageNum }&condition=${requestScope.condition }'" >添加</button>
          
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
	
		$(function(){
			$("#sub_page").click(function(){
				var pageNum = $("#pn_input").val();
				location = "StudentServlet?method=toStudent&pageNum="+pageNum+"&condition=${requestScope.condition}";
				
			});
			
			$(".del_Btn").click(function(){
				var sid = $(this).val();
				if(confirm("确定删除【" + sid + "】吗?") == false){
					return false;
				}
				location="StudentServlet?method=deleteStudent&sid="+sid+"&pageNum=${requestScope.pageNum}&condition=${requestScope.condition}";
			});
			
		});
		
			
		
		
	
	</script>
          
</body>
</html>