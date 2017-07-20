package cn.jbit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jbit.Service.AccountService;
import cn.jbit.Service.UserService;
import cn.jbit.Service.WithdrawalformService;
import cn.jbit.ServiceImpl.AccountServiceImpl;
import cn.jbit.ServiceImpl.UserServiceImpl;
import cn.jbit.ServiceImpl.WithdrawalformServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.User;
import cn.jbit.entity.Withdrawalform;

public class WithServlet extends HttpServlet {

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
		// 登录
		User login = (User) request.getSession().getAttribute("login");
		if (login == null) {
			response.sendRedirect("../userlogin/login.do");
			return;
		}
		// 查询余额
		AccountService ac = new AccountServiceImpl();
		Account cx = ac.findAccount(login.getUserId());
		request.setAttribute("cx", cx);
		request.getRequestDispatcher("/WEB-INF/Jsp/With.jsp").forward(request, response); // 页面转发
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

		String ul = request.getRequestURI(); // 自定义路径
		if (ul.endsWith("tixian.do")) {

			User login = (User) request.getSession().getAttribute("login");	//登陸
			if (login == null) {
				response.sendRedirect("../userlogin/login.do");
				return;
			}

			String czmonery = request.getParameter("czmonery"); //获取表单组件名称提交的数据
			String passwordjy = request.getParameter("passwordjy");//获取表单组件名称提交的数据
			if (czmonery == null || czmonery.equals("")) {
				response.sendRedirect("withtx/tixian.do");
			} else if (passwordjy == null || passwordjy.equals("")) {
				response.sendRedirect("withtx/tixian.do");
			} else {
				WithdrawalformService service = new WithdrawalformServiceImpl(); //实例化业务类

				Withdrawalform wf = new Withdrawalform();
//				UserService us = new UserServiceImpl();
//				User jy = us.transactionPwd(login.getUserId());
				wf.setApplyfortime(new Date());
				wf.setRechargeStatus(10);
				wf.setSucceedtime(new Date());
				wf.setUserId(login.getUserId());
				wf.setWithdrawdMoneny(Long.valueOf(czmonery));
				wf.setErrortime(new Date());
				ResBo tx = service.insert(wf);
				if (tx.getMsg() != null) {
					request.setAttribute("tx", tx.getMsg());
					request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response);
				} else {
					response.sendRedirect("withtx/tixian.do");
				}
			}

		}

	}

}
