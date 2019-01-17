package thk.fae.ua.infrastructure.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import thk.fae.ua.infrastructure.kafka.models.dvp.DvpUpdateMessageModel;


@Service
public class KafkaDvpListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDvpListener.class);

    @KafkaListener(topics = "${kafka.topics.dvp}")
    public void receive(@Payload DvpUpdateMessageModel data,
                        @Headers MessageHeaders headers) {
        LOGGER.info("received dvp data='{}'", data);

        headers.keySet().forEach(key -> {
            LOGGER.info("{}: {}", key, headers.get(key));
        });
    }
}
