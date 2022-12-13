<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="/pages/common/menu.jsp"></jsp:include>
	<table>
		<thead >
			<tr>
				<th width="100px">编号</th>
				<th width="100px">宿舍号</th>
				<th width="100px">欠费</th>
				<th width="100px">是否已缴纳</th>
				<th width="100px">操作</th>
			</tr>
		</thead>
		<tbody id = "tbody">
<%-- 			<c:forEach items="${billList }" var = "bill"> --%>
<!-- 				<tr> -->
<%-- 					<th>${bill.bid }</th> --%>
<%-- 					<th>${bill.did }</th> --%>
<%-- 					<th>${bill.money }</th> --%>
<%-- 					<c:if test="${bill.situation eq '1'}"> --%>
<!-- 						<th>已缴纳</th> -->
<%-- 					</c:if> --%>
<%-- 					<c:if test="${bill.situation eq '0'}"> --%>
<!-- 						<th>未缴纳</th> -->
<%-- 					</c:if> --%>
<!-- 					<th> -->
<%-- 						<button type="button" onclick="updateBill(${bill.bid},${bill.did },${bill.money },${bill.situation})" >改</button> --%>
<!-- 						<button type="button">删</button> -->
<!-- 					</th> -->
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
		</tbody>
	</table>
	<c:if test="${sessionScope.user.flag == 1}">
	<button type="button" onclick="addBill()">添加</button>
	</c:if>
	
	
	
<!-- 	updateModal -->
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button> -->
        <h4 class="modal-title" id="myModalLabel">修改账单</h4>
      </div>
      <div class="modal-body">
        <form id="myForm" >
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" id="cl_btn" class="btn btn-default">关闭</button>
        <button type="button" id="sa_btn" class="btn btn-primary">确定</button>
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
        <h4 class="modal-title" id="myModalLabel">添加账单</h4>
      </div>
      <div class="modal-body">
        <form id="addForm" action="BillServlet" >
        	<input type="hidden" name="method" value="addBill" >
        	<label>编号</label>
        	<input type="text" id="add_bid" name="bid" ><br>
        	<label>宿舍号</label>
        	<input type="text" id="add_did" name="did" ><br>
        	<label>欠费</label>
        	<input type="text" id="add_money" name="money" ><br>
        	<label>缴纳情况</label>
        	<input type="text" id="add_situation" name="situation" ><br>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" id="add_cl_btn" class="btn btn-default">关闭</button>
        <button type="button" id="add_sa_btn" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-2.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>

	
	<script type="text/javascript">
// 	================================
		
	$().ready(function(){
		init();
	});
// 	================================
	function init(){
		$("#tbody").html("");
		$.get(
			"${pageContext.request.contextPath}/BillServlet",
			{
				method:"init"
			},
			function(result){
				
				for (var p in result) {//遍历json数组时，这么写p为索引，0,1
					$("#tbody").append('<tr>');
					$("#tbody").append('<th>'+result[p].bid+'</th>');
					$("#tbody").append('<th>'+result[p].did+'</th>');
					$("#tbody").append('<th>'+result[p].money+'</th>');
					if(result[p].situation == "1"){
						$("#tbody").append('<th>已缴纳</th>');
					}else{
						$("#tbody").append('<th>未缴纳</th>');
					}
// 					$("#tbody").append('<th>');
		
					$("#tbody").append('<c:if test="${sessionScope.user.flag == 1}">');
					$("#tbody").append('<button type="button" onclick="updateBill('+result[p].bid+','+result[p].did+','+result[p].money+','+result[p].situation+')" >改</button>');
					$("#tbody").append('</c:if>');
					$("#tbody").append('<c:if test="${sessionScope.user.flag == 1}">');
					$("#tbody").append('<button type="button" onclick="deleteBill('+result[p].bid+')">删</button>');
					$("#tbody").append('</c:if>');
					$("#tbody").append('</th>');
					$("#tbody").append('</tr>');
				}
// 				$("#tbody").append('<c:forEach items="${billList }" var = "bill">');
// 				$("#tbody").append('<tr>');
// 				$("#tbody").append('<th>${bill.bid }</th>');
// 				$("#tbody").append('<th>${bill.did }</th>');
// 				$("#tbody").append('<th>${bill.money }</th>');
// 				$("#tbody").append('<c:if test="${bill.situation eq '1'}">');
// 				$("#tbody").append('<th>已缴纳</th>');
// 				$("#tbody").append('</c:if>');
// 				$("#tbody").append('<c:if test="${bill.situation eq '0'}">');
// 				$("#tbody").append('<th>未缴纳</th>');
// 				$("#tbody").append('</c:if>');
////		 		$("#tbody").append('<th>');
// 				$("#tbody").append('<button type="button" onclick="updateBill(${bill.bid},${bill.did },${bill.money },${bill.situation})" >改</button>');
// 				$("#tbody").append('<button type="button">删</button>');
// 				$("#tbody").append('</th>');
// 				$("#tbody").append('</tr>');
// 				$("#tbody").append('</c:forEach>');
			}
		
		)
		
		
	}
