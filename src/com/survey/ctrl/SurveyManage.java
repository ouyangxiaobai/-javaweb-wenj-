package com.survey.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.AnswersheetDAO;
import com.survey.dao.DAOFactory;
import com.survey.dao.QuestionDAO;
import com.survey.dao.SurveyDAO;
import com.survey.dao.TextDAO;
import com.survey.dto.Survey;

public class SurveyManage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1737458302140188798L;
 

	/**
	 * Constructor of the object.
	 */
	public SurveyManage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
		PrintWriter out=response.getWriter();
		 
		String mutex1="";
		String mutex2="";
		if("AddSurvey".equals(request.getParameter("op"))){
			SurveyDAO surveydao=DAOFactory.getSurveyDAO(); 
			Survey survey=new Survey();
			survey.setSName(request.getParameter("Survey_name"));
			survey.setSAuthor(request.getParameter("Survey_author"));
			survey.setSDesc(request.getParameter("Survey_description"));
			survey.setSCreateDate(new Date());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				survey.setSExpireDate(sdf.parse(request.getParameter("Survey_ExpireDate")));
			} catch (ParseException e) {
				 out.println("wrong DATE format.please check it!");
			}
			survey.setTemplet(0L);
			survey.setSIpRepeat(Boolean.valueOf(request.getParameter("Survey_ipRepeat")));
			survey.setSIsOpen(Boolean.valueOf(request.getParameter("Survey_isOpen")));
			if(request.getParameter("Survey_isImg")!=null)
				survey.setSImg(request.getParameter("imgfilepath"));
			if(request.getParameter("Survey_isPassword")!=null)
				survey.setSPassword(request.getParameter("Survey_Password1"));
			if(request.getParameter("Survry_IPLimit")!=null){
				//survey.setSIpLimitType(request.getParameter("Survey_ipLimitKinds"));
				survey.setSIpRange(request.getParameter("Survey_ipRange"));
			}
			survey.setSHits(0L);
			survey.setSIsAudited(false);
			survey.setSUsehits(0L);
			boolean ret=surveydao.addSurvey(survey);
			//System.out.println(ret);
			if(ret==true)
				response.sendRedirect("../admin/OpResult.jsp?op=SurveyAdd&ret=true");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=SurveyAdd&ret=false");
 
			 
		}
		else if("SurveyAudi".equals(request.getParameter("op"))){
			Boolean audit=Boolean.valueOf(request.getParameter("audit"));
			SurveyDAO surveydao=DAOFactory.getSurveyDAO();
			synchronized(mutex1){
			Survey  survey=surveydao.findSurvey(Long.valueOf(request.getParameter("sid")));
			if(audit==true)
				survey.setSIsAudited(true);
			else
				survey.setSIsAudited(false);
			boolean ret=surveydao.updateSurvey(survey);
			if(ret==true)
				response.sendRedirect("../admin/SurveyAudi.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=SurveyAudi&ret=false");
			}
		}else if("EditSurvey".equals(request.getParameter("op"))){
			SurveyDAO surveydao=DAOFactory.getSurveyDAO(); 
			String sid=request.getParameter("Survey_id");
			synchronized(mutex2){
			Survey survey=surveydao.findSurvey(Long.valueOf(request.getParameter("Survey_id")));
			survey.setSName(request.getParameter("Survey_name"));
			survey.setSAuthor(request.getParameter("Survey_author"));
			survey.setSDesc(request.getParameter("Survey_description"));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				survey.setSExpireDate(sdf.parse(request.getParameter("Survey_ExpireDate")));
			} catch (ParseException e) {
				 out.println("wrong DATE format.please check it!");
			}
			survey.setTemplet(0L);
			survey.setSIpRepeat(Boolean.valueOf(request.getParameter("Survey_ipRepeat")));
			survey.setSIsOpen(Boolean.valueOf(request.getParameter("Survey_isOpen")));
			if(request.getParameter("Survey_isImg")!=null){
				if(request.getParameter("imgfilepath")!=null)
				survey.setSImg(request.getParameter("imgfilepath"));
			}else
				survey.setSImg(null);
			
			//System.out.println(request.getParameter("Survey_isPassword"));
			if(request.getParameter("Survey_isPassword")!=null){
				survey.setSPassword(request.getParameter("Survey_isPassword"));
			}else
				survey.setSPassword(null);
			
			if(request.getParameter("Survry_IPLimit")!=null){
				//survey.setSIpLimitType(request.getParameter("Survey_ipLimitKinds"));
				survey.setSIpRange(request.getParameter("Survey_ipRange"));
				//System.out.print(request.getParameter("Survey_ipRange"));
			}else
			{
				survey.setSIpLimitType(null);
				survey.setSIpRange(null);
			}
			 
			boolean ret=surveydao.updateSurvey(survey);
			//System.out.println(ret);
			if(ret==true)
				response.sendRedirect("../admin/SurveyEdit.jsp?sid="+sid+"&words="+URLEncoder.encode("操作成功！", "UTF-8"));
			else
				response.sendRedirect("../admin/OpResult.jsp?op=SurveyEdit&ret=false");
 
			}
		}else if("DelSurvey".equals(request.getParameter("op"))){
			Long surveyId=Long.valueOf(request.getParameter("sid"));
			SurveyDAO surveydao=DAOFactory.getSurveyDAO(); 
			boolean ret1=surveydao.delSurvey(surveyId);
			QuestionDAO questiondao=DAOFactory.getQuestionDAO();
			
			if(ret1==true)
				ret1=questiondao.delQuestions(surveyId);
			if(ret1==true){
				TextDAO tdao=DAOFactory.getTextDAO();
				ret1=tdao.delText(surveyId);
			}
			if(ret1==true){
				AnswersheetDAO adao=DAOFactory.getAnswersheetDAO();
				ret1=adao.delAnswersheets(surveyId);
			}
			if(ret1==true)
				response.sendRedirect("../admin/SurveyAdmin.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=SurveyDel&ret=false");
		}
			
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

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
