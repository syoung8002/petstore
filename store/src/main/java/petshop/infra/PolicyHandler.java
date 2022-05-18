package petshop.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;

import petshop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import petshop.domain.*;


@Service
public class PolicyHandler{
    @Autowired ItemRepository itemRepository;
    @Autowired CartItemRepository cartItemRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPetRegistered_DisplayToTheShop(@Payload PetRegistered petRegistered){

        if(!petRegistered.validate()) return;
        PetRegistered event = petRegistered;
        System.out.println("\n\n##### listener DisplayToTheShop : " + petRegistered.toJson() + "\n\n");


        

        // Sample Logic //
        Item.displayToTheShop(event);
        

        

    }


}



<function>