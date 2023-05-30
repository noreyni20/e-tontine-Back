package sn.ssi.etontine.service;

import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Tontine;
import sn.ssi.etontine.repository.MembreRepository;
import sn.ssi.etontine.repository.TontineRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class TontineService {
    private final TontineRepository tontineRepository;
    private final MembreRepository membreRepository;

    public TontineService(TontineRepository tontineRepository, MembreRepository membreRepository) {
        this.tontineRepository = tontineRepository;
        this.membreRepository = membreRepository;
    }

    public boolean doesTontineExist(Long tontineId) {
        return tontineRepository.existsById(tontineId);
    }

    public boolean doesMembreExist(Long membreId) {
        return membreRepository.existsById(membreId);
    }

    public void addMembreToTontine(Long tontineId, Membre membre) {
        Tontine tontine = tontineRepository.findById(tontineId).orElse(null);
        if (tontine != null) {
            tontine.addMembre(membre);
            tontineRepository.save(tontine);
        }
    }


    //liste des membres d'une tontine

    public List<Membre> getMembresByTontineId(Long tontineId) {
        Tontine tontine = tontineRepository.findById(tontineId).orElse(null);
        if (tontine != null) {
            return tontine.getMembres();
        }
        return Collections.emptyList();
    }

    public void effectuerTirage(Long tontineId) {
        // Récupérer la tontine par son ID
        Tontine tontine = tontineRepository.findById(tontineId)
                .orElseThrow(() -> new RuntimeException("Tontine not found with id: " + tontineId));

        // Récupérer les membres non tirés de la tontine
        List<Membre> membresNonTires = membreRepository.findByTontineIdAndTireFalse(tontineId);

        // Vérifier s'il reste des membres non tirés
        if (membresNonTires.isEmpty()) {
            System.out.println("Tous les membres ont déjà été tirés.");
            return;
        }

        // Effectuer le tirage (ex: tirage aléatoire)
        Random random = new Random();
        Membre membreTire = membresNonTires.get(random.nextInt(membresNonTires.size()));

        // Mettre à jour le membre tiré
        membreTire.setTire(true);
        membreRepository.save(membreTire);

        System.out.println("Membre tiré : " + membreTire.getPrenom());


    }


    public List<Membre> getMembresTires(Long tontineId) {
        return membreRepository.findByTontineIdAndTireTrue(tontineId);
    }

    public int getNombreMembresRestants(Long tontineId) {
        List<Membre> membresNonTires = membreRepository.findByTontineIdAndTireFalse(tontineId);
        return membresNonTires.size();
    }



    }








