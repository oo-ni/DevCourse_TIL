package w3.day04.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        BoardRepository repo = BoardRepositoryMysql.getInstance();   // mysql 객체일 수도, oracle 객체일 수도

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("1: 게시글 작성 / 2: 게시글 목록 / 3: 게시글 수정 / 4: 게시글 삭제 / 5: 게시글 조회 / 9: 종료");
            int select = Integer.parseInt(br.readLine());
            if (select == 9) {
                break;
            }
            switch (select) {
                case 1:
                    System.out.print("title >> ");
                    String title = br.readLine();
                    System.out.print("writer >> ");
                    String writer = br.readLine();
                    System.out.print("content >> ");
                    String content = br.readLine();
                    System.out.println("실행결과 : " + repo.insert(new BoardDTO(title, content, writer)));
                    break;
                case 2:
                    for (BoardDTO b : repo.selectAll()) {
                        System.out.println(b);
                    }
                    break;
                case 3:
                    System.out.print("수정하려는 글 번호 입력 >> ");
                    int no = Integer.parseInt(br.readLine());
                    System.out.print("title(원치 않으면 그냥 enter) >> ");
                    title = br.readLine();
                    System.out.print("writer(원치 않으면 그냥 enter) >> ");
                    writer = br.readLine();
                    System.out.print("content(원치 않으면 그냥 enter) >> ");
                    content = br.readLine();
                    BoardDTO b = new BoardDTO(title, writer, content);
                    b.setNo(no);
                    System.out.println("실행결과 : " + repo.update(b));
                    break;
                case 5:
                    System.out.print("조회하려는 글 번호 입력 >> ");
                    no = Integer.parseInt(br.readLine());
                    System.out.println(repo.selectOne(no));
                    break;
            }
        }
    }
}
