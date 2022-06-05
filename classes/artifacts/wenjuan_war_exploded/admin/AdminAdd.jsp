<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script language="JavaScript" src="../Js/Func.js"></script>
<script language="JavaScript" src="../Js/prototype.js"></script>
<script language="javascript">
 
window.onload=tableFix;
function Check(){
	if($("username").value==""){
			alert("请输入用户名！");
			return false;
	}
	return CheckPassword('pwd','confirmPwd',6);
}
</script>

 
<link rel="stylesheet" href="../Css/Admin.css" type="text/css" />
 
</head>
<body>
  <div class=nav><a href=admin_main.jsp>桌面</a>»管理员添加
<hr>
</div> 
<div id="admin_surveyAdd_main">
<form name="from1" action="../servlet/AdminManage.do?op=AddAdmin" method="post" onSubmit="return Check();">

<table width="585" border="0" cellspacing="0" cellpadding="0" class="table">
  <tr>
    <th>管理员添加</th>
    <th>&nbsp;</th>
    <th width="374"><span class="R">*</span> 为必填项目 </th>
  </tr>
  <tr>
    <td>用户名</td>
    <td><input name="username" type="text" size="50"></td>
    <td width="374"><span class="R">*</span> </td>
  </tr>
  <tr>
    <td>密码</td>
    <td><input name="pwd" id=pwd type="password" size="50"></td>
    <td width="374"><span class="R">*</span> 至少6位</td>
  </tr>
  <tr>
    <td>密码确认</td>
    <td><input type=password name="confirmPwd" id=confirmPwd size="50"  ></textarea></td>
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