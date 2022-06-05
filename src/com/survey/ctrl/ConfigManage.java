package com.survey.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.survey.dao.ConfigDAO;
import com.survey.dao.DAOFactory;
import com.survey.dto.Config;

public class ConfigManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ConfigManage() {
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

		 
		ConfigDAO configdao=DAOFactory.getConfigDAO();
		Config config=new Config();
		config.setCSiteName(request.getParameter("siteName"));
		config.setCSiteUrl(request.getParameter("siteURL"));
		config.setCIsOpen(Boolean.valueOf(request.getParameter("siteOpen")));
		config.setCCloseWord(request.getParameter("closeWord"));
		config.setCopyright(request.getParameter("copyright"));
		boolean ret=configdao.updateConfig(config);
		if (ret==true)
			response.sendRedirect("../admin/OpResult.jsp?op=SysConfig&ret=true");
		else
			response.sendRedirect("../admin/OpResult.jsp?op=SysConfig&ret=false");
		 

	 
		
		
		 
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
