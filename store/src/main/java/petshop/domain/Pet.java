package petshop.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Embeddable
@Data

public class Pet  {


    
    private Long id;
    
    private Integer appearance;
    
    private String name;
    
    private String type;
    
    private Integer energy;





}

<function>