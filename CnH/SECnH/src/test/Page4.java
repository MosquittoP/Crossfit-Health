package test;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;

class Conditioner {
	public static int condition; // 운동인지 스트레칭인지 구분해준다
	public static int part; // 운동이나 스트레칭에서 팔,코어,다리 중 어느 부분인지 구분해준다.
}

public class Page4 extends JPanel {

	private JPanelTest win;

	private JButton btnExercise;
	private JButton btnStretching;
	private JButton btnFood;
	private JButton btnCommunity;
	private JButton btnMypage;

	public Page4(JPanelTest win) {
		setBackground(new Color(135, 206, 250));

		setLayout(null);
		this.win = win;

		btnExercise = new JButton("운동하기"); // 운동하기 버튼
		btnExercise.setSize(159, 49);
		btnExercise.setLocation(164, 85);
		add(btnExercise);
		btnExercise.addActionListener(new MyActionListener());

		btnStretching = new JButton("스트레칭하기"); // 스트레칭 버튼
		btnStretching.setBounds(164, 199, 159, 49);
		add(btnStretching);
		btnStretching.addActionListener(new MyActionListener());

		btnFood = new JButton("식단관리"); // 식단관리 버튼
		btnFood.setBounds(164, 311, 159, 49);
		add(btnFood);
		btnFood.addActionListener(new MyActionListener());

		btnCommunity = new JButton("게시판"); // 게시판 버튼
		btnCommunity.setBounds(164, 423, 159, 49);
		add(btnCommunity);
		btnCommunity.addActionListener(new MyActionListener());

		btnMypage = new JButton("Mypage"); // 마이페이지 버튼
		btnMypage.setBounds(164, 534, 159, 49);
		add(btnMypage);
		btnMypage.addActionListener(new MyActionListener());

	}

	class MyActionListener implements ActionListener {// 각각의 버튼을 누르면 알맞은 페이지로 이동한다.
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnExercise) { // 운동하기 버튼을 클릭시
				win.change("Page5");// 운동부위 선택페이지로 이동
				Conditioner.condition = 0;// condition이 0이면 운동을 나타낸다
			} else if (e.getSource() == btnStretching) {// 스트레칭하기 버튼 글릭시
				win.change("Page5");// 운동부위 선택페이지로 이동
				Conditioner.condition = 1;// condition이 1이면 스트레칭을 나타낸다
			} else if (e.getSource() == btnFood) {// 식단관리 버튼 클릭시
				win.change("Page13"); // 식단관리 페이지로 이동
			} else if (e.getSource() == btnMypage) {// 마이페이지 버튼 클릭시
				win.change("Page10");// 마이페이지로 이동
			} else {
				win.change("Page14");// 게시판 페이지로 이동
			}
		}
	}

}