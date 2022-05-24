package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Embeddable
@Data
public class Pet {

    private Long id;

    private Integer appearance;

    private String name;

    private String type;

    private Integer energy;
}
