package cn.jbit.ServiceImpl;

import java.math.BigDecimal;

import cn.jbit.Dao.AccountDao;
import cn.jbit.Dao.UserDao;
import cn.jbit.DaoImpl.AccountDaoImpl;
import cn.jbit.DaoImpl.UserDaoImpl;
import cn.jbit.Service.UserService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.User;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl();
	AccountDao accountDao = new AccountDaoImpl();

	public ResBo login(User user) {
		ResBo res = new ResBo();
		User user2 = dao.login(user);
		if (user2 != null) {
			res.setMsg("登录成功");
			res.setData(user2);
			return res;
		} else {
			res.setMsg("用户名密码错误");
		}
		return res;
	}

	public ResBo register(User user) {
		ResBo resBo = new ResBo();
		User aaa = dao.getMobliePhone(user.getMobilePhone()); // 查询用户名
		if (aaa != null) { // 判断
			resBo.setMsg("用户名已经存在");
			resBo.setData(user); // 返回对象
			return resBo;
		}
		
		 User zc = dao.Zhuce(user); // 调用添加方法
		if (zc !=null ) { // 大于0 就注册成功
			
			Account account = new Account();
			account.setAccountbalance(new BigDecimal(0));
			account.setAccountStatus(10);
			account.setAccumulatedIncome(new BigDecimal(0));
			account.setFrozenCapital(new BigDecimal(0));
			account.setFrostgold(new BigDecimal(0));
			account.setGoldgrammage(new BigDecimal(0));
			account.setGoldpresentvalue(new BigDecimal(0));
			account.setUserId(zc.getUserId());
			account.setTotalAssets(new BigDecimal(0));
			account = accountDao.addAccount(account);
			if(account!=null){
				resBo.setSuccess(true);
				resBo.setMsg("注册成功");
				resBo.setData(user); // 返回对象
			}else{
				resBo.setSuccess(false);
				resBo.setMsg("注册失败");
			}
			
		} else { // 否则注册失败
			resBo.setMsg("注册失败");
		}
		
		return resBo;
	}

	public ResBo Update(User user) {
		ResBo resBo = new ResBo();
		Integer up = dao.Update(user); // 修改方法
		if (up > 0) {
			resBo.setMsg("实名成功"); // 正确结果
			resBo.setData(user); // 返回对象
		} else {
			resBo.setMsg("实名失败"); // 失败
		}
		return resBo;
	}

	public Integer modifytheTradingPassword(User user) {
		return dao.UpdatePwd(user);
	}

	public User findNameId(Long UserId) {
		return dao.findNameId(UserId);
	}

	public User getMobliePhone(String mobilePhone) {
		return dao.getMobliePhone(mobilePhone);
	}

	public User findPassword(Long id) {
		return dao.findPassword(id);
	}

	public ResBo updatePassword(Long userId, String password, String password_old ) {
		ResBo resBo =new ResBo();
		
		UserDao dao = new UserDaoImpl();
		// 判断旧密码与数据库是否一致(鉴权)
		User userDB = dao.findUserById(userId);
		if (!password_old.equals(userDB.getPassword())) {
			resBo.setMsg("旧密码与数据库不一致");
			return resBo;
		}else{
			
		}
		// 根据用户ID修改密码
		User user = new User();
		user.setPassword(password);
		user.setUserId(userId);
		Integer count = dao.UpdatePassword(user);
		if(count>0){
			resBo.setSuccess(true);
			resBo.setData(count);
			return resBo;
		}else{
			
			resBo.setSuccess(false);
			resBo.setMsg("修改失败");
			return resBo;
		}

}

	public static void main(String[] args) {

		UserService us = new UserServiceImpl();
 User user = new User();
 user.setIdcardNo("123123");
 user.setMobilePhone("13015847963");
 user.setPassword("123123");
 user.setRealName("xxh");
 user.setTransactionPwd("123123");
 user.setUserStatus(10);

		//System.out.println(us.updatePassword(userId, password, password_old));
 	ResBo aa = us.register(user);
		System.out.println(aa);
		
	}

	public ResBo transactionPwd(Long uid,String trpassword) {
		ResBo resBo =new ResBo();
		User aa = dao.transactionPwd(uid);
		if(!trpassword.equals(aa.getTransactionPwd())){
			resBo.setMsg("正确");
			return resBo;
		}else{
			resBo.setMsg("失败");
		}
		return resBo;
	}

	public User getpassword(String password) {
		return dao.getpassword(password);
	}

	@Override
	public User findUserById(Long userId) {
		return dao.findUserById(userId);
	}
}
