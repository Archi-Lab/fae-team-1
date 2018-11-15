package thk.fae.urd.ort;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePersonRepo;
import thk.fae.urd.ort.domain.route.Route;
import thk.fae.urd.ort.domain.route.RouteRepo;
import thk.fae.urd.ort.repo.DemenziellVeraendertePersonRepoDBBase;
import thk.fae.urd.ort.repo.route.RouteRepoDBBase;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DemoData {
    private final @NonNull
    DemenziellVeraendertePersonRepoDBBase dvpRepo;

    private final @NonNull
    RouteRepoDBBase routenRepo;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {


        var dvp = new DemenziellVeraendertePerson();
        dvp.setId(UUID.fromString("7e57a6e2-1df0-4826-ad17-f072a7b90962"));
        dvpRepo.save(dvp);

        var r1 = new Route();
        r1.setName("Demo Route 1");
        r1.setDemenziellVeraendertePerson(dvp);
        routenRepo.save(r1);

        dvp.addRoute(r1);
        dvpRepo.save(dvp);
    }
}
