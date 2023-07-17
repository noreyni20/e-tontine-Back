package sn.ssi.etontine.model;

public class InscriptionRequest {
    private String telephone;
    private String motDepasse;

    public InscriptionRequest() {
    }

    public InscriptionRequest(String telephone, String motDepasse) {
        this.telephone = telephone;
        this.motDepasse = motDepasse;
    }

    // Getters et setters


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDepasse() {
        return motDepasse;
    }

    public void setMotDepasse(String motDepasse) {
        this.motDepasse = motDepasse;
    }
}
