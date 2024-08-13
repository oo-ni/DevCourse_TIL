package v3_componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {

        ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/v3_componentscan/beans.xml");
        Car c1 = (Car) context.getBean("car");

        c1.printInfo();
    }
}
