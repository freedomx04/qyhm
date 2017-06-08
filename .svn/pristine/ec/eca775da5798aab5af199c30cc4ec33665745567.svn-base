<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>模板</title>

	<link rel="stylesheet" type="text/css" href="${ctx}/plugins/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/plugins/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/plugins/animate/animate.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/local/common.css">

	<link rel="stylesheet" type="text/css" href="${ctx}/plugins/bootstrap-table/bootstrap-table.min.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/plugins/sweetalert/sweetalert.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/plugins/bootstrapValidator/css/bootstrapValidator.min.css">

	<link rel="stylesheet" type="text/css" href="${ctx}/plugins/hplus/style.min.css">

</head>

<body class="gray-bg body-tag">
	<div class="wrapper wrapper-content animated fadeInRight">
	 	<div class="ibox float-e-margins">
	 		<div class="ibox-title">
	 			<h5>标签管理</h5>
	 		</div>
	 		
	 		<div class="ibox-content">
				<div class="btn-group hidden-xs" id="tag-table-toolbar" role="group">
					<button type="button" class="btn btn-outline btn-default btn-tag-add" data-toggle="modal" data-target="#modal-tag-dialog">
						<i class="fa fa-plus fa-fw"></i>新增
					</button>
					<button type="button" class="btn btn-outline btn-default btn-tag-edit" disabled='disabled' data-toggle="modal" data-target="#modal-tag-dialog">
						<i class="fa fa-edit fa-fw"></i>编辑
					</button>
					<button type="button" class="btn btn-outline btn-default btn-tag-delete" disabled='disabled'>
						<i class="fa fa-trash-o fa-fw"></i>删除
					</button>
				</div>
				
				 <table id="tag-table" data-mobile-responsive="true"> 
 					<thead>
 						<tr>
 							<th data-field="state" data-checkbox="true"></th>
 							<th data-field="tagid" data-align="center">标签id</th>
 							<th data-field="tagname" data-align="center">标签名称</th>
 						</tr>
 					</thead>
 				</table>
				
		 	</div>
	 		
	 	</div>
	</div>
	
	<!-- 标签新增,编辑对话框 -->
	<div class="modal" id="modal-tag-dialog" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content animated fadeInDown">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title"><strong></strong></h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="form-tag" autocomplete="off">
						<div class="form-group">
							<label for="tagname" class="col-sm-3 control-label"><i class="hm-form-required">*</i>标签名称</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" name="tagname" required>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal">
						<i class="fa fa-close fa-fw"></i>关闭
					</button>
					<button type="button" class="btn btn-primary btn-confirm">
						<i class="fa fa-check fa-fw"></i>确定
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="${ctx}/plugins/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/plugins/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${ctx}/plugins/hplus/content.min.js"></script>
	<script type="text/javascript" src="${ctx}/local/common.js"></script>
	
	<script type="text/javascript" src="${ctx}/plugins/sweetalert/sweetalert.min.js"></script>
	<script type="text/javascript" src="${ctx}/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="${ctx}/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript" src="${ctx}/plugins/bootstrapValidator/js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="${ctx}/plugins/bootstrapValidator/js/language/zh_CN.js"></script>
	
	<script type="text/javascript">
		;(function( $ ) {
			
			var $page = $('.body-tag');
			var $tagDialog = $page.find('#modal-tag-dialog');
			var $tagForm = $tagDialog.find('form');
			
			var $table = $k.util.bsTable($page.find('#tag-table'), {
				url: '${ctx}/api/contacts/tag/list',
				toolbar: '#tag-table-toolbar',
				idField: 'tagid',			
				responseHandler: function(res) {
					return res.data;
				} 
			});
			
			$table.on('all.bs.table', function(e, row) {
				var selNum = $table.bootstrapTable('getSelections').length;
				
				if (selNum == 1) {
					$page.find('.btn-tag-edit').removeAttr('disabled');
					$page.find('.btn-tag-delete').removeAttr('disabled');
				} else {
					$page.find('.btn-tag-edit').attr('disabled', 'disabled');
					$page.find('.btn-tag-delete').attr('disabled', 'disabled');
				}
			});
			
			$page
			.on('click', '.btn-tag-add', function() {
				$tagDialog.find('.modal-title strong').text('新增标签');
				
				$tagDialog.on('click', '.btn-confirm', function() {
					$.ajax({
						url: '${ctx}/api/contacts/tag/add',
						type: 'POST',
						data: {
							tagname: $tagForm.find('input[name = "tagname"]').val()
						},
						success: function(ret) {
							debugger;
							console.log(ret.code);
						},
						error: function(err) {}
					});
				});
			})
			.on('click', '.btn-tag-edit', function() {
				
			})
			.on('click', '.btn-tag-delete', function() {
				swal({
					title: '确认删除标签?',
					text: '只是删除此标签，不会影响标签包含的成员',
					type: 'warning',
					showCancelButton: true,
					cancelButtonText: '取消',
					confirmButtonColor: '#DD6B55',
					confirmButtonText: '确定',
					closeOnConfirm: false
				}, function() {
					var rows = $table.bootstrapTable('getSelections');
					
					$.ajax({
						url: '${ctx}/api/contacts/tag/delete',
						data: { 
							tagid: rows[0].tagid
						},
						success: function(ret) {
							if (ret.code == '0') {
								swal('', '删除成功!', 'success');
							} else {
								swal('', ret.msg, 'error');
							}
							$table.bootstrapTable('refresh'); 
						},
						error: function(err) {}
					});
					
				});
			});
			
		})( jQuery );
	</script>

</body>

</html>