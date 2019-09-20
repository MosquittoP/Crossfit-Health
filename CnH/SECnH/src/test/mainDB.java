package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

//데이터베이스의 전체적인 틀을 잡아주는 추상클래스
abstract class mainDB {
   protected String url = "jdbc:mysql://localhost:3306/seproject?serverTimezone = UTC";
   protected String driver = "com.mysql.cj.jdbc.Driver";
   protected String id = "root";
   protected String pw = "00000000";
   protected Connection conn;
   protected PreparedStatement stmt;
   protected ResultSet rs;

   public void execute() {
   };
}

//데이터베이스에 정보를 저장하는 삽입 클래스
class insertDB extends mainDB { // 완성 - 회원가입시 데이터 저장
   // 회원가입용 변수
   private String uid;
   private String upw;
   private String uname;
   private int uage;
   private String gender;
   private float uheight;
   private float uweight;
   private float ubmi;

   // 게시판용 변수
   private int bnum;
   private String btitle;
   private String bcontents;

   // 회원정보를 벡터로 받아와서 변수에 저장
   public insertDB(Vector<String> v) {
      uid = v.get(0);
      upw = v.get(1);
      uname = v.get(2);
      uage = Integer.parseInt(v.get(3));
      gender = v.get(4);
      uheight = Float.parseFloat(v.get(5));
      uweight = Float.parseFloat(v.get(6));
   }

   // 게시판 정보를 벡터로 받아와서 변수에 저장
   public insertDB(Vector<String> v, int board) {

      btitle = v.get(0);
      bcontents = v.get(1);
      uid = v.get(2);
   }

