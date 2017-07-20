package cn.jbit.Service;

import cn.jbit.base.ResBo;
import cn.jbit.entity.Withdrawalform;

public interface WithdrawalformService {

	/**
	 * 增加提现记录
	 * @param withdrawalform
	 * @return
	 */
	public ResBo insert(Withdrawalform withdrawalform);
}
