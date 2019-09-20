package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class myThread extends Thread{
   JLabel lbl;
   myThread(JLabel lbl){
      this.lbl =lbl;
   }

   public void run() {
      //타이머 실행을 위한 반복문 5개
      int cycle = TimerSet.num[3];
        System.out.println("cycle = " + cycle);
        //music.musicPlay(); 스레드로 돌려야됨
        while(cycle > 0) //사이클 수만큼 반복
        {
           System.out.println("cycle start");
            int set = 3;
           while (set > 0) //세트 수만큼 반복
           {   
              System.out.println("set start");
               int readytime = TimerSet.num[0];
              while(readytime >= 0) //준비시간
                    {
                       System.out.println("ready start");
                       lbl.setText("" + readytime);
                       try {
                          Thread.sleep(1000);
                       } catch (InterruptedException e) {
                          e.printStackTrace();
                       }
                       readytime--; //1회 수행
                    }
                
                 int exertime = TimerSet.num[1];
                 while(exertime >= 0) //운동시간
                 {
                    System.out.println("exer start");
                    lbl.setText("" + exertime);
                    try {
                       Thread.sleep(1000);
                    } catch (InterruptedException e) {
                       e.printStackTrace();
                    }
                    exertime--; //1회 수행
                 }
        
                  int resttime = TimerSet.num[2];
                 while(resttime >= 0) //휴식시간
                 {
                    System.out.println("rest start");
                    lbl.setText("" + resttime);
                    try {
                       Thread.sleep(1000);
                    } catch (InterruptedException e) {
                       e.printStackTrace();
                    }
                    resttime--; //1회 감소
                 }           
              try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
              System.out.println("set = " + set);
              set--; //1세트 감소
           }
           try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
           System.out.println("cycle = " + cycle);
          cycle--; //1사이클 감소
        }
        //music.musicClose();
   }
}

public class Timer extends JFrame{
    JLabel timerLabel = null;
    public Timer()
    {
    	//타이머 기본틀 설정
        super("Timer");       
         this.setTitle("Timer Test");
         Container c = this.getContentPane();
         getContentPane().setLayout(null);
         timerLabel = new JLabel("0");
         timerLabel.setBounds(55, 5, 142, 141);
         timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
         c.add(timerLabel);
         this.setSize(356,193);
         this.setVisible(true);    
         myThread th = new myThread(timerLabel);
         th.start();
         
         //타이머 종료를 위한 버튼
         JButton TimerExit = new JButton("종료");
         TimerExit.setBounds(247, 107, 61, 27);
         TimerExit.setHorizontalAlignment(SwingConstants.RIGHT);
         TimerExit.setVerticalAlignment(SwingConstants.BOTTOM);
         getContentPane().add(TimerExit);
        TimerExit.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
         {
             //운동 후 정해진 소모딘 칼로리만큼 DB에 변동
             updateDB udb = new updateDB(CurrentUser.currentID, CurrentUser.calorie);
             udb.updateCalorie();
             dispose();//타이머창 종료
             th.stop();
         }});
        th.start();
    }

    
    public static void run()
    {
       Timer e = new Timer();
       
    }
}