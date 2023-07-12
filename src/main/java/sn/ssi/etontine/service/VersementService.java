package sn.ssi.etontine.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Tontine;
import sn.ssi.etontine.model.Versement;
import sn.ssi.etontine.repository.MembreRepository;
import sn.ssi.etontine.repository.TontineRepository;
import sn.ssi.etontine.repository.VersementRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class VersementService {
    private final VersementRepository versementRepository;
    private final TontineRepository tontineRepository;
    private final MembreRepository membreRepository;

    public VersementService(VersementRepository versementRepository, TontineRepository tontineRepository,
                            MembreRepository membreRepository) {
        this.versementRepository = versementRepository;
        this.tontineRepository = tontineRepository;
        this.membreRepository = membreRepository;
    }

    public void effectuerVersement(Long tontineId, Long membreId, double montant, String modeVersement, double amende) {
        Tontine tontine = tontineRepository.findById(tontineId)
                .orElseThrow(() -> new IllegalArgumentException("Tontine non trouvée"));

        Membre membre = membreRepository.findById(membreId)
                .orElseThrow(() -> new IllegalArgumentException("Membre non trouvé"));

        if (montant < tontine.getMontantVersement()) {
            throw new IllegalArgumentException("Le montant du versement est inférieur au montant minimum requis");
        }

        Versement versement = new Versement();



        LocalDate dateActuelle = LocalDate.now();
        LocalDate dateVersementPrevue = dateActuelle.plusDays(tontine.getFrequence());

        if (dateActuelle.isAfter(dateVersementPrevue)) {

            double montantAmende = tontine.getMontantAmende();
            tontine.setMontantAmende(montantAmende);

            // Vérifier si le versement de l'amende est effectué

            if (amende < tontine.getMontantAmende()) {

                throw new IllegalArgumentException("Le versement de l'amende est obligatoire.");
            }

            versement.setTontine(tontine);
            versement.setMembre(membre);
            versement.setMontant(montant);
            versement.setMontantAmende(amende);
            versement.setModeVersement(modeVersement);

            versementRepository.save(versement);
        }
    }

    public List<Map<String, Object>> getSommeEtDateVersements(Membre membre, Tontine tontine) {
        List<Versement> versements = versementRepository.findByMembreAndTontine(membre, tontine);
        List<Map<String, Object>> sommeEtDateVersements = new ArrayList<>();

        double somme = 0;
        for (Versement versement : versements) {
            somme += versement.getMontant();
            Map<String, Object> versementInfo = new HashMap<>();
            versementInfo.put("montant", versement.getMontant());
            versementInfo.put("dateVersement", versement.getDateVersement());
            sommeEtDateVersements.add(versementInfo);
        }

        Map<String, Object> sommeInfo = new HashMap<>();
        sommeInfo.put("somme", somme);
        sommeEtDateVersements.add(sommeInfo);

        return sommeEtDateVersements;
    }


}


