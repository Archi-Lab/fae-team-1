package thk.fae.ua.presentation.web.ort;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import thk.fae.ua.core.domain.entities.Ort;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.core.domain.repositories.OrtRepository;
import thk.fae.ua.presentation.web.dvp.DvpNotFoundException;

import java.util.UUID;

@RestController
@RequestMapping("orte")
@RequiredArgsConstructor
public class OrtController {

    private final OrtRepository ortRepository;
    private final DemenziellVeraendertePersonRepository dvpRepository;

    @GetMapping(path = "/dvp/{dvpId}")
    public Iterable<Ort> ReadOrte(@PathVariable("dvpId") UUID dvpId) {
        return dvpRepository.findById(dvpId)
                .map(dvp ->  ortRepository.findByDvpId(dvpId))
                .orElseThrow(() -> new DvpNotFoundException(dvpId));
    }

    @GetMapping(path = "/{ortId}")
    public Ort ReadRoute(@PathVariable("ortId")UUID ortId) {
        return ortRepository.findById(ortId)
                .orElseThrow(() -> new OrtNotFoundException(ortId));

    }

    @PostMapping(path = "/dvp/{dvpId}")
    public Ort CreateOrt(@PathVariable("dvpId")UUID dvpId, @RequestBody Ort ort) {
        return dvpRepository.findById(dvpId)
                .map(dvp -> {
                    ort.setDemenziellVeraendertePerson(dvp);
                    return ortRepository.save(ort);
                })
                .orElseThrow(() -> new DvpNotFoundException(dvpId));
    }

    @PutMapping(path = "/{ortId}")
    public Ort UpdateOrt(@PathVariable("ortId")UUID ortId, @RequestBody Ort ortUpdate) {
        return ortRepository.findById(ortId)
                .map(ort -> {
                    ort.setName(ortUpdate.getName());
                    ort.setBereich(ortUpdate.getBereich());
                    ort.setLokation(ortUpdate.getLokation());
                    return ortRepository.save(ort);
                })
                .orElseThrow(() -> new OrtNotFoundException(ortId));
    }

    @DeleteMapping(path = "/{ortId}")
    public void DeleteOrt(@PathVariable("ortId")UUID ortId) {
        if(ortRepository.existsById(ortId)) {
            ortRepository.deleteById(ortId);
        }
    }

}
