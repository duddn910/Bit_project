package Service;

import DTO.MemberDTO;

public interface MemberService {
	
	public boolean searchID(String id);
	public boolean addMember(String id, String pw, String name, String email);
	public MemberDTO Login(String ID , String Pw);
}
