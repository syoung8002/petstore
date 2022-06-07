package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Embeddable
@Data
public class User {

    private String id;

    private String password;

    private String name;

    private String email;

    private String address;

    private String phone;
}
