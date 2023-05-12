package sn.ssi.etontine.service;

import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.Compte;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.repository.CompteRepository;
import sn.ssi.etontine.repository.MembreRepository;

import java.math.BigDecimal;


@Service
public class VersementService {
    private final MembreRepository membreRepository;
    private final CompteRepository compteRepository;

    public VersementService(MembreRepository membreRepository, CompteRepository compteRepository) {
        this.membreRepository = membreRepository;
        this.compteRepository = compteRepository;
    }

    public void effectuerVersement(Long membreId, Long compteId, BigDecimal montant) {
        Membre membre = membreRepository.findById(membreId).orElseThrow(() -> new IllegalArgumentException("Membre non trouvé"));
        Compte compte = compteRepository.findById(compteId).orElseThrow(() -> new IllegalArgumentException("Compte non trouvé"));

        // Effectuer les opérations de versement
        // ajouter le montant au solde du compte

         compte.setSolde(compte.getSolde().add(montant));

        // Sauvegarder les modifications
        compteRepository.save(compte);
    }
}

