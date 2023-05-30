package sn.ssi.etontine.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Versement;
import sn.ssi.etontine.repository.VersementRepository;
import sn.ssi.etontine.service.CompteService;
import sn.ssi.etontine.service.VersementService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/membre")
public class VersementController {
    private final VersementService versementService;

    private  CompteService compteService;



    public VersementController(VersementService versementService) {
        this.versementService = versementService;
        this.compteService = compteService;
    }


    //Versement d'un membre sur son compte
    @PostMapping("/versements")
    public ResponseEntity<String> effectuerVersement(@RequestParam("membreId") Long membreId,
                                                     @RequestParam("compteId") Long compteId,
                                                     @RequestParam("montant") BigDecimal montant) {
        versementService.effectuerVersement(membreId, compteId, montant);
        return ResponseEntity.ok("Versement effectué avec succès");
    }


    //Historique des versments d'un membre

    @GetMapping("historiqueVersements")
    public List<Versement> getHistoriqueVersements(@RequestParam("membreId") Long membreId) {
        return versementService.getHistoriqueVersements(membreId);
    }








}

