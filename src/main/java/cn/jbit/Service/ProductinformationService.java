package cn.jbit.Service;

import java.util.List;

import cn.jbit.entity.Orderinformation;
import cn.jbit.entity.Productinformation;

public interface ProductinformationService {
	
	/**
	 * 添加
	 * @return
	 */
	public Productinformation addProduct(Productinformation productinformation);
	
	/**
	 * 根据ID查询
	 */
	public Productinformation findProById(Long productId);
	
	/**
	 * 修改库存
	 */
	public Integer Update(Productinformation productinformation);
	
	/**
	 * 查询全部
	 * 
	 */
	

	
	public List<Productinformation> findAllPage(int pageNo ,int pageSize);
	
	public Integer UpdateAll(Productinformation productinformation);
	
	public Long procount();
	
	public List<Productinformation> findProductionformation();
	

}
