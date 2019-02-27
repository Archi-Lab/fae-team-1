package thk.fae.ua.infrastructure.kafka.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.UAEventPublikationService;
import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;
import thk.fae.ua.infrastructure.kafka.models.uaevent.UAEventMessageModel;

import java.time.Instant;
import java.util.UUID;

@Service
public class UngewoehnlicherAufenthaltsortEventSender implements UAEventPublikationService {

    @Value("${kafka.topics.ua-event}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, UAEventMessageModel> kafkaTemplate;

    public void publishUAEvent(UngewoehnlicherAufenthaltsortEvent event) {

        UAEventMessageModel test = new UAEventMessageModel();

        test.dvpId = UUID.randomUUID();
        test.zeitpunk = Instant.now();
        test.version = 0L;

        kafkaTemplate.send(topic, test);
    }

}
