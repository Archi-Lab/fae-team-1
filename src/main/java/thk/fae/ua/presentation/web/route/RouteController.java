package thk.fae.ua.presentation.web.route;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thk.fae.ua.core.domain.entities.Route;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.core.domain.repositories.RouteRepository;
import thk.fae.ua.presentation.web.dvp.DvpNotFoundException;

import java.util.UUID;

@RestController
@RequestMapping("routen")
@RequiredArgsConstructor
public class RouteController {

    private final RouteRepository routeRepository;
    private final DemenziellVeraendertePersonRepository dvpRepository;

    @GetMapping(path = "/dvp/{dvpId}")
    public Iterable<Route> ReadRouten(@PathVariable("dvpId")UUID dvpId) {
        return dvpRepository.findById(dvpId)
                .map(dvp ->  routeRepository.findByDvpId(dvpId))
                .orElseThrow(() -> new DvpNotFoundException(dvpId));
    }

    @GetMapping(path = "/{routeId}")
    public Route ReadRoute(@PathVariable("routeId")UUID routeId) {
        return routeRepository.findById(routeId)
                .orElseThrow(() -> new RouteNotFoundException(routeId));
    }

    @PostMapping(path = "/dvp/{dvpId}")
    public Route CreateRoute(@PathVariable("dvpId")UUID dvpId, @RequestBody Route route) {
        return dvpRepository.findById(dvpId)
                .map(dvp -> {
                    route.setDemenziellVeraendertePerson(dvp);
                    return routeRepository.save(route);
                })
                .orElseThrow(() -> new DvpNotFoundException(dvpId));
    }

    @PutMapping(path = "/{routeId}")
    public Route UpdateOrt(@PathVariable("routeId")UUID routeId, @RequestBody Route routeUpdate) {
        return routeRepository.findById(routeId)
                .map(route -> {
                    route.setName(routeUpdate.getName());
                    route.setLokationen(routeUpdate.getLokationen());
                    return routeRepository.save(route);
                }).orElseThrow(() -> new RouteNotFoundException(routeId));
    }

    @DeleteMapping(path = "/{routeId}")
    public void DeleteOrt(@PathVariable("routeId")UUID routeId) {
        if(routeRepository.existsById(routeId)) {
            routeRepository.deleteById(routeId);
        }
    }

}
