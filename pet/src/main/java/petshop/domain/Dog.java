package petshop.domain;

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
    public void eat(){}
    @Override
    public void sleep(){}
    @Override
    public void speak(){}


}

<function>