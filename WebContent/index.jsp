<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.survey.dao.*" %>
<%@ page import="com.survey.dto.*" %>
<%
ConfigDAO cdao=DAOFactory.getConfigDAO();
Config cfg=cdao.findConfig();

SurveyDAO sdao=DAOFactory.getSurveyDAO();
List<Survey> slist=sdao.listVisitableSurvey();
List<Survey> shlist=sdao.listVisitableSurvey(OrderConst.UsehitsDesc);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="keywords" content=""/>
<meta http-equiv="description" content=""/>
<link rel="stylesheet" href="Css/Style.css" type="text/css" />
 <link rel="stylesheet" href="Css/Admin.css" type="text/css" />
<title><%=cfg.getCSiteName() %>---首页</title>
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
<a href="admin/admin_index.jsp" target="_blank">后台管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
</div>

<div id="main" class="middle">
<div id="main_1">
<div class="title">最新问卷</div>
<div class="head_new_flash">
<script type='text/javascript'>
var imgUrl = new Array();
var imgtext = new Array();
var imgLink = new Array();
<%
int k=0;
for(Survey s:slist){
	if(s.getSImg()!=null && (!"".equals(s.getSImg()))&&s.getSImg().endsWith(".jpg")){
		out.println("imgUrl["+k+"]='UploadImg/"+s.getSImg()+"';");
		out.println("imgtext["+k+"]='"+s.getSName()+"';");
		out.println("imgLink["+k+"]='SurveyShow.jsp?sid="+s.getSId()+"';");
		k++;
		
	}
	
}


%>


var pics=imgUrl[0];
var links=imgLink[0];
var texts=imgtext[0];
for(var i=1;i<imgUrl.length;i++){
	pics+='|'+imgUrl[i];
	links+='|'+imgLink[i];
	texts+='|'+imgtext[i];
}
var focus_width=250;
var focus_height=188;
var text_height=22;
var swf_height = focus_height+text_height;
document.write('<object data="Flash/rollpic.swf" type="application/x-shockwave-flash" width="'+ focus_width +'" height="'+ swf_height +'">');
document.write('<param name="movie" value="Flash/rollpic.swf" /><param name="quality" value="high" /><param name="bgcolor" value="#F0F0F0">');
document.write('<param name="menu" value="false"><param name=wmode value="opaque">');
document.write('<param name="FlashVars" value="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'">');
//document.write('<embed src="Flash/rollpic.swf" wmode="opaque" FlashVars="pics='+pics+'&links='+links+'&texts='+texts+'&borderwidth='+focus_width+'&borderheight='+focus_height+'&textheight='+text_height+'" menu="false" bgcolor="#F0F0F0" quality="high" width="'+ focus_width +'" height="'+ focus_height +'" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />');
document.write('</object>');
</script>

</div>
<div class="head_new_list">
<ul>
<% 
int i=0;
for(Survey s:slist){
	if(i>7)
		break;
	if(s.getSIsAudited()==false||s.getSIsOpen()==false)
		continue;
%>
<li class=li><a href="SurveyShow.jsp?sid=<%=s.getSId() %>" target="_blank"><%=s.getSName().length()>12?s.getSName().substring(0,11)+"...":s.getSName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;<i><font color=grey><%=s.getSCreateDate() %></font></i></li>
 <%
i++;
}
 %>
</ul>
</div>
</div>
<div id="main_2">
<div class="title">热门排行榜</div>
<div class="paihang_content">

<ol class=list-item>
<%
for(Survey s:shlist){
	if(i>10)
		break;
	if(s.getSIsAudited()==false||s.getSIsOpen()==false)
		continue;
%>
<li ><a href="SurveyShow.jsp?sid=<%=s.getSId() %>" target="_blank"><%=s.getSName().length()>12?s.getSName().substring(0,11)+"...":s.getSName()%></a></li>
<%
}
%>
</ol>
</div>
</div><!--main_2 end-->
</div><!--main end-->

<%
LinkDAO ldao=DAOFactory.getLinkDAO();
List<Link> llist=ldao.listAllLink();
%>
<div id="indexFriend" class="middle">
<div class="title">友情链接</div>
<div class="main" >
 <ul >
 
<%
int j=0;
for(Link link:llist){
	if(j>6)
		break;
	j++;
%>
<li class=friendBox><a href=<%=link.getLUrl() %>><img src=<%=link.getLImg() %> alt=<%=link.getLInfo() %> width=88px height=31px></img></a></li>

<%} %>
</ul>
 
</div>
</div>


<div id="bottom">
<%=cfg.getCSiteName() %><br/>
<%=cfg.getCopyright() %> 
</div><!--bottom end-->
</body>
</html>