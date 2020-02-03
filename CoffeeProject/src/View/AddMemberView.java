package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.MemberDAO;
import DAO_impl.MemberDAOimpl;
import Singleton.Singleton;

public class AddMemberView extends JFrame {

	
	JTextField[] cre_TF = new JTextField[4];
	JButton foundID_BT, Insert_BT, BackBT ;
	
	public AddMemberView() {
		super("회원가입 화면");
		setLayout(null);
		init();

		setBounds(0, 0, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		
		JLabel cre_label1 = new JLabel();
		cre_label1.setText("ID");
		cre_label1.setBounds(50, 40, 50, 50);
		cre_label1.setHorizontalAlignment(JLabel.CENTER);
		add(cre_label1);
		
		JLabel cre_label2 = new JLabel();
		cre_label2.setText("PW");
		cre_label2.setBounds(50, 90, 50, 50);
		cre_label2.setHorizontalAlignment(JLabel.CENTER);
		add(cre_label2);
		
		JLabel cre_label3 = new JLabel();
		cre_label3.setText("NAME");
		cre_label3.setBounds(50, 140, 50, 50);
		cre_label3.setHorizontalAlignment(JLabel.CENTER);
		add(cre_label3);
		
		JLabel cre_label4 = new JLabel();
		cre_label4.setText("E-mail");
		cre_label4.setBounds(50, 190, 50, 50);
		cre_label4.setHorizontalAlignment(JLabel.CENTER);
		add(cre_label4);
		
		
		for(int i = 0; i < cre_TF.length; i++) {
			cre_TF[i] = new JTextField();
			cre_TF[i].setBounds(110, 50 + i*50, 150, 30);
			add(cre_TF[i]);
		}
		
		foundID_BT = new JButton();
		foundID_BT.setText("ID확인");
		foundID_BT.setBounds(300, 50, 80, 30);
		foundID_BT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singleton s = Singleton.getInstance();
				boolean b = s.memCtr.idCheck(cre_TF[0].getText());
				
				if(b) JOptionPane.showMessageDialog(null, "생성가능"); 
				else JOptionPane.showMessageDialog(null, "생성불가");
			}
		});
		add(foundID_BT);
		
		Insert_BT = new JButton();
		Insert_BT.setText("회원가입");
		Insert_BT.setBounds(200, 250, 100, 50);
		Insert_BT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 모든 택스트 필드의 값을 가져와서 DB에 저장 
				boolean b = true;
				for(int i = 0; i < 4; i++) {
					//텍스트필드에 빈공간을 가진 텍스트 필드가 있는지 확인 
					if(cre_TF[i].getText().equals("")) {
						b = false;
						break;
					}
				}
				//여기서 위의 결과에 대한 처리
				
				if(b) {
					Singleton s = Singleton.getInstance();
					boolean b2 = s.memCtr.addMember(cre_TF[0].getText(),
													cre_TF[1].getText(),
													cre_TF[2].getText(),
													cre_TF[3].getText());
					if(b2) {
						JOptionPane.showMessageDialog(null, "가입되었습니다");
						s.memCtr.loginView(); //로그인 창으로 전환
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "가입실패");
					}
				}else {
					JOptionPane.showMessageDialog(null, "빈공간이 있습니다");
				}
			}
		});
		add(Insert_BT);
		
		BackBT = new JButton();
		BackBT.setText("돌아가기");
		BackBT.setBounds(50, 250, 100, 50);
		BackBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 화면으로 전환
				Singleton s = Singleton.getInstance();
				s.memCtr.loginView(); //로그인 창으로 전환
				dispose();
			}
		});
		add(BackBT);
		
	}
	
	
}
