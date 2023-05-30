package sn.ssi.etontine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sn.ssi.etontine.model.WhatsAppMessage;
import sn.ssi.etontine.service.WhatsAppMessageService;

@RestController
public class WhatsAppMessageController {
    private final WhatsAppMessageService messageService;

    public WhatsAppMessageController(WhatsAppMessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/envoyer-message-whatsapp")
    public ResponseEntity<String> envoyerMessageWhatsApp(@RequestBody WhatsAppMessage whatsappMessage) {
        messageService.envoyerNotificationWhatsApp(whatsappMessage.getPhoneNumber(), whatsappMessage.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

