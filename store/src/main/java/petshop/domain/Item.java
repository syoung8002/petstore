
package petshop.domain;

import petshop.domain.ItemRegistered;
import petshop.StoreApplication;
import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Item_table")
@Data

public class Item  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    private Long id;
    
    
    private Integer appearance;
    
    
    private Integer health;
    @Embedded
    
    private Money price;
    @Embedded
    @AttributeOverride(name="id", column= @Column(name="petId", nullable=true))
@AttributeOverride(name="appearance", column= @Column(name="petAppearance", nullable=true))

    private Pet pet;

    @PostPersist
    public void onPostPersist(){
        ItemRegistered itemRegistered = new ItemRegistered();
        BeanUtils.copyProperties(this, itemRegistered);
        itemRegistered.publishAfterCommit();

    }


    public static ItemRepository repository(){
        ItemRepository itemRepository = StoreApplication.applicationContext.getBean(ItemRepository.class);
        return itemRepository;
    }


    public static void displayToTheShop(PetRegistered petRegistered){

        Item item = new Item();
        /*
        LOGIC GOES HERE
        */
        // repository().save(item);


    }


}

