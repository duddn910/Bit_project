package Service_impl;

import java.util.List;

import DAO.CoffeeOrderDAO;
import DAO_impl.CoffeeOrderDAOimpl;
import DTO.CoffeeOrderDTO;
import Service.CoffeeOrderService;

public class CoffeeOrderServiceimpl implements CoffeeOrderService {
	
	CoffeeOrderDAO dao = new CoffeeOrderDAOimpl();
	
	@Override
	public List<CoffeeOrderDTO> getOrderlist() {
		// TODO Auto-generated method stub
		return dao.getOrderlist();
	}
	
	public int getCoffeePrice(String coffeeName, String size) {
		
		return dao.getCoffeePrice(coffeeName, size);
	}
	
	public List<CoffeeOrderDTO> getNowOrderlist(){
		return dao.getNowOrderlist();
	}
	
	public void saveOrderlist() {
		
		 dao.saveOrderlist();
	}
	
}
