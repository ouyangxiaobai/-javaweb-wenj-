<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.survey.dao.AdminDAO" %>
<%@ page import="com.survey.dao.DAOFactory" %>
<%@ page import="com.survey.dto.Admin" %>


<%
	String a_id=request.getParameter("aid");
	Long aid;
	if(a_id==null){
		//System.out.println(session.getAttribute("aid"));
		aid=(Long)session.getAttribute("aid");
		//System.out.println(aid);
		}
	else
		aid=Long.valueOf(a_id);
	
	if(aid==null){
		out.println("对不起，您没有登录！");
		return;
	}
	AdminDAO dao=DAOFactory.getAdminDAO();
	//System.out.println(aid);
	
	Admin admin=dao.findAdmin(aid);
	

 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script language="JavaScript" src="../Js/Func.js"></script>
<script language="JavaScript" src="../Js/prototype.js"></script>
<script language="javascript">
 
window.onload=tableFix;
function Check(){

	return CheckPassword('pwd','confirmPwd',6);
}
</script>

 
<link rel="stylesheet" href="../Css/Admin.css" type="text/css" />
 
</head>
<body>
  <div class=nav><a href=admin_main.jsp>桌面</a>»修改密码
<hr>
</div> 
<div id="admin_surveyAdd_main">
<form name="from1" action="../servlet/AdminManage.do?op=EditAdmin" method="post" onSubmit="return Check();">

<table width="585" border="0" cellspacing="0" cellpadding="0" class="table">
  <tr>
    <th>修改密码</th>
    <th>&nbsp;<input name="aid" type="hidden" value=<%=admin.getA_id() %>></th>
    <th width="374"><span class="R">*</span> 为必填项目 </th>
  </tr>
  <tr>
    <td>用户名</td>
    <td><input name="username" type="text" size="50" value=<%=admin.getA_user() %> readonly></td>
    <td width="374"><span class="R">*</span> </td>
  </tr>
  <tr>
    <td>旧密码</td>
    <td><input name="oldpwd" id=oldpwd type="password" size="50"></td>
    <td width="374"><span class="R">*</span> 至少6位</td>
  </tr>
  <tr>
    <td>密码</td>
    <td><input name="pwd" id=pwd type="password" size="50"></td>
    <td width="374"><span class="R">*</span> 至少6位</td>
  </tr>
  <tr>
    <td>密码确认</td>
    <td><input type=password name="confirmPwd" id=confirmPwd size="50"  ></td>
    <td> &nbsp;&nbsp; </td>
  </tr>
  
  <tr>
    <td width="179">&nbsp;</td>
    <td>
	<div id="button">
	<input type="submit" name="submit" value="完成"><input type="reset" name="reset1" value="取消">
	</div>	</td>
    <td>&nbsp;</td>
  </tr>
</table>  
</form>
</div>
<div id="admin_surveyAdd_bottom">
</div>
</body>
</html>