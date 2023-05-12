package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ssi.etontine.model.Membre;

@Repository
public interface VersementRepository extends JpaRepository<Membre,Long> {

}
