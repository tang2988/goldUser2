package cn.jbit.Service;

import cn.jbit.base.ResBo;
import cn.jbit.entity.Topuprecharge;

public interface TopuprechargeService {
	
	/**
	 * 充值记录
	 * @param topuprecharge
	 * @return
	 */
	public ResBo rechargeRecord(Topuprecharge topuprecharge);

}
