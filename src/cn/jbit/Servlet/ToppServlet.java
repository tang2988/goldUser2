package cn.jbit.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.jbit.Service.AccountService;
import cn.jbit.Service.BanklistService;
import cn.jbit.Service.TopuprechargeService;
import cn.jbit.Service.UserService;
import cn.jbit.Service.WithdrawalformService;
import cn.jbit.ServiceImpl.AccountServiceImpl;
import cn.jbit.ServiceImpl.BanklistServiceImpl;
import cn.jbit.ServiceImpl.TopuprechargeServiceImpl;
import cn.jbit.ServiceImpl.UserServiceImpl;
import cn.jbit.ServiceImpl.WithdrawalformServiceImpl;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.Banklist;
import cn.jbit.entity.Topuprecharge;
import cn.jbit.entity.User;
import cn.jbit.entity.Withdrawalform;

public class ToppServlet extends HttpServlet {

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
		
		
		//查询银行
		BanklistService bk = new BanklistServiceImpl();
		List<Banklist> ab = bk.findAll();
		request.setAttribute("ab", ab);
		request.getRequestDispatcher("/WEB-INF/Jsp/ToppCZ.jsp").forward(request, response); // 页面转发
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

		String uri = request.getRequestURI();
		if(uri.endsWith("top.do")){
			
			User login = (User) request.getSession().getAttribute("login");
			if (login == null) {
				response.sendRedirect("../userlogin/login.do");
				return;
			}
			String czmonery = request.getParameter("czmonery").trim();
			String raid = request.getParameter("raid").trim();
			
			if(czmonery==null || czmonery.equals("")){
				response.sendRedirect("topp/top.do");
			}else if(raid==null || raid.equals("")){
				response.sendRedirect("topp/top.do");
			}
			if(!Pattern.compile("^([0-9]+|[0-9]{1,3}(,[0-9]{3})*)(.[0-9]{1,2})?$").matcher(czmonery).find()){
					 response.sendRedirect("topp/top.do");
					 return;
			}
			
			
			else{
				TopuprechargeService ts = new TopuprechargeServiceImpl();
				Topuprecharge tp = new Topuprecharge();
				tp.setRechargeStatus(10);
				tp.setRechargeTime(new Date());
				tp.setRecharmoney(new BigDecimal(czmonery));
				
				tp.setBanklistId(Long.valueOf(raid));
				tp.setUserId(login.getUserId());
				
				ResBo cz = ts.rechargeRecord(tp);
				if(cz.getMsg()!=null){
					request.setAttribute("cz", cz.getMsg());
					request.getRequestDispatcher("/WEB-INF/Jsp/success.jsp").forward(request, response);
				}else{
					response.sendRedirect("topp/top.do");
				}
			}

		}
		
	}

}
