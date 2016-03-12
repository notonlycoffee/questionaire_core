//显示进度条
function progress(){
	$.fn.loadingtips();
}

//关闭进度条
function closeProgress(){
	$.fn.loadingtips('close');
}

$.fn.extend({
	pagearea : function(){//获取页面尺寸
		if (document.compatMode == 'BackCompat') {
			return {
				width: Math.max(document.body.scrollWidth, document.body.clientWidth),
				height: Math.max(document.body.scrollHeight, document.body.clientHeight)
			};
		} else {
			return {
				width: Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth),
				height: Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight)
			};
		}
	},
	
	center : function(w, h){//获取元素要处于页面中间所需的left-top值
		var pos = {};
		pos.l = ($(window).outerWidth() - w) / 2 + $(document).scrollLeft();
		pos.t = ($(window).outerHeight() - h) / 2 + $(document).scrollTop();
		return pos;
	},
	
	winmask : function(opts){//可以创建一个遮罩层，传入'close'关闭
		if(opts && opts === 'close'){
			$('body>div.window-mask-tips').hide();
			return;
		}
		if($('body>div.window-mask-tips').length==0){
			$('<div class="window-mask window-mask-tips"></div>').appendTo('body');
		}
		$('body>div.window-mask-tips').css({
			width: $.fn.pagearea().width,
			height: $.fn.pagearea().height,
			display: 'block',
			zIndex: ++$.fn.window.defaults.zIndex
		});
	},
	
	loadingtips : function(opts){//页面加载提示，opts如果是'close'就关闭，参数opts--{modal: true or false 默认true, text: 要显示的东西}
		if(opts && opts === 'close'){
			$('#loadingTips').hide();
			$.fn.winmask('close');
			return;
		}
		var opt = opts || {modal: true, text: GLOBAL_I18N.global_progress_text};
		if(opt.modal){
			$.fn.winmask();
		}
		var z = ++$.fn.window.defaults.zIndex;
		if($('#loadingTips').length==0){
			$('<div />',{"id":"loadingTips", "class":"datagrid-mask-msg"}).appendTo('body');
		}
		$('#loadingTips').css({'display':'block', 'z-index':z, 'left':'50%', 'margin-left':'-80px'}).html(opt.text);
	},
	
	msearch : function(opts){//高级查询，opts{btns:[]}最后显示的按钮，handler return false将阻止面板关闭
		var $t = $(this), sbox = $t.attr('href'),
		norInp = $t.prev().children('.searchbox-text'),
		opts = $.extend({
			btns : [
				{text:'确定',handler:function(){ return true;}},
				{text:'取消',handler:function(){ return true;}}
			]
		}, opts || {});
		if(typeof sbox == 'string' && sbox!=''){
			sbox = $(sbox);
			$t.unbind('click.msearch').bind('click.msearch', function(){
				if(sbox.children('.dialog-button').length==0){
					var btns = $('<div class="dialog-button"></div>');
					$.each(opts.btns, function(i,o){
						var btn = $('<a href="#">'+o.text+'</a>').appendTo(btns);
						btn.linkbutton().bind('click', function(){
							var callf = o.handler();
							if(typeof callf == 'undefined' || !!callf){
								sbox.slideUp();
							}
						});
					});
					btns.appendTo(sbox);
				}
				sbox.slideDown();
				return false;
			}).bind('mousedown.msearch', function(e){
				e.stopPropagation();
			});
			$(document).bind('mousedown.msearch', function(e){
				sbox.slideUp();
			});
			sbox.bind('mousedown.msearch', function(e){
				e.stopPropagation();
			});
		}
	}
});

function showWarningBox(title,fn){
	var t = '<div class="msgword">'+title+'</div>';
	$.messager.alert(GLOBAL_I18N.global_progress_title, t, 'warning',fn); 
}
function showErrorBox(title,fn){
	var t = '<div class="msgword">'+title+'</div>';
	$.messager.alert(GLOBAL_I18N.global_progress_title, t, 'error',fn); 
}
function showInfoBox(title,fn){
	var t = '<div class="msgword">'+title+'</div>';
	$.messager.alert(GLOBAL_I18N.global_progress_title, t, 'info',fn); 
}
function showConfirmBox(title,fn){
	var t = '<div class="msgword">'+title+'</div>';
	$.messager.confirm(GLOBAL_I18N.global_progress_title, t, fn);
}



