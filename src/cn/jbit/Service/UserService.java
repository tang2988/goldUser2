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
	public User findPassword(Long id);
	/**
	 * 修改登录密码
	 * @param user
	 * @return
	 */
	public ResBo updatePassword(Long userId, String password, String password_old) ;
	
	/**
	 * 根据ID查询交易密码
	 */
	public ResBo transactionPwd(Long uid,String trpassword);
	
	/**
	 * 根据密码查询密码
	 * 
	 */
	public User getpassword(String password);
}
