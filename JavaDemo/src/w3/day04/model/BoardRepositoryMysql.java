package w3.day04.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 좋은 객체지향 팁 : 수정에는 닫혀있고, 추가에는 열려있어야 함.
public class BoardRepositoryMysql implements BoardRepository {
    private BoardRepositoryMysql(){}
    private static BoardRepository instance = new BoardRepositoryMysql();

    public static BoardRepository getInstance(){
        return instance;
    }

    //    private static final String INSERT_SQL = "insert into board_tb(title, writer, content, reg_date) values(?,?,?,now())";

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int insert(BoardDTO board) throws SQLException {
        int result = 0;
        try {
            String sql = " insert into " + " board_tb(title, writer, content, reg_date) values(?,?,?,now()) ";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getWriter());
            ps.setString(3, board.getContent());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("insert error");
            throw e;
        } finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

//    @Override
//    public int update(BoardDTO board, String category) throws SQLException {
//        int result = 0;
//        try {
//            String sql = " update board_tb set ";
//            if ("title".equals(category)) {
//                sql += "title = " + board.getTitle();       // ' 없어도 문자열 잘 들어가려나...
//            } else if ("writer".equals(category)) {
//                sql += "writer = " + board.getWriter();
//            } else if ("content".equals(category)) {
//                sql += "content = " + board.getContent();
//            }
//            sql += " where no = " + board.getNo();
//            conn = DBUtil.getConnection();
//            ps = conn.prepareStatement(sql);
//            result = ps.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("insert error");
//            throw e;
//        } finally {
//            DBUtil.close(ps, conn);
//        }
//        return result;
//    }

    @Override
    public int update(BoardDTO board) throws SQLException {
        // 위의 update 버전은 수정하고 싶은게 뭔지 정확하게 찝어서 그것만 수정하기였고,
        // 이 update 는 수정하고 싶은게 여러개면 한꺼번에 수정하도록 값의 유무 체크로서 진행하는 버전
        int result = 0;
        try {
            String sql = " update board_tb set ";

            // 제목에 변경하고자 하는 값이 확실히 있는지 체크해서.
            if (board.getTitle() != null && !board.getTitle().isEmpty()) {
                sql += " title= '" + board.getTitle() + "', ";
            } if (board.getWriter() != null && !board.getWriter().isEmpty()) {
                sql += " writer= '" + board.getWriter() + "', ";
            } if (board.getContent() != null && !board.getContent().isEmpty()) {
                sql += " content= '" + board.getContent() + "', ";
            }
            sql = sql.substring(0, sql.length() - 2);

            sql += " where no = " + board.getNo();

            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("update error");
            throw e;
        } finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

    @Override
    public int delete(BoardDTO board) throws SQLException {
        return 0;
    }

    @Override
    public List<BoardDTO> selectAll() throws SQLException {
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        try {
            String sql = " select no, title, writer, content, read_count, reg_date from board_tb ";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(makeBoardDTO(rs));
            }
        } catch (SQLException e) {
            System.out.println("insert error");
            throw e;
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }

    @Override
    public BoardDTO selectOne(int no) throws SQLException {
        BoardDTO board = null;

        try {
            String sql = " select no, title, writer, content, read_count, reg_date from board_tb where no = " + no;
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {    // 글 번호 이상하면 없을수는 있음.
                board = makeBoardDTO(rs);
            }
        } catch (SQLException e) {
            System.out.println("update error");
            throw e;
        } finally {
            DBUtil.close(rs, ps, conn);
        }
        return board;
    }
    private BoardDTO makeBoardDTO(ResultSet rs) throws SQLException {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setNo(rs.getInt("no"));
        boardDTO.setTitle(rs.getString("title"));
        boardDTO.setWriter(rs.getString("writer"));
        boardDTO.setContent(rs.getString("content"));
        boardDTO.setReadCount(rs.getInt("read_count"));
        boardDTO.setRegDate(rs.getString("reg_date"));
        return boardDTO;
    }
}
