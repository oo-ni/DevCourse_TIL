package v3_componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // DB 작업이 아니라 비즈니스 로직을 처리하는 객체구나! 정체 확인!
public class Car {
    @Autowired
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
