package Service_impl;

import DAO.MemberDAO;
import DAO_impl.MemberDAOimpl;
import DTO.MemberDTO;
import Service.MemberService;

public class MemberServiceimpl implements MemberService {
	
	MemberDAO dao = new MemberDAOimpl();
	
	@Override
	public boolean searchID(String id) {
		
		return dao.searchID(id);
	}

	@Override
	public boolean addMember(String id, String pw, String name, String email) {
		// TODO Auto-generated method stub
		return dao.addMember(id, pw, name, email);
	}

	@Override
	public MemberDTO Login(String ID, String Pw) {
		// TODO Auto-generated method stub
		return dao.Login(ID, Pw);
	}

}