// 	================================
	$('#updateModal').modal({
		backdrop:false,
		show:false,
		keyboard:true
	});
// 	================================
	$('#addModal').modal({
		backdrop:false,
		show:false,
		keyboard:true
	});
// 	================================
	
	$("#cl_btn").click(function(){
			$("#updateModal").modal("hide");
			$("#myForm").html("");
			
		});
// 	================================
	
	$("#sa_btn").click(function(){
		$.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                url: "${pageContext.request.contextPath}/BillServlet" ,//url
                data: $('#myForm').serialize(),
                success: function (result) {
                    if(result == "ok"){
                    	alert("添加成功");
                    	$('#updateModal').modal("hide");
                    	init();
                    	$("#myForm").html("");
                    }else{
                    	alert("修改失败");
                    }
                },error: function(){
                	alert("异常")
                }
            });
	})
// 	================================
	
	$("#add_sa_btn").click(function(){
		$.ajax({
            //几个参数需要注意一下
                type: "POST",//方法类型
                url: "${pageContext.request.contextPath}/BillServlet" ,//url
                data: $('#addForm').serialize(),
                success: function (result) {
                    if(result == "ok"){
                    	alert("添加成功");
                    	$('#addModal').modal("hide");
                    	init();
                    	$('#addModal').on('hidden.bs.modal', function (){
                    		document.getElementById("addForm").reset();
                    	});
                    }else{
                    	alert("添加失败");
                    }
                },error: function(){
                	alert("异常")
                }
            });
	})
// 	================================
	$("#add_cl_btn").click(function(){
			$("#addModal").modal("hide");
			$('#addModal').on('hidden.bs.modal', function (){
        		document.getElementById("addForm").reset();
        	});
		});
// 	================================
	function updateBill(bid,did,money,situation){
	
		
		$("#myForm").append('<input type="hidden" name = "method" value = "updateBill" ><br>');
		$("#myForm").append('<input type="hidden" name = "bid_back" value = "'+bid+'" ><br>');
		$("#myForm").append('<label for="bid">编号</label>');
		$("#myForm").append('<input type="text" id = "bid" name = "bid" value = "'+bid+'" ><br>');
		$("#myForm").append('<label for="did">宿舍号</label>');
		$("#myForm").append('<input type="text" id = "did" name = "did" value = "'+did+'" ><br>');
		$("#myForm").append('<label for="money">欠费</label>');
		$("#myForm").append('<input type="text" id = "money" name = "money" value = "'+money+'" ><br>');
		$("#myForm").append('<label for="situation">是否缴费</label>');
		$("#myForm").append('<input type="text" id = "situation" name = "situation" value = "'+situation+'" ><br>');
		$("#updateModal").modal("show");
	}
// 	================================
	function deleteBill(bid){
		if(confirm("是否确认删除")==false){
			return false;
		}
		
		$.post(
			"${pageContext.request.contextPath}/BillServlet",
			{
				method:"deleteBill",
				bid:bid
				
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
// 	================================
	function addBill(){
		$("#addModal").modal("show");
	
	}
	</script>
</body>
</html>