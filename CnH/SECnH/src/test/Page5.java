package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.sun.prism.Image;

import test.Page4.MyActionListener;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

public class Page5 extends JPanel {

	private JPanelTest win;
	private Image img;
	// private static int part;
	JRadioButton leg;
	JRadioButton core;
	JRadioButton arm;

	public Page5(JPanelTest win) {// page5생성자
		setBackground(new Color(135, 206, 250));
		JButton exit = new JButton("exit"); // 종료버튼
		JButton mypage = new JButton("Mypage");// 마이페이지 버튼

		setLayout(null);
		this.win = win;
		JButton btn = new JButton("선택완료"); // 운동부위 선택완료 버튼
		btn.setSize(344, 50);
		btn.setLocation(86, 620);
		add(btn);

		JPanel panel = new JPanel();
		panel.setBounds(30, 86, 428, 506);
		add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(30, 10, 369, 486);
		panel.add(panel_2);
		panel_2.setLayout(null);

		ButtonGroup btnGroup = new ButtonGroup();

		arm = new JRadioButton();// 팔 선택가능한 라디오 버튼
		arm.setBounds(234, 24, 25, 27);
		panel_2.add(arm);
		btnGroup.add(arm);

		core = new JRadioButton();// 코어 선택가능한 라디오 버튼
		core.setBounds(168, 137, 32, 27);
		panel_2.add(core);
		btnGroup.add(core);

		leg = new JRadioButton();// 다리 선택가능한 라디오 버튼
		leg.setBounds(227, 300, 32, 27);
		panel_2.add(leg);
		btnGroup.add(leg);

		JLabel label = new JLabel("");// 몸 선택 사진 넣을 곳
		label.setBounds(0, 0, 332, 468);
		panel_2.add(label);
		label.setIcon(new ImageIcon("images\\인체사진.JPG"));

		JButton homebtn = new JButton("C & M");// 홈으로 이동 버튼
		homebtn.setBounds(0, 0, 89, 30);
		add(homebtn);
		homebtn.setForeground(Color.BLACK);
		homebtn.setBackground(new Color(153, 102, 255));
		homebtn.addActionListener(new HomeListener());

		btn.addActionListener(new MyActionListener());

		arm.addMouseListener(new MyMouseAdapter());
		core.addMouseListener(new MyMouseAdapter());
		leg.addMouseListener(new MyMouseAdapter());
	}

	class MyMouseAdapter extends MouseAdapter { // 선택한 부위가 팔 복근 다리 중 어느 부분인지 체크
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == arm) { // 팔을 선택하면 conditioner의 part가 1이 된다.
				Conditioner.part = 1;
			} else if (e.getSource() == leg) {// 다리을 선택하면 conditioner의 part가 3이 된다.
				Conditioner.part = 3;
			} else { // 복근을 선택하면 conditioner의 part가 2가 된다.
				Conditioner.part = 2;
			}
		}
	}

	class HomeListener implements ActionListener {// 홈으로 돌아가는 기능
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("Page4");
		}
	}

	class MyActionListener implements ActionListener { // 운동 추천 페이지로 이동
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("Page6");
		}
	}

}