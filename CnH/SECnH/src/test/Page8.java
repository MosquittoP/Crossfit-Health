package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import test.Page4.MyActionListener;
import test.Page7.HomeListener;

public class Page8 extends JPanel{
   
   private JPanelTest win;
   
   public Page8(JPanelTest win) {
      JToolBar tb = new JToolBar();
      setBackground(new Color(135, 206, 250));
       JButton exit = new JButton("exit");
       JButton mypage = new JButton("Mypage");
       tb.add(exit);
       tb.add(mypage);
           
       win.add(tb, BorderLayout.NORTH);
       
      setLayout(null);
        this.win = win;
        JButton homebtn = new JButton("C & M");
        homebtn.setBounds(0, 0, 89, 30);
        add(homebtn);
        homebtn.setForeground(Color.BLACK);
        homebtn.setBackground(new Color(153, 102, 255));
        homebtn.addActionListener(new HomeListener());
        

   }
	  class HomeListener implements ActionListener{
	         @Override
	           public void actionPerformed(ActionEvent e) {
	          //메인메뉴 페이지로 이동
	               win.change("Page4");
	           }
	   }}

