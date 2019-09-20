package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import test.Page4.MyActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;

public class Page15 extends JPanel {

	private JPanelTest win;
	private JTextField textField;
	private JTextArea textArea;

	public Page15(JPanelTest win) {
		setLayout(null);
		setBackground(new Color(135, 206, 250));

		this.win = win;

		JPanel panel = new JPanel(); // 기본 패널 추가
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 37, 455, 597);
		add(panel);

		textArea = new JTextArea(); // 게시글 내용이 들어갈 텍스트 에어리어 선언
		textArea.addFocusListener(new FocusAdapter() { // 마우스로 텍스트 에어리어를 클릭하면 기본 텍스트값인 "내용"을 ""로 초기화한다.
			@Override
			public void focusGained(FocusEvent e) {
				if (e.getSource().equals(textArea)) {
					textArea.setText("");
				}
			}
		});
		textArea.setText("내용"); // 기본 텍스트값을 "내용"으로 한다.
		textArea.setForeground(Color.LIGHT_GRAY);
		textArea.setBounds(22, 38, 410, 460);
		panel.add(textArea);

		JButton canclebtn = new JButton("취소"); // 취소 버튼을 선언한다
		canclebtn.setBounds(312, 536, 110, 35);
		panel.add(canclebtn);

		textField = new JTextField(); // 텍스트 제목이 들어갈 텍스트필드 선언
		textField.addFocusListener(new FocusAdapter() { // 텍스트 필드를 클릭하면 기본 값인 "게시판 제목 입력"이라는 글자대신 ""으로 초기화한다
			@Override
			public void focusGained(FocusEvent e) {
				if (e.getSource().equals(textField)) {
					textField.setText("");
				}
			}
		});

		textField.setForeground(Color.LIGHT_GRAY);
		textField.setText("게시판 제목 입력"); // 텍스트 필드의 기본 값을 "게시판 제목 입력"으로 바꾼다
		textField.setColumns(10);
		textField.setBounds(22, 7, 410, 21);
		panel.add(textField);

		JButton registbtn = new JButton("등록"); // 게시글 등록 버튼을 추가한다.
		registbtn.setBounds(12, 536, 110, 35);
		panel.add(registbtn);

		JPanel Titlepanel = new JPanel();
		Titlepanel.setLayout(null);
		Titlepanel.setBackground(new Color(153, 102, 255));
		Titlepanel.setBounds(0, 0, 500, 27);
		add(Titlepanel);

		JLabel label = new JLabel("게시판 글 작성"); // 페이지 제목인 게시판 글 작성 라벨을 추가한다.
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBounds(173, 2, 113, 24);
		Titlepanel.add(label);

		JButton homebtn = new JButton("C & M"); // 홈(MAIN)화면으로 돌아가는 버튼 구현
		homebtn.setBounds(0, -1, 89, 30);
		Titlepanel.add(homebtn);
		homebtn.setForeground(Color.BLACK);
		homebtn.setBackground(new Color(153, 102, 255));
		homebtn.setActionCommand("");

		homebtn.addActionListener(new HomeListener()); // 홈으로 돌아가는 액션리스너

		canclebtn.addActionListener(new CancleListener()); // 게시글 작성을 취소하고 14페이지 게시글 목록으로 돌아가는 액션 리스너
		registbtn.addActionListener(new MyActionListener()); // 게시글 작성을 완료하고 게시글을 데이터베이스에 등록하고 14페이지 게시글 목록으로 돌아가는 액션
																// 리스너

	}

	class HomeListener implements ActionListener { // 4페이지 메인화면으로 돌아가는 액션 리스너 구현
		@Override
		public void actionPerformed(ActionEvent e) {
			// 첫페이지로 이동
			win.change("Page4"); // 4페이지 홈화면으로 돌아간다.
		}
	}

	class MyActionListener implements ActionListener { // 게시글을 작성하고 데이터베이스에 등록하고 14페이지로 돌아가는 액션 리스너 구현

		@Override

		public void actionPerformed(ActionEvent e) {

			String a = textField.getText(); // 제목인 텍스트필드 값을 불러오는 string a선언
			String b = textArea.getText(); // 내용인 텍스트에어리어 값을 불러오는 string b선언
			Vector<String> v = new Vector<String>(); // 펙터 v를 선언하여 값들을 입력 받는다.

			v.add(a); // 벡터 v에 a값을 추가한다.
			v.add(b); // 벡터 v에 b값을 추가한다.
			v.add(CurrentUser.currentID); // 벡터 v에 현재 로그인한 아이디를 추가한다.
			insertDB bbsdb = new insertDB(v, 0); // 데이버베이스에 값을 넣는 기능을 선언한다.

			bbsdb.boardData(); // 데이터베이스에 입력한 값을 추가한다.

			getBoardDB gb = new getBoardDB(); // 벡터로 데이터베이스에 입력한 값들을 데이터베이스의 게시판의 글 번호, 제목, 내용, 작성자ID등 의 값으로 분리하는 기능을
												// 선언한다.
			gb.execute(Page14.model); // 선언한 기능을 실행한다.

			win.change("Page14"); // 14페이지 게시글 목록으로 돌아간다.

		}

	}

	class CancleListener implements ActionListener { // 14페이지 게시글 목록 화면으로 돌아가는 액션 리스너 구현
		@Override
		public void actionPerformed(ActionEvent e) {
			// 첫페이지로 이동
			win.change("Page14"); // 14페이지 게시글 목록으로 돌아간다.
		}
	}
}