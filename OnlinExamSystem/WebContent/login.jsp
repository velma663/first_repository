<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style type="text/css">
    <!--@import url(static/css/login.css);-->
    </style>
  </head>
  <body>
    <span class="text-right">Welcome to login!</span>
    <img src="static/image/LOGO_Web_Login.png" style="width:180px;height:90px;position:absolute;left:176px;top:304px;" alt=""/>
    <span class="text-left">Online Exam System</span>
    <div class="rectangle_a">
        <div id="nouser" class="rectangle_b" style="display:none">
            <label class="rectangle_b_text_a" style="width:134px;">Username does not exist!</label>
        </div>
        <div id="incorrect" class="rectangle_b" style="display:none">
            <label class="rectangle_b_text_a" style="width:146px;">Login password is incorrect!</label>
        </div>
        <form action="login" method="post">
            <div class="div-user">
                <i class="icon" style="background-image:url(static/image/user.png);"></i>
                <input type="text" class="input" name="username" value="" style="top:58px" placeholder="Username"/>
            </div>
            <div class="div-password">
                <i class="icon" style="background-image:url(static/image/password.png);"></i>
                <input type="password" class="input" name="password" value="" style="top:114px" placeholder="Password"/>
            </div>
            <input class="submit" name="login" type="submit" value="Login"/>
        </form>
        <i class="icon_error" style="top:64px; display:none"></i>
        <i class="icon_error" style="top:119px; display:none"></i>
        <input class="i-check" name="rember" type="checkbox" value="" />
        <label class="label1">Remember me
        </label>
        <label class="label2">Forgot password?</label>

    </div>
    <div class="border1">
    </div>
    <span class="text-bottom">Copyright © 2019 Augmentum，Inc. All Rights Reserved.</span>

  </body>
</html>