package com.grepp.model.dto;

public class BoardDTO {
    private int no;
    private String title;
    private String writer;
    private String content;
    private String regDate;
    private int readCount;

    public BoardDTO() {
    }

    public BoardDTO(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", regDate='" + regDate + '\'' +
                ", readCount=" + readCount +
                '}';
    }
}
