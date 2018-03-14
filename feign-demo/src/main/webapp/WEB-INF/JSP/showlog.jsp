<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2018/3/6
  Time: 21:12
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
    <table id="logtable" lay-filter="test" ></table>
</body>
    <script>
        $(function () {
            //展示表格数据
            layui.use('table', function(){
                var table = layui.table;
                //第一个实例
                table.render({
                    elem: '#logtable'
                    ,height: 480
                    ,url: '../user/queryLog.do' //数据接口
                    ,page: true //开启分页
                    ,cols: [[ //表头
                        {field: 'id', title: '编号', width:30,type:'checkbox'}
                        ,{field: 'ip', title: 'ip', width:170}
                        ,{field: 'ipaddress', title: 'ip所属地', width:100}
                        ,{field: 'status', title: '用户状态', width:100,}
                        ,{field: 'username', title: '用户名称', width: 100}
                        ,{field: 'logintime', title: '登录时间', width: 150}

                    ]]
                });

            });
        })
    </script>
</html>
