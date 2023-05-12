package sn.ssi.etontine.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum ModeVersement {

    @JsonProperty("Wave")
    WAVE,

    @JsonProperty("Orange Money")
    ORANGE_MONEY,

    @JsonProperty("Kpay")
    KPAY
}
