<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script language="JavaScript" src="../Js/Func.js"></script>
<script language="JavaScript" src="../Js/prototype.js"></script>
<script language="javascript">
 
window.onload=tableFix;
function Check(){
	if($("url").value==""){
			alert("请输入网址！");
			return false;
	}
	if($("sitename").value==""){
			alert("请输入网站名称！");
			return false;
	}
	
}
</script>

 
<link rel="stylesheet" href="../Css/Admin.css" type="text/css" />
 
</head>
<body>
  <div class=nav><a href=admin_main.jsp>桌面</a>»友情链接添加
<hr>
</div> 
<div id="admin_surveyAdd_main">
<form name="from1" action="../servlet/LinkManage.do?op=AddLink" method="post" onSubmit="return Check();">

<table width="585" border="0" cellspacing="0" cellpadding="0" class="table">
  <tr>
    <th>友情链接添加</th>
    <th>&nbsp;</th>
    <th ><span class="R">*</span> 为必填项目 </th>
  </tr>
  <tr>
    <td>网址</td>
    <td><input name="url" type="text" size="50"></td>
    <td ><span class="R">*</span>网址，请以HTTP://开头 </td>
  </tr>
  <tr>
    <td>网站名称</td>
    <td><input name="sitename" id=sitename type="text" size="50"></td>
    <td ><span class="R">*</span> 即链接显示的文字</td>
  </tr>
  <tr>
    <td>LOGO</td>
    <td><input type=text name="logo" id=logo size="50"  ></td>
    <td> 主页上显示的图片 ,大小限制在88*31像素</td>
  </tr>
  <tr>
    <td>网站说明</td>
    <td><textarea name="description" id=description   cols="50"></textarea></td>
    <td> 当鼠标移到LOGO上时显示的文字 </td>
  </tr>
 
  
  <tr>
    <td >&nbsp;</td>
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