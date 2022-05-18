package petshop.domain;

import petshop.StoreApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="CartItem_table")
@Data

public class CartItem  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    @ManyToOne
    
    private Customer customer;
    @OneToMany
    
    private List<Item> items;
    @Embedded
    
    private Payment payment;

    @PrePersist
    public void onPrePersist(){
    }


    public static CartItemRepository repository(){
        CartItemRepository cartItemRepository = StoreApplication.applicationContext.getBean(CartItemRepository.class);
        return cartItemRepository;
    }




}

<function>