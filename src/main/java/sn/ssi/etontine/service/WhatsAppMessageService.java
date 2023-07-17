package sn.ssi.etontine.service;

import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.WhatsAppMessage;
import sn.ssi.etontine.repository.WhatsAppMessageRepository;

@Service
public class WhatsAppMessageService {
    private final WhatsAppMessageRepository whatsAppMessageRepository ;
    private final WhatsAppClient whatsappClient;

    public WhatsAppMessageService(WhatsAppMessageRepository whatsAppMessageRepository, WhatsAppClient whatsappClient) {
        this.whatsAppMessageRepository = whatsAppMessageRepository;
        this.whatsappClient = whatsappClient;
    }

    public void envoyerNotificationWhatsApp(String phoneNumber, String message) {
        WhatsAppMessage whatsappMessage = new WhatsAppMessage();
        whatsAppMessageRepository.save(whatsappMessage);

        whatsappClient.envoyerMessageWhatsApp(phoneNumber, message);
    }
}

