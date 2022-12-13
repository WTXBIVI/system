<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<thead >
			<tr>
				<th width="100px">编号</th>
				<th width="100px">维修内容</th>
				<th width="100px">上报学生</th>
				<th width="100px">上报时间</th>
				<th width="100px">维修状态</th>
				<th width="100px">操作</th>
			</tr>
		</thead>
		<tbody id = "tbody">
		
		</tbody>
		
	</table>
		<button type="button" onclick="addBill()">添加</button>
	<!-- 	updateContentModal -->
<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
        <h4 class="modal-title" id="myModalLabel">修改维修内容</h4>
      </div>
      <div class="modal-body" id="update_div">
        <input type="text" name ="content" size="50" >
        <input type="hidden" name="rid" >
      </div>
      <div class="modal-footer">
        <button type="button" id="ch_cl_btn" class="btn btn-default">关闭</button>
        <button type="button" id="ch_sa_btn" class="btn btn-primary">确定修改</button>
      </div>
    </div>
  </div>
</div>


	<!-- 	updateOtherModal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
        <h4 class="modal-title" id="myModalLabel">修改维修信息</h4>
      </div>
      <div class="modal-body" id="update_other_div">
        <input type="hidden" name="rid_back" >
        <label for="rid">编号</label>
        <input type="text" id="rid" name="rid" ><br>
        <label for="sid">上报学生</label>
        <input type="text" id="sid" name="sid" ><br>
        <label for="time">上报时间</label>
        <input type="text" id="time" name="time" ><br>
        <label for="situation">维修状态</label>
        <input type="text" id="situation" name="situation" ><br>
      </div>
      <div class="modal-footer">
        <button type="button" id="up_cl_btn" class="btn btn-default">关闭</button>
        <button type="button" id="up_sa_btn" class="btn btn-primary">确定修改</button>
      </div>
    </div>
  </div>
</div>


	<!-- 	addModal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
        <h4 class="modal-title" id="myModalLabel">添加维修信息</h4>
      </div>
      <div class="modal-body" id="add_div">
        <label for="rid">编号</label>
        <input type="text" id="rid" name="rid" ><br>
        <label for="sid">上报学生</label>
        <input type="text" id="sid" name="sid" ><br>
        <label for="time">上报时间</label>
        <input type="text" id="time" name="time" ><br>
        <label for="situation">维修状态</label>
        <input type="text" id="situation" name="situation" ><br>
      </div>
      <div class="modal-footer">
        <button type="button" id="add_cl_btn" class="btn btn-default">关闭</button>
        <button type="button" id="add_sa_btn" class="btn btn-primary">确定修改</button>
      </div>
    </div>
  </div>
</div>


	
<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
//	================================

	$().ready(function(){
		init();
	});
//	================================
	function init(){
		
		$("#tbody").html("");
		$.get(
			"${pageContext.request.contextPath}/RepairServlet",
			{
				method:"init"
			},
			function(result){
				
				for (var p in result) {//遍历json数组时，这么写p为索引，0,1
					$("#tbody").append('<tr>');
					$("#tbody").append('<th>'+result[p].rid+'</th>');
					$("#tbody").append('<button type="button" onclick="check(\''+result[p].content+'\','+result[p].rid+')">详情</button>');
					$("#tbody").append('<th>'+result[p].sid+'</th>');
					$("#tbody").append('<th>'+result[p].time+'</th>');
					if(result[p].situation == "1"){
						$("#tbody").append('<th>已维修</th>');
					}else{
						$("#tbody").append('<th>未维修</th>');
					}
	
// 					$("#tbody").append('<th>');
					$("#tbody").append('<c:if test="${sessionScope.user.flag == 1}">');
					$("#tbody").append('<button type="button" onclick="updateBill('+result[p].rid+','+result[p].sid+',\''+result[p].time+'\','+result[p].situation+')" >改</button>');
					$("#tbody").append('<button type="button" onclick="deleteBill('+result[p].rid+')">删</button>');
					$("#tbody").append('</c:if>');
					$("#tbody").append('</th>');
					$("#tbody").append('</tr>');
				}				
			}
		
		)
	}
