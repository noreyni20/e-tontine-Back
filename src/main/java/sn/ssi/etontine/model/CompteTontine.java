package sn.ssi.etontine.model;

import jakarta.persistence.*;

@Entity
public class CompteTontine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double solde;

    @OneToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
// Constructeurs, getters et setters
}

