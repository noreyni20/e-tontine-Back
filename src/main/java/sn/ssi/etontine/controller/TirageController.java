package sn.ssi.etontine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.service.TirageService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tontines/tirage")
public class TirageController {
    private final TirageService tirageService;

    @Autowired
    public TirageController(TirageService tirageService) {
        this.tirageService = tirageService;
    }

}
