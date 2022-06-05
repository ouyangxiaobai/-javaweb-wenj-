<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.survey.dao.*" %>
<%@ page import="com.survey.dto.*" %>
 
 
<%
ConfigDAO cdao=DAOFactory.getConfigDAO();
Config cfg=cdao.findConfig();

 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="keywords" content=""/>
<meta http-equiv="description" content=""/>
<link rel="stylesheet" href="Css/Style.css" type="text/css" />
<link rel="stylesheet" href="Css/Admin.css" type="text/css" />
<script language="JavaScript" src="Js/Func.js"></script>
<script language="javascript">window.onload=tableFix;</script>
<script>
function ChkCode(){
	var sid=document.getElementById("sid");
	if (sid.value=="" || sid.value==null){ 
		alert("请输入问卷编号！");
		return false;
	}
	if (isNaN(sid.value)){
		alert("编号应为数字！");	
		return false;
	}
}

</script>


<title><%=cfg.getCSiteName() %>---访问私有问卷</title>
</head>
<body>
<script src="Js/AC_RunActiveContent.js" type="text/javascript"></script>
<div id="head">
</div>

<div id="banner">
<div class="text" >
<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="Survey_list.jsp">问卷列表</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="Survey_Code.jsp" target="_self">访问私有问卷</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 
</div>
</div>

<div id="box">
<div class="title">访问私有问卷</div>
<div class="boxContent">
<br/> 
<form action="SurveyShow.jsp" method=post name=form1 onsubmit="return ChkCode()">
请输入由问卷发起单位提供的问卷编号 <input type="text" id="sid" name=sid />  
<input type="submit" name="submit1" value="提交"  />
<br/>
<br/>
<br/>
</form>
</div>
</div><!--box end-->



<div id="bottom">
<%=cfg.getCSiteName() %><br/>
<%=cfg.getCopyright() %> 
</div><!--bottom end-->
</body>

</html>
