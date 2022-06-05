<%@ page language="java" import="java.util.*,com.survey.sql.*,com.survey.dao.*,com.survey.dto.Templet" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <script language="JavaScript" src="../Js/Func.js"></script>
<script language="javascript">window.onload=tableFix;</script>

 
<link rel="stylesheet" href="../Css/Admin.css" type="text/css" />
<script language="javascript" type="text/javascript" src="../Js/Date.js"></script>
 
</head>
<body>
  <div class=nav><a href=admin_main.jsp>桌面</a>»问卷添加
<hr>
</div> 
<div id="admin_surveyAdd_main">
<form name="from1" action="../servlet/SurveyManage.do?op=AddSurvey" method="post" onSubmit="return CheckForm();">

<table width="585" border="0" cellspacing="0" cellpadding="0" class="table">
  <tr>
    <th>问卷添加</th>
    <th>&nbsp;</th>
    <th width="374"><span class="R">*</span> 为必填项目 </th>
  </tr>
  <tr>
    <td>问卷名称</td>
    <td><input name="Survey_name" type="text" size="50"></td>
    <td width="374"><span class="R">*</span> 问卷的名称，既问卷的总标题</td>
  </tr>
  <tr>
    <td>问卷发起人(单位)</td>
    <td><input name="Survey_author" type="text" size="50"></td>
    <td width="374"><span class="R">*</span> 问卷发起人，此问卷的所有单位</td>
  </tr>
  <tr>
    <td>问卷描述</td>
    <td><textarea rows="2" name="Survey_description" cols="60" onpropertychange="this.style.posHeight=this.scrollHeight"></textarea></td>
    <td> &nbsp;&nbsp;对此问卷的简单描述，这段描述将放在问卷前</td>
  </tr>
  <tr>
    <td>问卷结束日期</td>
    <td><input type="text" name="Survey_ExpireDate"   readOnly="" onClick="setDay(this);" value="<%=new java.sql.Date(System.currentTimeMillis() +1000L*60*60*24*30)%>"></td>
    <td><span class="R">*</span> 问卷结束日期，到期后该问卷将不能接受</td>
  </tr>
   

  <tr>
    <td>同一IP可重复提交</td>
    <td><input name="Survey_ipRepeat" type="checkbox" value="true" checked="checked"></td>
    <td>&nbsp;&nbsp;选中此项，同一IP可重复提交问卷</td>
  </tr>
  <tr>
    <td>公开此问卷调查</td>
    <td><input name="Survey_isOpen" type="checkbox" value="true" checked="checked"></td>
    <td><span class="R">*</span> 不公开的问卷，只能通过编号进行访问</td>
  </tr>
  <tr>
    <td width="">为问卷添加主题图片</td>
    <td width=""><input type="checkbox" name="Survey_isImg" value="true" onClick="SwitchHidden('hidden_isImg');">
	   <div id="hidden_isImg" style="display:none;">
		<input type=hidden name="imgfilepath" id="imgfilepath">
		   <iframe name=myiframe src="upload.jsp" frameborder="0" width="400" height="50"></iframe>
      </div>	</td>
    <td width=""> &nbsp;&nbsp;主题图片的格式必须为.JPG或GIF</td>
  </tr>
  
  <tr>
    <td>设置问卷密码</td>
    <td><input type="checkbox" name="Survey_isPassword" value=true onClick="SwitchHidden('hidden_isPassword');">
	   <div id="hidden_isPassword" style="display:none;">
           输入密码：<input type="password" name="Survey_Password1" id="Survey_Password1"><br/>
           确认密码：<input type="password" name="Survey_Password2" id="Survey_Password2" onBlur="return CheckPassword('Survey_Password1','Survey_Password2','4');">
      </div>	</td>
    <td> &nbsp;&nbsp;选中此项，只有输入正确的密码才能完成问卷</td>
  </tr>
  
  <tr>
    <td>设置访问IP限制</td>
    <td>
	<input type="checkbox" name="Survry_IPLimit" value=true onClick="SwitchHidden('hidden_ipLimit');">
<div id="hidden_ipLimit" style="display:none;">
该IP段内可以访问<input name="Survey_ipLimitKind" type="radio" value="白名单" checked="checked"><br/>
该IP段内不可访问<input name="Survey_ipLimitKind" type="radio" value="黑名单"><br/>
IP段开始
<div style="border-width:1;border-color:balck;border-style:solid;width:165;font-size:9pt">
<input type=text name="ipSta1" id="ipSta1" maxlength="3" class="a3" onKeyUp="mask(this,'Sta')" onbeforepaste="mask_c()">.
<input type=text name="ipSta2" id="ipSta2" maxlength="3" class="a3" onKeyUp="mask(this,'Sta')" onbeforepaste="mask_c()">.
<input type=text name="ipSta3" id="ipSta3"  maxlength="3" class="a3" onKeyUp="mask(this,'Sta')" onbeforepaste="mask_c()">.
<input type=text name="ipSta4" id="ipSta4" maxlength="3" class="a3" onKeyUp="mask(this,'Sta')" onbeforepaste="mask_c()">
</div>
<br/>
IP段结束
<div style="border-width:1;border-color:balck;border-style:solid;width:165;font-size:9pt">
<input type=text name="ipEnd1" id="ipEnd1" maxlength="3" class="a3" onKeyUp="mask(this,'End')" onbeforepaste="mask_c()">.
<input type=text name="ipEnd2" id="ipEnd2" maxlength="3" class="a3" onKeyUp="mask(this,'End')" onbeforepaste="mask_c()">.
<input type=text name="ipEnd3" id="ipEnd3" maxlength="3" class="a3" onKeyUp="mask(this,'End')" onbeforepaste="mask_c()">.
<input type=text name="ipEnd4" id="ipEnd4" maxlength="3" class="a3" onKeyUp="mask(this,'End')" onbeforepaste="mask_c()">
</div>

<br/>
<input type="hidden" name="Survey_ipRange">
<input type="button" name="AddIP" value="添加" onClick="return AddIPAddress();">
<input type="button" name="DellIP" value="删除选定" onClick="return DellSelected();">
<input type="button" name="DellAllIP" value="清空" onClick="return DellAll();"><br/>
受限IP列表:
<br/>
<select name="Survey_ipList" size="5" style="width:270px" multiple="multiple" id="Survey_ipList">
</select>
<br/>
</div>	</td>
    <td>&nbsp;&nbsp;设置此项，对问卷访问者进行IP限制</td>
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