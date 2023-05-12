package sn.ssi.etontine.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Tontine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)

    private Long id;
    private String libelle;
    private Date dateCreation;
    private Boolean status;
    private String frequence;
    private BigDecimal montant;
    private Date datePayement;
    private Date dateCloture;
    private Integer nombreParticipant;

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

    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "Tontine_membre")
    private List<Membre> membres;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "Tontine_versement")
    private List<Versement> versements;

    public List<Tirage> getTirages() {
        return tirages;
    }

    public void setTirages(List<Tirage> tirages) {
        this.tirages = tirages;
    }

    @OneToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "Tontine_tirage")
    private List<Tirage> tirages;


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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
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
