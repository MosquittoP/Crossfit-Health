package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import test.Page4.MyActionListener;
import test.Page5.HomeListener;

import javax.swing.JLabel;

public class Page6 extends JPanel {

	private JPanelTest win;
	public String imgName;

	private JLabel laimg1 = new JLabel();// 첫번째 운동 사진
	private JLabel lbExName1 = new JLabel();// 첫번째 운동 이름
	private JLabel lbExkcal = new JLabel();// 첫번째 운동 칼로리
	private JLabel desLabel = new JLabel();// 첫번째 운동 설명
	private JLabel laimg2 = new JLabel();// 두번째 운동 사진
	private JLabel lbExName2 = new JLabel();// 두번째 운동 이름
	private JLabel lbExkcal_2 = new JLabel();// 두번째 운동 칼로리
	private JLabel desLabel_2 = new JLabel();// 두번째 운동 설명
	private JLabel laimg3 = new JLabel();// 세번째 운동 사진
	private JLabel lbExName3 = new JLabel();// 세번째 운동 이름
	private JLabel lbExkcal_3 = new JLabel();// 세번째 운동
	private JLabel desLabel_3 = new JLabel();// 세번째 운동 설명
	private JLabel totalKcal = new JLabel();// 총 칼로리

	public Vector<String> s = new Vector<String>();

	public Page6(JPanelTest win) {
		setLayout(null);
		setBackground(new Color(135, 206, 250));
		this.win = win;

		JPanel panel = new JPanel();// 첫번째 운동을 표시한 패널
		panel.setBounds(26, 99, 350, 92);
		add(panel);
		panel.setLayout(null);
		laimg1.setBounds(0, 0, 86, 92);
		panel.add(laimg1);

		lbExName1.setBounds(117, 37, 103, 18);
		panel.add(lbExName1);

		lbExkcal.setBounds(243, 37, 79, 18);
		panel.add(lbExkcal);

		desLabel.setBounds(117, 62, 205, 18);
		panel.add(desLabel);

		JLabel lblNewLabel_3 = new JLabel("총 칼로리");
		lblNewLabel_3.setBounds(83, 457, 71, 18);
		add(lblNewLabel_3);

		totalKcal.setBounds(211, 457, 89, 24);
		add(totalKcal);

		JLabel lblKcal = new JLabel("Kcal");
		lblKcal.setBounds(314, 457, 62, 18);
		add(lblKcal);

		JButton homebtn = new JButton("C & M"); // 홈으로 가는 버튼
		homebtn.setBounds(0, 0, 89, 30);
		add(homebtn);
		homebtn.setForeground(Color.BLACK);
		homebtn.setBackground(new Color(153, 102, 255));
		homebtn.addActionListener(new HomeListener());

		JPanel panel_1 = new JPanel();// 두번째 운동을 표시한 패널
		panel_1.setLayout(null);
		panel_1.setBounds(26, 215, 350, 92);
		add(panel_1);

		laimg2.setBounds(0, 0, 86, 92);
		panel_1.add(laimg2);

		lbExName2.setBounds(117, 37, 98, 18);
		panel_1.add(lbExName2);

		lbExkcal_2.setBounds(243, 37, 74, 18);
		panel_1.add(lbExkcal_2);

		desLabel_2.setBounds(117, 62, 200, 18);
		panel_1.add(desLabel_2);

		JPanel panel_2 = new JPanel(); // 세번째 운동을 표시한 패널
		panel_2.setLayout(null);
		panel_2.setBounds(26, 330, 350, 92);
		add(panel_2);

		laimg3.setBounds(0, 0, 86, 92);
		panel_2.add(laimg3);

		lbExName3.setBounds(117, 37, 95, 18);
		panel_2.add(lbExName3);

		lbExkcal_3.setBounds(243, 37, 74, 18);
		panel_2.add(lbExkcal_3);

		desLabel_3.setBounds(117, 67, 200, 18);
		panel_2.add(desLabel_3);

		JButton btn = new JButton("확인완료");// 확인완료버튼
		btn.setSize(109, 24);
		btn.setLocation(361, 505);
		add(btn);

		JButton btnRec = new JButton("추천"); // 추천 버튼
		btnRec.setBounds(26, 36, 477, 51);
		add(btnRec);

		btn.addActionListener(new MyActionListener());
		btnRec.addActionListener(new RecListener());
	}

