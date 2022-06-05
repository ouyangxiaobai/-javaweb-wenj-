// JavaScript Document
window.onload=function(){
 drag(document.getElementById('question_tz'),document.getElementById('question_tz_title'));
};
function drag(o,ot){
 ot.onmousedown=function(a){
  var d=document;if(!a)a=window.event;
  var x=a.layerX?a.layerX:a.offsetX,y=a.layerY?a.layerY:a.offsetY;
  if(ot.setCapture)
   o.setCapture();
  else if(window.captureEvents)
   window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);

  d.onmousemove=function(a){
   if(!a)a=window.event;
   if(!a.pageX)a.pageX=a.clientX;
   if(!a.pageY)a.pageY=a.clientY;
   var tx=a.pageX-x,ty=a.pageY-y;
   o.style.left=tx;
   o.style.top=ty;
  };

  d.onmouseup=function(){
   if(o.releaseCapture)
    o.releaseCapture();
   else if(window.captureEvents)
    window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
   d.onmousemove=null;
   d.onmouseup=null;
  };
 };
}
//-->

function showwin()
{
//visibility: visible;
 if(document.getElementById('question_tz').style.visibility!="visible")
 {
  document.getElementById('question_tz').style.visibility="visible";
  document.getElementById('question_tz').style.left=((document.body.clientWidth-400)/2);
  document.getElementById('question_tz').style.top=50;
 }
 
}
function closewin()
{
//visibility: visible;
 if(document.getElementById('question_tz').style.visibility!="hidden")
 {
  document.getElementById('question_tz').style.visibility="hidden";
  document.getElementById('question_tz').style.left=((document.body.clientWidth-400)/2);
  document.getElementById('question_tz').style.top=100;
 }
var check_box=document.getElementsByName('check_box');
 //
for (var i = 0; i < check_box.length; i++) { 
var tt=eval('document.form1.'+check_box[i].id+'_text');
if ((check_box[i].checked == true)&&(tt.value=='')){
	//alert(check_box[0].value);
	check_box[i].checked = false;
	}
} 
}
function getQuestList(I1){
//alert(document.getElementById("tz1").value);
    if (document.getElementById(I1).checked==true){
	showwin();
	}else{
	closewin();
    var obj=eval('document.getElementById("'+I1+'_text")');
	obj.value="";
	}
}
function Quest_selected(I1){
    var check_box=document.getElementsByName('check_box');
	for (var i = 0; i < check_box.length; i++) { 
	var tt=eval('document.getElementById("'+check_box[i].id+'_text")');
	if ((check_box[i].checked == true)&&(tt.value=='')){
		tt.value=I1;
		}
	} 
	closewin();
}
function SubTz(){
var check_box=document.getElementsByName('check_box');
for (var i = 0; i < check_box.length; i++) { 
	var tt=eval('document.form1.'+check_box[i].id+'_text');
	if ((check_box[i].checked == true)&&(tt.value=='')){
		check_box[i].checked = false;
		}
	} 
}