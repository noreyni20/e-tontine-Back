package sn.ssi.etontine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private LocalDateTime dateCreation;
    private BigDecimal solde;
    private Boolean etat;

    private  Integer compteId;

    private BigDecimal montantPrincipal;



    public BigDecimal getMontantPrincipal() {
        return montantPrincipal;
    }

    public void setMontantPrincipal(BigDecimal montantPrincipal) {
        this.montantPrincipal = montantPrincipal;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "membre_id")
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "Compte_tontine")
    private Tontine tontine;




    public Integer getCompteId() {
        return compteId;
    }

    public void setCompteId(Integer compteId) {
        this.compteId = compteId;
    }

    public Tontine getTontine() {
        return tontine;
    }

    public void setTontine(Tontine tontine) {
        this.tontine = tontine;
    }





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

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }
}
