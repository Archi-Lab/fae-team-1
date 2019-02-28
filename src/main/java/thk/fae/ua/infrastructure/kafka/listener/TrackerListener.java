package thk.fae.ua.infrastructure.kafka.listener;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import thk.fae.ua.core.application.interfaces.TrackerEventService;
import thk.fae.ua.core.domain.events.TrackerUpdateEvent;
import thk.fae.ua.core.domain.valueobjects.Lokation;
import thk.fae.ua.core.domain.valueobjects.Tracker;
import thk.fae.ua.infrastructure.kafka.models.tracker.TrackerMessageModel;

import java.time.ZonedDateTime;


@Service
@RequiredArgsConstructor
public class TrackerListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerListener.class);

    private final TrackerEventService trackerService;

    @KafkaListener(topics = "${kafka.topics.tracker}", containerFactory = "trackerListenerContainerFactory")
    public void receive(@Payload TrackerMessageModel trackerMessageModel) {

        switch (trackerMessageModel.type) {
            case "tracker-tracked":
                var trackerEvent = new TrackerUpdateEvent();

                trackerEvent.setTracker(new Tracker(trackerMessageModel.payload.trackerId));
                trackerEvent.setTimestamp(ZonedDateTime.parse(trackerMessageModel.time).toInstant());
                trackerEvent.setLokation(new Lokation(
                        trackerMessageModel.payload.currentPosition.latitude,
                        trackerMessageModel.payload.currentPosition.longitude,
                        trackerMessageModel.payload.currentPosition.altitude
                ));
                trackerService.handleTrackerUpdate(trackerEvent);
            break;

            default:
                LOGGER.info("RECEIVED UNKNOWN TRACKER EVENT");
            break;
        }
    }

}
