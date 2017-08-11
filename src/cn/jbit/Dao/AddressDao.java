package cn.jbit.Dao;

import cn.jbit.entity.Address;


public interface AddressDao {
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	public Address add(Address address);
	/**
	 * 修改地址
	 */
	public Integer update(Address address);
	
	
	public Address findById(Long addressId);
	
	
	
	
	public Address findByuserId(Long userId,Long addressId);
	
	public Address findByuserId(Long userid);
	
	

}
