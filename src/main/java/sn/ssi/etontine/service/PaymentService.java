package sn.ssi.etontine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.ssi.etontine.model.PaymentConfig;

@Service
public class PaymentService {
    private final PaymentConfig paymentConfig;

    @Autowired
    public PaymentService(PaymentConfig paymentConfig) {
        this.paymentConfig = paymentConfig;
    }

    public void effectuerPaiementWave(double montant) {
        String apiKey = paymentConfig.getWaveApiKey();
        // Code pour effectuer le paiement via Wave
    }

    public void effectuerPaiementOrangeMoney(double montant) {
        String apiKey = paymentConfig.getOrangeMoneyApiKey();
        // Code pour effectuer le paiement via Orange Money
    }

    public void effectuerPaiementFreeMoney(double montant) {
        String apiKey = paymentConfig.getFreeMoneyApiKey();
        // Code pour effectuer le paiement via Free Money
    }

    public void effectuerPaiementEspece(double montant) {
        // Code pour effectuer le paiement en espèces
    }
}

