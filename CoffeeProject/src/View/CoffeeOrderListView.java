package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.CoffeeDTO;
import DTO.CoffeeOrderDTO;
import Singleton.Singleton;

public class CoffeeOrderListView extends JFrame {
	
	JTable CoffeeOrderTable;
	JScrollPane jscrPane;
	
	
	String[] columnNames = {"CoffeeName", "시럽", "샷추가", "휘핑크림", "사이즈", "잔", "금액"};
	//테이블의 컬럼으로 들어갈 값들
	Object[][] rowData;
	//row데이터로 들어갈 값
	DefaultTableModel model;
	//table의 넓이를 설정할수 있는 모델 
	
	List<CoffeeOrderDTO> list = new ArrayList<CoffeeOrderDTO>();
	
	JButton BackBT;
	
	
	public CoffeeOrderListView() {
		super("장바구니 보기");
		setLayout(null);
		
		init();
		
		
		setBounds(0, 0, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void init() {
		Singleton s = Singleton.getInstance();
		int total = 0;
		//싱글톤에서 보관중인 리스트 
		list = s.orderlist;
		
		//테이블내에 들어갈 row배열 생성 
		
		rowData = new Object[list.size()][7];
		//{"커피 이름", "시럽", "샷추가", "휘핑크림", "사이즈", "잔", "금액"}
		for(int i = 0; i < list.size(); i++) {
			CoffeeOrderDTO c = list.get(i);
			int totalPrice = 0;
			
			
			rowData[i][0] = c.getCoffeeName();
			//시럽이 있는지 없는지 판단 
			if(c.getSyrup() == 0) {
				rowData[i][1] = "X";
			}else {
				rowData[i][1] = "O";
				 
			}
			//샷을 추가 했는지 판단 
			if(c.getShot() == 0) {
				rowData[i][2] = "X";
			}else {
				rowData[i][2] = "O";
				totalPrice += 500;
			}
			//휘핑크림 추가를 판단
			if(c.getWhipping() == 0) {
				rowData[i][3] = "X";
			}else {
				rowData[i][3] = "O";
				totalPrice += 500;
			}
			
			rowData[i][4] = c.getSize();
			rowData[i][5] = c.getCoffeeCount();
			
			//커피 이름의 사이즈에 해당하는 가격을 가져와서 잔수에 맞게 곱해준다
			int price = s.codCtr.getCoffeePrice(c.getCoffeeName(), c.getSize());
			price = price * c.getCoffeeCount();
			
			totalPrice = totalPrice + price; 
			
			rowData[i][6] =  totalPrice;
			
		}
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
				
		// 테이블 생성
		CoffeeOrderTable = new JTable(model);
				
		//{"커피 이름", "시럽", "샷추가", "휘핑크림", "사이즈", "잔", "금액"}					
		// column의 폭을 설정
		CoffeeOrderTable.getColumnModel().getColumn(0).setPreferredWidth(170);	// 커피이름
		CoffeeOrderTable.getColumnModel().getColumn(1).setPreferredWidth(77);	// 시럽 유무
		CoffeeOrderTable.getColumnModel().getColumn(2).setPreferredWidth(77);	// 샷 유무 
		CoffeeOrderTable.getColumnModel().getColumn(3).setMaxWidth(76);	// 휘핑 유무
		CoffeeOrderTable.getColumnModel().getColumn(4).setMaxWidth(76);	// 사이즈 
		CoffeeOrderTable.getColumnModel().getColumn(5).setMaxWidth(76);	// 잔 
		CoffeeOrderTable.getColumnModel().getColumn(6).setMaxWidth(76);	// 금액 
				
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
						
		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
		CoffeeOrderTable.getColumn("시럽").setCellRenderer(celAlignCenter);
		CoffeeOrderTable.getColumn("샷추가").setCellRenderer(celAlignCenter);
		CoffeeOrderTable.getColumn("휘핑크림").setCellRenderer(celAlignCenter);		
		CoffeeOrderTable.getColumn("사이즈").setCellRenderer(celAlignCenter);
		CoffeeOrderTable.getColumn("잔").setCellRenderer(celAlignCenter);
		CoffeeOrderTable.getColumn("금액").setCellRenderer(celAlignCenter);
		
		//CoffeeTable.setTableHeader(null);
		//테이블위의 컬럼들을 나타나지 않게 설정하는 코드 
		CoffeeOrderTable.setShowVerticalLines(false);
		CoffeeOrderTable.setShowHorizontalLines(false);
				
		jscrPane = new JScrollPane(CoffeeOrderTable);
		jscrPane.setBounds(40, 65, 400, 230);
		add(jscrPane);
				
		BackBT = new JButton("돌아가기");
		BackBT.setBounds(350, 300, 100, 50);
		BackBT.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		add(BackBT);
		
		
	}
	
	
}
