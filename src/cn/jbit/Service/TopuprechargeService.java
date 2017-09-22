package cn.jbit.Service;

import java.util.List;
import java.util.Map;

import cn.jbit.base.ResBo;
import cn.jbit.entity.Topuprecharge;

public interface TopuprechargeService {
	
	/**
	 * 充值记录
	 * @param topuprecharge
	 * @return
	 */
	public ResBo rechargeRecord(Topuprecharge topuprecharge);
	
	public List<Topuprecharge> findAll(int pageNo,int pageSize);
	
	public Long findCount();
	
	public List<Map<String, Object>> findAllaccountAndtopuprecharge(int pageno,int pageSize);

}
