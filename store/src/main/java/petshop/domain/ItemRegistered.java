package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class ItemRegistered extends AbstractEvent {

    private Long id;
    private Integer appearance;
    private Integer health;
    private Money price;

    public ItemRegistered() {
        super();
    }
}
