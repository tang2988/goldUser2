package cn.jbit.ServiceImpl;

import java.util.List;

import cn.jbit.Dao.ProductinformationDao;
import cn.jbit.DaoImpl.ProductinformationDaoImpl;
import cn.jbit.Service.ProductinformationService;
import cn.jbit.entity.Orderinformation;
import cn.jbit.entity.Productinformation;

public class ProductinformationServiceImpl implements ProductinformationService {
	ProductinformationDao dao = new ProductinformationDaoImpl();
	public Productinformation addProduct(Productinformation productinformation) {
		
		return dao.addProduct(productinformation);
	}

	public Productinformation findProById(Long productId) {
		return dao.findProById(productId);
	}

	public Integer Update(Productinformation productinformation) {
		return dao.Update(productinformation);
	}



	public List<Productinformation> findAllPage(int pageNo, int pageSize) {
		return dao.findAllPage( pageNo,  pageSize);
	}

	public Integer UpdateAll(Productinformation productinformation) {
		return dao.UpdateAll(productinformation);
	}

	public Long procount() {
		return dao.procount();
	}

	public List<Productinformation> findProductionformation(){
		return dao.findProductionformation();
	}

	

	
}
