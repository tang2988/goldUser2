package cn.jbit.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.UserService;
import cn.jbit.ServiceImpl.UserServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.User;

public class UserRealnameServlet extends HttpServlet {

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
		
		
		User login = (User) request.getSession().getAttribute("login");
		if(login == null){
			response.sendRedirect("../userlogin/login.do");
			return;
		}
		
		String uri = request.getRequestURI();  //创建路径
		if(uri.endsWith("/reanl.do")){	//后缀以reanl.do 重定向到 实名认证页面
			request.getRequestDispatcher("/WEB-INF/Jsp/UserRealname.jsp").forward(request, response);
			
			return; //终止
		}else if(uri.endsWith("/Real.do")){ //后缀以/Real.do结束 执行下面方法
			
			UserService accountService = new UserServiceImpl(); //实例化业务类
			User cx = accountService.findNameId(login.getUserId());  //调用业务类查询方法
			request.setAttribute("cx", cx);	//创建属性
			request.getRequestDispatcher("/WEB-INF/Jsp/RealSuccess.jsp").forward(request, response); //页面转发
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
		
		User login = (User) request.getSession().getAttribute("login");
		if(login == null){
			response.sendRedirect("../userlogin/login.do");
			return;
		}
		
		
		String url = request.getRequestURI();
		if(url.endsWith("real.do")){
			
//			response.setCharacterEncoding("utf-8");
//			request.setCharacterEncoding("utf-8");
			String realName = request.getParameter("realName"); //从页面表单组件名称获取提交的数据
			
			realName = new String(realName.getBytes("iso-8859-1"),"utf-8");
			
			
			String CardId = request.getParameter("CardId");	//从页面表单组件名称获取提交的数据
			User user = new User();
			user.setRealName(realName);
			user.setIdcardNo(CardId);
			user.setUserId(login.getUserId());
			UserService us = new UserServiceImpl();  //实例化业务类
			ResBo up = us.Update(user);		//调用业务类的修改方法
			if(up.getMsg()!=null){
				request.setAttribute("up", up.getMsg());  //创建属性
				request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response); //页面转发
			}else{
				response.sendRedirect("../userRealname/reanl.do"); //重定向
			}
		}
	}
}
