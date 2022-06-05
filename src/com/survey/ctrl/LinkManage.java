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
import com.survey.dao.LinkDAO;
import com.survey.dto.Admin;
import com.survey.dto.Link;

public class LinkManage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LinkManage() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
 

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

		String mutex1="";
		//String mutex2="";
		String op=request.getParameter("op");
		if("AddLink".equals(op)){
			String url=request.getParameter("url");
			String sitename=request.getParameter("sitename");
			String logo=request.getParameter("logo");
			String description=request.getParameter("description");
			 
			LinkDAO dao=DAOFactory.getLinkDAO();
			Link link=new Link();
			link.setLAddtime(new java.sql.Date(new java.util.Date().getTime()));
			link.setLImg(logo);
			link.setLInfo(description);
			link.setLIsLock(false);
			link.setLName(sitename);
			link.setLUrl(url);
			
			boolean ret1=dao.addLink(link);
			if(ret1)
				response.sendRedirect("../admin/FriendLinkAdmin.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=default&ret=false&words="+URLEncoder.encode("增加友情链接出错！请联系管理员", "UTF-8"));
		}
		else if("DelLink".equals(op)){
			Long lid=Long.valueOf(request.getParameter("lid"));
			LinkDAO dao=DAOFactory.getLinkDAO();
			
			boolean ret1=dao.delLink(lid);
			if(ret1)
				response.sendRedirect("../admin/FriendLinkAdmin.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=default&ret=false&words="+URLEncoder.encode("删除友情链接出错！请联系管理员", "UTF-8"));
			
		}else if("EditLink".equals(op)){
			Long lid=Long.valueOf(request.getParameter("lid"));
			String url=request.getParameter("url");
			String sitename=request.getParameter("sitename");
			String logo=request.getParameter("logo");
			String description=request.getParameter("description");
		 
			
			LinkDAO dao=DAOFactory.getLinkDAO();
  			
			synchronized(mutex1){
			Link link=dao.findLink(lid);
			link.setLId(lid);
			link.setLImg(logo);
			link.setLInfo(description);
			link.setLIsLock(false);
			link.setLName(sitename);
			link.setLUrl(url);
			boolean ret1=dao.updateLink(link);
			
			if(ret1)
				response.sendRedirect("../admin/FriendLinkAdmin.jsp");
			else
				response.sendRedirect("../admin/OpResult.jsp?op=default&ret=false&words=编辑友情链接出错！");
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
 
}
