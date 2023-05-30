package sn.ssi.etontine.service;

import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.WhatsAppMessage;
import sn.ssi.etontine.repository.WhatsAppMessageRepository;

@Service
public class WhatsAppMessageService {
    private final WhatsAppMessageRepository messageRepository;
    private final WhatsAppClient whatsappClient;

    public WhatsAppMessageService(WhatsAppMessageRepository messageRepository, WhatsAppClient whatsappClient) {
        this.messageRepository = messageRepository;
        this.whatsappClient = whatsappClient;
    }

    public void envoyerNotificationWhatsApp(String phoneNumber, String message) {
        WhatsAppMessage whatsappMessage = new WhatsAppMessage(phoneNumber, message);
        messageRepository.save(whatsappMessage);

        whatsappClient.envoyerMessageWhatsApp(phoneNumber, message);
    }
}

