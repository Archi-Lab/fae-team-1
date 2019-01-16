package thk.fae.ua.presentation.web;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepo;
import thk.fae.ua.core.domain.entities.Route;
import thk.fae.ua.core.domain.repositories.RouteRepo;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@ExposesResourceFor(RouteController.class)
@RequestMapping(path="")
@RequiredArgsConstructor
public class RouteController {

    private final @NonNull RouteRepo routeRepo;
    private final @NonNull DemenziellVeraendertePersonRepo dvpRepo;
    private final @NonNull EntityLinks entityLinks;

    @GetMapping(path = "/dvp/{dvpId}/routen")
    public HttpEntity<Resources<Resource<Route>>> ReadRouten(@PathVariable("dvpId")UUID dvpId) {
        var dvp = dvpRepo.findById(dvpId).get();
        var routen = dvp.getRouten();

        var routen2 = new ArrayList<Resource<Route>>();
        for (var route : routen) {
            var rr = new Resource<>(route);
            rr.add(entityLinks.linkToSingleResource(route).withSelfRel());
            rr.add(entityLinks.linkToSingleResource(route).withRel("UpdateRoute"));
            rr.add(entityLinks.linkToSingleResource(route).withRel("DeleteRoute"));
            routen2.add(rr);
        }
        var r = new Resources<>(routen2);
        r.add(entityLinks.linkToSingleResource(dvp));
        return ResponseEntity.ok(r);
    }

    @PostMapping(path = "/dvp/{dvpId}/routen")
    public HttpEntity<Resource<Route>> CreateRoute(@PathVariable("dvpId")UUID dvpId, @RequestBody Route route) {
        route.setDemenziellVeraendertePerson(dvpRepo.findById(dvpId).get());
        routeRepo.create(route);

        return ResponseEntity.ok(new Resource<>(route));
    }

    @GetMapping(path = "/routen/{routeId}")
    public HttpEntity<Resource<Route>> ReadRoute(@PathVariable("routeId")UUID routeId) {
        var route = routeRepo.findById(routeId).get();
        var r = new Resource<>(route);
        r.add(entityLinks.linkToSingleResource(route).withSelfRel());
        r.add(entityLinks.linkToSingleResource(route).withRel("UpdateRoute"));
        r.add(entityLinks.linkToSingleResource(route).withRel("DeleteRoute"));

        return ResponseEntity.ok(r);
    }

    @PutMapping(path = "/routen/{routeId}")
    public HttpEntity<Resource<Route>> UpdateRoute(@PathVariable("routeId")UUID routeId, @RequestBody Route route) {
        var r = routeRepo.findById(routeId).get();
        route.setDemenziellVeraendertePerson(r.getDemenziellVeraendertePerson());
        route.setId(r.getId());
        routeRepo.create(route);

        return ResponseEntity.ok(new Resource<>(route));
    }
}