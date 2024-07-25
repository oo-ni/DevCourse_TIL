package w1.day01;

class Employee {
    String name;
    double salary;      // 기본 급여
    int yearsOfWork;    // 근무 연수
    double hoursWork;   // 근무 시간
    boolean hasBonus;   // 보너스 여부

    public Employee(String name, double salary, int yearsOfWork, double hoursWork, boolean hasBonus) {
        this.name = name;
        this.salary = salary;
        this.yearsOfWork = yearsOfWork;
        this.hoursWork = hoursWork;
        this.hasBonus = hasBonus;
    }
}

public class SalaryCalc {
    Employee[] emps = new Employee[5];
    int i = 0;

    // 배열에 저장하는 메서드
    public void register(Employee e) {
        if (i < emps.length) {
            emps[i] = e;
            i++;
        }
    }

    // 급여를 계산하는 메서드
    /* 급여 계산 로직:
    근무 시간이 160시간을 초과하면 초과 근무 수당을 계산합니다. (50% 초과 근무수당 지급)
    근무 연수가 5년을 초과하면 기본 급여의 5%, 2년을 초과하면 기본 급여의 2%를 보너스로 추가합니다.
    보너스가 있는 경우 추가로 $500을 급여에 더합니다.
    */
    public double calculateSalary(Employee emp) {
        double total = emp.salary;

        // 초과 근무 수당 계산
        if (emp.hoursWork > 160) {
            double overtime = emp.hoursWork - 160;
            double overtimePay = overtime * (emp.salary / 160) * 1.5;
            total += overtimePay;
        }

        // 보너스 계산
        if (emp.yearsOfWork > 5) {
            total += emp.salary * 0.05;
        } else if (emp.yearsOfWork > 2) {
            total += emp.salary * 0.02;
        }
        // 500 cnrk
        if (emp.hasBonus) {
            total += 500;
        }

        return total;
    }

    public static void main(String[] args) {
        SalaryCalc sc = new SalaryCalc();

        sc.register(new Employee("Yoon", 3000, 5, 170, true));
        sc.register(new Employee("Lee", 3200, 6, 160, false));
        sc.register(new Employee("Kim", 2800, 2, 150, true));
        sc.register(new Employee("Choi", 3500, 7, 180, true));
        sc.register(new Employee("Jang", 3300, 4, 155, false));

        for (Employee emp : sc.emps) {
            double calculatedSalary = sc.calculateSalary(emp);
            System.out.println(emp.name + " : " + calculatedSalary);
        }
    }
}
