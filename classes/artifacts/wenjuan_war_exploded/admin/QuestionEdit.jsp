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
 
function showType(typecode){ 
//typecode: dx--单选 ;fx--复选;dxjk--单选加文本框;fxjk--复选加文本框;wd-问答题
document.getElementById("qEditor").innerHTML=document.getElementById(typecode).innerHTML;
}
 
</script>

 
</head>
  
  <body>
    
 
<table class=table cellspacing="0" cellpadding="0">
<tr><th>编辑题目</th><th></th><th></th></tr>
<tr><td>选择题型：</td><td><input name="Question_type" id="qtype_dx" type="radio" value="1" onClick="showType('dx');">单选题 <input name="Question_type" id=qtype_fx type="radio" value="2" onClick="showType('fx');">多选题  <input name="Question_type" id=qtype_dxjk type="radio" value="3" onClick="showType('dxjk');">带文字输入的单选题 <input name="Question_type" id=qtype_fxjk type="radio" value="4" onClick="showType('fxjk');">带文字输入的多选题 <input name="Question_type" id=qtype_wd type="radio" value="5" onClick="showType('wd');"> 问答题</td><td></td></tr>
<tr><td></td><td></td><td></td></tr>
</table>

<div id=qEditor></div>

<div id=dx style="display: none">
<form name="form1" action="../servlet/QuestionManage.do?op=EditQuestion&type=1&qid=<%=request.getParameter("qid") %>" method="post" onSubmit="return SubQuestion();">
<input type="hidden" value=<%=request.getParameter("sid") %>  name="sid">
<input type="hidden" value="" name="qBody" id="qBody">
<input type="hidden" value="" name=qResult id="qResult">
问题：<input name="qHead" type="text" size="40">
<br/><br/>
备选项：
<ul type="1" id="ulAnswer">
<li><input type="radio" ><input type="text" name="Answer"></li>
</ul>
<div id="button">
<input type="button" name="MoreAnswer1" value="增加选项" onClick="MoreAnswer('DX');">
<input type="button" name="LessAnswer1" value="减少选项" onClick="LessAnswer('DX');">
<input type="submit" value="保存修改"><input type="button"  onclick="javascript:history.back();" value="返回">
</div>
</form>
</div>

<div id=fx style="display: none">
<form name="form1" action="../servlet/QuestionManage.do?op=EditQuestion&type=2&qid=<%=request.getParameter("qid") %>" method="post" onSubmit="return SubQuestion();">
<input type="hidden" value=<%=request.getParameter("sid") %>  name="sid">
<input type="hidden" value="" name="qBody" id="qBody">
<input type="hidden" value="" name=qResult id="qResult">
问题：<input name="qHead" type="text" size="40">
<br/><br/>
备选项：
<ul type="1" id="ulAnswer">
<li><input type="checkbox"><input type="text" name="Answer"></li>
<li><input type="checkbox"><input type="text" name="Answer"></li>
<li><input type="checkbox"><input type="text" name="Answer"></li>
<li><input type="checkbox"><input type="text" name="Answer"></li>
</ul>
<div id="button">
<input type="button" name="MoreAnswer1" value="增加选项" onClick="MoreAnswer('FX');">
<input type="button" name="LessAnswer1" value="减少选项" onClick="LessAnswer('FX');">
<input type="submit" value="保存修改"><input type="button"  onclick="javascript:history.back();" value="返回">
</div>
</form>
 </div>


<div id=dxjk style="display: none">
<form name="form1" action="../servlet/QuestionManage.do?op=EditQuestion&type=3&qid=<%=request.getParameter("qid") %>" method="post" onSubmit="return SubQuestion();">
<input type="hidden" value=<%=request.getParameter("sid") %>  name="sid">
<input type="hidden" value="" name="qBody" id="qBody">
<input type="hidden" value="" name=qResult id="qResult">
问题：<input name="qHead" type="text" size="40">
<br/><br/>
备选项：
<ul type="1" id="ulAnswer">
<li><input type=radio ><input type="text" name="Answer"></li>
<li><input type=radio ><input type="text" name="Answer"></li>
<li><input type=radio ><input type="text" name="Answer"></li>
<li><input type=radio ><input type="text" name="Answer"><input type="text" name="Answer_2" readonly="true" value="用户在此框输入自定义文本"></li>
</ul>
<div id="button">
<input type="button" name="MoreAnswer1" value="增加选项" onClick="MoreAnswer('DXJK');">
<input type="button" name="LessAnswer1" value="减少选项" onClick="LessAnswer('DXJK');">
<input type="submit" value="保存修改"><input type="button"  onclick="javascript:history.back();" value="返回">
</div>
</form>
 </div>

