package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import test.Page4.MyActionListener;

public class Page11 extends JPanel{
	
	private JPanelTest win;
	
	public Page11(JPanelTest win) {
		JToolBar tb = new JToolBar();
		setBackground(new Color(135, 206, 250));
	    JButton exit = new JButton("exit");
	    JButton mypage = new JButton("Mypage");
	    tb.add(exit);
	    tb.add(mypage);
	        
	    win.getContentPane().add(tb, BorderLayout.NORTH);
	    
		setLayout(null);
        this.win = win;
        JButton btn = new JButton("11페이지");
        btn.setSize(70,20);
        btn.setLocation(10,10);
        add(btn);
        btn.addActionListener(new MyActionListener());
	}
	class MyActionListener implements ActionListener{
		
		@Override

        public void actionPerformed(ActionEvent e) {

            win.change("Page12");

        }
	}

}
