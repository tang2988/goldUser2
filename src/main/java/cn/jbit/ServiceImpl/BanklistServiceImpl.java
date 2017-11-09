package cn.jbit.ServiceImpl;

import java.util.List;

import cn.jbit.Dao.BanklistDao;
import cn.jbit.DaoImpl.BanklistDaoImpl;
import cn.jbit.Service.BanklistService;
import cn.jbit.entity.Banklist;

public class BanklistServiceImpl implements BanklistService{
	
	BanklistDao banklistDao = new BanklistDaoImpl();

	public List<Banklist> findAll() {
		return banklistDao.findAll();
	}

}
