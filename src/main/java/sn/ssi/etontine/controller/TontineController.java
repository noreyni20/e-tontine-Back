package sn.ssi.etontine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Tontine;

import sn.ssi.etontine.repository.TontineRepository;
import sn.ssi.etontine.service.TontineService;


import java.util.*;


@CrossOrigin(origins = "*")
@RestController
@Slf4j
public class TontineController {

    private final TontineService tontineService;

    public TontineController(TontineService tontineService) {
        this.tontineService = tontineService;
    }
    @Autowired
    TontineRepository tontineRepository;
    @PostMapping("/nouvelle_tontine")
    public ResponseEntity<Tontine> createTontine(
            @RequestBody Tontine tontine,
            @RequestParam double montantVersement,
            @RequestParam double montantAmende,
            @RequestParam int frequence) {

        Tontine createdTontine = tontineService.createTontine(tontine, montantVersement, montantAmende, frequence);
        return new ResponseEntity<>(createdTontine, HttpStatus.CREATED);
    }

    @GetMapping("/getById")
    public Optional<Tontine> getById(@RequestParam Long tontineId){
        return tontineRepository.findById(tontineId);
    }

    @GetMapping("/getAllTontine")

    public ResponseEntity<List<Tontine>> getAllTontines() {
        List<Tontine> tontines = tontineService.getAllTontines();
        return new ResponseEntity<>(tontines, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam Long tontineId){
        tontineRepository.deleteById(tontineId);
        Optional<Tontine> sms = tontineRepository.findById(tontineId);
        if(sms.isPresent())
            return generateRespose("Echec de suppression ", HttpStatus.BAD_REQUEST, tontineId);
        else
            return generateRespose("Tontine supprimée: "+tontineId , HttpStatus.OK, tontineId);
    }

    public ResponseEntity<Object> generateRespose(String message, HttpStatus st , Object responseobj){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("Status", st.value());
        map.put("data", responseobj);

        return new ResponseEntity<Object> (map,st);
    }


    @PutMapping("/updateTontine")
    public Tontine update(@RequestBody Tontine tontine)
    {
        return tontineRepository.save(tontine);
    }


    //Ajouter des membres à une tontine
    @PostMapping("/tontineId/addMembres")
    public ResponseEntity<String> addMembreToTontine(@RequestParam("membreId") Membre membre,
                                                     @RequestParam("tontineId") Long tontineId)  {
        if (!tontineService.doesTontineExist(tontineId)) {
            return ResponseEntity.ok("Tontine introuvable");
        }

        if (!tontineService.doesMembreExist(membre.getId())) {
            return ResponseEntity.ok("Membre introuvable.");
        }


        tontineService.addMembreToTontine(tontineId, membre);
        return ResponseEntity.ok("Membre ajouté à la tontine avec succès.");
    }

    //Liste des membres d'une tontine
    @GetMapping("tontineId/listeMembres")
    public ResponseEntity<List<Membre>> getMembresByTontineId(@RequestParam("tontineId") Long tontineId) {
        List<Membre> membres = tontineService.getMembresByTontineId(tontineId);
        return ResponseEntity.ok(membres);
    }

    @GetMapping("tontineId/effectuer-tirage")
    public ResponseEntity<String> effectuerTirage(@RequestParam("tontineId") Long tontineId) {
        tontineService.effectuerTirage(tontineId);
        return ResponseEntity.ok("Tirage effectué avec succès");
    }

    @GetMapping("tontineId/membres-tires")
    public ResponseEntity<List<Membre>> getMembresTires(@RequestParam("tontineId") Long tontineId) {
        List<Membre> membresTires = tontineService.getMembresTires(tontineId);
        return ResponseEntity.ok(membresTires);
    }

    @GetMapping("tontineId/membres-restants")
    public ResponseEntity<List<Membre>> getMembresRestants(@RequestParam("tontineId") Long tontineId) {
        List<Membre>  MembresRestants = tontineService.getMembresRestants(tontineId);
        return ResponseEntity.ok(MembresRestants);
    }





}



