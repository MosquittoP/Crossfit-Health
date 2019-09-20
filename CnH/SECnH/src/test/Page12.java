package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;

import javax.swing.*;

import test.Page7.HomeListener;

public class Page12 extends JPanel{

	private JPanelTest win;
	
	Vector<ImageIcon> v=new Vector<ImageIcon>();//이미지 저장할 vector만들기
	int cnt=0;//벡터안의 인덱스 넘버
	String[] filename;//파일 리스트 배열
	
	public Page12(JPanelTest win) {
		setBackground(new Color(135, 206, 250));
		JToolBar tb = new JToolBar();
	    JButton exit = new JButton("exit");
	    JButton mypage = new JButton("Mypage");
	    tb.add(exit);
	    tb.add(mypage);
	        
	    win.getContentPane().add(tb, BorderLayout.NORTH);
		
		setLayout(null);
        this.win = win;
        
        JButton btn = new JButton("메인메뉴");
        btn.setSize(124,33);
        btn.setLocation(147,355);
        add(btn);
        btn.addActionListener(new MyActionListener());
        
        File f=new File("profile");//images안에 있는 파일들 읽어오기
		filename=f.list();//images안의 파일 리스트 배열로 받아오기
		for(int i=0;i<filename.length;i++) {//파일의 갯수만큼 반복
			ImageIcon img=new ImageIcon("profile\\"+filename[i]);//images안의 이미지 파일들을 imageicon을 이용하여 로딩
			v.add(img);//vector v에 이미지 파일들 저장
		}
        
        JLabel imgLabel = new JLabel(v.get(0));
        imgLabel.setBounds(69, 44, 326, 247);
        add(imgLabel);
        
        JButton rightBtn = new JButton("");
        
        rightBtn.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == rightBtn) {
        			++cnt;
        			if(cnt>filename.length-1) {
        				cnt=filename.length-1;
        			}
        			imgLabel.setIcon(v.get(cnt));
        			
        		}
        	}
        });
        rightBtn.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\소공\\right.JPG"));
        rightBtn.setBounds(395, 135, 55, 49);
        add(rightBtn);
        
        JButton leftBtn = new JButton("");
        leftBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource() == leftBtn) {
        			--cnt;
        			if(cnt<0) {
        				cnt=cnt*0;
        			}
        			imgLabel.setIcon(v.get(cnt));
        		}
        	}
        });
        leftBtn.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\소공\\크기변환_left.JPG"));
        leftBtn.setBounds(0, 135, 55, 49);
        add(leftBtn);
        
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
          //첫페이지로 이동
               win.change("Page4");
           }
   }

	//페이지 넘기기
	class MyActionListener implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e) {

            win.change("Page4");
        }
	}


}
