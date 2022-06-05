<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>My JSP 'OpResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="../Css/Admin.css">
	 
  </head>
  <%
  String operation=request.getParameter("op");
  String result=request.getParameter("ret");

  if("ShowSurvey".equals(operation)){
  		if("true".equals(result)){
  			
  			out.print("<script>alert('操作已成功！');window.location='index.jsp';</script>");
  			 
  			}
  		else
  			out.print("问卷处理操作失败，请联系管理员！");

  }else if("default".equals(operation)){
	  if("true".equals(result))
		  out.print(request.getParameter("words"));
	  else
		  out.print(request.getParameter("words"));
  }
  
   %>
  <body>&nbsp;<br>
  </body>
</html>
