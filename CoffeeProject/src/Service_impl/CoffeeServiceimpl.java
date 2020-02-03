package Service_impl;

import java.util.List;

import DAO.CoffeeDAO;
import DAO_impl.CoffeeDAOimpl;
import DTO.CoffeeDTO;
import DTO.CoffeeOrderDTO;
import Service.CoffeeService;

public class CoffeeServiceimpl implements CoffeeService {
	
	CoffeeDAO dao = new CoffeeDAOimpl();
	
	@Override
	public List<CoffeeDTO> getCoffeeList() {
		// TODO Auto-generated method stub
		return dao.getCoffeeList();
	}

}
