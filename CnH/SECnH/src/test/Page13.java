package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.text.Document;

import test.Page4.MyActionListener;
import test.Page5.HomeListener;
import test.IntegerDocument;

public class Page13 extends JPanel{
   
   private JPanelTest win;
   private JTextField textField;
   private JTextField searchMenu;
   private JTextField KcalField;
   private JLabel lblName = new JLabel();
   private JLabel lblKcal = new JLabel();
   private JLabel totalKcal = new JLabel();
   float kcalcalc;
   private JLabel lbImage = new JLabel(); 
   
   public Page13(JPanelTest win) {
       
      setLayout(null);
      setBackground(new Color(135, 206, 250));
        this.win = win;        
       //메뉴 검색해서 DB에서 호출
        searchMenu = new JTextField();
        searchMenu.setBounds(0, 58, 332, 24);
        add(searchMenu);
        searchMenu.setColumns(10);
        
        //페이지 제목
        JLabel CheckFood = new JLabel("\uC2DD\uB2E8 \uAD00\uB9AC\uD558\uAE30");
        CheckFood.setBounds(185, 12, 140, 18);
        add(CheckFood);
        
        //검색된 결과       
        JPanel result = new JPanel();
        result.setBounds(24, 111, 330, 187);
        add(result);
        result.setLayout(null);  
        
        lbImage.setBounds(12, 10, 123, 165);
        result.add(lbImage);
             
        lblName.setBounds(175, 24, 92, 40);
        result.add(lblName);
        lblKcal.setBounds(175, 87, 84, 32);
        result.add(lblKcal);
        
        //칼로리 총합 계산
        JButton homebtn = new JButton("C & M");
        homebtn.setBounds(0, 0, 89, 30);
        add(homebtn);
        homebtn.setForeground(Color.BLACK);
        homebtn.setBackground(new Color(153, 102, 255));
        homebtn.addActionListener(new HomeListener());
        //총합 칼로리
        JLabel toka_txt = new JLabel("\uCD1D \uCE7C\uB85C\uB9AC");
        toka_txt.setBounds(119, 310, 70, 24);
        add(toka_txt);
        
        
        totalKcal.setBounds(185, 315, 57, 15);
        add(totalKcal);
  
        
        JLabel toka_KCAL = new JLabel("Kcal");
        toka_KCAL.setBounds(256, 315, 57, 15);
        add(toka_KCAL);
        
        //검색버튼
        JButton btnSearch = new JButton("\uAC80\uC0C9");
        btnSearch.setBounds(332, 57, 120, 27);
        add(btnSearch);
        btnSearch.addActionListener(new searchActionListener());
       
        //추가하기버튼
        JButton btnAddMenu = new JButton("\uCD94\uAC00");
        btnAddMenu.setBounds(368, 116, 70, 23);
        add(btnAddMenu);
        btnAddMenu.addActionListener(new addActionListener());
        
        JButton btn = new JButton("확인");
        btn.setSize(70,20);
        btn.setLocation(185,411);
        add(btn);
        btn.addActionListener(new MyActionListener());
   }
   class HomeListener implements ActionListener{
       @Override
         public void actionPerformed(ActionEvent e) {
        //첫페이지로 이동
             win.change("Page4");
         }
 }
   
   class MyActionListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
    	   float tmpCal = kcalcalc*-1;
    	   updateDB udb = new updateDB(CurrentUser.currentID, tmpCal);
    	   udb.updateCalorie();
    	   searchMenu.setText("");
    	   lblName.setText("");
    	   lblKcal.setText("");
    	   totalKcal.setText("");
           win.change("Page4");
        }
   }
   //검색버튼 기능
   class searchActionListener implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {
          getFoodDB fdb = new getFoodDB(searchMenu.getText());
          fdb.execute();
          Vector<String> data = new Vector<String>();
          data=fdb.getData();
          //이미지 추가
          lbImage.setIcon(new ImageIcon("images\\"+data.get(2)+".JPEG"));
          System.out.println(data.get(2));
          System.out.println(Conditioner.part);
          lblName.setText(data.get(0));
          lblKcal.setText(data.get(1));
        }
   }
   
//   class addActionListener implements ActionListener{
//      @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//   }
   
   class addActionListener implements ActionListener {
       JTextField text;
       JLabel label;
       
       addActionListener() { 
//           this.text = text;
//           this.label = label;
       }
       public void actionPerformed(ActionEvent e) {
          getFoodDB fdb = new getFoodDB(searchMenu.getText());
           fdb.execute();
           Vector<String> data = new Vector<String>();
           data=fdb.getData();
           
           lblName.setText(data.get(0));
           lblKcal.setText(data.get(1));
           int num = 0;
           float foodCal = Float.parseFloat(data.get(1));
           System.out.println(foodCal);
           kcalcalc = kcalcalc+foodCal;
           totalKcal.setText(String.valueOf(kcalcalc));
       }
   }
}