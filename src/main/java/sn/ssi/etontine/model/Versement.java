package sn.ssi.etontine.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Versement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal montant;
    private String motif;
    private Date dateVersement;

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Tontine getTontine() {
        return tontine;
    }

    public void setTontine(Tontine tontine) {
        this.tontine = tontine;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable (name = "versement_membre")
    private Membre membre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable (name = "versement_tontine")
    private Tontine tontine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable (name = "versement_compte")
    private Compte compte;

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Enumerated(EnumType.STRING)
    private ModeVersement modeVersement;

    public ModeVersement getModeVersement() {
        return modeVersement;
    }

    public void setModeVersement(ModeVersement modeVersement) {
        this.modeVersement = modeVersement;
    }

    public Versement (){

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(Date dateVersement) {
        this.dateVersement = dateVersement;
    }

    @Override
    public String toString() {
        return "Versement{" +
                "id=" + id +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", dateVersement=" + dateVersement +
                '}';
    }
}

