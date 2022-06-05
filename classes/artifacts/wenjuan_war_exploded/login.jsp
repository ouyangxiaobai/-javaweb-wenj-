<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.survey.dao.*" %>
<%@ page import="com.survey.dto.*" %>
<%
String username=request.getParameter("username");
if(username!=null&&!"".equals(username)){
String pwd=request.getParameter("pwd");
AdminDAO dao=DAOFactory.getAdminDAO();
boolean ret=dao.checkPwd(username,pwd);
if(ret==true){
	Admin admin=dao.findAdmin(username);
	session.setAttribute("username",username.toLowerCase());
	
	session.setAttribute("aid",admin.getA_id());
	response.sendRedirect("admin/admin_index.jsp");
}else
 response.sendRedirect("login.jsp");
	
}
 %>
<html>
<head>
<title>管理员登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script language="JavaScript" src="Js/Func.js"></script>
<script language="JavaScript" src="Js/prototype.js"></script> 
<link rel="stylesheet" href="Css/Admin.css" type="text/css" />
 <script type="text/javascript">
 if(window.name!=""&&window.name!=null)
	window.parent.location="login.jsp";
 
 </script>
</head>
<body>
 
 
<div id="admin_surveyAdd_main">
<form name="from1" action="login.jsp" method="post" >

<table width="585" border="0" cellspacing="0" align=center cellpadding="0" class="table">
  <tr>
  	
    <td colspan=2 align=center><b>管理员登录</b></td>
    
    
  </tr>
  <tr align=center>

    <td>用户名:<input name="username" type="text" size="30"></td>
    
  </tr>
  <tr align=center>

    
    <td>密 &nbsp;&nbsp;码:<input name="pwd" id=pwd type="password" size="30"></td>
    
  </tr>

  
  <tr align=center>
 
    
    <td>
	<div id="button">
	<input type="submit" name="submit" value="登录"><input type="reset" name="reset1" value="取消">
	</div>	</td>
   
  </tr>
</table>  
</form>
</div>
<div id="admin_surveyAdd_bottom">
</div>
</body>
</html>