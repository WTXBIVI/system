<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="LoginServlet?method=toLogin"></jsp:forward>
<!-- 	<form id="sumForm" action="TestServlet"> -->
<!-- 		<input type="hidden" name = "method" value = "sum"/> -->
<!-- 		输入一个数:<input name="num" type="text" /><br> -->
<!-- 		<input type="button" onclick="sum()" value="提交" /> -->
<!-- 	</form> -->
	
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script> --%>
<!-- 	<script type="text/javascript"> -->
<!--   		function sum(){   -->
<!--   // 			alert($);   -->
<!--   			var num = $("#sumForm input[name=num]").val();   -->
<!--   			$.ajax({   -->
<!--   				type:"GET",  -->
<!--   				url:"TestServlet",   -->
<!--  				data:"method=sum&num="+num,   -->
<!--   				success: function(result){   -->
<!--  					alert("result"+result);   -->
<!--   				}   -->
				
<!--   			});   -->
<!--    		}   -->
	</script>
</body>
	
</html>