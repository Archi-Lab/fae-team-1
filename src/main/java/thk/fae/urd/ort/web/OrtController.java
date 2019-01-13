package thk.fae.urd.ort.web;

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
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePersonRepo;
import thk.fae.urd.ort.domain.ort.Ort;
import thk.fae.urd.ort.domain.ort.OrtRepo;
import thk.fae.urd.ort.domain.route.Route;
import thk.fae.urd.ort.domain.route.RouteRepo;

import java.awt.image.ReplicateScaleFilter;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.UUID;

@Controller
@ExposesResourceFor(OrtController.class)
@RequestMapping(path="")
@RequiredArgsConstructor
public class OrtController {

    private final @NonNull OrtRepo ortRepo;
    private final @NonNull DemenziellVeraendertePersonRepo dvpRepo;
    private final @NonNull EntityLinks entityLinks;

    @GetMapping(path = "/dvp/{dvpId}/orte")
    public HttpEntity<Resources<Resource<Ort>>> ReadOrte(@PathVariable("dvpId")UUID dvpId) {
        var dvp = dvpRepo.findById(dvpId).get();
        var orte = dvp.getOrte();

        var orte2 = new ArrayList<Resource<Ort>>();
        for (var ort : orte) {
            var rr = new Resource<>(ort);
            rr.add(entityLinks.linkToSingleResource(ort).withSelfRel());
            rr.add(entityLinks.linkToSingleResource(ort).withRel("UpdateOrt"));
            rr.add(entityLinks.linkToSingleResource(ort).withRel("DeleteOrt"));
            orte2.add(rr);
        }
        var r = new Resources<>(orte2);
        r.add(entityLinks.linkToSingleResource(dvp));
        return ResponseEntity.ok(r);
    }

    @PostMapping(path = "/dvp/{dvpId}/orte")
    public HttpEntity<Resource<Ort>> CreateOrt(@PathVariable("dvpId")UUID dvpId, @RequestBody Ort ort) {
        ort.setDemenziellVeraendertePerson(dvpRepo.findById(dvpId).get());
        ortRepo.create(ort);

        return ResponseEntity.ok(new Resource<>(ort));
    }

    @GetMapping(path = "/orte/{ortId}")
    public HttpEntity<Resource<Ort>> ReadOrt(@PathVariable("ortId")UUID ortId) {
        var ort = ortRepo.findById(ortId).get();
        var r = new Resource<>(ort);
        r.add(entityLinks.linkToSingleResource(ort).withSelfRel());
        r.add(entityLinks.linkToSingleResource(ort).withRel("UpdateOrt"));
        r.add(entityLinks.linkToSingleResource(ort).withRel("DeleteOrt"));

        return ResponseEntity.ok(r);
    }

    @PutMapping(path = "/orte/{ortId}")
    public HttpEntity<Resource<Ort>> UpdateRoute(@PathVariable("ortId")UUID ortId, @RequestBody Ort ort) {
        var r = ortRepo.findById(ortId).get();
        ort.setDemenziellVeraendertePerson(r.getDemenziellVeraendertePerson());
        ort.setId(r.getId());
        ortRepo.create(ort);

        return ResponseEntity.ok(new Resource<>(ort));
    }
}
