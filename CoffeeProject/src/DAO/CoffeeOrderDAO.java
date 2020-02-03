package DAO;

import java.util.List;

import DTO.CoffeeOrderDTO;

public interface CoffeeOrderDAO {
	
	
	public List<CoffeeOrderDTO> getOrderlist();
	public int getCoffeePrice(String coffeeName, String size);
	public List<CoffeeOrderDTO> getNowOrderlist();
	public void saveOrderlist();
}
