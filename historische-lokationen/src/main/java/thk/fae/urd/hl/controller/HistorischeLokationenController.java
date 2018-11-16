package thk.fae.urd.hl.controller;

import thk.fae.urd.hl.models.HistorischeLokation;
import thk.fae.urd.hl.repos.HistorischeLokationenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("historische-lokationen")
class HistorischeLokationenController {
    
    private HistorischeLokationenRepository lokationenRepository;
    
    @Autowired
    public HistorischeLokationenController(HistorischeLokationenRepository lokationenRepository) {
		this.lokationenRepository = lokationenRepository;
	}
    
    @GetMapping(produces = "application/json")
    public Iterable<HistorischeLokation> getByDvpId() {
        return lokationenRepository.findAll();
    }

}