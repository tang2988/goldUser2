package cn.jbit.ServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.jbit.Dao.AccountDao;
import cn.jbit.Dao.TopuprechargeDao;
import cn.jbit.Dao.TradeflowtableDao;
import cn.jbit.DaoImpl.AccountDaoImpl;
import cn.jbit.DaoImpl.TopuprechargeDaoImpl;
import cn.jbit.DaoImpl.TradeflowtableDaoImpl;
import cn.jbit.Service.TopuprechargeService;
import cn.jbit.base.ResBo;
import cn.jbit.entity.Account;
import cn.jbit.entity.Topuprecharge;
import cn.jbit.entity.Tradeflowtable;

public class TopuprechargeServiceImpl implements TopuprechargeService{

	AccountDao accountDao = new AccountDaoImpl();
	TopuprechargeDao topuprechargeDao = new TopuprechargeDaoImpl();
	TradeflowtableDao tradeflowtableDao = new TradeflowtableDaoImpl();
	
	public ResBo rechargeRecord(Topuprecharge topuprecharge) {
		ResBo resBo = new ResBo();
		//保存充值的记录
		 Topuprecharge chargeBean = topuprechargeDao.rechargeRecord(topuprecharge);
		if(chargeBean!=null){
			
			
			 
			
			//获取用户的数据
			Account account = accountDao.findAccount(topuprecharge.getUserId()); //调用查询方法 根据用户ID查询 
			
			//获取当前余额
			 BigDecimal ye = account.getAccountbalance();
			BigDecimal aa = topuprecharge.getRecharmoney();
			
			//余额赋值
			account.setAccountbalance(ye.add(aa)); //当前余额+充值余额
			
			//更新账户数据
			Boolean bl = accountDao.TopCZ(account);
			if(bl){
				Tradeflowtable tradeflowtable = new Tradeflowtable();
				 tradeflowtable.setBusinessId(chargeBean.getRechargeId());
				 tradeflowtable.setBusinessdescription("充值");
				 tradeflowtable.setMoney(topuprecharge.getRecharmoney());
				 tradeflowtable.setType(10);
				 tradeflowtable.setBusinesstype(10);
				 tradeflowtable.setCreateTime(new Date());
				 tradeflowtable = tradeflowtableDao.addTrade(tradeflowtable );
				if(tradeflowtable.getTransactionId()>0){
					topuprecharge.setSucceedTime(new Date());
					topuprecharge.setRechargeStatus(20);
					topuprecharge.setRechargeId(chargeBean.getRechargeId());
					topuprechargeDao.StatusAndTime(topuprecharge);
					resBo.setSuccess(true);
					resBo.setMsg("充值金额成功"); //成功提示
					resBo.setData(bl);  //返回对象
				}else{
					topuprecharge.setErrorTime(new Date());
					topuprecharge.setRechargeStatus(90);
					topuprecharge.setRechargeId(chargeBean.getRechargeId());
					topuprechargeDao.updateStatusAndTime(topuprecharge);
					resBo.setMsg("充值失败");
				}
				
			}else{
				topuprecharge.setErrorTime(new Date());
				topuprecharge.setRechargeStatus(90);
				topuprecharge.setRechargeId(chargeBean.getRechargeId());
				topuprechargeDao.updateStatusAndTime(topuprecharge);
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
		tp.setRecharmoney(new BigDecimal(10000.2012323123123123123123123123));
		tp.setSucceedTime(new Date());
		tp.setBanklistId(1L);
		tp.setUserId(114L);
	
		ResBo aa = service.rechargeRecord(tp);
		System.out.println(aa);
	}

	public List<Topuprecharge> findAll(int pageNo, int pageSize) {
		return topuprechargeDao.findAll(pageNo, pageSize);
	}

	public Long findCount() {
		return topuprechargeDao.findCount();
	}

	public List<Map<String, Object>> findAllaccountAndtopuprecharge(int pageno,int pageSize) {
		return topuprechargeDao.findAllaccountAndtopuprecharge(pageno, pageSize);
	}

	public Integer updateStatusAndTime(Topuprecharge topuprecharge) {
		return topuprechargeDao.updateStatusAndTime(topuprecharge);
	}

}
