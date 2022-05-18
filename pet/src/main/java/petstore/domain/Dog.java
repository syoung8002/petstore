
package petstore.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Data
@DiscriminatorValue("dog")
public class Dog extends Pet {

    @Override
    public void speak(){
         System.out.println("멍멍");
    }

    @Override
    public void eat(){
        setEnergy(getEnergy() + 2);
    }

    @Override
    public void sleep() {
        super.sleep();
      
        setAppearance(getAppearance() + 1);
        
    }

}