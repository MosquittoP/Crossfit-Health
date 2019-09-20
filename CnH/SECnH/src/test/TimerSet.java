package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class TimerSet extends JFrame
{
   //JTextField 선언
   private JTextField readyField, exerField, restField, cycleField;
   //변환된 문자를 받을 문자열
   String testReady, testExer, testRest, testCycle;
   //정수로 변환된 값을 받을 변수(static 으로 받아야 데이터 유지 가능)
   static int num[] = new  int [4];
   
   public TimerSet() 
   {
      //프레임 제목
      super("Timer Setting");
      // FlowLayout사용
        getContentPane().setLayout( new FlowLayout() );
        // Border로 영역 생성
        EtchedBorder eborder =  new EtchedBorder();
      
        //준비시간
        JPanel readyPanel = new JPanel();
      readyPanel.setBorder(eborder);
      add(readyPanel);
      JLabel readyTime = new JLabel("준비시간");
      readyPanel.add(readyTime);
      
      readyField = new JTextField();
      readyPanel.add(readyField);
      readyField.setColumns(10);
        IntegerDocument check_ready = new IntegerDocument();
        readyField.setDocument(check_ready);//숫자만 입력할 수 있게
        
        //운동시간
      JPanel exerPanel = new JPanel();      
      add(exerPanel);
      JLabel exerTime = new JLabel("운동시간");
      exerPanel.add(exerTime);
      
      exerField = new JTextField();
      exerPanel.add(exerField);
      exerField.setColumns(10);
        IntegerDocument check_exer = new IntegerDocument();
        exerField.setDocument(check_exer);//숫자만 입력할 수 있게
      
      //휴식시간
      JPanel restPanel = new JPanel();
      add(restPanel);      
      JLabel restTime = new JLabel("휴식시간");
      restPanel.add(restTime);
      
      restField = new JTextField();
      restPanel.add(restField);
      restField.setColumns(10);
        IntegerDocument check_rest = new IntegerDocument();
        restField.setDocument(check_rest);//숫자만 입력할 수 있게
            
      //사이클수
      JPanel cyclePanel = new JPanel();
      add(cyclePanel);      
      JLabel cycle = new JLabel("사이클");
      cyclePanel.add(cycle);
      
      cycleField = new JTextField();
      cyclePanel.add(cycleField);
      cycleField.setColumns(10);
        IntegerDocument check_cycle = new IntegerDocument();
        cycleField.setDocument(check_cycle);//숫자만 입력할 수 있게
           
      //페이지이동버튼
      JButton btnSettingOver = new JButton("Setting Over");
      getContentPane().add(btnSettingOver);
      btnSettingOver.setLocation(50, 50);
      
      btnSettingOver.addActionListener(new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
         {
             //입력받은 JTextField 값을 int로 변경
             testReady = readyField.getText(); //JTextFeild-> String
               if(testReady.equals(""))
                 {//아무 값도 없으면 패스
                 }
                 else
                 {num[0] = Integer.parseInt(testReady); //String -> int
                 }
               
               testExer = exerField.getText(); //JTextFeild-> String 
                 if(testExer.equals(""))
                 {//아무 값도 없으면 패스
                 }
                 else
                 {num[1] = Integer.parseInt(testExer);//String -> int
                 }
                 
               testRest = restField.getText();   //JTextFeild-> String 
                 if(testRest.equals(""))
                 {//아무 값도 없으면 패스
                 }
                 else
                 {num[2] = Integer.parseInt(testRest); //String -> int
                 }                
               testCycle = cycleField.getText();   //JTextFeild-> String 
                 if(testCycle.equals(""))
                 {//아무 값도 없으면 패스
                 }
                 else
                 {num[3] = Integer.parseInt(testCycle); //String -> int
                 }
               
            System.out.println("준비시간(int) " + num[0]);
            System.out.println("운동시간(int) " + num[1]);
            System.out.println("휴식시간(int) " + num[2]);
            System.out.println("사이클(int) " + num[3]);   
            Timer.run();
            dispose();
         }
          
      });
      
      //프레임 설정
      setSize( 250, 350 );
        setVisible(true); 
   }
   
   //실행 메소드
    public static void run()
       {
          TimerSet e = new TimerSet();
       }
}