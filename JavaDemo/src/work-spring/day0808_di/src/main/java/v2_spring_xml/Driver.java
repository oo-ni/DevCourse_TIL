package v2_spring_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {
        // 객체가 필요하면 new를 하지 않고 beans.xml에서 생성된 객체를 가져다가 쓰면 된답니다.

        ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/v2_spring_xml/beans.xml");
        Car c1 = (Car) context.getBean("sonata1");
        Car c2 = (Car) context.getBean("sonata2");

        c1.printInfo();
        c2.printInfo();

        System.out.println((Car) context.getBean("sonata1"));
        System.out.println((Car) context.getBean("sonata1"));
    }
}
