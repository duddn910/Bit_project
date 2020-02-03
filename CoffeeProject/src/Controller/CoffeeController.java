package Controller;

import java.util.List;

import DTO.CoffeeDTO;
import Service.CoffeeService;
import Service_impl.CoffeeServiceimpl;
import View.CoffeeTegView;
import View.MenuView;

public class CoffeeController {
	
	CoffeeService cfSv = new CoffeeServiceimpl();
	
	public void menuView() {
		new MenuView();
	}
	
	public void tegView() {
		new CoffeeTegView();
	}
	
	public List<CoffeeDTO> getCoffeeList() {
		
		return cfSv.getCoffeeList();
	}
	
}
