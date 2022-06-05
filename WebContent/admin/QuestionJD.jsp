<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.survey.dao.DAOFactory"%>
<%@ page import="com.survey.dto.Question" %>
<%@ page import="com.survey.dao.QuestionDAO" %>
 
<%
	QuestionDAO dao=DAOFactory.getQuestionDAO();
	Question question=dao.findQuestion(Long.valueOf(request.getParameter("qid")));
	 
 %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     
    <title>My JSP 'SurveyAudi.jsp' starting page</title>
 
	<link rel="stylesheet" type="text/css" href="../Css/Admin.css">
<script language="JavaScript" src="../Js/Func.js"></script>
<script language="javascript">window.onload=tableFix;</script>
<script language="JavaScript" src="../Js/QuestAdd.js"></script>


 
</head>
  
  <body>
    
 
<table class=table cellspacing="0" cellpadding="0">
<tr><th>设置截断</th><th></th><th></th></tr>
 
</table>

<div >
<form name="form1" action="../servlet/QuestionManage.do?op=setJD&qid=<%=request.getParameter("qid") %>" method="post">
<input type="hidden" value=<%=request.getParameter("sid") %>  name="sid">
 
问题：<input name="qHead" type="text" size="40" value="<%=question.getQHead() %>" readonly>
<br/><br/>
备选项：
<ul type="1" id="ulAnswer">
<%
String bodys=question.getQBody();
String [] body=bodys.split("&\\$\\$&");
int i=0;
for(String s:body){
out.println("<li><input type=\"text\" name=\"Answer\" value=\""+s+"\" readonly><span>&nbsp;&nbsp;&nbsp;</span>");
if(question.getQType()!=5)
out.println("<input type=checkbox name=check_jd"+i+++" value=on>设置截断</li>");
else
out.println("<font color=red>问答题不能设置截断！</font></li>");
}
%>

</ul>
<input type=hidden name=jd_count value=<%=i %>>
<div id="button">

<input type="submit" value="保存修改"><input type="button"  onclick="javascript:history.back();" value="返回">
</div>
</form>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
提示：设置截断跳转后，请勿再执行“编辑题目”操作，否则本题的截断跳转设置将失效，需重新设置。 

<%
String jdtz=question.getQJdtz();
if(jdtz==null)
	return;
String [] sz_jdtz=jdtz.split("&");
for(int j=0;j<sz_jdtz.length;j++){
	if("over".equals(sz_jdtz[j])){
		out.println("<script>document.forms[0].check_jd"+j+".click();</script>");
	}
}
 %>
</body>
</html>
