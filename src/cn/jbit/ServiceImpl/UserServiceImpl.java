package cn.jbit.ServiceImpl;

import cn.jbit.Dao.UserDao;
import cn.jbit.DaoImpl.UserDaoImpl;
import cn.jbit.Service.UserService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.User;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl();
	public ResBo login(User user){
		ResBo res = new ResBo();
		User user2 = dao.login(user);
		if(user2!=null){
			res.setMsg("登录成功");
			res.setData(user2);
			return res;
		}else{
			res.setMsg("用户名密码错误");
		}
		return res;
	}

	public ResBo register(User user) {
		ResBo resBo = new ResBo();
		User aaa = dao.getMobliePhone(user.getMobilePhone());  //查询用户名
		if(aaa!=null){		//判断
			resBo.setMsg("用户名已经存在"); 
			resBo.setData(user);	//返回对象
			return resBo;
		}
		
		Integer zc = dao.Zhuce(user);  //调用添加方法
		if(zc>0){		//大于0 就注册成功
			resBo.setSuccess(true); 
			resBo.setMsg("注册成功");
			resBo.setData(user); //返回对象
		}else{ 		//否则注册失败
			resBo.setMsg("注册失败");
		}
		return resBo;
	}

	public ResBo Update(User user) {
		ResBo resBo = new ResBo();
		Integer up = dao.Update(user);  //修改方法
		if(up>0){
				resBo.setMsg("实名成功"); //正确结果
				resBo.setData(user);	//返回对象
			}else{
				resBo.setMsg("实名失败"); //失败
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

	public ResBo updatePassword(User user) {
		ResBo resBo = new ResBo();
		 User pwd = dao.findPassword(user.getUserId());  //调用查询方法 获取密码
		if(pwd==null){
			resBo.setMsg("原密码错误");
			resBo.setData(pwd);
			return resBo;
		}
		Integer aa = dao.UpdatePassword(user);  			//调用修改密码方法
		 if(aa>0){
			 resBo.setSuccess(true); 
			 resBo.setMsg("密码修改成功");	//修改成功后提示
			 resBo.setData(aa);	//返回对象
		 }else{
			 resBo.setMsg("修改失败");
		 }
		return resBo;
	}
	
	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		User user = new User();
		user.setUserId(1L);
		user.setPassword("789789");
		 ResBo aa = us.updatePassword(user);
		System.out.println(aa);

	}

	public User transactionPwd(Long uid) {
		
		return dao.transactionPwd(uid);
	}

}
