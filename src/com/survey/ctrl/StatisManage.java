package com.survey.ctrl;

import java.io.IOException;
import java.net.URLEncoder;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.AnswersheetDAO;
import com.survey.dao.DAOFactory;
import com.survey.dao.QuestionDAO;
import com.survey.dao.TextDAO;
import com.survey.dto.Question;

public class StatisManage extends HttpServlet {

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
			String sid=request.getParameter("sid");
			String op=request.getParameter("op");
			
			if("DelSheet".equals(op)){
				Long asid=Long.valueOf(request.getParameter("asid"));
				AnswersheetDAO adao=DAOFactory.getAnswersheetDAO();
				boolean ret=adao.delAnswersheet(asid);
				if(ret==true)
					response.sendRedirect("../admin/ShowSheets.jsp?sid="+sid);
				else
					response.sendRedirect("../admin/OpResult.jsp?op=DelSheet&ret=false");
			}else if("ZeroFill".equals(op)){
				synchronized(this){
					boolean success=true;
					QuestionDAO qdao=DAOFactory.getQuestionDAO();
					List<Question> qlist=qdao.listAllQuestion(Long.valueOf(sid));
					TextDAO tdao=DAOFactory.getTextDAO();
					for(Question q:qlist){
						if(q.getQType()==5)
							continue;
						String results=q.getQResult();
						String[] result=results.split(",");
						results="";
						for(String s:result){
							results=results+",0";
						}
						results=results.substring(1);
						q.setQResult(results);
						//System.out.println("sm:"+q.getSurvey());
						boolean ret=qdao.updateQuestion(q);
						if(ret==false)
							success=false;
						
						ret=tdao.delText(q.getQId());
						if(ret==false)
							success=false;
					}
					AnswersheetDAO adao=DAOFactory.getAnswersheetDAO();
					boolean ret=adao.delAnswersheets(Long.valueOf(sid));
					if(ret==false)
						success=false;
					//response.setCharacterEncoding("UTF-8");
					//response.setContentType("text/html;charset=UTF-8"); 
					
					if(success==true)
						response.sendRedirect("../admin/SurveyStatis.jsp?words="+URLEncoder.encode("操作成功!", "UTF-8"));
					else
						response.sendRedirect("../admin/OpResult.jsp?ret=false&op=default&words="+URLEncoder.encode("问卷统计出错,请与系统管理员联系！","UTF-8"));
				}
			}
	}

}
