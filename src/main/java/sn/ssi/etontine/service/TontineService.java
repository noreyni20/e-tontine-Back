package sn.ssi.etontine.service;

import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.*;
import sn.ssi.etontine.repository.CompteTontineRepository;
import sn.ssi.etontine.repository.MembreRepository;
import sn.ssi.etontine.repository.TontineRepository;
import sn.ssi.etontine.repository.VersementRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


@Service
public class TontineService {
    private final TontineRepository tontineRepository;
    private final MembreRepository membreRepository;

    private final PaymentService paymentService;

    private final CompteTontineRepository compteTontineRepository;
    private final VersementRepository versementRepository;

    public TontineService(TontineRepository tontineRepository, MembreRepository membreRepository, PaymentService paymentService, CompteTontineRepository compteTontineRepository,
    VersementRepository versementRepository) {
        this.tontineRepository = tontineRepository;
        this.membreRepository = membreRepository;

        this.paymentService = paymentService;
        this.compteTontineRepository=compteTontineRepository;
        this.versementRepository=versementRepository;


    }

    public boolean doesTontineExist(Long tontineId) {
        return tontineRepository.existsById(tontineId);
    }

    public boolean doesMembreExist(Long membreId) {
        return membreRepository.existsById(membreId);
    }

    public Tontine createTontine(Tontine tontine, double montantVersement, double montantAmende, int frequence) {
        tontine.setMontantVersement(montantVersement);
        tontine.setMontantAmende(montantAmende);
        tontine.setFrequence(frequence);

        return tontineRepository.save(tontine);
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

    public List<Tontine> getAllTontines() {
        return tontineRepository.findAll();
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


        Random random = new Random();
        Membre membreTire = membresNonTires.get(random.nextInt(membresNonTires.size()));

        // Mettre à jour le membre tiré
        membreTire.setTire(true);
        membreRepository.save(membreTire);

        System.out.println("Membre tiré : " + membreTire.getPrenom() + " "+membreTire.getNom());


    }


    public List<Membre> getMembresTires(Long tontineId) {
        return membreRepository.findByTontineIdAndTireTrue(tontineId);
    }

    public List<Membre> getMembresRestants(Long tontineId) {
        return membreRepository.findByTontineIdAndTireFalse(tontineId);

    }








    }








