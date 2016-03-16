var path = CONTEXT_PATH + '/resourcemanage';


var doResource = {
		
		addResource:function() {
			 //添加资源
			$('#add_window').window({
				width:300,
				height:350,
				href: path+'/addResourcePage.xhtml',
				minimizable:false,
				maximizable:false,
				collapsible:false,
				modal:true,
				iconCls:'icon-add',
				title:'添加资源',
				resizable:false,
			})
		},
		editResource:function() {
			//修改资源
			var selector = $('#resource_table').datagrid('getSelected');
			if (!selector) {
				parent.showWarningBox('请先选择一个资源');
				return;
			} else {
				
			}
		},
		removeResource:function() {
			var selector = $('#resource_table').datagrid('getSelected');
			if (!selector) {
				parent.showWarningBox('请先选择一个资源');
				return;
			} else {
			$.messager.confirm('删除资源', '是否删除资源', function(r){
				if (r){
					$.ajax({
						url:path + '/deleteResource.xhtml',
						type:"post",
						data:{'id':selector.id},
						success:function(data) {
							alert(data.message);
						}
					});
					
				}
			});
			}
		},
		addResourceSure:function() {
			var name = $('#resourcename').val();
			var path = $('#resourcepath').val();
			var privilege_id = $('#cc').combobox('getValue');
			
			if((name == "" || $.trim(name) == "") || (path == "" || $.trim(path)=="" ) || (privilege_id == "" || $.trim(privilege_id) == "") ) {
				$('#resourcename').val(name);
				$('#resourcepath').val(path);
				alert("请输入完整输入");
				return ;
			}
			var url = CONTEXT_PATH + '/resourcemanage/addresourcesub.xhtml';
			$.ajax({
				url: url,
				data:{'name':name,'path':path,'privilege_id':privilege_id},
				type:'post',
				success:function(data) {
					
				}
			});
			alert("添加成功");
			$('#add_window').window('close');
			
		},
		addResourceCacel:function() {
			$('#add_window').window('close');
		}
	}


$('#privilege_tree').tree({
	url:path+'/resourcetree.xhtml',
	onClick:function(node) {
		if(node.attributes.url != null) {
			createtable(node.id);
		}
	},
})



function createtable(resourceid) {
	$('#resource_table').datagrid({
		fit : true,
		method : 'post',
		queryParams: {
			resourceid: resourceid,
			},
		url : path + '/getResourceTable.xhtml',
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
			title : '资源名称',
			editor: {
				type:'textbox'
			},
			
		},{
			field : 'path',
			width : 100,
			title : '路径',
			editor: {
				type:'textbox'
			}
			
		}] ]
	});
}