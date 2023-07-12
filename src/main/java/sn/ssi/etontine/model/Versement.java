package sn.ssi.etontine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Versement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "membre_id")

    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "tontine_id")

    private Tontine tontine;

    @Column(name = "montant")
    private double montant;

    private Double montantAmende;

    @Column(name = "date_versement")
    private LocalDate dateVersement = LocalDate.now();

    @Column(name = "mode_paiement")
    private String modeVersement;



    public enum ModeVersement {

        WAVE,
        ORANGE_MONEY,
        ESPÈCES,
        FREE_MONEY
    }

    public double getMontantAmende() {
        return montantAmende;
    }

    public void setMontantAmende(double montantAmende) {
        this.montantAmende = montantAmende;
    }

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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(LocalDate dateVersement) {
        this.dateVersement = dateVersement;
    }

    public String getModeVersement() {
        return modeVersement;
    }

    public void setModeVersement(String modeVersement) {
        this.modeVersement = modeVersement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }







    // Autres relations et annotations

    // Getters et setters
}
