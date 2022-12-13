<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="/pages/common/menu.jsp"></jsp:include>
	

	<table>
		<tr>
			<th>宿舍号</th>
			<th>宿舍当前评分</th>
		</tr>
		<c:forEach items="${list }" var="dor">
			<tr>
				<td><button type="button" onclick="showDormitory(${dor.did})">${dor.did}</button></td>
				<td><input type="text" class="score" name="${dor.did}" value="${dor.score}" /></td>
			</tr>
		</c:forEach>
	</table>


<!-- modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
        <h4 class="modal-title" id="myModalLabel">该宿舍已住学生</h4>
      </div>
      <div class="modal-body">
        <table>
        	<thead>
	        	<tr>
	        		<th>姓名</th>
	        		<th>操作</th>
	        	</tr>
        	</thead>
        	<tbody id = "tbody">
<%-- 	        	<c:forEach items=""> --%>
<!-- 			       	<tr> -->
<!-- 			       		<th></th> -->
<!-- 			       		<th>操作</th> -->
<!-- 			       	</tr> -->
<%-- 	        	</c:forEach> --%>
        	</tbody>
        </table>
      </div>
      <div class="modal-footer">
<!--         <button type="button" id="cl_btn" class="btn btn-default">关闭</button> -->
        <button type="button" id="sa_btn" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
		$('#myModal').modal({
			backdrop:false,
			show:false,
			keyboard:true
		});
// 		====================================
			$(".score").change(function(){
				if(confirm("是否确认修改")==false){
					return false;
				}
				var score = $(this).val();
				var did = $(this).attr("name");
				$.post(
					"DormitoryServlet",
					{
						method:"updateScore",
						score:score,
						did:did
					},
					function(result){
						if(result=="ok"){
							alert("修改成功");
						}else{
							alert("修改失败");
						}
					}
				)
				
			})
			
// 		====================================
		function deleteStudentDid(id){
			if(confirm("确定删除吗")==false){
				return false;
			}
			$.post(
				"StudentServlet",
				{
					method:"deleteStudentDid",
					sid:id
				},
				function(result){
					if(result=="ok"){
						$("#myModal").modal("hide");
						$("#tbody").html("");
						alert("删除成功");
					}else{
						$("#myModal").modal("hide");
						$("#tbody").html("");
						alert("删除失败");
					}
				}
			)
		}
// 		====================================
		
// 		$("#myModal").modal("show");

		$("#sa_btn").click(function(){
			$("#myModal").modal("hide");
			$("#tbody").html("");
		});
		
// 		$("#cl_btn").click(function(){
// 			$("#myModal").modal("hide");
// 			$("#tbody").html("");
// 		});
	
// 		====================================
			function showDormitory(id){
//	 			alert(did);
				$("#myModal").modal("show");
				$.get(
					"StudentServlet",
					{
						method:"listStudentByDid",
						did:id
					},
					function(result){
						
						for (var p in result) {//遍历json数组时，这么写p为索引，0,1
							$("#tbody").append('<tr>');
							$("#tbody").append('<th>'+result[p].name+'</th>');
							$("#tbody").append('<th><button type="button" onclick="deleteStudentDid(\''+result[p].sid+'\')" ">删除</button></th>');
							console.log(result[p].sid)
							$("#tbody").append('</tr>');
						}
// 						$("#tbody").append('<c:forEach items="'+result+'" var = "student">');
// 											$("#tbody").append('</c:forEach>');
						
					}
				);
				
			}
//	 		====================================
		
</script>

</body>
</html>