$.extend($.fn.datagrid.defaults.editors, {
    text: {
	    init: function(container, options){
		    var input = $('<input type="text" onblur="this.value=this.value.trim();" class="datagrid-editable-input">').appendTo(container);
		    return input;
	    },
	    destroy: function(target){
	    	$(target).remove();
	    },
	    getValue: function(target){
	        return $(target).val();
	    },
	    setValue: function(target, value){
	        $(target).val(value);
	    },
	    resize: function(target, width){
	       $(target)._outerWidth(width);
	    }
	    }
});


/**
 * post请求，返回json格式数据
 * @param url
 * @param data
 * @param fn
 */
function postReturnJson(url,data,callback){
	$.ajax({
		  type: 'POST',
		  data: data,//请求字符窜
		  cache: false,//不从缓存中读取数据
		  url: CONTEXT_PATH+url,    //服务端的URL
		  dataType: 'json',  //预期服务器返回的数据类型，可以是XML,HTML,JSON等
		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		  timeout : 30000,   //超时设置 30秒
		  success : function(result){ 
			if (result.success) {
				showInfoBox(GLOBAL_I18N.global_action_success,function(){
					callback(result);
				}); 
					
			}else{
				showErrorBox(GLOBAL_I18N.global_action_failure+result.msg);
				callback(result);
			}
			
		  },
		  error:function(result){
			  callback(result);
		  }
	});
}

/**
 * post请求，返回json格式数据没有提示
 * @param url
 * @param data
 * @param fn
 */
function postReturnJsonnoalert(url,data,callback){
	$.ajax({
		  type: 'POST',
		  data: data,//请求字符窜
		  cache: false,//不从缓存中读取数据
		  async:false,
		  url: CONTEXT_PATH+url,    //服务端的URL
		  dataType: 'json',  //预期服务器返回的数据类型，可以是XML,HTML,JSON等
		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		  timeout : 30000,   //超时设置 30秒
		  success : function(result){ 
			  callback(result);
		  }
	});
}


function getReturnJson(url,data,callback){
	$.ajax({
		  type: 'get',
		  data: data,//请求字符窜
		  cache: false,//不从缓存中读取数据
		  url: CONTEXT_PATH+url,    //服务端的URL
		  dataType: 'json',  //预期服务器返回的数据类型，可以是XML,HTML,JSON等
		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		  timeout : 30000,   //超时设置 30秒
		  success : function(result){callback(result);}	
	});
}


/**
 * post请求，返回json格式数据,同步请求
 * @param url
 * @param data
 * @param fn
 */
function postReturnasync(url,data,callback){
	$.ajax({
		  type: 'POST',
		  data: data,//请求字符窜
		  cache: false,//不从缓存中读取数据
		  async:false,
		  url: CONTEXT_PATH+url,    //服务端的URL
		  dataType: 'json',  //预期服务器返回的数据类型，可以是XML,HTML,JSON等
		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		
		  timeout : 30000,   //超时设置 30秒
		  success : function(result){ 
			  closeProgress();
			  callback(result);
		  },
		  error:function(XMLHttpRequest, textStatus, errorThrown){
			  console.log(XMLHttpRequest.status);
			  console.log(XMLHttpRequest.readyState);
			  console.log(textStatus);
		  }
	});
}

/**
 * 把表单用ajax提交，返回json格式数据
 * @param url
 * @param data
 * @param fn
 */
function submitForm(jqForm,callback){

	$.ajax({
		  type: 'POST',
		  data: $.serializeObject(jqForm),//序列化表单里的input对象为json对象
		  cache: false,//不从缓存中读取数据
		  url: CONTEXT_PATH+jqForm.attr('action'),    //服务端的URL
		  dataType: 'json',  //预期服务器返回的数据类型，可以是XML,HTML,JSON等
		  contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		  timeout : 30000,   //超时设置 30秒
		  success : function(result){callback(result);}		
	});
}
/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
 */
$.fn.panel.defaults.onBeforeDestroy = function() {
	var frame = $('iframe', this);
	try {
		if (frame.length > 0) {
			for ( var i = 0; i < frame.length; i++) {
				frame[i].src = '';
				frame[i].contentWindow.document.write('');
				frame[i].contentWindow.close();
			}
			frame.remove();
			if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
				try {
					CollectGarbage();
				} catch (e) {
				}
			}
		}
	} catch (e) {
	}
};

