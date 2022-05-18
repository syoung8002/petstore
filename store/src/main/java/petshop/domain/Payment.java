
package petshop.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Embeddable
@Data

public class Payment  {


    
    private String method;
    
    private String status;





}

