package cn.jbit.ServiceImpl;

import cn.jbit.Dao.UserDao;
import cn.jbit.DaoImpl.UserDaoImpl;
import cn.jbit.Service.UserService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.User;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl();

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
			resBo.setSuccess(true);
			resBo.setMsg("注册成功");
			resBo.setData(user); // 返回对象
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
		} else {
			
		}
		
		// 根据用户ID修改密码
		User user = new User();
		user.setPassword(password);
		user.setUserId(userId);
		Integer count = dao.UpdatePassword(user);
		if(count>0){
			resBo.setSuccess(true);
			return resBo;
		}else{
			
			resBo.setSuccess(false);
			resBo.setMsg("修改失败");
			return resBo;
		}

	}

	public static void main(String[] args) {

//		Long userId = 1L;
//		String password = "123123";// 新密码
//		String password_old = "new123";// 新密码
//
		UserService us = new UserServiceImpl();
//System.out.println(us.updatePassword(userId, password, password_old));
		
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

}
