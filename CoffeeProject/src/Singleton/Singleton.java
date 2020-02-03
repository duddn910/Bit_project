package Singleton;

import java.util.ArrayList;
import java.util.List;

import Controller.CoffeeController;
import Controller.CoffeeOrderController;
import Controller.MemberController;
import DTO.CoffeeOrderDTO;
import DTO.MemberDTO;


public class Singleton {
	
	public static Singleton singleton = null;
	
	public MemberController memCtr = null;
	public CoffeeController cofCtr = null;
	public CoffeeOrderController codCtr = null;
	
	public List<CoffeeOrderDTO> orderlist = null;
	
	private MemberDTO LoginID = null;
	
	private Singleton() {
		memCtr = new MemberController();
		cofCtr = new CoffeeController();
		codCtr = new CoffeeOrderController();
		orderlist = new ArrayList<CoffeeOrderDTO>();
	}
	
	public static Singleton getInstance() {
		
		if(singleton == null) {
			singleton = new Singleton();
		}
		
		return singleton;
	}

	public MemberDTO getLoginID() {
		return LoginID;
	}

	public void setLoginID(MemberDTO loginID) {
		LoginID = loginID;
	}

	
	
	
	
	
}
