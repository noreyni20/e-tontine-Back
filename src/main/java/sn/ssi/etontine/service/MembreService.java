package sn.ssi.etontine.service;


import org.springframework.stereotype.Service;
import sn.ssi.etontine.repository.MembreRepository;


@Service
public class MembreService {
    private final MembreRepository membreRepository;

    public MembreService(MembreRepository membreRepository) {

        this.membreRepository = membreRepository;
    }

    // Méthodes pour gérer les membres (création, récupération, etc.)

}

