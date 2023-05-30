package sn.ssi.etontine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Compte;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Tontine;

import sn.ssi.etontine.repository.TontineRepository;
import sn.ssi.etontine.service.TontineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Tontine tontine(@RequestBody Tontine tontine){

        return tontineRepository.save(tontine);
    }

    @GetMapping("/getById")
    public Optional<Tontine> getById(@RequestBody Tontine tontine){
        return tontineRepository.findById(tontine.getId());
    }

    @GetMapping("/getAllTontine")
    public Iterable<Tontine> getAll() {
        return tontineRepository.findAll();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(@RequestBody Tontine tontine){
        tontineRepository.deleteById(tontine.getId());
        Optional<Tontine> sms = tontineRepository.findById(tontine.getId());
        if(sms.isPresent())
            return generateRespose("Echec de suppression ", HttpStatus.BAD_REQUEST, tontine);
        else
            return generateRespose("Tontine supprimée: "+tontine.getId() , HttpStatus.OK, tontine);
    }

    public ResponseEntity<Object> generateRespose(String message, HttpStatus st , Object responseobj){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("Status", st.value());
        map.put("data", responseobj);

        return new ResponseEntity<Object> (map,st);
    }

    //creating put mapping that updates the book detail
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
            return ResponseEntity.notFound().build();
        }

        if (!tontineService.doesMembreExist(membre.getId())) {
            return ResponseEntity.notFound().build();
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

    @GetMapping("tontineId/nombre-membres-restants")
    public ResponseEntity<Integer> getNombreMembresRestants(@RequestParam("tontineId") Long tontineId) {
        int nombreMembresRestants = tontineService.getNombreMembresRestants(tontineId);
        return ResponseEntity.ok(nombreMembresRestants);
    }

}



