package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Data
@DiscriminatorValue("cat")
public class Cat extends Pet {

    @Override
    public void eat() {}

    @Override
    public void speak() {}
}
