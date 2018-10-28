package thk.fae.urd.lh.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import thk.fae.urd.lh.model.HistoricalLocation;
import thk.fae.urd.lh.repo.HistoricalLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/locationhistory")
class HistoricalLocationController {
    
    @Autowired
    private HistoricalLocationRepository locationRepository;
    
    @GetMapping
    public Iterable getAll() {
        return locationRepository.findAll();
    }
    
    @GetMapping(value = "/{id}", produces = "application/json")
    public HistoricalLocation getById(@PathVariable Long id) {
        Optional<HistoricalLocation> location = locationRepository.findById(id);

        if (!location.isPresent()) {
            throw new RessourceNotFoundException("id: " + id);
        }

        return location.get();
    }   
    
    @GetMapping(value = "dvp/{dvpId}", produces = "application/json")
    public List<HistoricalLocation> getByDvpId(@PathVariable Long dvpId) {
        return locationRepository.findAllByDvpId(dvpId);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HistoricalLocation create(@RequestBody @Valid HistoricalLocation location) {
        return locationRepository.save(location);
    }
}