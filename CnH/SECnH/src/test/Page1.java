package test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import test.Page4.MyActionListener;

import java.awt.BorderLayout;
import java.awt.Color;

public class Page1 extends JPanel {

	private JPanelTest win;

	public Page1(JPanelTest win) {

		setLayout(null);
		this.win = win;
		// 화면크기 만큼 버튼 넣어서 클릭시 화면 이동
		JButton btn = new JButton("");
		btn.setIcon(new ImageIcon("images\\logo.JPG"));

		btn.setSize(530, 800);
		btn.setLocation(0, 0);
		add(btn);
		btn.addActionListener(new MyActionListener());
	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("Page2");

		}
	}

}