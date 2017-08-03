package cn.jbit.ServiceImpl;

import cn.jbit.Dao.AddressDao;
import cn.jbit.DaoImpl.AddressDaoImpl;
import cn.jbit.Service.AddressService;
import cn.jbit.entity.Address;

public class AddressServiceImpl implements AddressService {
	
	AddressDao addressDao = new AddressDaoImpl();
	public Address add(Address address) {
		return addressDao.add(address);
	}

	public Integer update(Address address) {
		return addressDao.update(address);
	}

	public Address findById(Long addressId) {
		return addressDao.findById(addressId);
	}

	public Address findByuserId(Long userId) {
		return addressDao.findByuserId(userId);
	}

}
