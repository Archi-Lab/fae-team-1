package thk.fae.ua.infrastructure.kafka.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.UAEventService;
import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;
import thk.fae.ua.infrastructure.kafka.models.uaevent.UAEventMessageModel;

@Service
@RequiredArgsConstructor
public class UngewoehnlicherAufenthaltsortEventSender implements UAEventService {

    @Value("${kafka.topics.ua-event}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, UAEventMessageModel> kafkaTemplate;

    public void publishUAEvent(UngewoehnlicherAufenthaltsortEvent event) {

        UAEventMessageModel eventMessage = new UAEventMessageModel();

        eventMessage.dvpId = event.dvp.getId();
        eventMessage.zeitpunk = event.timestamp;
        eventMessage.version = 0L;
        eventMessage.standort = event.lokation;

        kafkaTemplate.send(topic, eventMessage);
    }

}
