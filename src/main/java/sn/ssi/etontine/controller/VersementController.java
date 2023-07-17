package sn.ssi.etontine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Tontine;
import sn.ssi.etontine.model.Versement;
import sn.ssi.etontine.repository.MembreRepository;
import sn.ssi.etontine.repository.TontineRepository;
import sn.ssi.etontine.service.MembreNotFoundException;
import sn.ssi.etontine.service.TontineNotFoundException;
import sn.ssi.etontine.service.TontineService;
import sn.ssi.etontine.service.VersementService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*")

@RestController
@Slf4j

@RequestMapping("/versements")
public class VersementController {



    private final VersementService versementService;
    private  final TontineRepository tontineRepository;
    private  final MembreRepository membreRepository;

    public VersementController(VersementService versementService, TontineRepository tontineRepository, MembreRepository membreRepository) {
        this.versementService = versementService;
        this.tontineRepository = tontineRepository;
        this.membreRepository = membreRepository;
    }

    @PostMapping("/tontineId/membreId")
    public ResponseEntity<String> effectuerVersement(@RequestParam Long tontineId, @RequestParam Long membreId,
                                   @RequestParam double montant, @RequestParam String modeVersement, @RequestParam  double amende) {
        versementService.effectuerVersement(tontineId, membreId, montant, modeVersement, amende);
        return ResponseEntity.ok("Versement effectué avec succès.");
    }

    @GetMapping("/historique")
    public ResponseEntity<List<Map<String, Object>>> getSommeEtDateVersements(
            @RequestParam Long membreId,
            @RequestParam Long tontineId

            ) {
        Membre membre = membreRepository.findById(membreId)
                .orElseThrow(() -> new MembreNotFoundException("Membre not found with id: " + membreId));

        Tontine tontine = tontineRepository.findById(tontineId)
                .orElseThrow(() -> new TontineNotFoundException("Tontine not found with id: " + tontineId));

        List<Map<String, Object>> sommeEtDateVersements = versementService.getSommeEtDateVersements(membre, tontine);

        return ResponseEntity.ok(sommeEtDateVersements);
    }



}
