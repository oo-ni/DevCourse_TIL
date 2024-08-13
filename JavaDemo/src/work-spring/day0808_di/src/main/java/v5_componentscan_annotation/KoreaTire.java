package v5_componentscan_annotation;

import org.springframework.stereotype.Repository;
import v1_strategy.Tire;

@Repository
public class KoreaTire implements Tire {
    @Override
    public String getModel() {  // insert
        return "한국";    // mysql insert 구현함.
    }
}
