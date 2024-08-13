package v4_xml_no;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car c1 = (Car) context.getBean("sonata");

        c1.printInfo();
    }
}
