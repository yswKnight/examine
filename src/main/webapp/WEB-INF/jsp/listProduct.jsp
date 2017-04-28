<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品信息</title>

</head>
<link href="css/bootstrap.min.css"  type="text/css" rel="stylesheet" />
<script type="text/javascript"  src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript"  src="layer/layer.js"></script>
<script type="text/javascript"  src="layer/laypage/laypage.js"></script>
<script type="text/javascript">
$(function(){
	//加载就显示产品记录
	//byPage();
	ready();

	//添加
	$("#savebtn").click(function(){
		//把产品类别查询出来
		$.post("${pageContext.request.contextPath }/type/listTypeInfo",function(res){
				var content="";
				$.each(res,function(i,type){
					//alert(type.typeid);
					content+="<option value="+type.typeid+" selected='selected'>"+type.typename+"</option>";
				});
				$("#selectType").html(content);
		 },"json") 
		
		layer.open({
			type:1,
			content: $("#saveProduct"),
			area: ['400px', '350px'],
			btn:['确定','取消'],
			btnAlign: 'c',
			btn1:function(){
				var submitlist=$("#saveForm").serialize();
				//alert(submitlist);
				$.post("${pageContext.request.contextPath }/product/saveProductInfo",submitlist,function(res){
					if(res=="success"){
						layer.msg('添加成功',{icon:6});
						$("form").get(0).reset();
					}else{
						layer.msg('添加失败',{icon:5});
					}
					ready();
				});
				layer.closeAll();
				$("#saveProduct").hide();
			},btn2:function(){
				layer.closeAll();
				$("#saveProduct").hide();
			}
		})
			
	}); //添加end
	
	//修改
	$(document).on("click","#updatePro",function(){
		//根据id把相关信息查询出来
		var id=$(this).attr("proid");
		var tpid=$(this).attr("tpid");
		var name=$(this).attr("proname");
		var remark=$(this).attr("proremark");
		//alert(tpid);
		//把产品类别查询出来
		$.post("${pageContext.request.contextPath }/type/listTypeInfo",function(res){
				var content3="";
				$.each(res,function(i,type){
					//alert(type.typeid);
					if(type.typeid==tpid){
					content3+="<option value="+type.typeid+" selected='selected'>"+type.typename+"</option>";
					}else{
					content3+="<option value="+type.typeid+">"+type.typename+"</option>";
					}
					});
				$("#optionType").html(content3);
		 }) 
		//根据id查询，并将逐个填写进去
		//alert(id);
		 $.post("${pageContext.request.contextPath }/product/toUpdate",{pid:id},function(){
			$("#proid").val(id);
			$("#proname").val(name);
			$("#proremark").val(remark);
			
		 })  
		 
		layer.open({
			type:1,
			content: $("#updateProduct"),
			area: ['400px', '350px'],
			btn:['确定','取消'],
			btnAlign: 'c',
			btn1:function(){
				var submitlist=$("#updateForm").serialize();
				 $.post("${pageContext.request.contextPath }/product/updateProductInfo",submitlist,function(result){
					//alert(result);
					  if(result=="success"){
						layer.msg('修改成功',{icon:6});
					}else{
						layer.msg('修改失败',{icon:5});
					}
					  ready();
				}); 
				layer.closeAll();
				$("#updateProduct").hide();
			},btn2:function(){
				layer.closeAll();
				$("#updateProduct").hide();
			}
		})
			
	}); //修改end
	
	//删除
	$(document).on("click","#deletePro",function(){
		//id(data)就是发送给服务端的数据
			var id=$(this).attr("proid");
		
			layer.confirm('你确定要删除我吗?', {icon: 3, title:'提示'}, function(index){
 				$.post("${pageContext.request.contextPath }/product/deleteProductInfo",{id:id},function(res){
 	 				if(res=="success"){
 						layer.msg('删除成功',{icon:6});
 					}else{
 						layer.msg('删除失败',{icon:5});
 					}
 	 				ready();
 	 			});
 				 //layer.close(index);
 				});
			
	});//删除end
});
	//查看
function show(res){
		 var content1="";
			$.each(res,function(i,pro){
				content1+="<tr  align='center'>"
				content1+="<td >"+pro.proid+"</td>"
				content1+="<td>"+pro.proname+"</td>"
				content1+="<td>"+pro.protype.typename+"</td>"
				content1+="<td>"+pro.proremark+"</td>"
				content1+="<td><a href='#' id='updatePro' proid="+pro.proid+" proname="+pro.proname+"  proremark="+pro.proremark+"  tpid="+pro.protype.typeid+">修改</a>&nbsp;&nbsp;<a href='#' id='deletePro' proid="+pro.proid+">删除</a></td>"
					content1+="</tr>"
			});
			$("#tobody").html(content1);
}
//分页
function ready(){
			$.post("${pageContext.request.contextPath}/product/listProductInfoByPage",{pageno:1},function(res){
				show(res.result);
			laypage({
		        cont: bypage, //容器。值支持id名、原生dom对象，jquery对象。
		        pages: res.totalPageNum, //通过后台拿到的总页数
		        curr: 1, //初始化当前页
		        skin: '#1E9FFF',
		        jump: function(e){ //触发分页后的回调
		         $.getJSON('${pageContext.request.contextPath}/product/listProductInfoByPage', {"pageno": e.curr}, function(res){
		 			show(res.result);
		            });
		        }
		        });
		  	},"json")
		}
</script>
<body>
	<h3 align="center">产品维护中心</h3>
	<button class="btn btn-success"  id="savebtn" >增加新产品</button>
	<table align="center" border="1" width="70%"
		class="table table-bordered">
		<thead>
			<tr align="center">
				<td>产品编号</td>
				<td>产品名称</td>
				<td>产品类别</td>
				<td>产品描述</td>
				<td>管理</td>
			</tr>
		</thead>
		<tbody id="tobody">

		</tbody>
	</table>
	 <!--分页显示-->
               <br>
         	 <div id="bypage" style="font-size: 18px;" align="center"></div>
	<!-- 添加框 -->
	<div id="saveProduct" style="display: none;">
	<form action="${pageContext.request.contextPath}/product/saveProductInfo" method="post"  id="saveForm">
	<table align="center" >
		<tr><td>产品编号:</td><td><input type="text" name="proid" value="${pro.proid }"/></td></tr>
		<tr><td>产品名称:</td><td><input type="text" name="proname" value="${pro.proname }"/></td></tr>
		<tr>
			<td>产品类别:</td>
			<td>
				<select name="protype.typeid" id="selectType">
				
				</select>
			</td>
		</tr>
		<tr><td>产品描述:</td><td><input type="text" name="proremark" value="${pro.proremark }"/></td></tr>
	</table>
	</form>
	</div>
	<!-- 修改框 -->
		<div id="updateProduct" style="display: none;">
	<form action="${pageContext.request.contextPath}/product/updateProductInfo" method="post" id="updateForm">
	<table align="center" >
		<tr><td>产品编号:</td><td><input type="text"  id="proid"  name="proid" value="${pro.proid }" readonly="readonly" /></td></tr>
		<tr><td>产品名称:</td><td><input type="text"  id="proname" name="proname"  value="${pro.proname }"/></td></tr>
		<tr>
			<td>产品类别:</td>
			<td>
				<select name="protype.typeid" id="optionType">
				
				</select>
			</td>
		</tr>
		<tr><td>产品描述:</td><td><input type="text"  id="proremark" name="proremark" value="${pro.proremark }"/></td></tr>
	</table>
	</form>
	</div>
</body>
</html>