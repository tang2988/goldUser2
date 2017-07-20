package cn.jbit.ServiceImpl;

import java.util.List;

import cn.jbit.Dao.AccountDao;
import cn.jbit.DaoImpl.AccountDaoImpl;
import cn.jbit.Service.AccountService;
import cn.jbit.entity.Account;

public class AccountServiceImpl implements AccountService {
	AccountDao accountDao = new AccountDaoImpl();
	public List<Account> findUser() {
		return accountDao.findUser();
	}

	public Account findAccount(Long UserId) {
		return accountDao.findAccount(UserId);
	}

	@Override
	public Boolean Recharge(Account account) {
		return accountDao.Chongzhi(account);
	}

}
