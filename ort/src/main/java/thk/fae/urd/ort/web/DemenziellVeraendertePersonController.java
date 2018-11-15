package thk.fae.urd.ort.web;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePersonRepo;

import java.net.http.HttpResponse;
import java.util.UUID;

@RepositoryRestController
@ExposesResourceFor(DemenziellVeraendertePerson.class)
@RequestMapping("/dvp")
@RequiredArgsConstructor
public class DemenziellVeraendertePersonController {
    private final @NonNull DemenziellVeraendertePersonRepo repo;
    private final @NonNull EntityLinks entityLinks;

    @GetMapping(path="/{dvpId}")
    public ResponseEntity<Resource<DemenziellVeraendertePerson>> ReadDVP(@PathVariable("dvpId")UUID dvpId) {
        var dvp = repo.findById(dvpId).get();

        var r = new Resource<>(dvp);
        r.add(entityLinks.linkForSingleResource(dvp).slash("/routen").withRel("CreateRoute"));
        r.add(entityLinks.linkForSingleResource(dvp).slash("/routen").withRel("ReadRouten"));

        return ResponseEntity.ok(r);
    }
}