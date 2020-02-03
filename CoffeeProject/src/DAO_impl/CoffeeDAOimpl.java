package DAO_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CoffeeDAO;
import DB.DBClose;
import DB.DBConnection;
import DTO.CoffeeDTO;
import DTO.CoffeeOrderDTO;

public class CoffeeDAOimpl implements CoffeeDAO {

	@Override
	public List<CoffeeDTO> getCoffeeList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM coffeemem "
					+ " ORDER BY SHORT DESC";
		
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		//리턴할 리스트 생성
		List<CoffeeDTO> list = new ArrayList<CoffeeDTO>();
		
		//반드시 sql문을 콘솔로 출력해서 제대로 된 커리문이 넘어갔는지 확인해야됨
		System.out.println("sql : " + sql);
		
		try {
			//디비와 연결 
			conn = DBConnection.getConnection();
			//sql문 DB로 보내서 실행 
			psmt = conn.prepareStatement(sql);
			//위에서 실행한 값을 가져오기
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				//rs에 값이 없을때까지 
				CoffeeDTO cd = new CoffeeDTO(rs.getString(1), // 커피이름
											rs.getInt(2), // short 가격
											 rs.getInt(3), // tall 가격
											 rs.getInt(4)); // grande 가격
				
				list.add(cd);
			}
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}finally {
			//무조건 DB연결 후에 위에 사용한 변수들은 해방시켜야됨
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}

}
