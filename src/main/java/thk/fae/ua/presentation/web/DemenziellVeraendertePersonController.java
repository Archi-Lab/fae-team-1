package thk.fae.ua.presentation.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<DemenziellVeraendertePerson> ReadDVP(@PathVariable("dvpId")UUID dvpId) {
        var dvp = dvpRepository.findById(dvpId);
        if(dvp.isPresent()) {
            return new ResponseEntity<>( dvp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}