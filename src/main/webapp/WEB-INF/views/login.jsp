<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("basePath",basePath);
%>
<c:set var="basePath" value="${basePath}" />
<!DOCTYPE HTML>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>简洁时尚的用户登录界面设计效果|DEMO_jQuery之家-自由分享jQuery、html5、css3的插件库</title>
	<link rel="stylesheet" type="text/css" href="/css/htmleaf-demo.css">
	<link rel="stylesheet" href="/css/loginStyle.css">
	<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/js/md5.min.js"></script>
	<script type="text/javascript" src="/js/regular.js"></script>
	<script type="text/javascript" src="/js/brine-sites.js"></script>
</head>
<body>
	<div class="htmleaf-container">
		<div class="cont_principal">
			<header class="htmleaf-header">
				<h1>用户登录界面设计效果 <span>The effect of the user login interface design</span></h1>
				<div class="error_msg">
					该帐号不存在(The account does not exist.)
				</div>
			</header>
		  <div class="cont_join  cont_join_form_act">
		   <%-- <div class="cont_letras">
		      <p>LET 'S</p>
		      <p>GET</p>
		      <p>LOST</p>
		    </div>--%>

		    <div class="cont_form_join">
		      <h2>JOIN</h2>

		      <p>用户名:</p>    
		      <input type="text" name="username" class="input_text" />

		      <p>密　码:</p>    
		      <input type="password" name="password" class="input_text" />

		      <p class="margin-t30 display_n"><span class="float-lt codetext display_n">验证码:</span>
				<div id="codediv" class="float-lt display_n">
					<input type="text" maxlength="4"  class="input_text inputVerify"/>
				</div>
				<div id="srcdiv" class="float-lt display_n">
					<img id="imgVerify" src="" alt="更换验证码"  codeName="${basePath}"  height="40" width="85" onclick="getVerify()">
			    </div>
				<div class="jzmima display_n"><input type="checkbox" id="jzmy"><span>&nbsp;记住我</span></div>
			  </p>
		    </div>
		 <%--   <div class="cont_join_form_finish">
		      <h2>Finish <i class="material-icons">&#xE5CA;</i></h2>  
		    </div>--%>
		    <div class="cont_btn_join">
		     <%-- <a href="#" onclick='join_1()'>登录</a>--%>
				<div id="sub">登录</div>
		    </div>
		  </div>
		</div>
	</div>
	
	<script src="/js/login.js"></script>
</body>
</html>