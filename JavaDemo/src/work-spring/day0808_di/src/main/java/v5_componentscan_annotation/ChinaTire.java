package v5_componentscan_annotation;

import org.springframework.stereotype.Repository;
import v1_strategy.Tire;

@Repository // DB작업 객체인가보당
public class ChinaTire implements Tire {
    @Override
    public String getModel() {  // insert
        return "대륙";    // oracle insert 구현함.
    }
}
