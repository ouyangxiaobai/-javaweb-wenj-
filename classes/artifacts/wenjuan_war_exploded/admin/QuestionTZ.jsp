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
<script type="text/javascript">
function showDiv(id,left,top){
	 
	var obj=document.getElementById(id);
	obj.style.position="absolute";
	obj.style.left=left+150;
	obj.style.top=top;
	obj.style.display="block";
    var chkboxes=document.getElementsByTagName("input");
    for(i=0;i<chkboxes.length;i++){
    
    	if(chkboxes[i].getAttribute("type")=="checkbox"&&chkboxes[i].checked==true)
    	return;
    }
	obj.style.display="none";
}
function setVal(top){
	//alert(top);
	var chkboxes=document.getElementsByTagName("input");
    for(i=0;i<chkboxes.length;i++){
    	//alert(chkboxes[i].offsetTop);
    	if(chkboxes[i].getAttribute("type")=="checkbox"&&chkboxes[i].offsetTop==top)
    	{
    		chkboxes[i].value=document.getElementById("sel_tz").value;
    	//	alert(chkboxes[i].value);
    		break;
    	}
    }
    
} 
</script>

 
</head>
  
  <body>
    
 
<table class=table cellspacing="0" cellpadding="0">
<tr><th>设置跳转</th><th></th><th></th></tr>
 
</table>

<div >
<form name="form1" action="../servlet/QuestionManage.do?op=setTZ&qid=<%=request.getParameter("qid") %>" method="post">
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

out.println("<input type=checkbox name=check_tz"+i+" id=check_tz"+i+" value=on onclick=\"javascript:showDiv('selector',this.offsetLeft,this.offsetTop);\">设置跳转    <span style='color:red' id=span_old_tz"+i+++"></span>");
//value=on 设置默认值，为不同浏览器

}
%>

</ul>
<input type=hidden name=tz_count value=<%=i %>>
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
<div id=selector style='display:none'>→
<select id=sel_tz onchange="setVal(document.getElementById('selector').offsetTop)">
<option>---请选择---</option>
<% 
List<Question> qlist=dao.listQuestions("s_id="+Long.valueOf(request.getParameter("sid"))+" and q_id>"+Long.valueOf(request.getParameter("qid")));

for(Question q:qlist)
out.println("<option value="+q.getQId()+" >"+q.getQId()+":"+q.getQHead()+"</option>");
%>
</select>
</div> 


<%
String jdtz=question.getQJdtz();
if(jdtz==null)
	return;
String [] sz_jdtz=jdtz.split("&");
for(int j=0;j<sz_jdtz.length;j++){
	if(!"over".equals(sz_jdtz[j])&&!"null".equals(sz_jdtz[j])){
		
		out.println("<script>document.getElementById('span_old_tz"+j+"').innerHTML='to "+sz_jdtz[j]+"';</script>");
		out.println("<script>document.forms[0].check_tz"+j+".click();</script>");
		out.println("<script>document.forms[0].check_tz"+j+".value='"+sz_jdtz[j]+"';</script>");
	}
}
 %>



 
</body>
</html>
