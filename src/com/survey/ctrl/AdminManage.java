package com.survey.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.AdminDAO;
import com.survey.dao.DAOFactory;
import com.survey.dao.QuestionDAO;
import com.survey.dao.SurveyDAO;
import com.survey.dto.Admin;

public class AdminManage extends HttpServlet {

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
		
	doPost(request, response);
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
		 
		String mutex1="";
		//String mutex2="";
		String op=request.getParameter("op");
		if("AddAdmin".equals(op)){
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			AdminDAO dao=DAOFactory.getAdminDAO();
			Admin admin=new Admin();
			admin.setA_user(username);
			admin.setA_pass(pwd);
			boolean ret1=dao.addAdmin(admin);
			if(ret1)
				response.sendRedirect("../admin/AdminList.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=default&ret=false&words="+URLEncoder.encode("增加管理员出错！请联系管理员", "UTF-8") );
		}
		else if("DelAdmin".equals(op)){
			Long aid=Long.valueOf(request.getParameter("aid"));
			AdminDAO dao=DAOFactory.getAdminDAO();
			
			boolean ret1=dao.delAdmin(aid);
			if(ret1)
				response.sendRedirect("../admin/AdminList.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=default&ret=false&words="+URLEncoder.encode("删除管理员出错！请联系管理员", "UTF-8"));
			
		}else if("EditAdmin".equals(op)){
			Long aid=Long.valueOf(request.getParameter("aid"));
			String oldpwd=request.getParameter("oldpwd");
			String pwd=request.getParameter("pwd");
			String username=request.getParameter("username");
			
			AdminDAO dao=DAOFactory.getAdminDAO();
			if(dao.checkPwd(username, oldpwd)!=true){
				response.sendRedirect("../admin/OpResult.jsp?op=default&ret=false&words="+URLEncoder.encode("旧密码错误", "UTF-8"));
				return;
			}
				
			synchronized(mutex1){
			Admin admin=dao.findAdmin(aid);
			admin.setA_user(username);
			admin.setA_pass(pwd);
			boolean ret1=dao.updateAdmin(admin);
			
			if(ret1)
				response.sendRedirect("../admin/AdminList.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=default&ret=false&words="+URLEncoder.encode("编辑管理员出错！请联系管理员", "UTF-8"));
			}
		}
	}

}
