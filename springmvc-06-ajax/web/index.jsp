<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jquery导入后测试ajax请求</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.1.1.js"></script>

    <script>
      function postTest(){
        $.post({
          url:"${pageContext.request.contextPath}/a1",
          data:{"name":$("#username").val()},
          success:function (data,status){
            alert(data);
            console.log("data="+data);
            console.log("status="+status);//200 300 400 500
          },
          error:function () {
            
          }
        })
      }

    </script>
  </head>
  <body>

  用户名:
  <input type="text" id="username" onblur="postTest()">

  <hr>
  <table>
    <tr>
      <td><a href="${pageContext.request.contextPath}/index.jsp">/index.jsp</a></td>
      <td>失去焦点的时候，发起一个请求到后台</td>
    </tr>
    <tr>
      <td><a href="${pageContext.request.contextPath}/index2.jsp">/index2.jsp</a></td>
      <td>ajax异步加载列表</td>
    </tr>
    <tr>
      <td><a href="${pageContext.request.contextPath}/a2">/a2</a></td>
      <td>后台数据源</td>
    </tr>
    <tr>
      <td><a href="${pageContext.request.contextPath}/index3.jsp">/index3.jsp</a></td>
      <td>ajax表单输入框提示</td>
    </tr>
  </table>

  </body>
</html>
