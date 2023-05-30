package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.ssi.etontine.model.Membre;

import java.util.List;


@Repository
public interface MembreRepository extends JpaRepository<Membre,Long> {

    List<Membre> findByTontineId(Long tontineId);
    List<Membre> findByTontineIdAndTireFalse(Long tontineId);
    List<Membre> findByTontineIdAndTireTrue(Long tontineId);




}
