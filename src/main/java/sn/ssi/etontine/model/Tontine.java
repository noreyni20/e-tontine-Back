package sn.ssi.etontine.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity


public class Tontine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String libelle;
    private LocalDate dateCreation = LocalDate.now();

    private Double montantVersement;


    private Double montantAmende;

    private Date dateEcheance;
    private Boolean status;
    private Integer frequence;
    private BigDecimal montantAuTirage;

    private Integer nombreParticipant;



    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getMontantVersement() {
        return montantVersement;
    }

    public void setMontantVersement(Double montantVersement) {
        this.montantVersement = montantVersement;
    }

    public Double getMontantAmende() {
        return montantAmende != null ? montantAmende : 0.0;
    }

    public void setMontantAmende(Double montantAmende) {
        this.montantAmende = montantAmende;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    @JsonIgnoreProperties("tontine")
    @OneToMany(mappedBy = "tontine")

    private List<Membre> membres;

    private Integer tontineId;

    private BigDecimal comptePrincipal;

    private LocalDate dateVersementPrevu;


    public void ajouterVersement(Versement versement) {
        // Add logic to process and store the versement
        // You can access the Tontine's main account and update it with the versement amount
        // You can also perform any necessary checks or calculations related to amende and payment mode
        // Ensure the versement is recorded appropriately in the Tontine's data structure or database
    }

    public LocalDate getDateVersementPrevu() {
        return dateVersementPrevu;
    }

    public void setDateVersementPrevu(LocalDate dateVersementPrevu) {
        this.dateVersementPrevu = dateVersementPrevu;
    }

    public BigDecimal getComptePrincipal() {
        return comptePrincipal;
    }

    public void setComptePrincipal(BigDecimal comptePrincipal) {
        this.comptePrincipal = comptePrincipal;
    }
    @JsonIgnoreProperties("tontine")
    @OneToMany(mappedBy = "tontine")

    private List<Versement> versements;


    public Integer getTontineId() {
        return tontineId;
    }

    public List<Versement> getVersements() {
        return versements;
    }

    public void setVersements(List<Versement> versements) {
        this.versements = versements;
    }

    public void setTontineId(Integer tontineId) {
        this.tontineId = tontineId;
    }



    public Integer getNombreParticipant() {
        return nombreParticipant;
    }

    public void setNombreParticipant(Integer nombreParticipant) {
        this.nombreParticipant = nombreParticipant;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }



    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }



    @OneToMany(mappedBy = "tontine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tirage> tirages = new ArrayList<>();

    public void addMembre(Membre membre) {
        membres.add(membre);


        membre.setTontine(this);


    }




    public List<Tirage> getTirages() {
        return tirages;
    }

    public void setTirages(List<Tirage> tirages) {
        this.tirages = tirages;
    }



    @OneToMany(mappedBy = "tontine", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tontine")
    private List<Compte> comptes = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }



    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getFrequence() {
        return frequence;
    }

    public void setFrequence(Integer frequence) {
        this.frequence = frequence;
    }

    public BigDecimal getMontant() {
        return montantAuTirage;
    }

    public void setMontant(BigDecimal montant) {
        this.montantAuTirage = montant;
    }


}
