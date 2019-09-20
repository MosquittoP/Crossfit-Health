package test;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import test.Page6.HomeListener;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import java.awt.Font;

public class Page7 extends JPanel{
   
   private JPanelTest win;
   
   public Page7(JPanelTest win) {
      JToolBar tb = new JToolBar();
      setBackground(new Color(135, 206, 250));
       JButton exit = new JButton("exit");
       JButton mypage = new JButton("Mypage");
       tb.add(exit);
       tb.add(mypage);
           
       win.getContentPane().add(tb, BorderLayout.NORTH);
      
       //타이머 세팅 화면을 불러오는 버튼
      setLayout(null);
        this.win = win;
        JButton btn = new JButton("타이머 세팅");
        btn.setFont(new Font("굴림", Font.PLAIN, 40));
        btn.setSize(331,146);
        btn.setLocation(49,74);
        add(btn);
        
        //메인화면으로 돌아가는 버튼
        JButton homebtn = new JButton("C & M");
        homebtn.setBounds(0, 0, 89, 30);
        add(homebtn);
        homebtn.setForeground(Color.BLACK);
        homebtn.setBackground(new Color(153, 102, 255));
        homebtn.addActionListener(new HomeListener());
        
        btn.addActionListener(new MyActionListener());
   }
	  class HomeListener implements ActionListener{
	         @Override
	           public void actionPerformed(ActionEvent e) {
	          //메인메뉴 페이지로 이동
	               win.change("Page4");
	           }
	   }
      
   class MyActionListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
            win.change("Page8");
         TimerSet set = new TimerSet();
         set.setVisible(true);
        }
   }
}