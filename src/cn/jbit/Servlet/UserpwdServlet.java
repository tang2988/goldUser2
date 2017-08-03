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

public class UserpwdServlet extends HttpServlet {

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
		
		String uri  =request.getRequestURI();  //定义路径
		if(uri.endsWith("/userpwdd.do")){		//交易密码路径
			request.getRequestDispatcher("/WEB-INF/Jsp/UserPassword.jsp").forward(request, response);
			return;
		}else if(uri.endsWith("/updatepwd.do")){	//修改登录密码路径
			request.getRequestDispatcher("/WEB-INF/Jsp/UpdatePassword.jsp").forward(request, response);
			return;
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
		String ur = request.getRequestURI();
		if(ur.endsWith("userpwd.do")){
			
			User login = (User) request.getSession().getAttribute("login");
			if(login == null){
				response.sendRedirect("../userlogin/login.do");
				return;
			}
			
			String trPassword = request.getParameter("trPassword"); //从页面表单组件名称获取提交的数据
			String qrPassword = request.getParameter("qrPassword");	//从页面表单组件名称获取提交的数据
			if(trPassword==null || trPassword.equals("")){ 	//如果等于null  重定向到 设置交易密码页面
				response.sendRedirect("../userpwd/userpwdd.do");
			}else if(qrPassword==null || qrPassword.equals("")){ //如果等于null  重定向到 设置交易密码页面
				response.sendRedirect("../userpwd/userpwdd.do");
			}else if(!qrPassword.equals(trPassword)){			//如果等于null  重定向到 设置交易密码页面
				response.sendRedirect("../userpwd/userpwdd.do");
			}else{
				User user = new User();		//实例化
				user.setTransactionPwd(trPassword);
				user.setUserId(login.getUserId());
				UserService us = new UserServiceImpl(); //实例化业务类
				Integer xg = us.modifytheTradingPassword(user);	//调用修改方法
				if(xg>0){
					request.setAttribute("xg", "设置成功");	//创建属性值
					request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response); //页面转发
				}else{
					response.sendRedirect("../userpwd/userpwdd.do"); //页面重定向
				}
			}
			
		}else if(ur.endsWith("update.do")){
			
			User login = (User) request.getSession().getAttribute("login");
			if(login == null){
				response.sendRedirect("../userlogin/login.do");
				return;
			}
			
			String password = request.getParameter("password");	//从页面表单组件名称获取提交的数据
			String passwordone = request.getParameter("passwordone");	//从页面表单组件名称获取提交的数据
			String passwordtwo = request.getParameter("passwordtwo");	//从页面表单组件名称获取提交的数据
			
			if(password==null || password.equals("")){  //判断 等于 null 页面重定向到修改密码页面
				response.sendRedirect("../userpwd/updatepwd.do");
			}else if(passwordone == null || passwordone.equals("")){	//判断 等于 null 页面重定向到修改密码页面
				response.sendRedirect("../userpwd/updatepwd.do");
			}else if(passwordtwo == null || passwordtwo.equals("")){	//判断 等于 null 页面重定向到修改密码页面
				response.sendRedirect("../userpwd/updatepwd.do");
			}else if(!passwordone.equals(passwordtwo)){				//2次密码不一样 重定向到修改密码页面
				response.sendRedirect("../userpwd/updatepwd.do");
			}else{
					UserService us = new UserServiceImpl(); //实例化业务类
					User user = new User();
					user.setPassword(password);
					ResBo uo = us.updatePassword(login.getUserId(), passwordone, password);
					
					if(uo.isSuccess()){
						request.setAttribute("uo", uo.getMsg()); //创建属性
						
						request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response); //页面转发
					}else{
						response.sendRedirect("../userpwd/updatepwd.do");
					}
				}
		}
	}

}
