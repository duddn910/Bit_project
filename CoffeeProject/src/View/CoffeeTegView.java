package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO_impl.CoffeeDAOimpl;
import DTO.CoffeeDTO;

public class CoffeeTegView extends JFrame {
	
	JTable CoffeeTable;
	JScrollPane jscrPane;
	
	String[] columnNames = {"커피 이름", "SHORT", "TALL", "GRANDE"};
	//테이블의 컬럼으로 들어갈 값들
	Object[][] rowData;
	//row데이터로 들어갈 값
	DefaultTableModel model;
	//table의 넓이를 설정할수 있는 모델 
	
	List<CoffeeDTO> list = null;
	
	JButton BackBT;
	
	public CoffeeTegView() {
		super("커피 가격표 보기");
		setLayout(null);
		
		init();
		
		
		setBounds(0, 0, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void init() {
		//리스트를 가져오기 위한 다오 생성
		CoffeeDAOimpl cd = new CoffeeDAOimpl();
		
		//DB에서 보관중인 커피메뉴의 정보를 리스트에 가져오기 
		list = cd.getCoffeeList();
		
		//테이블내에 들어갈 row배열 생성 
		rowData = new Object[list.size()][4];
		
		// row배열내에 리스트 데이터 삽입 
		for(int i = 0; i < list.size(); i++) {
			CoffeeDTO c = list.get(i);
		
			rowData[i][0] = c.getName();
			rowData[i][1] = c.getShort();
			rowData[i][2] = c.getTall();
			rowData[i][3] = c.getGrande();
		}
		
		// 테이블 관련
		// 테이블 폭을 설정하기 위한 Model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
				
		// 테이블 생성
		CoffeeTable = new JTable(model);
		
					
		// column의 폭을 설정
		CoffeeTable.getColumnModel().getColumn(0).setPreferredWidth(170);	// 커피이름
		CoffeeTable.getColumnModel().getColumn(1).setPreferredWidth(77);	// SHORT 가격
		CoffeeTable.getColumnModel().getColumn(2).setPreferredWidth(77);	// TALL 가격
		CoffeeTable.getColumnModel().getColumn(2).setMaxWidth(76);	// GRANDE 가격
				
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
				
		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
		CoffeeTable.getColumn("SHORT").setCellRenderer(celAlignCenter);
		CoffeeTable.getColumn("TALL").setCellRenderer(celAlignCenter);
		CoffeeTable.getColumn("GRANDE").setCellRenderer(celAlignCenter);		
		
		//CoffeeTable.setTableHeader(null);
		//테이블위의 컬럼들을 나타나지 않게 설정하는 코드 
		CoffeeTable.setShowVerticalLines(false);
		CoffeeTable.setShowHorizontalLines(false);
		
		jscrPane = new JScrollPane(CoffeeTable);
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
		
		JLabel label = new JLabel("커피 가격표");
		label.setBounds(150, 15, 150, 50);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("serif", Font.BOLD, 23));
		add(label);
	}
	
	
}
