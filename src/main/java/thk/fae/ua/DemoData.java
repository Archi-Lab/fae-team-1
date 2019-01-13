package thk.fae.ua;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import thk.fae.ua.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;
import thk.fae.ua.domain.ort.Ort;
import thk.fae.ua.domain.route.Route;
import thk.fae.ua.repo.DemenziellVeraendertePersonRepoDBBase;
import thk.fae.ua.repo.ort.OrtRepoDBBase;
import thk.fae.ua.repo.route.RouteRepoDBBase;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DemoData {
    private final @NonNull
    DemenziellVeraendertePersonRepoDBBase dvpRepo;

    private final @NonNull
    RouteRepoDBBase routenRepo;

    private final @NonNull
    OrtRepoDBBase ortRepo;

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

        var o1 = new Ort();
        o1.setName("Demo Ort 1");
        o1.setDemenziellVeraendertePerson(dvp);
        ortRepo.save(o1);

        dvp.addOrt(o1);

        dvpRepo.save(dvp);
    }
}
