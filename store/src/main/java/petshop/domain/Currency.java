package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

public enum Currency {
    KR_WON,
    US_DOLLAR,
    ENG_POUND,
    EURO,
}
