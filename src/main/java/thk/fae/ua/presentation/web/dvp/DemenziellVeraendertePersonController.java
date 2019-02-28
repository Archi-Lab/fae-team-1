package thk.fae.ua.presentation.web.dvp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;

import java.util.UUID;

@RestController
@RequestMapping("dvp")
@RequiredArgsConstructor
public class DemenziellVeraendertePersonController {

    private final DemenziellVeraendertePersonRepository dvpRepository;

    @GetMapping
    public Iterable<DemenziellVeraendertePerson> getAll() {
        return dvpRepository.findAll();
    }

    @GetMapping(path="/{dvpId}")
    public DemenziellVeraendertePerson ReadDVP(@PathVariable("dvpId")UUID dvpId) {
        return dvpRepository.findById(dvpId)
                .orElseThrow(() -> new DvpNotFoundException(dvpId));
    }
}