package cn.jbit.Dao;

import java.util.List;

import cn.jbit.entity.Account;



public interface AccountDao {

	public List<Account>findUser();
	
	public Account findAccount(Long UserId);
	
	public Boolean JianKuan(Account account);
	
}
