layui.use([ 'upload', 'table' ], function() {
	var $ = layui.jquery, upload = layui.upload;
	var table = layui.table;
	upload.render({
		elem : '#test8',
		url : '/LY/admin/addVideo',
		auto : false,
		accept : 'video',
		size : 512000 // 限制文件大小，单位 KB
		,
		data : {
			v_content : function() {
				return $("#add_v_content").val();
			}
		},
		bindAction : '#test9',
		done : function(res) {
			table.reload("videotab");
			layer.msg('上传成功');
			console.log(res)
		}
	});
})

function videodel(v_code) {
	layer.msg("确认提交？", {
		time : 5000, // 20s后自动关闭
		btn : [ "确认", "取消" ],
		area : [ '200px', '100px' ],
		yes : function() {
			var table = layui.table;
			$.post("/LY/admin/delViddeoByV_code", {
				v_code : v_code,
			}, function(res) {
				if (res > 0) {
					table.reload("videotab");
					layer.msg("修改成功")
					close();

				} else {
					table.reload("videotab");
					layer.msg("修改失败");
					close();
				}
			}, "json")
		}
	});

}

function videoedit(v_code) {
	layer.open({
		type : 1,
		offset : 'auto',
		area : [ '400px', '300px' ],
		content : $("#editvideo"),
		btn : [ "确定", "取消" ],
		yes : function() {
			layer.msg("确认提交？", {
				time : 5000, // 20s后自动关闭
				btn : [ "确认", "取消" ],
				area : [ '200px', '100px' ],
				yes : function() {
					var table = layui.table;
					$.post("/LY/admin/updateV_contentByV_code", {
						v_code : v_code,
						v_content : $("#edit_v_content").val()
					}, function(res) {
						if (res > 0) {
							table.reload("videotab");
							layer.msg("修改成功")
							close();

						} else {
							table.reload("videotab");
							layer.msg("修改失败");
							close();
						}
					}, "json")
				}
			});
		},
		btn2 : function() {
			close();
		}
	});
}

function addscenery() {
	layer.open({
		type : 1,
		offset : 'auto',
		area : [ '610px', '600px' ],
		content : $("#addvideo"),

	});
}
function close() {
	layui.use([ "layer", "form", "table" ], function() {
		layer.closeAll();
	})

}
layui.use([ 'form', 'laydate' ], function() {
	var form = layui.form;
	$ = layui.jquery;
	laydate = layui.laydate;

	laydate.render({ // 创建时间选择框
		elem : '#search_v_time' // 指定元素
	});

});

$(function() {
	init();
})

function init() {
	layui
			.use(
					'table',
					function() {
						var table = layui.table;
						var $ = layui.jquery;
						var form = layui.form;
						table
								.render({
									elem : '#test',
									method : 'post',
									url : '/LY/admin/getVideo',
									loading : true,
									page : true,
									toolbar : "#toolbar",
									where : {
										v_code : $("#scener_v_code").val(),
										v_time : $("#search_v_time").val(),
										state : $("#scenery_v_state").val()
									},
									id : 'videotab',
									cols : [ [
											// {field:'id', width:80, title:
											// 'ID', sort: true},
											{
												field : 'v_code',
												title : '编号',
												width : 140
											},
											{
												field : 'v_img',
												title : '音频',
												width : 280,
												templet : "#videotemplet"
											},
											{
												field : 'v_content',
												title : '视频简介',
												width : 220,
												templet : "#sceneryv_content"
											},
											{
												field : 'v_state',
												title : '是否推荐',
												templet : '#istuijiantemplet',
												width : 90
											},
											{
												field : 'v_time',
												title : '上传时间',
												width : 120
											},
											{
												field : "asd",
												title : "操作",
												width : 190,
												templet : function(d) {
													return "<a class='layui-btn layui-btn-radius layui-btn-normal'onclick='videoedit("
															+ d.v_code
															+ ")' >编辑</a> <a class='layui-btn layui-btn-radius layui-btn-normal'onclick='videodel("
															+ d.v_code
															+ ")' >删除</a>"
												}
											} ] ],
									limit : 5,
									limits : [ 5, 10, 20, 50 ]
								});

						form.on("switch(switchptstatus)", function(data) {
							var selectIfKey = data.othis;
							var parentTr = selectIfKey.parents("tr");
							var v_code = $(parentTr).find("td:eq(0)").find(
									".layui-table-cell").text();
							if (data.elem.checked == true) {

								$.post("/LY/admin/editVideoState", {
									v_code : v_code,
									v_state : 1
								}, function(res) {
									if (res > 0) {
										layer.msg("已设置为推荐");

									} else {
										layer.msg("处理异常");
									}

								}, "json")
							} else {
								$.post("/LY/admin/editVideoState", {
									v_code : v_code,
									v_state : 2
								}, function(res) {
									if (res > 0) {
										// table.reload("imgTab");
										layer.msg("已取消");
									} else {
										layer.msg("取消失败.");

									}
								}, "json")
							}
						});
					});
}