package cn.jbit.ServiceImpl;

import java.util.Date;

import cn.jbit.Dao.AccountDao;
import cn.jbit.Dao.TopuprechargeDao;
import cn.jbit.DaoImpl.AccountDaoImpl;
import cn.jbit.DaoImpl.TopuprechargeDaoImpl;
import cn.jbit.Service.TopuprechargeService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.Topuprecharge;

public class TopuprechargeServiceImpl implements TopuprechargeService{

	AccountDao accountDao = new AccountDaoImpl();
	TopuprechargeDao topuprechargeDao = new TopuprechargeDaoImpl();
	
	public ResBo rechargeRecord(Topuprecharge topuprecharge) {
		ResBo resBo = new ResBo();
		//保存充值的记录
		Integer count = topuprechargeDao.rechargeRecord(topuprecharge);
		if(count>0){
			
			//获取用户的数据
			Account account = accountDao.findAccount(topuprecharge.getUserId()); //调用查询方法 根据用户ID查询 
			
			//获取当前余额
			Long ye = account.getAccountbalance();
			
			//余额赋值
			account.setAccountbalance(ye + topuprecharge.getRecharmoney()); //当前余额+充值余额
			
			//更新账户数据
			Boolean bl = accountDao.Chongzhi(account);
			if(bl){
				resBo.setSuccess(true);
				resBo.setMsg("充值金额成功"); //成功提示
				resBo.setData(bl);  //返回对象
			}else{
				resBo.setMsg("充值失败");
			}
		}
		return resBo;
	}
	
	public static void main(String[] args) {
		TopuprechargeService service = new TopuprechargeServiceImpl();
		
		Topuprecharge tp = new Topuprecharge();
		tp.setRechargeStatus(10);
		tp.setRechargeTime(new Date());
		tp.setRecharmoney(10000);
		tp.setSucceedTime(new Date());
		tp.setBanklistId(1L);
		tp.setUserId(1L);
		ResBo aa = service.rechargeRecord(tp);
		System.out.println(aa);
	}

}
