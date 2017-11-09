package cn.jbit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.jbit.Service.AccountService;
import cn.jbit.Service.UserService;
import cn.jbit.ServiceImpl.AccountServiceImpl;
import cn.jbit.ServiceImpl.UserServiceImpl;
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
				
				User login = (User) request.getSession().getAttribute("login");
				if(login == null){
					response.sendRedirect("../userlogin/login.do");
					return;
				}
				AccountService accountService = new AccountServiceImpl(); //实例化  业务层
				System.out.println(login);
				Account ac = accountService.findAccount(login.getUserId());	//调用方法
				request.setAttribute("ac", ac);		//设置属性值
				request.getRequestDispatcher("/WEB-INF/Jsp/home.jsp").forward(request, response); //页面转发
				return;  //终止
			}else if(url.endsWith("/getUser4ajax.do")){	
				String userId = request.getParameter("userId");
				
				
				UserService userService = new UserServiceImpl();
				User user = userService.findUserById(Long.valueOf(userId));
				
				Map<String, Object> retMap = new HashMap<String, Object>();
				
				if(user==null){
					retMap.put("isSuccess", "1");
					retMap.put("data", user);
				}else{
					retMap.put("isSuccess", "0");
					retMap.put("data", user);
				}
				
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//				}
				
				String jsonStr = JSON.toJSONString(retMap);
				System.out.println(jsonStr);
				
				response.getWriter().write(jsonStr);
				
			}else if(url.endsWith("/getUser5ajax.do")){	
				String userId = request.getParameter("userId");
				
				AccountService accountService = new AccountServiceImpl();
				
				Account account = accountService.findAccount(Long.valueOf(userId));
				
				
				
				Map<String, Object> retMapp = new HashMap<String, Object>();
				
				if(account==null){
					retMapp.put("isSuccess", "1");
					retMapp.put("data", account);
				}else{
					retMapp.put("isSuccess", "0");
					retMapp.put("data", account);
				}
				
				String jsonStr = JSON.toJSONString(retMapp);
				System.out.println(jsonStr);
				
				response.getWriter().write(jsonStr);
			}
			
			
	}


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
