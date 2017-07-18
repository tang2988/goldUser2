package cn.jbit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.AccountService;
import cn.jbit.ServiceImpl.AccountServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.User;

public class HomeServlet extends HttpServlet {

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
		
			String url = request.getRequestURI();  //定义访问路径
			if(url.endsWith("/home.do")){	
				
				//后缀以 home.do结尾 就执行 下面的内容
				
				ResBo login = (ResBo) request.getSession().getAttribute("login");
				if(login == null){
					response.sendRedirect("../userlogin/login.do");
					return;
				}
				AccountService accountService = new AccountServiceImpl(); //实例化  业务层
				
				Account ac = accountService.findAccount(1L);	//调用方法
				request.setAttribute("ac", ac);		//设置属性值
				request.getRequestDispatcher("/WEB-INF/Jsp/home.jsp").forward(request, response); //页面转发
				return;  //终止
			}	
	}


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
