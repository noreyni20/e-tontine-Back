package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ssi.etontine.model.Compte;
import sn.ssi.etontine.model.CompteTontine;

public interface CompteTontineRepository extends JpaRepository<CompteTontine,Long> {


}