/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * 防止panel/window/dialog组件超出浏览器边界
 * @param left
 * @param top
 */
var easyuiPanelOnMove = function(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;

/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * 通用错误提示
 * 
 * 用于datagrid/treegrid/tree/combogrid/combobox/form加载数据出错时的操作
 */
var easyuiErrorFunction = function(XMLHttpRequest) {
	//$.messager.progress('close');
	//$.messager.alert('错误', XMLHttpRequest.responseText);
};
$.fn.datagrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.treegrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.tree.defaults.onLoadError = easyuiErrorFunction;
$.fn.combogrid.defaults.onLoadError = easyuiErrorFunction;
$.fn.combobox.defaults.onLoadError = easyuiErrorFunction;
$.fn.form.defaults.onLoadError = easyuiErrorFunction;

/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * 为datagrid、treegrid增加表头菜单，用于显示或隐藏列，注意：冻结列不在此菜单中
 */
var createGridHeaderContextMenu = function(e, field) {
	e.preventDefault();
	var grid = $(this);/* grid本身 */
	var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
	if (!headerContextMenu) {
		var tmenu = $('<div style="width:100px;"></div>').appendTo('body');
		var fields = grid.datagrid('getColumnFields');
		for ( var i = 0; i < fields.length; i++) {
			var fildOption = grid.datagrid('getColumnOption', fields[i]);
			if (!fildOption.hidden) {
				$('<div iconCls="tick" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			} else {
				$('<div iconCls="bullet_blue" field="' + fields[i] + '"/>').html(fildOption.title).appendTo(tmenu);
			}
		}
		headerContextMenu = this.headerContextMenu = tmenu.menu({
			onClick : function(item) {
				var field = $(item.target).attr('field');
				if (item.iconCls == 'tick') {
					grid.datagrid('hideColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'bullet_blue'
					});
				} else {
					grid.datagrid('showColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'tick'
					});
				}
			}
		});
	}
	headerContextMenu.menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};
$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;

/**
 * grid tooltip参数
 * 
 
 */
var gridTooltipOptions = {
	tooltip : function(jq, fields) {
		// the last field maybe a function to set the tooltip content, modify by guan.dong
		var contentFunc=null;
		if (fields && typeof fields == 'object'){
			contentFunc = fields[fields.length-1];
			if (typeof contentFunc == 'function'){
				fields.pop();
			}
		}
		return jq.each(function() {
			var panel = $(this).datagrid('getPanel');
			if (fields && typeof fields == 'object' && fields.length > 0 && fields.sort) {
				$.each(fields, function() {
					var field = this;
					if (contentFunc && typeof contentFunc == 'function') {
						bindEvent($('.datagrid-body td[field=' + field + '] .datagrid-cell', panel), contentFunc);
					} else {
						bindEvent($('.datagrid-body td[field=' + field + '] .datagrid-cell', panel));
					}
				});
			} else {
				if (contentFunc && typeof contentFunc == 'function') {
					bindEvent($(".datagrid-body .datagrid-cell", panel), contentFunc);
				} else {
					bindEvent($(".datagrid-body .datagrid-cell", panel));
				}
			}
		});

		function bindEvent(jqs, contentFunc) {
			jqs.mouseover(function() {								
				var $t = $(this), cw = $(this).width(), sw = 0, content = $t.text();				
				//deal the content
				if (contentFunc && typeof contentFunc == 'function') {
					content = contentFunc(this);
				}
				
				if(content==''){
					return;
				}
				if($t.data('toolWidth')){
					sw = $t.data('toolWidth');
				}else{
					var $sp = $('<span />').html(content).appendTo('body');
					sw = $sp.width();
					$sp.remove();
					$t.children().each(function(){
						if($(this).text()!=content){
							sw += $(this).width();
						}
					});
					$t.data('toolWidth',sw);
				}
				//if (content.replace(/(^\s*)|(\s*$)/g, '').length > 5) {
				if (cw<sw) {
					$t.tooltip({
						content : content,
						trackMouse : true,
						position : 'bottom',
						onHide : function() {
							$(this).tooltip('destroy');
						},
						onUpdate : function(p) {
							var tip = $(this).tooltip('tip');
							if (parseInt(tip.css('width')) > 180) {
								tip.css({'width': 180 + 'px','word-break':'break-all'});
								var tl = $t.offset().left, pw = $.fn.pagearea().width;
								if(tl + 180 > pw){
									$t.tooltip('options').position = 'left';
								}
							}
						}
					}).tooltip('show');
				}
			});
		}
	}
};
/**
 * Datagrid扩展方法tooltip 基于Easyui 1.3.3，可用于Easyui1.3.3+
 * 
 * 简单实现，如需高级功能，可以自由修改
 * 
 * 使用说明:
 * 
 * 在easyui.min.js之后导入本js
 * 
 * 代码案例:
 * 
 * $("#dg").datagrid('tooltip'); 所有列
 * 
 * $("#dg").datagrid('tooltip',['productid','listprice']); 指定列
 * 
 */
