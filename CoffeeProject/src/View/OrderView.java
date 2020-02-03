package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import DTO.CoffeeOrderDTO;
import Singleton.Singleton;

public class OrderView extends JFrame implements ItemListener{
	
	JButton MenuBT, OrderBT, NowBT, TegBT, Order_BT;
	// 메뉴창으로 돌아가기, 주문하기, 현재주문목록(수정, 삭제)
	JComboBox<String> Coffee, Amount;
	String[] coffee_str = {"아메리카노", "카푸치노", "카페 라떼", "카라멜 라떼", "카페 모카", "카라멜 모카", "화이트 초콜릿 모카", "카라멜 마끼아또", "딸기 스무디", "블루베리 스무디", "파인애플 스무디"}; 
	String[] Amount_str = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	
	JPanel size, syrup , other;
	JRadioButton rb1, rb2, rb3, rb4, rb5, rb6;
	JCheckBox cb1,cb2;
	
	ButtonGroup sizeG, syrupG; 
	
	List<CoffeeOrderDTO> orderlist = null;
	
	
	public OrderView() {
		super("주문화면");
		setLayout(null);
		init();
		
		setBounds(0, 0, 600, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void init() {
		
		//커피 종류를 가진 콤보박스
		JLabel label = new JLabel();
		label.setBounds(30, 100, 60, 40);
		label.setText("커피종류 :");
		add(label);
		Coffee = new JComboBox<String>(coffee_str);
		Coffee.setBounds(100, 100, 400, 50);
		Coffee.setSelectedIndex(0);
		add(Coffee);
		
		//잔수를 가진 콤보박스 
		JLabel label2 = new JLabel();
		label2.setBounds(260, 400, 50, 40);
		label2.setText("잔");
		add(label2);
		Amount = new JComboBox<String>(Amount_str);
		Amount.setBounds(200, 400, 50, 40);
		add(Amount);
		
		// 커피의 사이즈를 입력받을 패널 
		size = new JPanel();
		size.setBackground(Color.green);
		size.setLayout(new GridLayout(4,1));
		size.setBounds(50, 210, 150, 150);
		size.add(new JLabel("사이즈"));
		rb1 = new JRadioButton("SHORT");
		rb1.addItemListener(this);
		rb1.setSelected(true);
		
		rb2 = new JRadioButton("TALL");
		rb2.addItemListener(this);
		
		rb3 = new JRadioButton("GRANDE");
		rb3.addItemListener(this);
		
		//버튼 그룹생성 
		sizeG = new ButtonGroup();
		sizeG.add(rb1);
		sizeG.add(rb2);
		sizeG.add(rb3);
		//패널에 라디오버튼 추가 
		size.add(rb1);
		size.add(rb2);
		size.add(rb3);
		
		add(size);
		
		
		
		// 커피에 시럽을 넣을지 판단하는 패널 
		syrup = new JPanel();
		syrup.setBackground(Color.CYAN);
		syrup.setLayout(new GridLayout(4,1));
		syrup.setBounds(220, 210, 150, 150);
		syrup.add(new JLabel("시럽추가"));
		
		rb4 = new JRadioButton("시럽없음");
		rb4.setSelected(true);
		rb4.addItemListener(this);
		
		//첫 화면에 시럽없음 자동선택
		rb5 = new JRadioButton("카라멜 시럽");
		rb5.addItemListener(this);
		
		rb6 = new JRadioButton("바닐라 시럽");
		rb6.addItemListener(this);
		
		//버튼 그룹생성 
		syrupG = new ButtonGroup();
		syrupG.add(rb4);
		syrupG.add(rb5);
		syrupG.add(rb6);
		//패널에 라디오버튼 추가 
		syrup.add(rb4);
		syrup.add(rb5);
		syrup.add(rb6);
		
		add(syrup);
		//휘핑 , 샷 추가 등을 선택하는 패널 
		other = new JPanel();
		other.setBackground(Color.red);
		other.setLayout(new GridLayout(4,1));
		other.setBounds(390, 210, 150, 150);
		other.add(new JLabel("기타"));
		
		cb1 = new JCheckBox("샷 추가");
		cb1.addItemListener(this);
		cb2 = new JCheckBox("휘핑크림 추가");
		cb2.addItemListener(this);
		
		JLabel label4 = new JLabel();
		label4.setText("**샷  & 휘핑 각 500원");
		
		other.add(cb1);
		other.add(cb2);
		other.add(label4);
		add(other);
		
		MenuBT = new JButton("메뉴화면");
		MenuBT.setBounds(450, 20, 100, 40);
		MenuBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton s = Singleton.getInstance();
				s.cofCtr.menuView();
				dispose();
			}
		});
		add(MenuBT);
		
		NowBT = new JButton("주문목록");
		NowBT.setBounds(50, 400, 100, 50);
		NowBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton s = Singleton.getInstance();
				
				s.codCtr.OrderListView();
			}
		});
		add(NowBT);
		
		
		OrderBT = new JButton("목록에 추가");
		OrderBT.setBounds(300, 400, 130, 50);
		//(320, 400, 100, 50)
		OrderBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 커피 이름 
				String coffeeName = (String)Coffee.getSelectedItem();
				System.out.println(coffeeName);
				
				// 사이즈 판단
				String size = null;
				if(rb1.isSelected()) {
					//SHORT
					size = "SHORT";
				}else if(rb2.isSelected()) {
					//TALL
					size = "TALL";
				}else if(rb3.isSelected()) {
					//Grande
					size = "GRANDE";
				}
				System.out.println(size);
				//시럽판단
				int syrup = 0;
				if(rb4.isSelected()) {
					//시럽없음
					syrup = 0;
				}else if(rb5.isSelected()) {
					//카라멜 시럽
					syrup = 1;
				}else if(rb6.isSelected()) {
					//바닐라 시럽
					syrup = 2;
				}
				
				//기타 판단
				int whipping = 0;
				int shot = 0;
				
				if(cb1.isSelected()) {
					//눌려있으면 true 
					shot = 1;
				}
				if(cb2.isSelected()) {
					whipping = 1;
				}
				
				//잔수 판단 
				String coffeecount = (String)Amount.getSelectedItem();
				
				Singleton s = Singleton.getInstance();
				s.codCtr.OrderAdd(coffeeName, size, syrup, whipping, shot, Integer.parseInt(coffeecount));
				
			}
		});
		add(OrderBT);
		
		Order_BT = new JButton("주문 확정");
		Order_BT.setBounds(450, 400, 100, 50);
		Order_BT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 싱글톤의 리스트를 DB에 저장 
				Singleton s = Singleton.getInstance();
				
				s.codCtr.saveOrderlist();
				
				//메뉴화면으로 전환
				s.cofCtr.menuView();
				dispose();
				
			}
		});
		add(Order_BT);
		
		
		TegBT = new JButton("메뉴 가격표");
		TegBT.setBounds(200, 160, 150, 30);
		TegBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton s = Singleton.getInstance();
				s.cofCtr.tegView();
			}
		});
		add(TegBT);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Object obj = e.getSource();
		
		
		
		
	}
	
	
	
	
}
