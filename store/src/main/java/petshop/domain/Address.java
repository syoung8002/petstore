package petshop.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Embeddable
@Data

public class Address  {


    
    private String detail;
    
    private String zipcode;





}

<function>