	class HomeListener implements ActionListener { // 메인페이지로 이동
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("Page4");
		}
	}

	class MyActionListener implements ActionListener { // 운동영상으로 이동
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("Page7");
		}
	}

	class RecListener implements ActionListener { // 운동을 추천해준다
		public void actionPerformed(ActionEvent e) {

			getExeStrDB Exestrdb = new getExeStrDB(Conditioner.condition, Conditioner.part);
			Exestrdb.execute();
			Vector<String> s = new Vector<String>();
			s = Exestrdb.getData();

			String[] dd = s.get(0).split(";"); // 첫번째 운동의 정보를 ;으로 구분하여, dd에 넣는다.
			System.out.println(s.get(0)); // 벡터 s안에 데드리프트;삼대; 이런 형태로 나온다

			String[] dd1 = s.get(1).split(";");// 두번째 운동의 정보를 ;으로 구분하여, dd에 넣는다.
			System.out.println(s.get(1));// 벡터 s안에 데드리프트;삼대; 이런 형태로 나온다

			String[] dd2 = s.get(2).split(";");// 세번째 운동의 정보를 ;으로 구분하여, dd에 넣는다.
			System.out.println(s.get(2));// 벡터 s안에 데드리프트;삼대; 이런 형태로 나온다

//         for(int i=0; i<dd.length; i++)
//         {
//            System.out.println(dd[i]); 
//         }

			laimg1.setIcon(new ImageIcon("images\\" + dd[4] + ".JPG"));// 첫번째 운동과 일치하는 사진 화면에 출력
			lbExName1.setText(dd[0]);// 첫번째 운동의 이름을 화면에 출력
			lbExkcal.setText(dd[3]);// 첫번째 운동의 칼로리를 화면에 출력
			desLabel.setText(dd[1]);// 첫번째 운동의 설명을 화면에 출력

			float ddkcal = Float.parseFloat(dd[3]);// 첫번째 운동의 칼로리의 타입을 float으로 바꾼다
			float ddkcal_1 = Float.parseFloat(dd1[3]);// 두번째 운동의 칼로리의 타입을 float으로 바꾼다
			float ddkcal_2 = Float.parseFloat(dd2[3]);// 세번째 운동의 칼로리의 타입을 float으로 바꾼다
			float totalkc = ddkcal + ddkcal_1 + ddkcal_2;// 세개 운동의 칼로리를 합한다.
			String sttotal = String.valueOf(totalkc); // 총 칼로리를 다시 string 타입으로 변경
			totalKcal.setText(sttotal);// 총 칼로리를 화면에 출력해준다.

			laimg2.setIcon(new ImageIcon("images\\" + dd1[4] + ".JPG"));// 두번째 운동과 일치하는 사진 화면에 출력
			lbExName2.setText(dd1[0]);// 두번째 운동의 이름을 화면에 출력
			lbExkcal_2.setText(dd1[3]);// 두번째 운동의 칼로리를 화면에 출력
			desLabel_2.setText(dd1[1]);// 두번째 운동의 설명을 화면에 출력

			laimg3.setIcon(new ImageIcon("images\\" + dd2[4] + ".JPG"));
			lbExName3.setText(dd2[0]);// 세번째 운동의 이름을 화면에 출력
			lbExkcal_3.setText(dd2[3]);// 세번째 운동의 칼로리를 화면에 출력
			desLabel_3.setText(dd2[1]);// 세번째 운동의 설명을 화면에 출력

			CurrentUser.calorie = totalkc;// 계산된 총 칼로리를 사용자의 칼로리에 저장한다.
//           System.out.println(CurrentUser.calorie);

		}
	}
}