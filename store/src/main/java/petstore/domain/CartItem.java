
package petstore.domain;

import petstore.StoreApplication;
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
    Long id;
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

    
    @ManyToOne
    Customer customer;
        public Customer getCustomer() {
            return customer;
        }
        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

    
    @OneToMany
    List<Item> item;
        public List<Item> getItems() {
            return items;
        }
        public void setItems(List<Item> items) {
            this.items = items;
        }


    @Embedded
    Payment payment;
        public Payment getPayment() {
            return payment;
        }
        public void setPayment(Payment payment) {
            this.payment = payment;
        }


    public static CartItemRepository repository(){
        CartItemRepository cartItemRepository = StoreApplication.applicationContext.getBean(CartItemRepository.class);
        return cartItemRepository;
    }


}

