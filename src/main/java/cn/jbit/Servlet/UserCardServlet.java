package cn.jbit.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.BankcardService;
import cn.jbit.Service.UserService;
import cn.jbit.ServiceImpl.BankcardServiceImpl;
import cn.jbit.ServiceImpl.UserServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Bankcard;
import cn.jbit.entity.User;

public class UserCardServlet extends HttpServlet {

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
		 	UserService userService = new UserServiceImpl();   //实例化业务层实现类
		 	User na = userService.findNameId(login.getUserId());		//调用业务层的查询方法
		 	request.setAttribute("na", na);			//设置属性 
		 	request.getRequestDispatcher("/WEB-INF/Jsp/UserCard.jsp").forward(request, response); //页面转发
		 	
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
		
		String url = request.getRequestURI();   //定义访问路径
		if(url.endsWith("user.do")){
			
			User login = (User) request.getSession().getAttribute("login");
			if(login == null){
				response.sendRedirect("../userlogin/login.do");
				return;
			}
			//后缀以 user.do 结束  执行下面
			String CardnoId = request.getParameter("CardnoId").trim();  //从页面表单组件名称获取提交的数据
			if(CardnoId==null || CardnoId.equals("")){   //如果等于null 或者 相等"" 
				response.sendRedirect("../usercard/user.do");  //页面重定向
			}else{	//否则执行下面		
				BankcardService bankcardService = new BankcardServiceImpl(); //实例化业务类
				Bankcard bankcard = new Bankcard();		//实例化Bankcard
				bankcard.setBankcardStatus(10);			//设置值
				bankcard.setCard(Long.valueOf(CardnoId));
				bankcard.setUserId(login.getUserId());
				bankcard.setBanknameId(CardnoId);
				ResBo tj = bankcardService.ins(bankcard);  //调用业务类的添加方法
				if(tj.getMsg()!=null){		//判断
					request.setAttribute("tj", tj.getMsg()); //创建属性 
					request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response); //页面转发
				}else{
					response.sendRedirect("../usercard/user.do");  //页面重定向
				}
			}
		}
		
	}

}
