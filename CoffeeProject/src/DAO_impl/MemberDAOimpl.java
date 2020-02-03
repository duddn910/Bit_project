package DAO_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.MemberDAO;
import DB.DBClose;
import DB.DBConnection;
import DTO.MemberDTO;
import Singleton.Singleton;

public class MemberDAOimpl implements MemberDAO {

	public boolean searchID(String id) {
		
		String sql = "SELECT * FROM COFMEMBER "
				+ " WHERE ID = ?";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		System.out.println("sql : " + sql);
		
		
		try {
			
			conn = DBConnection.getConnection(); // DB연결 
			psmt = conn.prepareStatement(sql); // DB로 sql문 전송 
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();  //실행후 값 가져오기 
			
			if(rs.next()) return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//DB 사용후 해제 작업
			DBClose.close(psmt, conn, rs);
		}
		
		return true;
	}
	
	
	@Override
	public boolean addMember(String id, String pw, String name, String email) {
		// 회원관리 DB에 추가하는 
		String sql = " INSERT INTO COFMEMBER(ID, PWD, NAME, EMAIL, ORDERCOUNT, AUTH) "
				+ " VALUES( '" + id + "', " + "'" + pw + "',"
							+ "'" + name + "'," + "'" + email + "', 0, 0 )";
				
		
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		System.out.println("sql : " + sql);
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			int count = 0;
			count = psmt.executeUpdate(sql);
			if(count == 0) {
				return false;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//DB연결 후 해제 
			DBClose.close(psmt, conn, rs);
		}
		
		return true;
	}

	@Override
	public MemberDTO Login(String ID, String Pw) {
		// 로그인하려는 아이디와 비밀번호를 DB에서 검색을 통해 
		// 있는지 없는지 판단 
		String sql = " SELECT * FROM COFMEMBER "
				+ "WHERE ID = '" + ID + "'";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		System.out.println("sql : " + sql);
		
		MemberDTO dto = null;
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			//psmt.setString(1, ID);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				//쿼리문 실행 후 데이터가 있으면 정보 넣기 
				dto = new MemberDTO(rs.getString("ID"),
												rs.getString("PWD"),
												rs.getString("NAME"),
												rs.getString("EMAIL"),
												rs.getInt("ORDERCOUNT"),
												rs.getInt("AUTH"));	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return dto;
		
	}
	
	
	
}
