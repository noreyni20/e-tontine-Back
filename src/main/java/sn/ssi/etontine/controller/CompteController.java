package sn.ssi.etontine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Compte;
import sn.ssi.etontine.model.Versement;
import sn.ssi.etontine.repository.CompteRepository;
import sn.ssi.etontine.service.CompteService;
import sn.ssi.etontine.service.VersementService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    CompteRepository compteRepository;

    private final CompteService compteService;


    public CompteController(CompteService compteService) {

        this.compteService = compteService;


    }

    // Endpoint pour récupérer le solde du compte d'un membre
    @GetMapping("/solde")
    public BigDecimal getSoldeCompte(@RequestParam("membreId") Long membreId) {

        return compteService.getSoldeCompte(membreId);
    }


    // Endpoint pour créer un compte pour un membre
    @PostMapping("/membre")
    public ResponseEntity<Compte> createCompte(@RequestParam("membreId") Long membreId) {
        Compte compte = compteService.createCompte(membreId);
        return ResponseEntity.ok(compte);
    }

    @GetMapping("/getAllCompte")
    public List<Compte> getAll() {
        return compteRepository.findAll();

    }


    //Historique des versments d'un membre




}
