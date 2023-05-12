package sn.ssi.etontine.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Membre;

import sn.ssi.etontine.repository.MembreRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/membre")
public class MembreController {



    @Autowired
    MembreRepository membreRepository;
    @PostMapping("/nouveau")
    public Membre membre(@RequestBody Membre membre){

        return membreRepository.save(membre);
    }

    @GetMapping("/getById{id}")
    public Optional<Membre> getById(@RequestBody Membre membre){
        return membreRepository.findById(membre.getId());
    }

    @GetMapping("/getAll")
    public Iterable<Membre> getAll() {
        return membreRepository.findAll();
    }

    @DeleteMapping("/supprimer")
    public ResponseEntity<Object> delete(@RequestBody Membre membre){
        membreRepository.deleteById(membre.getId());
        Optional<Membre> sms = membreRepository.findById(membre.getId());
        if(sms.isPresent())
            return generateRespose("Echec de suppression ", HttpStatus.BAD_REQUEST, membre);
        else
            return generateRespose("Membre supprimée: "+membre.getId() , HttpStatus.OK, membre);
    }

    public ResponseEntity<Object> generateRespose(String message, HttpStatus st , Object responseobj){

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("Status", st.value());
        map.put("data", responseobj);

        return new ResponseEntity<Object> (map,st);
    }


    @PutMapping("/update")
    public Membre update(@RequestBody Membre membre)
    {
        return membreRepository.save(membre);
    }


}
