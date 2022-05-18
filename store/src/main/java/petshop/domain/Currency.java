
package petshop.domain;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Data

public enum Currency  {

    KR_WON,
    US_DOLLAR,
    ENG_POUND,
    EURO;






}