<div id=fxjk style="display: none">
<form name="form1" action="../servlet/QuestionManage.do?op=EditQuestion&type=4&qid=<%=request.getParameter("qid") %>" method="post" onSubmit="return SubQuestion();">
<input type="hidden" value=<%=request.getParameter("sid") %>  name="sid">
<input type="hidden" value="" name="qBody" id="qBody">
<input type="hidden" value="" name=qResult id="qResult">
问题：<input name="qHead" type="text" size="40">
<br/><br/>
备选项：
<ul type="1" id="ulAnswer">
<li><input type=checkbox><input type="text" name="Answer"></li>
<li><input type=checkbox><input type="text" name="Answer"></li>
<li><input type=checkbox><input type="text" name="Answer"></li>
<li><input type=checkbox><input type="text" name="Answer"><input type="text" name="Answer_2" readonly="true" value="用户在此框输入自定义文本"></li>
</ul>
<div id="button">
<input type="button" name="MoreAnswer1" value="增加选项" onClick="MoreAnswer('FXJK');">
<input type="button" name="LessAnswer1" value="减少选项" onClick="LessAnswer('FXJK');">
<input type="submit" value="保存修改"> <input type="button"  onclick="javascript:history.back();" value="返回">
</div>
</form>
 </div>

<div id=wd style="display: none">
<form name="form1" action="../servlet/QuestionManage.do?op=EditQuestion&type=5&qid=<%=request.getParameter("qid") %>" method="post" onSubmit="return SubQuestion();">
<input type="hidden" value=<%=request.getParameter("sid") %>  name="sid">
<input type="hidden" value="" name="qBody" id="qBody">
<input type="hidden" value="" name=qResult id="qResult">
问题：<br/><input name="qHead" type="text" size="40">
<br/><br/>
回答框：<br/>
<textarea rows="3" readonly="readonly"></textarea>
<br/><br/>
<div id="button">
<input type="submit" value="保存修改"><input type="button"  onclick="javascript:history.back();" value="返回">
</div>
</form>

</div>

<script type="text/javascript">
 
switch(<%=question.getQType() %>){
case 1: document.getElementById("qtype_dx").click();
document.forms[0].qHead.value="<%=question.getQHead().replace("\'","\\'").replace("\"","\\\"") %>";
var qBodys="<%=question.getQBody().replace("\'","\\'").replace("\"","\\\"") %>";
var qBody=qBodys.split("&$$&");
//alert(qBody.length);
document.getElementById("ulAnswer").innerHTML="";
for(i=0;i<qBody.length;i++){
	MoreAnswer("DX");
} 
for(i=0;i<qBody.length;i++){
var answer=document.forms[0].Answer;
answer[i].value=qBody[i];
}
break;
case 2: document.getElementById("qtype_fx").click();
document.forms[0].qHead.value="<%=question.getQHead().replace("\'","\\'").replace("\"","\\\"") %>";
var qBodys="<%=question.getQBody().replace("\'","\\'").replace("\"","\\\"") %>";
var qBody=qBodys.split("&$$&");
//alert(qBody.length);
document.getElementById("ulAnswer").innerHTML="";
for(i=0;i<qBody.length;i++){
	MoreAnswer("FX");
} 
for(i=0;i<qBody.length;i++){
var answer=document.forms[0].Answer;
answer[i].value=qBody[i];
}
break;
case 3: document.getElementById("qtype_dxjk").click();
document.forms[0].qHead.value="<%=question.getQHead().replace("\'","\\'").replace("\"","\\\"") %>";
var qBodys="<%=question.getQBody().replace("\'","\\'").replace("\"","\\\"") %>";
var qBody=qBodys.split("&$$&");
//alert(qBody.length);
document.getElementById("ulAnswer").innerHTML="";
for(i=0;i<qBody.length-1;i++){
	MoreAnswer("DXJK");
} 
for(i=0;i<qBody.length;i++){
var answer=document.forms[0].Answer;
answer[i].value=qBody[i];
}
break;
case 4: document.getElementById("qtype_fxjk").click();
document.forms[0].qHead.value="<%=question.getQHead().replace("\'","\\'").replace("\"","\\\"") %>";
var qBodys="<%=question.getQBody().replace("\'","\\'").replace("\"","\\\"") %>";
var qBody=qBodys.split("&$$&");
//alert(qBody.length);
document.getElementById("ulAnswer").innerHTML="";
for(i=0;i<qBody.length-1;i++){
	MoreAnswer("FXJK");
} 
for(i=0;i<qBody.length;i++){
var answer=document.forms[0].Answer;
answer[i].value=qBody[i];
}
break;
case 5: document.getElementById("qtype_wd").click();
document.forms[0].qHead.value="<%=question.getQHead().replace("\'","\\'").replace("\"","\\\"") %>";
break;
default: alert("题目类型错误！");
}
</script>
</body>
</html>
