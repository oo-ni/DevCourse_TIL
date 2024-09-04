package com.grepp.jpa.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

// 이 자바파일이 그대로 DB 테이블. 즉 jpa에서는 DB 테이블 안만들고 자바 클래스만 생성해도 자동으로 테이블이 되는 것!
@Entity(name = "board_tb")
public class BoardEntity {
    @Id     // pk로 설정할 컬럼에게 붙여주는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // IDENTITY가 mysql에서 auto_increment 한다는 의미임.
    private int no;
    private String title;
    private String content;
    private String writer;
    private int readCount;
    @CreationTimestamp          // 생성되는 시점의 시간이 자동으로 들어가도록 해줌.
    private String regDate;
    //////////////////////////////////////////////////////////////////////////////////////////////////// 여기까지 테이블 생성 로직

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", readCount=" + readCount +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
