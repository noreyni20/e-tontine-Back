package sn.ssi.etontine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sn.ssi.etontine.service.VersementService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/membre")
public class VersementController {
    private final VersementService versementService;

    public VersementController(VersementService versementService) {
        this.versementService = versementService;
    }

    @PostMapping("/versements")
    public ResponseEntity<String> effectuerVersement(@RequestParam("membre_id") Long membre_id,
                                                     @RequestParam("compte_id") Long compte_id,
                                                     @RequestParam("montant") BigDecimal montant) {
        versementService.effectuerVersement(membre_id, compte_id, montant);
        return ResponseEntity.ok("Versement effectué avec succès");
    }
}

