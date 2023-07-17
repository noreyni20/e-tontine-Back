package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.ssi.etontine.model.Compte;


@Repository
public interface CompteRepository extends JpaRepository<Compte,Long> {

    Compte findByMembreId(@Param("membreId") Long membreId);





}
