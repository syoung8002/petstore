package petshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.config.kafka.KafkaProcessor;
import petshop.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ItemRepository itemRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPetRegistered_전시(
        @Payload PetRegistered petRegistered
    ) {
        if (!petRegistered.validate()) return;
        PetRegistered event = petRegistered;
        System.out.println(
            "\n\n##### listener 전시 : " + petRegistered.toJson() + "\n\n"
        );

        // Sample Logic //
        Item.전시(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOverweighted_정보변경(
        @Payload Overweighted overweighted
    ) {
        if (!overweighted.validate()) return;
        Overweighted event = overweighted;
        System.out.println(
            "\n\n##### listener 정보변경 : " + overweighted.toJson() + "\n\n"
        );

        // Sample Logic //
        Item.정보변경(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverGroomed_정보변경(@Payload Groomed groomed) {
        if (!groomed.validate()) return;
        Groomed event = groomed;
        System.out.println(
            "\n\n##### listener 정보변경 : " + groomed.toJson() + "\n\n"
        );

        // Sample Logic //
        Item.정보변경(event);
    }
    // keep

}
