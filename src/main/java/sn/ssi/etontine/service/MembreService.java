package sn.ssi.etontine.service;


import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.repository.MembreRepository;

import java.util.NoSuchElementException;

@Service
public class MembreService {

    private MembreRepository membreRepository;



    public MembreService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    public void supprimerMembre(Long memberId) {
        membreRepository.deleteById(memberId);
    }

    public void supprimerTousLesMembres() {
        membreRepository.deleteAll();
    }

    // Autres méthodes de service

}

