package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ssi.etontine.model.Tontine;

@Repository
public interface TontineRepository extends JpaRepository<Tontine,Long> {



}
