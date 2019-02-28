package thk.fae.ua.infrastructure.kafka.sender;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.application.interfaces.UAEventService;
import thk.fae.ua.core.domain.events.UngewoehnlicherAufenthaltsortEvent;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.infrastructure.kafka.models.uaevent.UAEventMessageModel;

@Service
@RequiredArgsConstructor
public class UngewoehnlicherAufenthaltsortEventSender implements UAEventService {

    @Value("${kafka.topics.ua-event}")
    private String topic;

    private static final Logger LOGGER = LoggerFactory.getLogger(UAEventService.class);

    private final DemenziellVeraendertePersonRepository dvpRepository;

    @Autowired
    private KafkaTemplate<String, UAEventMessageModel> kafkaTemplate;

    public void publishUAEvent(UngewoehnlicherAufenthaltsortEvent event) {

        UAEventMessageModel eventMessage = new UAEventMessageModel();

        eventMessage.dvpId = event.getDvpId();
        eventMessage.zeitpunk = event.getTimestamp();
        eventMessage.version = 0L;
        eventMessage.standort = event.getLokation();

        LOGGER.info("PUBLISHING UAEVENT FOR DVP: {}", event.getDvpId());
        kafkaTemplate.send(topic, eventMessage);
    }

}
