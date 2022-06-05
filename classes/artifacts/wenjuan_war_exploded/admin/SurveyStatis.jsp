<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.survey.dao.DAOFactory"%>
<%@ page import="com.survey.dto.Survey" %>
<%@ page import="com.survey.dao.SurveyDAO" %>
<%@ page import="com.survey.pager.*" %>
<jsp:useBean id="pageConfig" class="com.survey.pager.PageConfig"></jsp:useBean>
<jsp:setProperty property="request" name="pageConfig" value="<%=request %>"/>

<%
	SurveyDAO dao=DAOFactory.getSurveyDAO();
	PageControl pc=new PageControl(dao,pageConfig,"SurveyStatis.jsp");
		pc.setSizePage(20);
	 
	List<Survey> sList=pc.getRecord();
	
	 

 %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    <title>My JSP 'SurveyAudi.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 
	<link rel="stylesheet" type="text/css" href="../Css/Admin.css">
	 <script language="JavaScript" src="../Js/Func.js"></script>
	<script language="javascript">window.onload=tableFix;</script>
<script type="text/javascript">
function ZeroFill(sid){
if(confirm("确定要将收集到的信息归零吗？")==true)
window.location="../servlet/StatisManage.do?op=ZeroFill&sid="+sid;
}
</script>
<script type="text/javascript">
var words="<%=request.getParameter("words") %>";
if (words!='null' && words!='') {
	alert(words);
}
</script>

  </head>
  
  <body>
  <div class=nav><a href=admin_main.jsp>桌面</a>»问卷列表
<hr>
</div>  
 <table class=table cellspacing="0" cellpadding="0" align="center">
<tbody><tr>
<th width=7%>编号</th>
<th width=20%>问卷名称</th>
<th width=15%>发起者 <br></th>
<th>创建时间 <br></th>
<th>结束日期<br></th>
<th width=7%>审核 <br></th>
<th>操作 <br></th></tr>
<%
for(Survey survey:sList){
 %>
<tr>
<td><%=survey.getSId() %></td>
<td><%=survey.getSName() %></td>
<td><%=survey.getSAuthor() %></td>
<td><%=survey.getSCreateDate() %></td>
<td><%=survey.getSExpireDate() %></td>
<td><%=survey.getSIsAudited()?"<img src='images/on.gif'>":"<img src='images/off.gif'>" %></td>
<td><a href=../SurveyShow.jsp?sid=<%=survey.getSId() %> target="_blank">预览</a>|<a href=SurveyStatisShow.jsp?sid=<%=survey.getSId() %>>查看统计</a>|<a href=ShowSheets.jsp?sid=<%=survey.getSId() %>>查看答卷</a>|<a href='javascript:ZeroFill(<%=survey.getSId() %>)'>结果清零</a></td></tr>
 <%} %>
<tr> <td colspan=7 align="right"><%=pc.getCurrentPageHTML() %><%=pc.getCountPageHTML() %>|<%=pc.getFirstPageHTML() %>|<%=pc.getPageUpHTML() %>|<%=pc.getPageDownHTML() %>|<%=pc.getLastPageHTML() %></td></tr>
</tbody></table></body>
</html>
