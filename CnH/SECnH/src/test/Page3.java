package test;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.util.Vector;
import javax.swing.JRadioButton;

public class Page3 extends JPanel{
   private JPanelTest win;
   private JPasswordField user_pw2;
   private JPasswordField user_pw;
   private JTextField user_id;
   private JTextField user_name;
   private JTextField age;
   private JTextField height;
   private JTextField weight;
   private int checkbit=0;
   JToggleButton tglbtnMan;
   JToggleButton tglbtnWoman;
   
   private Vector<String> user = new Vector<String>();
   
   public Page3(JPanelTest win) {
	   user.removeAllElements();
       JToolBar tb = new JToolBar();
       JButton exit = new JButton("exit");
       JButton mypage = new JButton("Mypage");
       tb.add(exit);
       tb.add(mypage);
           
       win.getContentPane().add(tb, BorderLayout.NORTH);
       
      setLayout(null);
        this.win = win;
        JButton clearBtn = new JButton("가입완료");
        clearBtn.setSize(95,20);
        clearBtn.setLocation(401,436);
        add(clearBtn);
        
        JLabel lbID = new JLabel("ID");
        lbID.setBounds(14, 94, 62, 18);
        add(lbID);
        //id
        JLabel lbPW = new JLabel("비밀번호");
        lbPW.setBounds(14, 150, 62, 18);
        add(lbPW);
        user_id = new JTextField();
        user_id.setColumns(10);
        user_id.setBounds(111, 91, 200, 24);
        add(user_id);
        
        
        //pw
        user_pw2 = new JPasswordField();
        user_pw2.setBounds(111, 209, 200, 24);
        add(user_pw2);
        user_pw2.setColumns(10);
        
        user_pw = new JPasswordField();
        user_pw.setColumns(10);
        user_pw.setBounds(111, 147, 200, 24);
        add(user_pw);

        
       
        //name
        JLabel lbName = new JLabel("성명");
        lbName.setBounds(14, 274, 62, 18);
        add(lbName);
        
        user_name = new JTextField();
        user_name.setColumns(10);
        user_name.setBounds(111, 271, 200, 24);
        add(user_name);

                
  
        //age
 
        JLabel lbAge = new JLabel("나이");
        lbAge.setBounds(232, 332, 62, 18);
        add(lbAge);
        
        age = new JTextField();
        age.setBounds(308, 329, 62, 24);
        add(age);
        age.setColumns(10);
        

        
        JLabel lbAgeList = new JLabel("세");
        lbAgeList.setBounds(384, 332, 62, 18);
        add(lbAgeList);
        
        JLabel lbHeight = new JLabel("신장");
        lbHeight.setBounds(14, 385, 62, 18);
        add(lbHeight);
        

        JButton btnCheck = new JButton("중복확인");
        btnCheck.setBounds(369, 90, 105, 27);
        add(btnCheck);
        btnCheck.addActionListener(new CheckIDListener());
        
        //gender
        JLabel lbGender = new JLabel("성별");
        lbGender.setBounds(14, 332, 62, 18);
        add(lbGender);
        
        tglbtnMan = new JToggleButton("남");
        tglbtnMan.setBounds(110, 332, 56, 27);
        add(tglbtnMan);
        
        tglbtnWoman = new JToggleButton("여");
        tglbtnWoman.setBounds(162, 332, 56, 27);
        add(tglbtnWoman);
        ButtonGroup gender = new ButtonGroup();
        gender.add(tglbtnMan);
        gender.add(tglbtnWoman);
        
        //height
        height = new JTextField();
        height.setBounds(111, 382, 50, 24);
        add(height);
        height.setColumns(10);

        
        JLabel lbCm = new JLabel("cm");
        lbCm.setBounds(175, 385, 32, 18);
        add(lbCm);
        
        JLabel lbWeight = new JLabel("체중");
        lbWeight.setBounds(232, 385, 62, 18);
        add(lbWeight);
        
        weight = new JTextField();
        weight.setBounds(308, 382, 62, 24);
        add(weight);
        weight.setColumns(10);
      
        
        JLabel lbKg = new JLabel("kg");
        lbKg.setBounds(384, 385, 62, 18);
        add(lbKg);
        clearBtn.addActionListener(new ADDListener());
        
   }
   
   
   class CheckIDListener implements ActionListener {
      
      @Override
      public void actionPerformed(ActionEvent e) {
         showDB check = new showDB();
         check.execute(user_id.getText());
         String uinfo=check.idCheck();
         if(uinfo ==null) {
        	 JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.");
             checkbit = 1;
         }else {
        	 JOptionPane.showMessageDialog(null, "이미 존재하는 ID입니다.");
             user_id.setText("");
         }
      }
   }
   class ADDListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         CheckIDListener check = new CheckIDListener();
         user.removeAllElements();
         user.add(user_id.getText());
         user.add(user_pw.getText());
         user.add(user_name.getText());
         user.add(age.getText());
         if(tglbtnMan.isSelected() == true)
         {
            user.add("M");
         }
         else if (tglbtnWoman.isSelected() == true)
         {
            user.add("F");
         }
         user.add(height.getText());
         user.add(weight.getText());
         
         insertDB idb = new insertDB(user);
         if(checkbit == 1 && user_pw.getText().equals(user_pw2.getText())) {
            idb.execute();
            win.change("Page2");
         }else if(checkbit==0) {
        	 JOptionPane.showMessageDialog(null, "id중복확인 하세요");
         }else if(!user_pw.getText().equals(user_pw2.getText())){
        	 JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
         }
         
      }
   }
   }
