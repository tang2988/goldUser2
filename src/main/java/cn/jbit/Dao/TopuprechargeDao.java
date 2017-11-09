package cn.jbit.Dao;

import java.util.List;
import java.util.Map;

import cn.jbit.entity.Topuprecharge;

public interface TopuprechargeDao {
	
	public Topuprecharge rechargeRecord(Topuprecharge topuprecharge);
	
	public List<Topuprecharge> findAll(int pageNo,int pageSize);
	
	public Long findCount();
	
	public List<Map<String, Object>> findAllaccountAndtopuprecharge(int pageno,int pageSize);
	
	public Integer updateStatusAndTime(Topuprecharge topuprecharge);
	
	public Integer StatusAndTime(Topuprecharge topuprecharge);

}
