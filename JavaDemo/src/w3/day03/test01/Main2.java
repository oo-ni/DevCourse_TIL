package w3.day03.test01;

import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        Connection conn = null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // Connection, PreparedStatement 이런 애들은 다 interface임. 객체 없이는 못돌아감. 그럼 어떡하지?
        // -> MySQL에서 이런걸 다 driver로 만들어서 제공함. 자바에서는 끌어다 쓰기만 하면 되는 것.

        try {
            // 1. 커넥션 생성
//            conn = DriverManager.getConnection("jdbc:mysql://59.277.84.200:3306/workshop", "grepp", "grepp");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop", "root", "3787");
            // 2. SQL 생성
            SQL = "select bno, title, writer, publisher, price from book_tb";
            // 3. PreparedStatement or Statement에 명령어 담기
            pstmt = conn.prepareStatement(SQL);     // Statement는 이렇게 미리 SQL을 넣지 않고 execute하는 시점에 넣는 차이가 있음.
            // 4. 실행하기
            // 4.1 insert/update/delete : int
            // 4.2 select : ResultSet
            rs = pstmt.executeQuery();
            // 5. 결과값 처리
            while (rs.next()) { // next의 결과가 true이면 레코드 있네? 한줄 읽을 수 있다!!
                int bno = rs.getInt("bno");
                int price = rs.getInt("price");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String pub = rs.getString("publisher");
                System.out.println(bno + " " + title + " " + writer + " " + pub + " " + price);
            };
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            // 6. 사용 완료한 리소스 반납(생성한 순서의 역순으로)
            if (rs != null) {   // close 과정에서 또 인터럽트나 외부 오류가 생기면 안됨.
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
