package sn.ssi.etontine.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ssi.etontine.model.Tontine;

import sn.ssi.etontine.repository.TontineRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
public class TontineController {
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

    @GetMapping("/getAll")
    public Iterable<Tontine> getAll() {
        return tontineRepository.findAll();
    }

    @PostMapping("/delete")
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

}

