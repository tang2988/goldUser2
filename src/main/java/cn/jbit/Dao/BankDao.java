package cn.jbit.Dao;

import cn.jbit.entity.Bankcard;

public interface BankDao {
	
	public Bankcard ins(Bankcard bankcard);
	
	public Bankcard findBankcard(Bankcard bankcard);
	
	public Bankcard getCard(Long card);

}
