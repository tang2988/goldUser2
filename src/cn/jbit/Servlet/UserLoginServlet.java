package cn.jbit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.jbit.Service.UserService;
import cn.jbit.ServiceImpl.UserServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.User;

public class UserLoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI(); // 定义路径
		if (url.endsWith("/login.do")) { // 后缀以 login.do
			request.getRequestDispatcher("/WEB-INF/Jsp/UserLogin.jsp").forward(request, response);
			return;
		} else if (url.endsWith("/Register.do")) {

			request.getRequestDispatcher("/WEB-INF/Jsp/UserRegister.jsp").forward(request,
					response);
			return;
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */ 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI(); // 定义路径
		if (uri.endsWith("userlogin.do")) { // 后缀以 userlogin.do结束 执行下面

			request.setCharacterEncoding("utf-8"); // 设置字符集
			String mobliePhone = request.getParameter("mobliePhone"); // 从页面表单组件名称获取提交的数据
			String password = request.getParameter("password"); // 从页面表单组件名称获取提交的数据
			if (mobliePhone == null || mobliePhone.equals("") & password == null
					|| password.equals("")) { // 判断 如果等于null 重定向到登录页面
				response.sendRedirect("../userlogin/login.do"); // 重定向
				return; // 终止
			}
			UserService userService = new UserServiceImpl(); // 实例化业务类
			User user = new User();
			user.setMobilePhone(mobliePhone);
			user.setPassword(password);
			ResBo login = userService.login(user);
			if (login.getMsg()!=null) {
				HttpSession httpSession = request.getSession(); // 创建session
				httpSession.setAttribute("login", login.getData()); // 创建属性值
				response.sendRedirect("../home/home.do"); // 重定向
			} else {
				response.sendRedirect("../userlogin/login.do");
			}
			return;
		} else if (uri.endsWith("resgis.do")) { // 后缀以resgis.do路径 执行下面
			request.setCharacterEncoding("utf-8"); // 设置字符集
			String mobliePhone = request.getParameter("mobliePhone"); // 从页面表单组件名称获取提交的数据
			String Password = request.getParameter("Password"); // 从页面表单组件名称获取提交的数据
			if (mobliePhone == null || mobliePhone.equals("") & Password == null|| Password.equals("")) { // 判断 如果等于null 重定向到注册页面
				response.sendRedirect("../userlogin/Register.do"); // 页面重定向
				return; // 终止
			}
			System.out.println(mobliePhone);
			 if(Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$").matcher(mobliePhone).find()){
			 
			 }else{
				 response.sendRedirect("../userlogin/Register.do");
				 return;
			 }
			 if(!Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$").matcher(Password).find()){
			 response.sendRedirect("../userlogin/Register.do");
			 return;
			 }
			User user = new User(); // 实例化
			user.setMobilePhone(mobliePhone);
			user.setPassword(Password);
			user.setIdcardNo(null);
			user.setRealName(null);
			user.setTransactionPwd(null);
			user.setUserStatus(10);
			UserService us = new UserServiceImpl(); // 实例化业务类
			ResBo zc = us.register(user); // 调用业务类的方法
			if (zc.isSuccess()) {

				response.sendRedirect("../userlogin/login.do"); // 重定向
			} else {
				response.sendRedirect("../userlogin/Register.do");
			}
		}
	}
}
