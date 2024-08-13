package v5_componentscan_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import v1_strategy.Tire;

//@Service    // 이렇게 이 클래스 객체를 생성할 거지만 name을 지정하지 않았네? 기본 이름은 클래스 첫글자 소문자로 바꾼 이름.
@Service(value = "sonata")
public class Car {
    @Autowired  // 객체 이름에 의존하지 않고 객체 타입을 기반으로 객체를 탐색함
    @Qualifier("chinaTire")
    private Tire tire;
    private String model;
    private String color;
    /////////////////////////////////////////////////////////////////////////////////////////
    public Car(){}

    public Car(Tire tire) {
        this.tire = tire;
    }

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Car(String model, String color, Tire tire) {
        this.model = model;
        this.color = color;
        this.tire = tire;
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public void printInfo(){
        System.out.println("차량 모델 : " + model);
        System.out.println("차량 색상 : " + color);
        System.out.println("장착된 타이어 : " + tire.getModel());
    }

}
