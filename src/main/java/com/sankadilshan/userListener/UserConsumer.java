package com.sankadilshan.userListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sankadilshan.userListener.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserConsumer {

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(id = "sanka.dilshan.user.id_v0", topics = {"sanka.dilshan.users.v0"}, groupId = "sanka.dilshan.user.group.v0", autoStartup = "true")
    public void consume(Acknowledgment acknowledgment, @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key, @Header(name = KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(name = KafkaHeaders.RECEIVED_PARTITION) long partition, @Header(name = KafkaHeaders.OFFSET) long offset, @Payload String userPayload) {
        try {

            User user = null;
            log.info("User listener invoked.");
            log.info("{} : {}", KafkaHeaders.RECEIVED_KEY, key);
            log.info("{} : {}", KafkaHeaders.RECEIVED_TOPIC, topic);
            log.info("{} : {}", KafkaHeaders.RECEIVED_PARTITION, partition);
            log.info("{} : {}", KafkaHeaders.OFFSET, offset);

            if (userPayload != null) {
                user = objectMapper.readValue(userPayload, User.class);
            }
            assert user != null;
            log.info(user.toString());
        } catch (JsonProcessingException ex) {
            log.error("Having error when mapping");
        }

        acknowledgment.acknowledge();

    }
}
