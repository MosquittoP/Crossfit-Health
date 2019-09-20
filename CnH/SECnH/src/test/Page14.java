package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import test.Page4.MyActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Panel;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Page14 extends JPanel {

	private JPanelTest win;
	private JTable table;
	public static DefaultTableModel model;
	private String header[];
	private String Contents[][];
	private int selectRow;
	private int deleteRow;
	private String deleteID;

	public Page14(JPanelTest win) {

		setLayout(null);
		this.win = win;
		setBackground(new Color(135, 206, 250));

		JPanel panel = new JPanel(); // 기본 패널 추가
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(12, 29, 434, 505);
		add(panel);

		JButton writebtn = new JButton("작성"); // 글 작성버튼 추가
		writebtn.setBounds(27, 459, 140, 36);
		panel.add(writebtn);

		String header[] = { "글 번호", "제목", "내용", "작성자" }; // 테이블 제목
		String contents[][] = {}; // 테이블 구성
		model = new DefaultTableModel(contents, header) {
			public boolean isCellEditable(int r, int m) { // 테이블 임의 수정 불가
				return false;
			}
		};

		JScrollPane scrollPane = new JScrollPane(); // 스크롤 추가
		scrollPane.setBounds(30, 53, 371, 396);
		panel.add(scrollPane);
		table = new JTable(model); // 테이블 추가
		scrollPane.setViewportView(table);

		getBoardDB gbdb = new getBoardDB(); // 데이터베이스에서 게시판 리스트 불러오는 기능 선언
		gbdb.execute(model); // 데이터베이스에서 게시판리스트 불러오기 실행

		table.setCellSelectionEnabled(false); // 한 셀만 선택가능하게 해준다.
		table.setRowSelectionAllowed(true); // ROW선택 가능
		table.setColumnSelectionAllowed(false); // Column선택 불가
		table.getTableHeader().setReorderingAllowed(false); // 테이블 제목의 임의 위치변경 불가
		table.getTableHeader().setResizingAllowed(false); // 테이블 제목의 임의 사이즈변경 불가

		table.addMouseListener(new MouseAdapter() { // 마우스 클릭시 해당 글의 행 값 반환
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				selectRow = table.getSelectedRow();
				deleteRow = (Integer) table.getValueAt(selectRow, 0);
				deleteID = (String) table.getValueAt(selectRow, 3);
			}
		});

		JPanel Titlepanel = new JPanel(); // 홈버튼과 페이지 제목이 포함되어있는 패널 추가
		Titlepanel.setBackground(new Color(153, 102, 255));
		Titlepanel.setBounds(0, 4, 450, 27);
		add(Titlepanel);
		Titlepanel.setLayout(null);

		JButton deletebtn = new JButton("삭제"); // 삭제 버튼 추가
		deletebtn.addActionListener(new DeleteListener());
		deletebtn.setBounds(261, 459, 140, 36);
		panel.add(deletebtn);

		JButton homebtn = new JButton("C & M"); // 홈버튼
		homebtn.setForeground(Color.BLACK);
		homebtn.setBackground(new Color(153, 102, 255));
		homebtn.setActionCommand("");
		homebtn.setBounds(-1, -1, 89, 30);
		Titlepanel.add(homebtn);

		JLabel TitleLabel = new JLabel("게시판"); // 페이지 제목
		TitleLabel.setFont(new Font("굴림", Font.BOLD, 15));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setBounds(173, 2, 113, 24);
		Titlepanel.add(TitleLabel);

		homebtn.addActionListener(new HomeListener()); // 홈으로 가는 기능이 포함된 액션리스너를 추가한다.

		writebtn.addActionListener(new WriteListener()); // 글 작성페이지(15page)로 넘어가는 액션리스너를 추가한다.
	}

	class WriteListener implements ActionListener { // 글 작성페이지(15page)로 넘어간다

		@Override

		public void actionPerformed(ActionEvent e) {
			// 작성페이지로 이동;
			win.change("Page15");
		}

	}

	class HomeListener implements ActionListener { // 홈(MAIN화면)으로 돌아가는 기능 선언

		@Override

		public void actionPerformed(ActionEvent e) {
			// 첫페이지로 이동
			win.change("Page4");

		}
	}

	class DeleteListener implements ActionListener { // 등록된 게시글을 삭제하는 기능 선언

		@Override

		public void actionPerformed(ActionEvent e) {

			if (table.getSelectedRow() == -1) // 셀이 선택 안되면 디폴트값(-1)로 값을 반환하여 동작 안함
			{
				return;
			} else {
				if (deleteID.equals(CurrentUser.currentID)) { // 작성된 ID와 현재 로그인된 ID가 같을 경우에만 게시글 삭제하기 위해서 비교하는 조건문
					model.removeRow(table.getSelectedRow()); // 테이블의 해당 글 즉, 해당 게시글이 포함된 행을 테이블로부터 삭제한다.
					deleteDB ddb = new deleteDB(deleteRow); // 데이터베이스에서 해당 게시글(행)을 삭제하도록 기능을 선언한다.
					ddb.execute(CurrentUser.currentID); // 현재 로그인 아이디와 글을 쓴 아이디가 같을 경우에 데이터베이스에서 행을 삭제한다.
				}
			}
		}

	}
}