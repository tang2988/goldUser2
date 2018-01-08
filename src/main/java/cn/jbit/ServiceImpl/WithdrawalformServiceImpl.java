 package cn.jbit.ServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.jbit.Dao.AccountDao;
import cn.jbit.Dao.UserDao;
import cn.jbit.Dao.WithdrawalformDao;
import cn.jbit.DaoImpl.AccountDaoImpl;
import cn.jbit.DaoImpl.UserDaoImpl;
import cn.jbit.DaoImpl.WithdrawalformDaoImpl;
import cn.jbit.Service.WithdrawalformService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.User;
import cn.jbit.entity.Withdrawalform;

public class WithdrawalformServiceImpl implements WithdrawalformService {

	AccountDao accountDao = new AccountDaoImpl();
	WithdrawalformDao withdrawalformDao = new WithdrawalformDaoImpl();
	UserDao dao = new UserDaoImpl();
	
	public ResBo insert(Withdrawalform withdrawalform) {
		ResBo resBo = new ResBo(); // 实例化

		Account account = accountDao.findAccount(withdrawalform.getUserId()); // 根据用户ID查询
		 User user = dao.findUserById(withdrawalform.getUserId());														
		
		BigDecimal accountbalance = account.getAccountbalance(); // 获取当前余额
		BigDecimal withdrawdMoneny = withdrawalform.getWithdrawdMoneny(); // 获取提现余额
		BigDecimal dongjie = account.getFrozenCapital();
	
		
		if (accountbalance.compareTo(accountbalance)>=0) {
			resBo.setMsg("申请成功");

		} else {
			resBo.setMsg("提现金额大于当前余额");
			return resBo;
		}
		Withdrawalform count = withdrawalformDao.insert(withdrawalform);
		if (count != null) {
			account.setAccountbalance((accountbalance.subtract(withdrawdMoneny))); // 当前余额-提现余额
			account.setFrozenCapital((dongjie.add(withdrawdMoneny)));
			Boolean up = accountDao.JianKuan(account);
			if (up) {
				resBo.setSuccess(true);
				resBo.setMsg("提现成功");
				resBo.setData(up);
				return resBo;
			} else {
				resBo.setMsg("失败");
			}
		}
		return resBo;
	}

	public static void main(String[] args) {
		WithdrawalformService service = new WithdrawalformServiceImpl();
		Withdrawalform withdrawalform = new Withdrawalform();
		
		withdrawalform.setApplyfortime(new Date());
		withdrawalform.setRechargeStatus(10);
	
		withdrawalform.setUserId(1L);
		withdrawalform.setWithdrawdMoneny(new BigDecimal(100));
		ResBo aa = service.insert(withdrawalform);
		System.out.println(aa);
	}

	public List<Map<String, Object>> findAll(int pageNo, int pageSize) {
		return withdrawalformDao.findAll(pageNo, pageSize);
	}

	public Long findCount() {
		return withdrawalformDao.findCount();
	}

	

	public Integer updatestatusbysuccesstime(Long withdrawalId,
			Integer rechargeStatus, Date succeedtime) {
		Withdrawalform withdrawalform = new Withdrawalform();
		withdrawalform.setWithdrawalId(withdrawalId);
		withdrawalform.setSucceedtime(new Date());
		withdrawalform.setRechargeStatus(rechargeStatus);
		return withdrawalformDao.updatestatusbysuccesstime(withdrawalform );
	}

	public Withdrawalform findById(Long withdrawalformId) {
		return withdrawalformDao.findById(withdrawalformId);
	}


}
