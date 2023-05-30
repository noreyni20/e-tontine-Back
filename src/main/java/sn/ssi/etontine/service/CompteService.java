package sn.ssi.etontine.service;


import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.Compte;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Versement;
import sn.ssi.etontine.repository.CompteRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    private final CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public Compte createCompte(Long membreId) {
        Compte compte = new Compte();
        compte.setMembre(new Membre(membreId));
        compte.setDateCreation(LocalDateTime.now());
        compte.setSolde(BigDecimal.ZERO);
        return compteRepository.save(compte);
    }

    public BigDecimal getSoldeCompte(Long membreId) {
        Compte compte = compteRepository.findByMembreId(membreId);
        if (compte != null) {
            return compte.getSolde();
        }
        throw new IllegalArgumentException("Le membre n'a pas de compte associé.");
    }




    }



