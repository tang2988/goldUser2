package cn.jbit.Dao;

import java.util.List;

import cn.jbit.entity.Productinformation;

public interface ProductinformationDao {
	
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
	 * 修改
	 */
	public Integer Update(Productinformation productinformation);
	
	/**
	 * 查询全部
	 */
	public List<Productinformation> findProductionformation();

	

}
