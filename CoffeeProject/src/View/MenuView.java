package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import DTO.CoffeeOrderDTO;
import Singleton.Singleton;

public class MenuView extends JFrame {
	
	JButton Menu1_BT, Menu2_BT;
	//메뉴 1 -> 주문하기 ,  메뉴2 -> 주문내역 
	JButton LogoutBT;
	
	List<CoffeeOrderDTO> orderlist = null;	// 주문내역을 받아올 리스트 생성
	
	
	public MenuView() {
		super("메뉴 화면");
		setLayout(null);
		init();
		
		setBounds(0, 0, 400, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);							
		
	}
	
	public void init() {
		Singleton s = Singleton.getInstance();
		
		JLabel ID = new JLabel();
		ID.setText(s.getLoginID().getId());
		ID.setBounds(30, 20, s.getLoginID().getId().length() * 10, 30);
		ID.setHorizontalTextPosition(JLabel.CENTER);
		ID.setFont(new Font("serif", Font.BOLD, 15));
		
		add(ID);
		
		JLabel ID2 = new JLabel();
		ID2.setText("님 어서오세요 ^^");
		ID2.setBounds((s.getLoginID().getId().length() * 10) + 20, 20, 100, 30);
		add(ID2);
		
		Menu1_BT = new JButton();
		Menu1_BT.setText("주문하기");
		Menu1_BT.setBounds(40, 80, 120, 50);
		Menu1_BT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OrderView();
				dispose();
			}
		});
		add(Menu1_BT);
		
		
		Menu2_BT = new JButton();
		Menu2_BT.setText("주문내역");
		Menu2_BT.setBounds(220, 80, 120, 50);
		Menu2_BT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				s.codCtr.orderCheckView();
				
			}
		});
		add(Menu2_BT);
		
		LogoutBT = new JButton();
		LogoutBT.setText("로그아웃");
		LogoutBT.setBounds(280, 20, 90, 30);
		LogoutBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton s = Singleton.getInstance();
				s.setLoginID(null); //로그아웃시 로그인된 회원정보 초기화 
				s.memCtr.loginView();
				dispose();
			}
		});
		add(LogoutBT);
		
	}
	
	
}
