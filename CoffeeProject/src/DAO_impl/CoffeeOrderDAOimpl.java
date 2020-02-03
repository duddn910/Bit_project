package DAO_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CoffeeOrderDAO;
import DB.DBClose;
import DB.DBConnection;
import DTO.CoffeeOrderDTO;
import Singleton.Singleton;

public class CoffeeOrderDAOimpl implements CoffeeOrderDAO {

	public List<CoffeeOrderDTO> getOrderlist(){
		Singleton s = Singleton.getInstance(); 
		
		String sql = " SELECT * FROM COFFEE_ORDER "
				+ "WHERE USERID = '" + s.getLoginID().getId() + "' "
				+ " ORDER BY ORDERCOUNT DESC"; 
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		//위의 sql문 확인을 위한 콘솔 출력문
		System.out.println("sql : " + sql);
		
		//리턴해줄 리스트 생성
		List<CoffeeOrderDTO> list = new ArrayList<CoffeeOrderDTO>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			// 로그인 할때 저장된 아이디를 싱글톤에서 가져온다.
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CoffeeOrderDTO c = new CoffeeOrderDTO(rs.getInt("ORDERCOUNT"), 
													rs.getString("USERID"),
													rs.getString("COFFEENAME"),
													"",
													rs.getInt("SYRUP"),
													rs.getString("CSIZE"),
													rs.getInt("WHIPPING"),
													0,
													rs.getInt("AMOUNT"),
													rs.getInt("TOTAL"));
				list.add(c);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public int getCoffeePrice(String coffeeName, String size) {
		
		
		String sql = " SELECT " + size + " FROM COFFEEMEM"
				+ "  WHERE NAME =  ?";
				
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		System.out.println("sql : " + sql);
		
		int Price = 0; // 반환할 변수
		
		try {
			
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, coffeeName);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				
				Price = rs.getInt(size);
				
			}else {
				System.out.println("커피이름이 잘못입력되었습니다");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}

		return Price;
	}
	
	public List<CoffeeOrderDTO> getNowOrderlist(){
		Singleton s = Singleton.getInstance();
		return s.orderlist;
	}
	
	public void saveOrderlist() {
		
		Singleton s = Singleton.getInstance();
		
		String sql = "";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		int count = 0;
		try {
			conn = DBConnection.getConnection();
			for(int i = 0; i < s.orderlist.size(); i++) {
				sql = " INSERT  INTO  COFFEE_ORDER (ORDERCOUNT,USERID,COFFEENAME"
						+ ", SYRUP, WHIPPING, CSIZE, AMOUNT, TOTAL) "
						+ " VALUES( " + s.orderlist.get(i).getOrderCount() + ","
						+ "'" + s.orderlist.get(i).getUserId() + "',"
						+ "'" + s.orderlist.get(i).getCoffeeName() + "',"
						//+" TO_DATE( '" + s.orderlist.get(i).getWDATE() + "', '" + "YYYYMMDD'), "
						+ s.orderlist.get(i).getSyrup() + " , "
						+ s.orderlist.get(i).getWhipping() + ", "
						+ "' " + s.orderlist.get(i).getSize() + "' , "
						+ s.orderlist.get(i).getCoffeeCount() + " , "
						+ s.orderlist.get(i).getTotal() + " )";
				
				System.out.println("sql : " + sql);
				
				psmt = conn.prepareStatement(sql);
				count = psmt.executeUpdate(sql);
			}
				
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		
	}
	
}
