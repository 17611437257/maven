<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2018/3/6
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-3.2.1/jquery-3.2.1.js"></script>
    <script src="../js/layui/layui.js"></script>
    <link rel="stylesheet" href="../js/layui/css/layui.css">
</head>
<body>
    <table id="stafftable" lay-filter="test" ></table>
</body>
    <script>
        $(function () {
            //展示表格数据
            layui.use('table', function(){
                var table = layui.table;
                //第一个实例
                table.render({
                    elem: '#stafftable'
                    ,height: 480
                    ,url: '../user/queryStaff.do' //数据接口
                    ,page: true //开启分页
                    ,cols: [[ //表头
                        {field: 'id', title: '编号', width:30,type:'checkbox'}
                        ,{field: 'staffname', title: '员工名称', width:100}
                        ,{field: 'staffage', title: '员工年龄', width:100}
                        ,{field: 'staffsex', title: '员工性别', width:100,
                            templet: function(d){
                                if(d.staffsex==1){
                                    return "男";
                                }
                                return "女";
                            }}
                        ,{field: 'staffinfo', title: '员工简介', width: 200}
                        ,{field: 'staffhobby', title: '员工爱好', width: 100,
                            templet: function(d){
                                var staffhobby="";
                                var arr= d.staffhobby.split(",")
                                for(var i=0;i<arr.length;i++){
                                    switch (arr[i]){
                                        case '1':staffhobby+=","+"写作";break;
                                        case '2':staffhobby+=","+"阅读";break;
                                        case '3':staffhobby+=","+"发呆";break;
                                    }
                                }
                                return staffhobby.substring(1);
                            }
                        }
                        ,{field: 'staffeducation', title: '员工学历', width: 100,
                            templet: function(d){
                                if(d.staffeducation==1){
                                    return "初中";
                                }else if(d.staffeducation==2){
                                    return "高中";
                                } else if(d.staffeducation==3){
                                    return "大专"
                                }
                                return "本科";
                            }
                        }
                        ,{field: 'createtime', title: '入职日期', width: 130}
                        ,{field: 'xx', title: '操作',align:'center',
                            templet: function(d){
                                return '  <button class="layui-btn" onclick="delstaff('+d.id+')" >\n' +
                                    '            <i class="layui-icon">&#xe640;</i> 删除\n' +
                                    '        </button>\n' +
                                    '        <button class="layui-btn" onclick="updatestaff('+d.id+')">\n' +
                                    '            <i class="layui-icon">&#xe642;</i> 修改\n' +
                                    '        </button>';
                            }}
                        ,{field: 'staffimg', title: '封面', width: 200,
                            templet: function(d){
                                return "<img width='300px' height='300px' src='"+d.staffimg+"' alt='图片不存在'>";
                            }
                        }
                    ]]
                });

            });
        })
    </script>
</html>
