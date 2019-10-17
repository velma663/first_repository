<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<script type="text/javascript">
    function quit(){
        var mymessage=confirm("确定退出系统吗？")
        if(mymessage==true){
            window.location="login.jsp";
        }
    }
    
</script>

<head>
<meta charset="UTF-8">
<style type="text/css">
<!--
@import url(static/css/login_success.css);
-->
</style>
<title>Insert title here</title>
</head>

<body>
    <div class="rectangle_a">
        <p style="font-size:30px;font-color:#FFFFFF">登陆成功</p>
        <label class="label_out" onclick="quit()">logout</label>>
    </div>
</body>
</html>