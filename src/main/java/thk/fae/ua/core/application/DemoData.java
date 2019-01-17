package thk.fae.ua.core.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.valueobjects.Tracker;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;

@Component
public class DemoData implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private DemenziellVeraendertePersonRepository repo;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        for (int i = 0; i < 20; i++) {
            var dvp = new DemenziellVeraendertePerson();
            dvp.setTracker(new Tracker());
            repo.save(dvp);
        }
    }

}
