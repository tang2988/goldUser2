package cn.jbit.Dao;

import java.util.List;
import java.util.Map;

import cn.jbit.entity.Withdrawalform;

public interface WithdrawalformDao {
	
	public Withdrawalform insert(Withdrawalform withdrawalform);

	public List<Map<String, Object>> findAll(int pageNo,int pageSize);
	
	public Long findCount();
	
	public Integer updatestatusbysuccesstime(Withdrawalform withdrawalform);
	
	public Withdrawalform findById(Long withdrawalformId);
	
	
}
