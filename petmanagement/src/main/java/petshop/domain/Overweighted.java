package petshop.domain;

import java.util.Date;
import lombok.Data;
import petshop.domain.*;
import petshop.infra.AbstractEvent;

@Data
public class Overweighted extends AbstractEvent {

    private Long id;
    private Integer energy;
    private Integer appearance;
    private String status;
    private String name;

    public Overweighted(Pet aggregate) {
        super(aggregate);
    }

    public Overweighted() {
        super();
    }
    // keep

}
