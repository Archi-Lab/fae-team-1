package thk.fae.ua.infrastructure.kafka.listener;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.core.domain.valueobjects.Tracker;
import thk.fae.ua.infrastructure.kafka.models.dvp.DvpMessageModel;
import thk.fae.ua.infrastructure.kafka.models.dvp.DvpModel;


@Service
@RequiredArgsConstructor
public class DvpListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(DvpListener.class);

    private final DemenziellVeraendertePersonRepository dvpRepository;

    @KafkaListener(topics = "${kafka.topics.dvp}", containerFactory = "dvpListenerContainerFactory")
    public void receive(@Payload DvpMessageModel dvpMM) {

        switch (dvpMM.type) {
            case "dvp-created":
            case "dvp-updated":
                dvpRepository.findById(dvpMM.payload.id).ifPresentOrElse(
                        dvp -> { if(dvp.getVersion() < dvpMM.payload.version) applyChanges(dvp, dvpMM.payload); },
                        () -> createNew(dvpMM.payload)
                );
            break;

            case "dvp-deleted":
                if(dvpRepository.existsById(dvpMM.id)) dvpRepository.deleteById(dvpMM.id);
            break;

            default:
                LOGGER.info("RECEIVED UNKNOWN DVP EVENT");
            break;
        }
    }

    public void createNew(DvpModel dvpModel) {
        DemenziellVeraendertePerson dvp = new DemenziellVeraendertePerson();
        dvp.setId(dvpModel.id);
        applyChanges(dvp, dvpModel);
    }

    public void applyChanges(DemenziellVeraendertePerson dvp, DvpModel update) {
        dvp.setVersion(update.version);
        dvp.setTracker(new Tracker(update.tracker.key));
        dvp.setVorname(update.vorname.vorname);
        dvp.setNachname(update.nachname.nachname);
        dvpRepository.save(dvp);
    }

}
