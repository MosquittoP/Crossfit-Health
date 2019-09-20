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

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;

class JPanelTest extends JFrame{
	
	public static final int SCREEN_WIDTH = 530;
	public static final int SCREEN_HEIGHT = 800;
	
    public Page1 Page1 = null;
    public Page2 Page2 = null;
    public Page3 Page3 = null;
    public Page4 Page4 = null;
    public Page5 Page5 = null;
    public Page6 Page6 = null;
    public Page7 Page7 = null;
    public Page8 Page8 = null;
    public Page9 Page9 = null;
    public Page10 Page10 = null;
    public Page11 Page11 = null;
    public Page12 Page12 = null;
    public Page13 Page13 = null;
    public Page14 Page14 = null;
    public Page15 Page15 = null;
      
    public void change(String panelName){// 패널 1번과 2번 변경 후 재설정
    	//페이지 전환을 위한 메소드

        if(panelName.equals("Page1")){

            getContentPane().removeAll();
            getContentPane().add(Page1);
            revalidate();
            repaint();

        }else if(panelName.equals("Page2")){

            getContentPane().removeAll();
            getContentPane().add(Page2);
            revalidate();
            repaint();

        }else if(panelName.equals("Page3")){

            getContentPane().removeAll();
            getContentPane().add(Page3);
            revalidate();
            repaint();

        }else if(panelName.equals("Page4")){

            getContentPane().removeAll();
            getContentPane().add(Page4);
            revalidate();
            repaint();

        }else if(panelName.equals("Page5")){

            getContentPane().removeAll();
            getContentPane().add(Page5);
            revalidate();
            repaint();

        }else if(panelName.equals("Page6")){

            getContentPane().removeAll();
            getContentPane().add(Page6);
            revalidate();
            repaint();

        }
        else if(panelName.equals("Page7")){

            getContentPane().removeAll();
            getContentPane().add(Page7);
            revalidate();
            repaint();
            
            JFrame f = new JFrame("운동영상");
            f.setLocation(100, 100);
            f.setSize(1000,600);
            //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            JButton finishbtn = new JButton("시청 완료 ");

            //create an instance of canvas wish will be used to display video
            //영상을 플레이하기 위한 화면을 생성
            Canvas c= new Canvas();
            //배경은 블랙
            c.setBackground(Color.black);
            JPanel p = new JPanel();
            p.setLayout(new BorderLayout());
            //video take all the surface of jpanel
            //패널에 영상을 불러옴
            p.add(c);
            p.add(finishbtn,BorderLayout.SOUTH);
            f.add(p);
            
            //load the native library of vlc
            //vlc라이브러리를 로드
            NativeLibrary.addSearchPath(uk.co.caprica.vlcj.runtime.RuntimeUtil.getLibVlcLibraryName(),"VideoLAN\\VLC");
            Native.loadLibrary(uk.co.caprica.vlcj.runtime.RuntimeUtil.getLibVlcLibraryName(),LibVlc.class);
            MediaPlayerFactory mpf = new MediaPlayerFactory();
            EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
            emp.setVideoSurface(mpf.newVideoSurface(c));
            //emp.toggleFullScreen();
            emp.setEnableMouseInputHandling(false);
            emp.setEnableKeyInputHandling(false);
            
            //영상시청
            String file="video\\exervideo.mp4";
            emp.prepareMedia(file);
            emp.play();
            finishbtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					emp.release();
					mpf.release();
				}
			});
        }else if(panelName.equals("Page8")){

            getContentPane().removeAll();
            getContentPane().add(Page8);
            revalidate();
            repaint();

        }else if(panelName.equals("Page9")){

            getContentPane().removeAll();
            getContentPane().add(Page9);
            revalidate();
            repaint();

        }else if(panelName.equals("Page10")){

            getContentPane().removeAll();
            getContentPane().add(Page10);
            revalidate();
            repaint();

        }else if(panelName.equals("Page11")){
        	
            getContentPane().removeAll();
            getContentPane().add(Page11);
            revalidate();
            repaint();

        }else if(panelName.equals("Page12")){

            getContentPane().removeAll();
            getContentPane().add(Page12);
            revalidate();
            repaint();

        }else if(panelName.equals("Page13")){
        	
            getContentPane().removeAll();
            getContentPane().add(Page13);
            revalidate();
            repaint();

        }else if(panelName.equals("Page14")){

            getContentPane().removeAll();
            getContentPane().add(Page14);
            revalidate();
            repaint();
        }
        else {
        	getContentPane().removeAll();
            getContentPane().add(Page15);
            revalidate();
            repaint();
        }

    }

    public static void main(String[] args) {
       JPanelTest win = new JPanelTest();            
        win.setTitle("frame test");

        win.Page1 = new Page1(win);
        win.Page2 = new Page2(win);
        win.Page3 = new Page3(win);
        win.Page4 = new Page4(win);
        win.Page5 = new Page5(win);
        win.Page6 = new Page6(win);
        win.Page7 = new Page7(win);
        win.Page8 = new Page8(win);
        win.Page9 = new Page9(win);
        win.Page10 = new Page10(win);
        win.Page11 = new Page11(win);
        win.Page12 = new Page12(win);
        win.Page13 = new Page13(win);
        win.Page14 = new Page14(win);
        win.Page15 = new Page15(win);

        win.add(win.Page1);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setResizable(false);      
        win.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        win.setVisible(true); 
    }

}
