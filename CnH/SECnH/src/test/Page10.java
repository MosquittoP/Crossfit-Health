package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import test.Page4.MyActionListener;
import test.Page7.HomeListener;

import javax.swing.JLabel;
import java.awt.Font;

public class Page10 extends JPanel {

	private JPanelTest win;
	public JLabel lbNameValue = new JLabel();
	private JLabel lbAgeValue = new JLabel();
	private JTextField lbTallValue = new JTextField();
	private JTextField lbWeightValue = new JTextField();
	private JLabel lbBMIValue = new JLabel();
	private JLabel lbLvl = new JLabel();
	private JLabel lbColValue = new JLabel();
	public Vector<String> uinfo = new Vector<String>();
	public String name;

	public Page10(JPanelTest win) {

		setBackground(new Color(135, 206, 250));
		setLayout(null);
		this.win = win;
		JButton btn = new JButton("개인정보 확인하기");
		btn.setSize(209, 47);
		btn.setLocation(264, 467);
		add(btn);
		btn.addActionListener(new InfoListener());

		JLabel lbName = new JLabel("이름");
		lbName.setFont(new Font("굴림", Font.PLAIN, 15));
		lbName.setBounds(139, 108, 49, 31);
		add(lbName);

		lbNameValue.setBounds(264, 116, 57, 15);
		lbNameValue.setText(name);
		add(lbNameValue);

		JLabel lbAge = new JLabel("나이");
		lbAge.setFont(new Font("굴림", Font.PLAIN, 15));
		lbAge.setBounds(139, 170, 57, 20);
		add(lbAge);

		lbAgeValue.setBounds(264, 173, 57, 15);
		add(lbAgeValue);

		JLabel lbAgeList = new JLabel("세");
		lbAgeList.setFont(new Font("굴림", Font.PLAIN, 15));
		lbAgeList.setBounds(360, 170, 57, 18);
		add(lbAgeList);

		JLabel lbTall = new JLabel("신장");
		lbTall.setFont(new Font("굴림", Font.PLAIN, 15));
		lbTall.setBounds(139, 230, 57, 20);
		add(lbTall);

		lbTallValue.setBounds(264, 233, 57, 15);
		add(lbTallValue);

		JLabel lbCm = new JLabel("cm");
		lbCm.setFont(new Font("굴림", Font.PLAIN, 15));
		lbCm.setBounds(360, 230, 57, 18);
		add(lbCm);

		JLabel lbWeight = new JLabel("체중");
		lbWeight.setFont(new Font("굴림", Font.PLAIN, 15));
		lbWeight.setBounds(139, 290, 57, 20);
		add(lbWeight);

		lbWeightValue.setBounds(264, 293, 57, 15);
		add(lbWeightValue);

		JLabel lbKg = new JLabel("kg");
		lbKg.setFont(new Font("굴림", Font.PLAIN, 15));
		lbKg.setBounds(360, 290, 57, 18);
		add(lbKg);

		JLabel lbBMI = new JLabel("BMI 지수");
		lbBMI.setFont(new Font("굴림", Font.PLAIN, 15));
		lbBMI.setBounds(124, 362, 75, 20);
		add(lbBMI);

		JButton homebtn = new JButton("C & M");
		homebtn.setBounds(0, 0, 89, 30);
		add(homebtn);
		homebtn.setForeground(Color.BLACK);
		homebtn.setBackground(new Color(153, 102, 255));
		homebtn.addActionListener(new HomeListener());

		lbBMIValue.setBounds(264, 365, 57, 15);
		add(lbBMIValue);

		JButton btnProfile = new JButton("일일 프로필 보기");
		btnProfile.setFont(new Font("굴림", Font.PLAIN, 20));
		btnProfile.setBounds(14, 467, 236, 47);
		add(btnProfile);
		ActionListener profile = new NextActionListener();
		btnProfile.addActionListener(profile);

		JButton btnModify = new JButton("수정하기");
		btnModify.setFont(new Font("굴림", Font.PLAIN, 20));
		btnModify.setBounds(14, 552, 236, 47);
		add(btnModify);

		JLabel lbColorie = new JLabel("소모칼로리");
		lbColorie.setFont(new Font("굴림", Font.PLAIN, 15));
		lbColorie.setBounds(113, 402, 75, 20);
		add(lbColorie);

		lbColValue.setBounds(264, 407, 57, 15);
		add(lbColValue);

		lbLvl.setBounds(360, 116, 57, 15);
		add(lbLvl);
		btnModify.addActionListener(new ModifyListener());

	}

	class NextActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("Page12");
		}
	}

	class HomeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 첫페이지로 이동
			win.change("Page4");
		}
	}

	// 수정내용
	class ModifyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			updateDB udb = new updateDB(CurrentUser.currentID, Float.parseFloat(lbTallValue.getText()),
					Float.parseFloat(lbWeightValue.getText()));
			udb.execute();
			float newbmi = Float.parseFloat(lbWeightValue.getText())
					/ (Float.parseFloat(lbTallValue.getText()) / 100 * Float.parseFloat(lbTallValue.getText()) / 100);
			lbBMIValue.setText(String.valueOf(newbmi));
		}

	}

	class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("Page11");
		}
	}

	class InfoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Page10 p10=new Page10(win);
			// p10.lbNameValue.setText(CurrentUser.currentInfo.get(2));
			showDB sdb = new showDB();
			sdb.execute(CurrentUser.currentID);
			uinfo = sdb.getInfo();
			System.out.println(uinfo);

			lbNameValue.setText(uinfo.get(2));
			lbAgeValue.setText(uinfo.get(3));
			lbTallValue.setText(uinfo.get(5));
			lbWeightValue.setText(uinfo.get(6));
			lbBMIValue.setText(uinfo.get(7));
			lbColValue.setText(uinfo.get(8));
			lbLvl.setText("lvl: " + uinfo.get(9));
		}
	}
}
