package thk.fae.ua.infrastructure.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaTrackerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaTrackerListener.class);

    @KafkaListener(topics = "${kafka.topics.tracker}")
    public void consume(String payload) {
        // LOGGER.info("received payload='{}'", payload);
    }
}
