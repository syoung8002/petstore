package petshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petshop.PetmanagementApplication;
import petshop.domain.PetRegistered;
import petshop.domain.Slept;

@Entity
@Table(name = "Pet_table")
@Data
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer energy;

    private Integer appearance;

    private String name;

    @Embedded
    @AttributeOverride(
        name = "s",
        column = @Column(name = "addressS", nullable = true)
    )
    private Address placeOfBirth;

    @Enumerated(EnumType.STRING)
    private PetStatus petState;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    @OneToMany
    private List<IllnessHistory> illnessHistory;

    @PostPersist
    public void onPostPersist() {
        PetRegistered petRegistered = new PetRegistered(this);
        petRegistered.publishAfterCommit();

        Slept slept = new Slept(this);
        slept.publishAfterCommit();
    }

    public static PetRepository repository() {
        PetRepository petRepository = PetmanagementApplication.applicationContext.getBean(
            PetRepository.class
        );
        return petRepository;
    }

    public void feed() {
        Fed fed = new Fed(this);
        fed.publishAfterCommit();

        Overweighted overweighted = new Overweighted(this);
        overweighted.publishAfterCommit();
    }

    public void groom() {
        Groomed groomed = new Groomed(this);
        groomed.publishAfterCommit();
    }
}
