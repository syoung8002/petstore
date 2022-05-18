
package petshop.domain;

import petshop.domain.*;
import petshop.infra.AbstractEvent;
import java.util.Date;
import lombok.Data;

@Data
public class ItemRegistered extends AbstractEvent {

    private Long id;
    private Integer appearance;
    private Integer health;
    private Money price;

    public ItemRegistered(){
        super();
    }
}

