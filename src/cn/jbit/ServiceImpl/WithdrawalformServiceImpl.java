package cn.jbit.ServiceImpl;

import java.util.Date;

import cn.jbit.Dao.AccountDao;
import cn.jbit.Dao.WithdrawalformDao;
import cn.jbit.DaoImpl.AccountDaoImpl;
import cn.jbit.DaoImpl.WithdrawalformDaoImpl;
import cn.jbit.Service.WithdrawalformService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.Withdrawalform;

public class WithdrawalformServiceImpl implements WithdrawalformService {

	AccountDao accountDao = new AccountDaoImpl();
	WithdrawalformDao withdrawalformDao = new WithdrawalformDaoImpl();
	public ResBo insert(Withdrawalform withdrawalform) {
		ResBo resBo = new ResBo(); //实例化
		
		Account account = accountDao.findAccount(withdrawalform.getUserId());  //根据用户ID 获取用户信息
		
		Long dq = account.getAccountbalance(); //获取当前余额
		Long tx = withdrawalform.getWithdrawdMoneny(); //获取提现余额
		if(dq>tx){
			resBo.setMsg("提现成功");
			
		}else{
			resBo.setMsg("提现金额大于当前余额");
			return resBo;
		}
		Integer count = withdrawalformDao.insert(withdrawalform);
		if(count>0){
			account.setAccountbalance(dq - withdrawalform.getWithdrawdMoneny());  //当前余额-提现余额
			
			Boolean up = accountDao.Chongzhi(account);
			if(up){
				resBo.setSuccess(true);
				resBo.setMsg("提现成功");
				resBo.setData(up);
				return resBo;
			}else{
				resBo.setMsg("失败");
			}
		}
		return resBo;
	}
	public static void main(String[] args) {
		WithdrawalformService service = new WithdrawalformServiceImpl();
		Withdrawalform withdrawalform = new Withdrawalform();
		withdrawalform.setErrortime(new Date());
		withdrawalform.setApplyfortime(new Date());
		withdrawalform.setRechargeStatus(10);
		withdrawalform.setSucceedtime(new Date());
		withdrawalform.setUserId(1L);
		withdrawalform.setWithdrawdMoneny(100000L);
		ResBo aa = service.insert(withdrawalform);
		System.out.println(aa);
	}

}
