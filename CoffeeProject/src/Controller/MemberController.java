package Controller;

import javax.swing.JOptionPane;

import DTO.MemberDTO;
import Service.MemberService;
import Service_impl.MemberServiceimpl;
import Singleton.Singleton;
import View.AddMemberView;
import View.LoginView;
import View.MenuView;

public class MemberController {
	
	MemberService memSv = new MemberServiceimpl();
	
	public void loginView() {
		new LoginView();
	}
	public void addMemberView() {
		new AddMemberView();
	}
	
	
	
	public int LoginAf(String id, String pw) {
		
		MemberDTO dto = memSv.Login(id, pw);
		
		if(dto != null) {
			// ID는 있는 상황
			if(dto.getPwd().equals(pw)) {
				//ID도 맞고 PW도 맞는 상황
				//싱글톤에 정보 전달 
				Singleton s = Singleton.getInstance();
				s.setLoginID(dto);
				
				return 2;  // 2개 다 맞을 때
			}else {
				
				return 1; // ID만 맞을 때
			}
		}
		return 0; // ID 틀릴 때
	}
	
	public boolean addMember(String id, String pw, String name, String email) {
		return memSv.addMember(id, pw, name, email);
	}
	
	public boolean idCheck(String id) {
		
		return memSv.searchID(id); 
	}
	
	
}
