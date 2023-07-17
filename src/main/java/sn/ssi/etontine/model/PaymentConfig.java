package sn.ssi.etontine.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "payment")
public class PaymentConfig {
    private String waveApiKey;
    private String orangeMoneyApiKey;
    private String freeMoneyApiKey;

    public String getWaveApiKey() {
        return waveApiKey;
    }

    public void setWaveApiKey(String waveApiKey) {
        this.waveApiKey = waveApiKey;
    }

    public String getOrangeMoneyApiKey() {
        return orangeMoneyApiKey;
    }

    public void setOrangeMoneyApiKey(String orangeMoneyApiKey) {
        this.orangeMoneyApiKey = orangeMoneyApiKey;
    }

    public String getFreeMoneyApiKey() {
        return freeMoneyApiKey;
    }

    public void setFreeMoneyApiKey(String freeMoneyApiKey) {
        this.freeMoneyApiKey = freeMoneyApiKey;
    }
// Getters and Setters
}

