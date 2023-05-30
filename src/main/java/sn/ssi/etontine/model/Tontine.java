package sn.ssi.etontine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tontine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)



    private Long id;
    private String libelle;
    private LocalDateTime dateCreation;
    private Boolean status;
    private String frequence;
    private BigDecimal montant;
    private Date datePayement;
    private Date dateCloture;
    private Integer nombreParticipant;

    private Integer tontineId;

    public Integer getTontineId() {
        return tontineId;
    }

    public void setTontineId(Integer tontineId) {
        this.tontineId = tontineId;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
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

    public List<Versement> getVersements() {
        return versements;
    }

    public void setVersements(List<Versement> versements) {
        this.versements = versements;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @OneToMany(mappedBy = "tontine", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tontine")
    private List<Membre> membres = new ArrayList<>();

    @OneToMany(mappedBy = "tontine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tirage> tirages = new ArrayList<>();

    public void addMembre(Membre membre) {
        membres.add(membre);


        membre.setTontine(this);


    }


    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "Tontine_versement")
    private List<Versement> versements;

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

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Tontine{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", dateCreation=" + dateCreation +
                ", status=" + status +
                ", frequence='" + frequence + '\'' +
                ", montant=" + montant +
                '}';
    }
}
