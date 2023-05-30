package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import sn.ssi.etontine.model.Compte;
import sn.ssi.etontine.model.Versement;

import java.util.List;

@Repository
public interface VersementRepository extends JpaRepository<Versement,Long> {
    List<Versement> findByMembreId(Long membreId);
}
