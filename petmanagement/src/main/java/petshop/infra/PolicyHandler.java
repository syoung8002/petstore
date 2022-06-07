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
    PetRepository petRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDissoluted_상태변경(@Payload Dissoluted dissoluted) {
        if (!dissoluted.validate()) return;
        Dissoluted event = dissoluted;
        System.out.println(
            "\n\n##### listener 상태변경 : " + dissoluted.toJson() + "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAdopted_상태변경(@Payload Adopted adopted) {
        if (!adopted.validate()) return;
        Adopted event = adopted;
        System.out.println(
            "\n\n##### listener 상태변경 : " + adopted.toJson() + "\n\n"
        );
        // Sample Logic //

    }
    // keep

}