   // 회원가입 실행
   public void execute() {
      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.prepareStatement(
               "INSERT INTO User_DB(id, password, name, age, gender, height, weight) VALUES(?,?,?,?,?,?,?)");
         stmt.setString(1, uid);
         stmt.setString(2, upw);
         stmt.setString(3, uname);
         stmt.setInt(4, uage);
         stmt.setString(5, gender);
         stmt.setFloat(6, uheight);
         stmt.setFloat(7, uweight);
         stmt.executeUpdate();
         stmt.close();
         conn.close();
         System.out.println("삽입성공");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // 게시판내용 저장 실행
   public void boardData() {
      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.prepareStatement("INSERT INTO boardsystem(title,contents,uid) VALUES(?,?,?)");
         stmt.setString(1, btitle);
         stmt.setString(2, bcontents);
         stmt.setString(3, uid);
         Object dd[] = { bnum, btitle, bcontents, uid };
         stmt.executeUpdate();
         stmt.close();
         conn.close();
         System.out.println("삽입성공");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}

//데이터베이스에서 정보를 읽어오는 클래스
class showDB extends mainDB {
   protected Statement stmt;

   // 불러온 사용자 정보를 담을 벡터
   private Vector<String> uinfo = new Vector<String>();
   private String uid;
   private String upw;

   // 사용자 정보를 받아서 데이터베이스의 내용을 받아오는 쿼리 실행
   public void execute(String uuid) {
      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.createStatement();
         rs = stmt
               .executeQuery("select id, password, name, age, gender, height, weight, bmi, calorie from user_db where id= '"
                     + uuid + "'");
         while (rs.next()) {

            uid = rs.getString(1);
            upw = rs.getString(2);

            uinfo.add(rs.getString(1));// id
            uinfo.add(rs.getString(2));// password
            uinfo.add(rs.getString(3));// name
            uinfo.add(rs.getString(4));// age
            uinfo.add(rs.getString(5));// gender
            uinfo.add(rs.getString(6));// height
            uinfo.add(rs.getString(7));// weight
            uinfo.add(rs.getString(8));// bmi
            uinfo.add(rs.getString(9));//calorie
         }
         rs = stmt
               .executeQuery("select lev_table.lev from user_db, lev_table where calorie>=min_cal and calorie<max_cal and user_db.id='"+uuid+"'");
         while(rs.next()) {
            uinfo.add(rs.getString(1)); //level
         }
         rs.close();
         stmt.close();
         conn.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // 회원가입시 동일아이디가 존재하는지 확인하는 메소드
   public String idCheck() {
      return uid;
   }

   // 로그인 확인하는 메소드
   public String LoginCheck() {
      return uid + "/" + upw;
   }

   // 사용자 정보 전체를 불러오는 메소드
   public Vector<String> getInfo() {
      return uinfo;
   }
}

//게시판 정보를 불러오는 클래스
class getBoardDB extends mainDB {
   private Statement stmt;
   // 게시판 내용을 담을 변수
   private int bnum;
   private String title;
   private String contentboard;
   private String bid;
   private String uinfo;

   // 게시판 테이블을 받아와서 차례로 내용을 저장하는 메소드
   public void execute(DefaultTableModel model) {

      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.createStatement();
         rs = stmt.executeQuery("Select * from boardsystem");

         while (rs.next()) {
            title = rs.getString(1);
            contentboard = rs.getString(2);
            bid = rs.getString(3);
            bnum = Integer.parseInt(rs.getString(4));
            Object dd[] = { bnum, title, contentboard, bid };
            model.addRow(dd);
         }

         rs.close();
         stmt.close();
         conn.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}

//운동 및 스트레칭 정보를 불러오는 클래스
class getExeStrDB extends mainDB {
//운동 및 스트레칭 정보를 저장할 변수
   private String title;
   private String desc;
   private String youtubeurl;
   private String pic;
   private float calorie;
   private Vector<String> data = new Vector<String>();
   private String uinfo;

   // 운동 또는 스트레칭 테이블, 그리고 몸 부위 선택하는 조건 변수
   private String setDB;
   private int cond;
   private int part;

   // 임의의 정수 3개를 저장할 변수
   private Random rand = new Random();
   private int[] randNum = new int[3];

   // 세가지 임의의 숫자를 차례로 배열에 저장
   private void numSet() {
      for (int i = 0; i < 3; i++) {
         randNum[i] = rand.nextInt(7) + 1;
         System.out.println(randNum[i]);
      }
      randomC();
   }

   // 변수에 중복된 숫자를 처리하는 메소드
   private void randomC() {
      for (int i = 0; i < randNum.length - 1; i++) {
         int tmp = i;
         for (int j = i + 1; j < randNum.length; j++) {
            if (randNum[tmp] == randNum[j]) {
               randNum[j]++;
            }
         }
      }
   }

   public getExeStrDB(int con, int part) {
      this.cond = con;
      this.part = part;
      ExStFoDB();
      numSet();
   }

   // 테이블 및 부위 조건을 설정하는 메소드
   private void ExStFoDB() {
      if (cond == 0)
         setDB = "exercise_DB";
      else
         setDB = "stretching_DB";
   }

   // 데이터베이스에서 정보를 출력하는 메소드
   public void execute() {

      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공" + setDB);
         stmt = conn.prepareStatement("Select * from " + setDB + " where part = ? and ( id =? or id=? or id=?)");
         stmt.setInt(1, part);
         stmt.setInt(2, randNum[0]);
         stmt.setInt(3, randNum[1]);
         stmt.setInt(4, randNum[2]);
         rs = stmt.executeQuery();
         
         // 운동정보 한 개를 ;로 구분하는 하나의 문자열로 만들어서 벡터에 저장
         while (rs.next()) {
            title = rs.getString(1);
            desc = rs.getString(2);
            youtubeurl = rs.getString(3);
            calorie = rs.getFloat(4);
            pic = rs.getString(5);
            uinfo = title + ";" + desc + ";" + youtubeurl + ';' + calorie + ";" + pic; // split(";") 해야함
            data.add(uinfo);
         }

         uinfo = title + ";" + desc + ";" + youtubeurl + ';' + calorie + ";" + pic;
         rs.close();
         stmt.close();
         conn.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // 운동정보 getter
   public Vector<String> getData() {
      return data;
   }
}

//음식정보를 불러오는 클래스
class getFoodDB extends mainDB {

   // 음식정보를 저장하는 변수
   private String title;
   private float calorie;
   private String pic;
   private Vector<String> data = new Vector<String>();
   private String finfo;

   public getFoodDB(String title) {
      this.title = title;
   }

   // 음식정보를 불러오는 메소드
   public void execute() {

      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.prepareStatement("Select * from food_db where title= '" + title + "'");

         rs = stmt.executeQuery();

         while (rs.next()) {

            title = rs.getString(1);
            calorie = rs.getFloat(4);
            pic = rs.getString(5);
            data.add(title);
            data.add(String.valueOf(calorie));
            data.add(pic);
         }

         rs.close();
         stmt.close();
         conn.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // 음식정보 getter
   public Vector<String> getData() {
      return data;
   }
}

//사용자 정보를 업데이트하는 클래스
class updateDB extends mainDB {
   private String uid;
   private float uheight;
   private float uweight;
   private float calorie;

   public updateDB(String uid, float calorie) {
      this.uid = uid;
      this.calorie = calorie;
   }

   public updateDB(String uid, float uheight, float uweight) { // vector로 변환
      this.uid = uid;
      this.uheight = uheight;
      this.uweight = uweight;
   }

   // 유저정보 갱신하는 메소드
   public void execute() {
      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.prepareStatement("UPDATE User_DB SET height=?,weight=? where id=?");
         
         stmt.setFloat(1, uheight);
         stmt.setFloat(2, uweight);
         stmt.setString(3, uid);
         stmt.executeUpdate();
         stmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   // 유저가 사용한 칼로리를 업데이트하는 메소드
   public void updateCalorie() {
      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.prepareStatement("UPDATE User_DB SET calorie=calorie+? where id=?");
         stmt.setFloat(1, calorie);
         stmt.setString(2, uid);
         stmt.executeUpdate();
         stmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}

//데이터베이스에서 게시판 정보를 삭제하는 메소드 
class deleteDB extends mainDB {
   // 글번호를 저장할 변수
   private int bnum;

   public deleteDB(int i) {
      bnum = i;
   }

   // user id를 받아서 데이터베이스에서 게시글을 삭제하는 메소드
   public void execute(String uuid) {
      try {
         conn = DriverManager.getConnection(url, id, pw);
         try {
            Class.forName(driver);
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         }
         System.out.println("연결성공");
         stmt = conn.prepareStatement("DELETE FROM boardsystem where id=? and uid = ?");
         stmt.setInt(1, bnum);
         stmt.setString(2, uuid);
         stmt.executeUpdate();
         stmt.close();
         conn.close();
         System.out.println("삭제성공");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}