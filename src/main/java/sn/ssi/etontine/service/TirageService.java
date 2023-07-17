package sn.ssi.etontine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.repository.MembreRepository;

import java.util.List;
import java.util.Random;

@Service
public class TirageService {
    private final MembreRepository membreRepository;

    @Autowired
    public TirageService(MembreRepository membreRepository) {

        this.membreRepository = membreRepository;
    }

}

