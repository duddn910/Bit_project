package main;

import DB.DBConnection;
import Singleton.Singleton;
import View.AddMemberView;
import View.CoffeeTegView;
import View.LoginView;
import View.MenuView;
import View.OrderView;

public class main {

	public static void main(String[] args) {
		//디비 연결과 초기화 
		DBConnection.initConnection();
		
		Singleton s = Singleton.getInstance();
		s.memCtr.loginView();
		
		//new LoginView();
		//new AddMemberView();
		//new MenuView();
		//new OrderView();
		//new CoffeeTegView();
		
	}
	
}
