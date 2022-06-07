package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.StoreApplication;
import petshop.domain.ItemAdded;
import petshop.domain.PriceSet;

@Entity
@Table(name = "Item_table")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private Money price;

    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "userId", nullable = true)
    )
    private User adopter;


    @Embedded
    @AttributeOverride(
        name = "id",
        column = @Column(name = "petIdId", nullable = true)
    )
    private PetId petId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PostPersist
    public void onPostPersist() {
        PriceSet priceSet = new PriceSet(this);
        priceSet.publishAfterCommit();

        ItemAdded itemAdded = new ItemAdded(this);
        itemAdded.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static ItemRepository repository() {
        ItemRepository itemRepository = StoreApplication.applicationContext.getBean(
            ItemRepository.class
        );
        return itemRepository;
    }

    public void adopt() {
        setStatus(Status.ADOPTED);
        
        Adopted adopted = new Adopted(this);
        adopted.publishAfterCommit();
    }

    public void dissolute() {
        Dissoluted dissoluted = new Dissoluted(this);
        dissoluted.publishAfterCommit();
    }

    public static void 전시(PetRegistered petRegistered) {
        Item item = new Item();
        PetId petId = new PetId();
        petId.setId(petRegistered.getId());
        item.setPetId(petId);
        repository().save(item);

        ItemAdded itemAdded = new ItemAdded(item);
        itemAdded.publishAfterCommit();

    }

    public static void 정보변경(Overweighted overweighted) {
        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        */

        /** Example 2:  finding and process
        
        repository().findById(overweighted.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);


         });
        */

    }

    public static void 정보변경(Groomed groomed) {
        /** Example 1:  new item 
        Item item = new Item();
        repository().save(item);

        */

        /** Example 2:  finding and process
        
        repository().findById(groomed.get???()).ifPresent(item->{
            
            item // do something
            repository().save(item);


         });
        */

    }
}

