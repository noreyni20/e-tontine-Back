package sn.ssi.etontine.controller;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.ConnexionRequest;
import sn.ssi.etontine.model.InscriptionRequest;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Tontine;
import sn.ssi.etontine.repository.MembreRepository;
import sn.ssi.etontine.service.MembreService;
import sn.ssi.etontine.service.TelephoneNotFoundException;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@CrossOrigin(origins = "*")

@JsonInclude(JsonInclude.Include.NON_NULL)
@RestController
@Slf4j
@RequestMapping("/api/membre")
public class MembreController {

    @Autowired
     private MembreRepository membreRepository;


    private MembreService membreService;

    public MembreController(MembreService membreService, MembreRepository membreRepository) {
        this.membreService = membreService;
        this.membreRepository = membreRepository;
    }

    @PostMapping("/nouveau")
    public Membre membre(@RequestBody Membre membre) {

        return membreRepository.save(membre);
    }

    @GetMapping("/getMembreById")
    public Optional<Membre> getById(@RequestParam Long membreId){
        return membreRepository.findById(membreId);
    }

    @GetMapping("/getAll")
    public Iterable<Membre> getAll() {
        return membreRepository.findAll();
    }

    @DeleteMapping("/supprimerMembre")
    public ResponseEntity<String> supprimerMembre(@RequestParam Long membreId) {
        membreService.supprimerMembre(membreId);
        return ResponseEntity.ok("Membre supprimé avec succès.");
    }

    @DeleteMapping("supprimerTous")
    public ResponseEntity<String> supprimerTousLesMembres() {
        membreService.supprimerTousLesMembres();
        return ResponseEntity.ok("Tous les membres ont été supprimés avec succès.");
    }


    @PutMapping("/update")
    public Membre update(@RequestBody Membre membre) {

        return membreRepository.save(membre);
    }

    }


