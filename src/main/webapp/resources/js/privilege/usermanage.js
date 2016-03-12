var doUser = {
		url : CONTEXT_PATH+'/usermanage',
		
		toRole:function() {
			
			var row = $('#dg').datagrid('getSelected');
			if (!row) {
				parent.showWarningBox('请先选择一个用户');
				return;
			} else {
				$('#window_dia').window({
					width:800,
					height:500,
					modal:true,
					title:'用户授权',
					minimizable:false,
					maximizable:false,
					collapsible:false,
				});
				loadAllRole();
				var selector = $('#roletable').datagrid('getSelected');
				var result_id = null;
				selector==null?result_id='2222':result_id=selector.id;
				privilege_tree_fu(result_id);
			}
			
			
		},
		toAdd : function() {
			$('#contain_add_user').show();
		},
		searchUser:function() {
			$('#dg').datagrid({
				queryParams : {
					"name" : $('#username').val(),
					"num" : $('#num').val(),
				}
			});
		},
		
		caceladd:function() {
			$('#user_sex_type').val("");
			$('#user_type').val("");
			$('#user_num').val("");
			$('#user_name').val("");
			$('#contain_add_user').hide();
		},
		
		addUser:function() {
			var sex = $('#user_sex_type').val();
			var type = $('#user_type').val();
			var num = $('#user_num').val();
			var name = $('#user_name').val();
			var pwd = $('#user_pwd').val();
			if(num.length == 4 || num.length==10) {
				//学号或者工号输入正确
				if((num.length==10 && type=='学生')||(num.length==4 && type!='学生')) {
					//学号对应学生,工号对应非学生
					
					$.ajax({
						url:this.url+'/addUser.xhtml',
						type:"post",
						data:{'num':num,'name':name,'type':type,'sex':sex,'password':pwd},
						success:function(data) {
							$('#user_sex_type').val("");
							$('#user_type').val("");
							$('#user_num').val("");
							$('#user_name').val("");
							$('#dg').datagrid('reload');
							$('#contain_add_user').hide();
						}
					});
				} else {
					//如果不对应
					alert("填写错误,请重新填写");
				}
				
			} else {
				//学号或者工号不合要求
				alert("填写错误,请重新填写");
			}
			
		},
		addRole:function() {
			//添加角色
			alert("add");
			
		},
		deleteRole:function() {
			//删除角色
			alert("de");
		},
		accreditRole:function() {
			//授权角色功能模块
			alert("acc");
		}
		
		
		
};
$(function() {
	
	$('#dg').datagrid({
		fit : true,
		method : 'post',
		url : CONTEXT_PATH + '/usermanage/getUser.xhtml',
		iconCls : 'icon-ok',
		rownumbers : true,
		fitColumns : true,
		toolbar : '#extToolbar',
		singleSelect : true,
		idField : 'userId',
		nowrap : false,
		striped : true,
		remoteSort : false,
		pagination : true,
		loadMsg:'数据加载中,请稍等...',
		rowStyler : function(index, row) {
		},
		pageSize : 15,
		pageList : [ 5, 10, 15, 20, 25, 30, 35, 40, 45, 50 ],
		frozenColumns : [ [ {
			field : 'id',
			checkbox : true
		} ] ],
		columns : [ [  {
			field : 'name',
			width : 100,
			title : '姓名'
		},{
			field : 'type',
			width : 100,
			title : '类型',
			formatter:function(value,row,index) {
				var type = row.type;
				if(typeof(type) == 'undefined' ) {
					return row.type='学生';
				} else if(type == '0') {
					return row.type='任课老师';
				} else if(type == '1') {
					return row.type='普通老师';
				} else if(type='2') {
					return row.type='管理员';
				}
			}
		}, {
			field : 'num',
			width : 100,
			title : '工号(或学号)'
		},{
			field : 'sex',
			width : 100,
			title : '性别'
		}] ]
	});
		
		
		
	});


function loadAllRole() {
	$('#roletable').datagrid({
		fit : true,
		method : 'post',
		url : doUser.url + '/getAllRoleDialog.xhtml',
		iconCls : 'icon-ok',
		rownumbers : true,
		fitColumns : true,
		toolbar : '#toolbar',
		singleSelect : true,
		idField : 'id',
		nowrap : false,
		striped : true,
		remoteSort : false,
		loadMsg:'数据加载中,请稍等...',
		onLoadSuccess :function(data) {
			$.each(data.rows,function(i,e){
				if(e.name ==  '管理员') {
					$('#roletable').datagrid('selectRecord',e.id);
				}
			});
 		},
 		onCheck:function(rowIndex,rowData) {
 			privilege_tree_fu(rowData.id);
 		},
		rowStyler : function(index, row) {
		},
		frozenColumns : [ [ {
			field : 'id',
			checkbox : true
		} ] ],
		columns : [ [  {
			field : 'name',
			width : 100,
			title : '姓名',
			
		}, {
			field : 'descrip',
			width : 100,
			title : '描述'
		}] ]
	});
}



function privilege_tree_fu(id) {
	var url = doUser.url + '/getRolePrivilege2assign.xhtml?'+'id='+id;
	$('#privilege_tree').tree({
		url:url,
		checkbox:true,
	});
}

