package cn.jbit.ServiceImpl;

import cn.jbit.Dao.BankDao;
import cn.jbit.DaoImpl.BankDaoImpl;
import cn.jbit.Service.BankcardService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Bankcard;

public class BankcardServiceImpl implements BankcardService {

	BankDao bankDao = new BankDaoImpl();
	public ResBo ins(Bankcard bankcard) {
		ResBo resBo = new ResBo();
		
		Bankcard kh = bankDao.getCard(bankcard.getCard()); //调用查询卡号方法,从bankcard获取到卡号
		if(kh!=null){	//判断
			resBo.setMsg("卡号已经存在"); //已经存在
			resBo.setData(bankcard); //返回对象
			return resBo;
		}
		 Bankcard zc = bankDao.ins(bankcard);  //调用 添加方法
		if(zc!=null){  
			resBo.setMsg("绑定成功"); //大于0就绑定成功
			resBo.setData(bankcard); //返回对象
			return resBo;
		}else{						//否则绑定失败
			resBo.setMsg("绑定失败");  
		}
		return resBo;
	}

	public Bankcard findBankcard(Bankcard bankcard) {
		return bankDao.findBankcard(bankcard);
	}

	public Bankcard getCard(Long card) {
		return bankDao.getCard(card);
	}

	public static void main(String[] args) {
		BankcardService bankcardService = new BankcardServiceImpl();
		Bankcard bankcard = new Bankcard();
		bankcard.setBankcardStatus(10);
		bankcard.setBanknameId("建设");
		bankcard.setCard(12312313221L);
		bankcard.setUserId(3L);
		ResBo aa = bankcardService.ins(bankcard);
		System.out.println(aa);
	}
}
