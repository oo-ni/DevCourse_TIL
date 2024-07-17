package day01;

public class Member {
    private int no;
    private String name;
    private String tel;

    public Member(int no, String name, String tel) {
        this.no = no;
        this.name = name;
        this.tel = tel;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public String toString() {
        return "Member{no=" + no + ", name='" + name + "', tel='" + tel + "'}";
    }
}
