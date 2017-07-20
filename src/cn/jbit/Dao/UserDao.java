package cn.jbit.Dao;

import cn.jbit.entity.User;

public interface UserDao {
	
	public User login(User user);
	
	public Integer Zhuce(User user);
	
	public Integer Update(User user);
	
	public Integer UpdatePwd(User user);
	
	public User findNameId(Long UserId);
	
	public User getMobliePhone(String mobilePhone);
	
	public User findPassword(Long id);
	
	public Integer UpdatePassword(User user);
	
	public User transactionPwd(Long uid);
	
	

}
