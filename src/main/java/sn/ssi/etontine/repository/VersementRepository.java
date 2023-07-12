package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ssi.etontine.model.Membre;
import sn.ssi.etontine.model.Tontine;
import sn.ssi.etontine.model.Versement;

import java.util.List;

public interface VersementRepository extends JpaRepository<Versement,Long> {

    List<Versement> findByMembreAndTontine(Membre membre, Tontine tontine);

    List<Versement> findByMembreIdAndTontineId(Long membreId, Long tontineId);

}
