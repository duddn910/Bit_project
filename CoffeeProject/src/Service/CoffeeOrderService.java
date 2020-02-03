package Service;

import java.util.List;

import DTO.CoffeeOrderDTO;

public interface CoffeeOrderService {

	public List<CoffeeOrderDTO> getOrderlist();
	public int getCoffeePrice(String coffeeName, String size);
	public List<CoffeeOrderDTO> getNowOrderlist();
	public void saveOrderlist();
}
