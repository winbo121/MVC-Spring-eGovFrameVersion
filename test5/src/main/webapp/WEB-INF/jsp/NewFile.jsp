<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
<script src = "https://cdn.jsdelivr.net/npm/jquery-datatables-checkboxes@1.2.12/js/dataTables.checkboxes.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap.min.css" />

 
<script type="text/javascript">
var userTable;
$(document).ready(function(){

 userTable=$("#userTable").DataTable({
	 
	    ajax: {
	        url:'list.do', 
	        type: 'POST',
	        dataType: "json",
	        data:{},
	        dataFilter:function(data){
	        	console.log(data);
	            return data;
	        }
	     },
	    columns: [
	    	{data:"name",fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
	    		var _input = $("<input>").attr("type","checkbox").addClass("dt-checkboxes");
	            $(nTd).html(_input);
	    	}},
	        {data: "name"},
	        {data: "password"}
	    ],
	    columnDefs: [
	        {targets: 0, orderable: false, searchable: false, checkboxes: true, className: "text-center"}
	      ],
	      initComplete:function(){
	    	   
	      }
	     
	}).columns.adjust();
	
$("#insertUser").on("click",function(){

	
	$.ajax({
		url:"insert.do",
		type:"post",
		data:$("#userForm").serialize(),
		success:function(data){
			var json=JSON.parse(data);
			alert(json.data);
			
			userTable.ajax.reload();
		}
			
		
	});
	
})


$("#deleteUser").on("click",function(){

	var data="";
	var ep_list=userTable.column(0).checkboxes.selected();
	for(var i=0; i<ep_list.length; i++){
		data=data+ep_list[i]+","
	}
	
	
	$.ajax({
		url:"delete.do",
		type:"post",
		data:{
			deleteNames:data
		},
		success:function(data){
			var json=JSON.parse(data);
			alert(json.data);
			
			userTable.ajax.reload();
		}	
	});
	
	
})


})




</script>

</head>

<body>
<div style="width:1000px; margin:auto; margin-top:10%" >
<table id="userTable" class='table table-striped table-bordered'>
<thead>
<tr><th></th><th>name</th><th>password</th></tr>
</thead>
<tbody>

</tbody>
</table> 
<form id="userForm">
아이디99: <input type="text" name="name"> <br>
비밀번호999: <input type="text" name="password">
<button type="button" id="insertUser">입력</button><button type="button" id="deleteUser">삭제</button>  
</form>
</div>
</body>
</html>
