<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.1.1.js"></script>

    <script>
        window.onload = function (){
            $("#btn").click(function (){
                $.post("${pageContext.request.contextPath}/a2", function (data){
                    //console.log(data);

                    let html="";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>"
                    }
                    // 获取body中的#content，将js中的html变量导入进去
                    $("#content").html(html);
                });
            })
        }


    </script>
</head>
<body>

<input type="button" value="加载数据" id="btn">
<table>
    <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
    </tr>
    <tbody id="content">
        <%--数据: 后台--%>
    </tbody>
</table>

</body>
</html>
