package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.MemberDAO;
import DAO_impl.MemberDAOimpl;
import Singleton.Singleton;

public class LoginView extends JFrame {
	
	
	JTextField IDTF;
	JPasswordField PWTF;
	public JButton loginBT, createBT;
	
	public LoginView() {
		super("로그인 화면");
		setLayout(null);
		init();
		
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		
		JLabel log_label1;
		log_label1 = new JLabel();
		log_label1.setBounds(50, 40, 50, 50);
		log_label1.setText("ID :");
		log_label1.setHorizontalAlignment(JLabel.CENTER);
		add(log_label1);
		
		
		JLabel log_label2;
		log_label2 = new JLabel();
		log_label2.setBounds(50, 120, 50, 50);
		log_label2.setText("PW :");
		log_label2.setHorizontalAlignment(JLabel.CENTER);
		add(log_label2);

		IDTF = new JTextField();
		IDTF.setBounds(120, 50, 200, 30);
		add(IDTF);
		
		PWTF = new JPasswordField();
		PWTF.setBounds(120, 130, 200, 30);
		add(PWTF);
		
		
		loginBT = new JButton();
		loginBT.setText("로그인");
		loginBT.setBounds(50, 200, 100, 50);
		loginBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "로그인버튼");
				Singleton s = Singleton.getInstance();
				int pass = s.memCtr.LoginAf(IDTF.getText(), PWTF.getText());
				if(pass == 0) {
					JOptionPane.showMessageDialog(null, "ID가 틀렸습니다");
					IDTF.setText("");
					PWTF.setText("");
				}else if(pass == 1) {
					JOptionPane.showMessageDialog(null, "PW가 틀렸습니다");
					PWTF.setText("");
				}else if(pass == 2) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					//로그인 되었으면 싱글톤에 있는 로그인 아이디에 
					//아이디 세팅 
					s.cofCtr.menuView();
					dispose();
				}	
			}
		});
		add(loginBT);
		
		
		createBT = new JButton();
		createBT.setText("회원가입");
		createBT.setBounds(250, 200, 100, 50);
		createBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 회원가입 화면으로 전환 
				Singleton s = Singleton.getInstance();
				s.memCtr.addMemberView();
				dispose();
			}
		});
		add(createBT);
	}
	
}
