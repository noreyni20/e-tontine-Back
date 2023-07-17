package sn.ssi.etontine.model;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;



@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Membre  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String motDePasse;
    private String sexe;
    private String cni;
    private Integer membreId;
    private Boolean tire=false;
    private LocalDate dateVersement;

    @OneToOne(mappedBy = "membre")
    private CompteTontine compteTontine;

    public CompteTontine getCompteTontine() {
        return compteTontine;
    }

    public void setCompteTontine(CompteTontine compteTontine) {
        this.compteTontine = compteTontine;
    }

    public LocalDate getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(LocalDate dateVersement) {
        this.dateVersement = dateVersement;
    }
    public LocalDate getDateVersementPrevu() {
        return dateVersement;
    }

    public void setDateVersementPrevu(LocalDate dateVersementPrevu) {
        this.dateVersement = dateVersementPrevu;
    }

    @JsonIgnoreProperties("membre")
    @OneToMany(mappedBy = "membre")

    private List<Versement> versements;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tontine_id")

    private Tontine tontine;


    public List<Versement> getVersements() {
        return versements;
    }

    public void setVersements(List<Versement> versements) {
        this.versements = versements;
    }

    public Boolean getTire() {
        return tire;
    }

    public void setTire(Boolean tire) {
        this.tire = tire;
    }



    public boolean isTire() {
        return tire != null ? tire : false;
    }

    public void setTire(boolean tire) {
        this.tire = tire;
    }





    public Integer getMembreId() {
        return membreId;
    }

    public void setMembreId(Integer membreId) {
        this.membreId = membreId;
    }

    public Membre() {
        // Constructeur par défaut sans arguments

    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    private String telephone;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable (name = "Membre_tirage")
    private Tirage tirage;
    @JsonManagedReference
    @OneToMany(mappedBy = "membre")
    private List<Compte> comptes;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'UTILISATEUR_STANDARD'")
    private Role role;
    public Tontine getTontine() {
        return tontine;
    }

    public void setTontine(Tontine tontine) {
        this.tontine = tontine;
    }

    public Tirage getTirage() {
        return tirage;
    }

    public void setTirage(Tirage tirage) {
        this.tirage = tirage;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Membre (Long membreId){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }




}
