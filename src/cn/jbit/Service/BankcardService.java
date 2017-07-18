package cn.jbit.Service;

import cn.jbit.base.ResBo;
import cn.jbit.entity.Bankcard;

public interface BankcardService {
	
	/**
	 * 添加银行卡
	 * @param bankcard
	 * @return
	 */
	public ResBo ins(Bankcard bankcard);
	
	/**
	 * 查询卡号户名
	 * @param bankcard
	 * @return
	 */
	public Bankcard findBankcard(Bankcard bankcard);
	/**
	 * 根据卡号查询
	 * @param card
	 * @return
	 */
	public Bankcard getCard(Long card);

}
