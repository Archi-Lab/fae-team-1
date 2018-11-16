package thk.fae.urd.hl;

import java.time.Instant;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import thk.fae.urd.hl.models.HistorischeLokation;
import thk.fae.urd.hl.models.Lokation;
import thk.fae.urd.hl.repos.HistorischeLokationenRepository;

@Component
public class DemoDaten implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private HistorischeLokationenRepository repo;

    private Long getDvpId() {
        return (long) (new Random().nextInt(10) + 1);
    }

    private Lokation getLokation() {
        return new Lokation(getLatitude(), getLongitude(), getAltitude());
    }

    private double getLatitude() {
        return new Random().nextInt(180 + 1 + 180) - 180;
    }

    private double getLongitude() {
        return new Random().nextInt(90 + 1 + 90) - 90;
    }

    private double getAltitude() {
        return new Random().nextInt(100 + 1 + 10) - 10;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        for (int i = 0; i < 100; i++) {
            repo.save(new HistorischeLokation(getDvpId(), Instant.now(), getLokation()));
        }
    }

}
