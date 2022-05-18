
package petstore.domain;

import petstore.domain.PetReserved;
import petstore.StoreApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
public class Item  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    int appearance;
    int health;
    Long petId;

    @Embedded
    Money price;

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Money getMoney() {
        return price;
    }

    public void setMoney(Money price) {
        this.price = price;
   }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }


    public static ItemRepository repository(){
        ItemRepository itemRepository = StoreApplication.applicationContext.getBean(ItemRepository.class);
        return itemRepository;
    }

}

