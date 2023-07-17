package sn.ssi.etontine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.ssi.etontine.model.WhatsAppMessage;

@Repository
public interface WhatsAppMessageRepository extends JpaRepository<WhatsAppMessage, Long> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}

