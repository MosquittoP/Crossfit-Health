package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;

import test.Page4.MyActionListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;

class CurrentUser {
	public static String currentID; // 사용자의 id를 저장한다.
	public static float calorie; // 사용자의 칼로리를 저장한다.
	public static Vector<String> currentInfo = new Vector<String>();// 사용자 정보를 벡터에 저장한다.
}

public class Page2 extends JPanel {

	private JPanelTest win;
	private JTextField txtID;
	private JPasswordField txtPass;

	public Page2(JPanelTest win) { // page2생성자
		setBackground(new Color(135, 206, 250));
		setLayout(null);
		this.win = win;
		JButton LogInBtn = new JButton("LogIn"); // 로그인 버튼
		LogInBtn.setSize(106, 34);
		LogInBtn.setLocation(156, 296);
		add(LogInBtn);

		txtID = new JTextField(); // id입력 창
		txtID.setBounds(177, 133, 116, 24);
		add(txtID);
		txtID.setColumns(10);

		JLabel LabelID = new JLabel("ID: ");
		LabelID.setHorizontalAlignment(SwingConstants.CENTER);
		LabelID.setBounds(14, 136, 62, 18);
		add(LabelID);

		txtPass = new JPasswordField();// 비밀번호 입력 창
		txtPass.setEchoChar('*');
		txtPass.setBounds(177, 169, 116, 24);
		add(txtPass);

		JLabel LabelPassWord = new JLabel("Password: ");
		LabelPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		LabelPassWord.setBounds(14, 172, 83, 18);
		add(LabelPassWord);

		JButton signUpbtn = new JButton("회원가입"); // 회원가입 버튼
		signUpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// 회원가입 누르면 회원가입 페이지로 이동
				win.change("Page3");
			}
		});
		signUpbtn.setBackground(SystemColor.control);
		signUpbtn.setForeground(Color.BLACK);
		signUpbtn.setBounds(304, 296, 105, 34);
		add(signUpbtn);
		LogInBtn.addActionListener(new MyActionListener()); // 로그인 액션리스너

	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showDB sdb = new showDB(); // 사용자 데이터 가져온다.
			sdb.execute(txtID.getText());// 입력한 id와 데이터베이스 연결한다.
			CurrentUser.currentInfo = sdb.getInfo();// 가져온 정보를 현재 사용자 정보에 저장한다.
			String uinfo = sdb.LoginCheck();// 로그인된 id와 비밀번호를 unifo에 저장.
			String[] uu = uinfo.split("/");// 사용자 정보를 uu에 저장한다.

			if (uu[0].equals(txtID.getText()) && uu[1].equals(txtPass.getText())) {// 입력한 id와 비밀번호가 데이터베이스에서 가져온 정보와
																					// 일치한다면
				JOptionPane.showMessageDialog(null, "로그인 성공"); // 로그인 성공 팝업 생성
				CurrentUser.currentID = txtID.getText();// 로그인 성공시 currenID에 사용자 id 저장.
				txtID.setText("");
				txtPass.setText("");
				win.change("Page4");// 메인페이지로 이동
			} else { // 로그인 실패시 id, 비밀번호 입력창 비우기
				txtID.setText("");
				txtPass.setText("");
				JOptionPane.showMessageDialog(null, "로그인 실패");
			}
		}
	}
}