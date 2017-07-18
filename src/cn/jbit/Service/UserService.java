package cn.jbit.Service;

import cn.jbit.base.ResBo;
import cn.jbit.entity.User;

public interface UserService {
	
	/**
	 * 登录
	 * @param mobilePhone
	 * @param Password
	 * @return
	 */
	public ResBo login(User user);
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public ResBo register(User user);
	
	/**
	 * 修改姓名身份
	 * @param user
	 * @return
	 */
	public ResBo Update(User user);
	/**
	 * 修改交易密码
	 * @param user
	 * @return
	 */
	
	public Integer modifytheTradingPassword(User user);
	/**
	 * 查询姓名身份证
	 * @param UserId
	 * @return
	 */
	public User findNameId(Long UserId);
	/**
	 * 通过手机号码查找
	 */
	public User getMobliePhone(String mobilePhone);
	/**
	 * 
	 * @param userId
	 * @return
	 */
	/**
	 * 查询密码
	 * @param userId
	 * @return
	 */
	public User findPassword(String Password);
	/**
	 * 修改登录密码
	 * @param user
	 * @return
	 */
	public ResBo UpdatePassword(User user);
}
