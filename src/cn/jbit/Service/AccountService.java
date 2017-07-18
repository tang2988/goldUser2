package cn.jbit.Service;

import java.util.List;

import cn.jbit.entity.Account;

public interface AccountService {
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Account> findUser();
	/**
	 * 根据用户ID查询
	 * @param UserId
	 * @return
	 */
	public Account findAccount(Long UserId);

}