$.extend($.fn.datagrid.methods, gridTooltipOptions);

/**
 * Treegrid扩展方法tooltip 基于Easyui 1.3.3，可用于Easyui1.3.3+
 * 
 * 简单实现，如需高级功能，可以自由修改
 * 
 * 使用说明:
 * 
 * 在easyui.min.js之后导入本js
 * 
 * 代码案例:
 * 
 * $("#dg").treegrid('tooltip'); 所有列
 * 
 * $("#dg").treegrid('tooltip',['productid','listprice']); 指定列
 * 
 */
$.extend($.fn.treegrid.methods, gridTooltipOptions);

/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展validatebox，添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules, {
	eqPwd : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '密码不一致！'
	}
});

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展tree，使其可以获取实心节点
 */
$.extend($.fn.tree.methods, {
	getCheckedExt : function(jq) {// 获取checked节点(包括实心)
		var checked = $(jq).tree("getChecked");
		var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
		$.each(checkbox2, function() {
			var node = $.extend({}, $.data(this, "tree-node"), {
				target : this
			});
			checked.push(node);
		});
		return checked;
	},
	getSolidExt : function(jq) {// 获取实心节点
		var checked = [];
		var checkbox2 = $(jq).find("span.tree-checkbox2").parent();
		$.each(checkbox2, function() {
			var node = $.extend({}, $.data(this, "tree-node"), {
				target : this
			});
			checked.push(node);
		});
		return checked;
	},
	getLeafNodes: function(t){
		var leafs = [], nodes = $(t).find('.tree-node');
		$.each(nodes, function(){
			if($(t).tree('isLeaf', this)){
				var nd = $.extend({}, $(this).data('tree-node'), {target: this});
				leafs.push(nd);
			}
		});
		return leafs;
	}
});

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展tree，使其支持平滑数据格式
 */
$.fn.tree.defaults.loadFilter = function(data, parent) {
	var opt = $(this).data().tree.options;
	var idFiled, textFiled, parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};

/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展treegrid，使其支持平滑数据格式
 */
$.fn.treegrid.defaults.loadFilter = function(data, parentId) {
	var opt = $(this).data().treegrid.options;
	var idFiled, textFiled, parentField;
	if (opt.parentField) {
		idFiled = opt.idFiled || 'id';
		textFiled = opt.textFiled || 'text';
		parentField = opt.parentField;
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idFiled]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textFiled];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textFiled];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};

/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展combotree，使其支持平滑数据格式
 */
$.fn.combotree.defaults.loadFilter = $.fn.tree.defaults.loadFilter;

/**
 
 * 
 * @requires jQuery,EasyUI
 * 
 * 创建一个模式化的dialog
 * 
 * @returns $.modalDialog.handler 这个handler代表弹出的dialog句柄
 * 
 * @returns $.modalDialog.xxx 这个xxx是可以自己定义名称，主要用在弹窗关闭时，刷新某些对象的操作，可以将xxx这个对象预定义好
 */
$.modalDialog = function(options) {
	if ($.modalDialog.handler == undefined) {// 避免重复弹出
		var opts = $.extend({
			title : '',
			width : 840,
			height : 680,
			modal : true,
			onClose : function() {
				$.modalDialog.handler = undefined;
				$(this).dialog('destroy');
			},
			onOpen : function() {
				progress();
			},
			onLoad : function(){
				$(this).find(':text:visible:enabled:first').focus();
			}
		}, options);
		opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
		return $.modalDialog.handler = $('<div/>').dialog(opts);
	}
};

