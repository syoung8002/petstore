
package petshop.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Data

public class Customer  {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private String id;
    @Embedded
    private Address address;





}

