package sn.ssi.etontine.service;
import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.Compte;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Versement;
import sn.ssi.etontine.repository.CompteRepository;
import sn.ssi.etontine.repository.MembreRepository;
import sn.ssi.etontine.repository.VersementRepository;



import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;


@Service
public class VersementService {

    private final VersementRepository versementRepository;

    private final MembreRepository membreRepository;
    private final CompteRepository compteRepository;

    public VersementService(MembreRepository membreRepository, CompteRepository compteRepository, VersementRepository versementRepository) {
        this.membreRepository = membreRepository;
        this.compteRepository = compteRepository;
        this.versementRepository = versementRepository;


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

    public List<Versement> getHistoriqueVersements(Long membreId) {
        return versementRepository.findByMembreId(membreId);
    }

}