$.extend($.fn.datagrid.defaults.view,{
	onAfterRender : function(tag){//隐藏单行选择时头部的checkbox
		if($(tag).datagrid('options').singleSelect){
			$(tag).parent().find('.datagrid-header-check').children(':checkbox').hide();
		}
		/*无数据列表提示信息
		if(!$(tag).datagrid('options').norecode){
			var temd = $(tag).datagrid('getData');
			if(temd && temd.total == 0){
				var tid = $(tag).attr('id')+'-norecd',
				tpa = $(tag).datagrid('getPanel'),
				thd = tpa.find('.datagrid-view:first'),
				tho = thd.position(),
				tht = tho.top + thd.find('.datagrid-header:first').outerHeight();
				thl = thd.find('.datagrid-view2:first').length>0?thd.find('.datagrid-view1:first').outerWidth():0;
				if($('#'+tid).length==0){
					$('<div/>',{id:tid}).addClass('poa').appendTo(tpa);
				}
				$('#'+tid).html('本列表暂无数据').css({'top':tht+'px', 'left':(thl+5)+'px', 'display':'block'});
			}else{
				var tid = $(tag).attr('id')+'-norecd';
				$('#'+tid).hide();
			}
		}
		*/
	}
});

$.extend($.fn.draggable.defaults,{
	onBeforeDrag : function(){
		if($(this).find('iframe').length>0){
			var pbody = $(this).find('.dialog-content:first');
			if(pbody.children('.ifrmask').length==0){
				$('<div class="ifrmask" style="position:absolute;top:0;right:0;width:100%;height:100%;z-index:99999999;background:#fff;"></div>').css('opacity', '0').appendTo(pbody);
			}
		}
	}
});

$.extend($.fn.dialog.defaults,{
	onMove : function(t,l){
		var ifrm = $(this).find('.ifrmask');
		if(ifrm.length>0){
			ifrm.remove();
		}
		easyuiPanelOnMove(t, l);
	},
	iconCls: 'icon-slogo'
});

$.extend($.fn.window.defaults,{
	iconCls: 'icon-slogo'
});

/**
 * 以iframe的方式弹出窗口
 * 
 * @param opts
 * 
 */
$.ifrdialog =  function(opts){
	if($.ifrdialog.handler) return;
	var opts = $.extend({
		title: '',
		width: 600,
		height: 480,
		modal: true,
		onClose : function() {
			$.ifrdialog.ifr.attr('src', 'about:blank');
			$.ifrdialog.handler = undefined;
			$.ifrdialog.ifr = null;
			$(this).dialog('destroy');
		},
		onOpen : function() {
			progress();
		}
	}, opts||{});
	var ifr = opts.href;
	opts.href = null;
	$.ifrdialog.ifr = $('<iframe frameborder="no" style="border:none; position:absolute; width:100%; height:100%" src=""/>');
	$.ifrdialog.handler = $('<div/>').css('position','relative').append($.ifrdialog.ifr).dialog(opts);
	$.ifrdialog.ifr.attr('src', ifr);
	$.ifrdialog.ifr.bind('load', function(){
		closeProgress();
		$.ifrdialog.ifr[0].contentWindow.$(':text:visible:enabled:first').focus();
	});
	return $.ifrdialog.handler;
};

$.extend($.fn.datagrid.methods, {
	autoColfix: function(jq, calf){
		jq.each(function(i,e){
			var epa = $(e).datagrid('getPanel'), v2 = epa.find('.datagrid-view2:first'),
			bta = v2.children('.datagrid-body:first').children('table:first'),
			cfit = $(e).datagrid('options').fitColumns?$(e).datagrid('options').fitColumns:false,
			v2w = v2.outerWidth();
			if(v2w>bta.outerWidth()){
				$.extend($(e).datagrid('options'),{fitColumns: true});
				$(e).datagrid('resize');
			}else{
				$.extend($(e).datagrid('options'),{fitColumns: cfit});
				$(e).datagrid('resize');
			}
			calf && calf();
		});
		return jq;
	}
});