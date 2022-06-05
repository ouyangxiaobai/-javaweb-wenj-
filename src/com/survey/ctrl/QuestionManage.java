package com.survey.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.DAOFactory;
import com.survey.dao.QuestionDAO;
import com.survey.dto.Question;

public class QuestionManage extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String mutex = ""; 
		 String mutex1 = ""; 
		 String mutex2 = ""; 
		String op=request.getParameter("op");
		if("AddQuestion".equals(op)){
			String sid=request.getParameter("sid");
			String type=request.getParameter("type");
			String qhead=request.getParameter("qHead");
			String qbody=request.getParameter("qBody"); 
			String qresult=request.getParameter("qResult");
			String qimg=request.getParameter("qImg");
			Question question=new Question();
			question.setSurvey(Long.valueOf(sid));
			question.setQType(Long.valueOf(type));
			question.setQHead(qhead);
			question.setQBody(qbody);
			question.setQResult(qresult);
			question.setQImg(qimg);
			question.setQOrder(0L);
			String [] qbodys=qbody.split("&\\$\\$&");
			String spliter="";
			for(int i=1;i<qbodys.length;i++)
				if(i==qbodys.length-1)
					spliter=spliter+"null&null";
				else
					spliter=spliter+"null&";
			question.setQJdtz(spliter);
			QuestionDAO dao=DAOFactory.getQuestionDAO();
			boolean ret=dao.addQuestion(question);
			if(ret==true)
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=true&sid="+sid);
			else{
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=false");
			}
		}else if("DelQuestion".equals(op)){
			String sid=request.getParameter("sid");
			String qid=request.getParameter("qid");
			QuestionDAO dao=DAOFactory.getQuestionDAO();
			boolean ret=dao.delQuestion(Long.valueOf(qid));
			if(ret==true)
				response.sendRedirect("../admin/QuestionAdmin.jsp?sid="+sid);
			else
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=false");
		}else if("EditQuestion".equals(op)){
			String sid=request.getParameter("sid");
			String qid=request.getParameter("qid");
			//System.out.println(qid);
			String type=request.getParameter("type");
			String qhead=request.getParameter("qHead");
			String qbody=request.getParameter("qBody"); 
			String qimg=request.getParameter("qImg");
			QuestionDAO dao=DAOFactory.getQuestionDAO();
			synchronized(mutex){
			Question question=dao.findQuestion(Long.valueOf(qid));
			
			//System.out.println(question==null);
			question.setQType(Long.valueOf(type));
			question.setQHead(qhead);
			question.setQBody(qbody);
			question.setQImg(qimg);
			String [] qbodys=qbody.split("&\\$\\$&");
			String spliter="";
			for(int i=1;i<qbodys.length;i++)
				if(i==qbodys.length-1)
					spliter=spliter+"null&null";
				else
					spliter=spliter+"null&";
			question.setQJdtz(spliter);
			question.setQOrder(0L);
			boolean ret=dao.updateQuestion(question);
			if(ret==true)
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=true&sid="+sid);
			else
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=false");
			}
		}else if("setJD".equals(op)){
			String sid=request.getParameter("sid");
			String qid=request.getParameter("qid");
			int jd_count=Integer.parseInt(request.getParameter("jd_count"));
			List<String> list=new ArrayList<String>();
			for(int j=0;j<jd_count;j++){
				String checked=request.getParameter("check_jd"+j);
					list.add(checked);
				 
			}
			QuestionDAO dao=DAOFactory.getQuestionDAO();
			synchronized(mutex1){
			Question question=dao.findQuestion(Long.valueOf(qid));
			
			String [] jdtz=question.getQJdtz().split("&");
			for(int j=0;j<jdtz.length;j++){
				if("on".equals(list.get(j)))
					jdtz[j]="over";
			}
			String newJdtz="";
			for(int j=0;j<jdtz.length;j++){
				if(j==jdtz.length-1)
					newJdtz=newJdtz+jdtz[j];
				else
					newJdtz=newJdtz+jdtz[j]+"&";
			}
		
			question.setQJdtz(newJdtz);
			boolean ret=dao.updateQuestion(question);
			if(ret==true)
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=true&sid="+sid);
			else
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=false");
			}
		}else if("setTZ".equals(op)){
			String sid=request.getParameter("sid");
			String qid=request.getParameter("qid");
			int jd_count=Integer.parseInt(request.getParameter("tz_count"));
			List<String> list=new ArrayList<String>();
			for(int j=0;j<jd_count;j++){
				String checked=request.getParameter("check_tz"+j);
					list.add(checked);
				 
			}
			QuestionDAO dao=DAOFactory.getQuestionDAO();
			synchronized(mutex2){
			Question question=dao.findQuestion(Long.valueOf(qid));
			
			//set value of jdtz for every choice
			String [] jdtz=question.getQJdtz().split("&");
			for(int j=0;j<jdtz.length;j++){
				//System.out.println(list.get(j));
				if("on".equals(list.get(j))||list.get(j)==null){
					
					jdtz[j]="null";
				}else
					jdtz[j]=list.get(j);
			}
			
			//start concat the jdtz field with &.
			String newJdtz="";
			for(int j=0;j<jdtz.length;j++){
				if(j==jdtz.length-1)
					newJdtz=newJdtz+jdtz[j];
				else
					newJdtz=newJdtz+jdtz[j]+"&";
			}
		
			question.setQJdtz(newJdtz);
			boolean ret=dao.updateQuestion(question);
			if(ret==true)
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=true&sid="+sid);
			else
				response.sendRedirect("../admin/OpResult.jsp?op=Question&ret=false");
		}
		}
	}

}
