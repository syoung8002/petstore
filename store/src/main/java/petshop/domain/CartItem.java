package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import petshop.StoreApplication;

@Entity
@Table(name = "CartItem_table")
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Item> items;

    @Embedded
    private Payment payment;

    @PrePersist
    public void onPrePersist() {}

    public static CartItemRepository repository() {
        CartItemRepository cartItemRepository = StoreApplication.applicationContext.getBean(
            CartItemRepository.class
        );
        return cartItemRepository;
    }
}
