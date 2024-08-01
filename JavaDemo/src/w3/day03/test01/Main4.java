package w3.day03.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main4 {
    public static void main(String[] args) {
        Connection conn = null;
        String SQL = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
//            conn = DriverManager.getConnection("jdbc:mysql://59.277.84.200:3306/workshop", "grepp", "grepp");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/workshop", "root", "3787");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("조회 : 1, 수정: 2, 삭제: 3, 종료: 9 >> ");
                int input = Integer.parseInt(br.readLine());
                if (input == 9) {
                    System.out.println("종료합니다~ ㅂㅂ");
                    break;
                }
                if (input == 1) {
                    SQL = "select bno, title, writer, publisher, price from book_tb";

                    pstmt = conn.prepareStatement(SQL);
                    rs = pstmt.executeQuery();

                    while (rs.next()) {
                        int bno = rs.getInt("bno");
                        int price = rs.getInt("price");
                        String title = rs.getString("title");
                        String writer = rs.getString("writer");
                        String pub = rs.getString("publisher");
                        System.out.println(bno + " " + title + " " + writer + " " + pub + " " + price);
                    }
                } else if(input == 2) {
                    System.out.println("수정할 책 제목 >> ");
                    String oldTitle = br.readLine();
                    System.out.println("새 제목 >> ");
                    String newTitle = br.readLine();
                    System.out.println("출판사 >> ");
                    String pub = br.readLine();
                    System.out.println("저자 >> ");
                    String writer = br.readLine();
                    System.out.println("가격 >> ");
                    int price = Integer.parseInt(br.readLine());

                    SQL = "update book_tb set title = ?, writer = ?, price = ?, publisher = ? where title = ?";

                    pstmt = conn.prepareStatement(SQL);
                    pstmt.setString(1, newTitle);
                    pstmt.setString(2, writer);
                    pstmt.setInt(3, price);
                    pstmt.setString(4, pub);
                    pstmt.setString(5, oldTitle);

                    int result = pstmt.executeUpdate();

                    System.out.println("수정이 완료되었습니다." + result);
                } else if (input == 3) {
                    System.out.println("삭제할 책 제목 >> ");
                    String title = br.readLine();

                    SQL = "delete from book_tb where title = ?";

                    pstmt = conn.prepareStatement(SQL);
                    pstmt.setString(1, title);

                    int result = pstmt.executeUpdate();

                    System.out.println("삭제가 완료되었습니다. " + result);
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
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