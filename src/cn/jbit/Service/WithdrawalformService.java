package cn.jbit.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.jbit.base.ResBo;
import cn.jbit.entity.Withdrawalform;

public interface WithdrawalformService {

	/**
	 * 增加提现记录
	 * 
	 * @param withdrawalform
	 * @return
	 */
	public ResBo insert(Withdrawalform withdrawalform);

	public List<Map<String, Object>> findAll(int pageNo, int pageSize);

	public Long findCount();

	public Integer updatestatusbysuccesstime(Long withdrawalId, Integer rechargeStatus, Date succeedtime);
	
	public Withdrawalform findById(Long withdrawalId);

	
}
