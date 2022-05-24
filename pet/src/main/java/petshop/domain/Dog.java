package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Data
@DiscriminatorValue("dog")
public class Dog extends Pet {

    @Override
    public void eat() {}

    @Override
    public void sleep() {}

    @Override
    public void speak() {}
}