//	================================
	
	$('#checkModal').modal({
		backdrop:false,
		show:false,
		keyboard:true
	});
//	================================
	$('#updateModal').modal({
		backdrop:false,
		show:false,
		keyboard:true
	});
//	================================
	function check(content,rid){
		$("#checkModal").modal("show");
		$("#update_div input[name=content]").prop("value",content);
		$("#update_div input[name=rid]").prop("value",rid);
		
	
	}
//	================================
	$("#ch_sa_btn").click(function(){
		var content = $("#update_div input[name=content]").val();
		var rid =$("#update_div input[name=rid]").val();
		
		$.post(
			"${pageContext.request.contextPath}/RepairServlet",
			{
				method:"updateContentByRid",
				content:content,
				rid:rid				
			},
			function(result){
				if(result=="ok"){
					alert("修改成功");
					$("#checkModal").modal("hide");
					init();
				}else{
					alert("修改失败");
				}
			}
		
		)
		
		
	});
	
	
	
//	================================
	$("#ch_cl_btn").click(function(){
			$("#checkModal").modal("hide");

		});
//	================================
	
	function updateBill(rid,sid,time,situation){
		
		$("#updateModal").modal("show");
		$("#update_other_div input[name=rid_back]").prop("value",rid);
		$("#update_other_div input[name=rid]").prop("value",rid);
		$("#update_other_div input[name=sid]").prop("value",sid);
		$("#update_other_div input[name=time]").prop("value",time);
		$("#update_other_div input[name=situation]").prop("value",situation);
		
	
	}
//	================================
	$("#up_sa_btn").click(function(){
		var rid_back = $("#update_other_div input[name=rid_back]").val();
		var rid = $("#update_other_div input[name=rid]").val();
		var sid = $("#update_other_div input[name=sid]").val();
		var time = $("#update_other_div input[name=time]").val();
		var situation = $("#update_other_div input[name=situation]").val();
		$.post(
			"${pageContext.request.contextPath}/RepairServlet",
			{
				method:"updateRepair",
				rid_back:rid_back,
				rid:rid,
				sid:sid,
				time:time,
				situation:situation
				
			},
			function(result){
				if(result=="ok"){
					alert("修改成功");
					$("#updateModal").modal("hide");
					init();
				}else{
					alert("修改失败");
					
				}
			}
		
		)
		
	})
	
//	================================
	$("#up_cl_btn").click(function(){
			$("#updateModal").modal("hide");

		});
//	================================
	
	function deleteBill(rid){
		if(confirm("是否确认删除")==false){
			return false;
		}
		$.post(
			"${pageContext.request.contextPath}/RepairServlet",
			{
				method:"deleteBill",
				rid:rid
				
			},
			function(result){
				if(result=="ok"){
					alert("删除成功");
					init();
					
				}else{
					alert("删除失败");
				}
			}
			
		)
		
		
	
	}
//	================================
	function addBill(){
		$("#add_div input[name=rid]").prop("value","");
		$("#add_div input[name=sid]").prop("value","");
		$("#add_div input[name=time]").prop("value","");
		$("#add_div input[name=situation]").prop("value","");
		$("#addModal").modal("show");
	
	}
	
//	================================
	$("#add_sa_btn").click(function(){
		var rid = $("#add_div input[name=rid]").val();
		var sid = $("#add_div input[name=sid]").val();
		var time = $("#add_div input[name=time]").val();
		var situation = $("#add_div input[name=situation]").val();
		$.post(
			"${pageContext.request.contextPath}/RepairServlet",
			{
				method:"addBill",
				rid:rid,
				sid:sid,
				time:time,
				situation:situation
			},
			function(result){
				if(result=="ok"){
					alert("添加成功");
					$("#addModal").modal("hide");
					init();
				}else{
					alert("添加失败");
				}
			}
		
		)
		
		
	});
	
//	================================
	$("#add_cl_btn").click(function(){
		$("#addModal").modal("hide");
	});
	
//	================================
</script>
</body>
</html>