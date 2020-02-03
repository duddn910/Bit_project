package Controller;



import java.util.Date;
import java.util.List;

import DTO.CoffeeOrderDTO;
import Service.CoffeeOrderService;
import Service_impl.CoffeeOrderServiceimpl;
import Singleton.Singleton;
import View.CoffeeOrderListView;
import View.OrderCheckView;

public class CoffeeOrderController {
	
	CoffeeOrderService Cosv = new CoffeeOrderServiceimpl();
	 
	public void OrderAdd(String coffeeName, String size, int syrup, int whipping, int shot, int coffeecount) {
		Singleton s = Singleton.getInstance();
		
		//현재 시간을 넣기 위한 함수와 변수 
		Date d = new Date(); 
		String wdate = d.toString();
		
		//잔수에 따른 가격
		int Price = Cosv.getCoffeePrice(coffeeName, size);
		Price = Price * coffeecount;
		
		CoffeeOrderDTO dto = new CoffeeOrderDTO(s.getLoginID().getOrderCount()+1
												,s.getLoginID().getId(),
												coffeeName,
												wdate,
												syrup,
												size,
												whipping,
												shot,
												coffeecount,
												Price
												);
		
		s.orderlist.add(dto); 
	}
	
	public List<CoffeeOrderDTO> getOrderlist(){
		return Cosv.getOrderlist();
	}
	
	
	public List<CoffeeOrderDTO> getNowOrderlist(){
		
		return Cosv.getNowOrderlist();
	}
	
	public int getCoffeePrice(String coffeeName, String size) {
		
		return Cosv.getCoffeePrice(coffeeName, size);
	}
	
	
	public void OrderListView() {
		new CoffeeOrderListView();
	}
	
	public void saveOrderlist() {
		
		Cosv.saveOrderlist();

	}
	
	public void orderCheckView() {
		new OrderCheckView();
	}
}
