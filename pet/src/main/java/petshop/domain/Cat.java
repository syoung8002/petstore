
package petshop.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Data
@DiscriminatorValue("cat")
public class Cat extends Pet {





    @Override
    public void eat(){}
    @Override
    public void speak(){}


}

