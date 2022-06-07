package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Entity
@Data
public class IllnessHistory {

    @Id
    private String illName;

    private Double start;

    private Double end;
}
