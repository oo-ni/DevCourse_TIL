package w1.day03;

public class Emp implements java.io.Serializable {
    private String name;
    private String dept;
    private int salary;

    public Emp(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public void showInfo() {
        System.out.println("---------Record for " + name + "---------");
        System.out.println("Name : " + name);
        System.out.println("Dept : " + dept);
        System.out.println("Salary : " +salary);
    }
}
