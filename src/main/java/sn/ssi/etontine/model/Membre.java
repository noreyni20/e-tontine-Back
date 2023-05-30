package sn.ssi.etontine.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Membre {
    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

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

    @Column(name = "mode_paiement")
    private String modePaiement;

    public Boolean getTire() {
        return tire;
    }

    public void setTire(Boolean tire) {
        this.tire = tire;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    public boolean isTire() {
        return tire != null ? tire : false;
    }

    public void setTire(boolean tire) {
        this.tire = tire;
    }

    @OneToMany(mappedBy = "membre")
    private List<Versement> historiqueVersements;

    public List<Versement> getHistoriqueVersements() {
        return historiqueVersements;
    }

    public void setHistoriqueVersements(List<Versement> historiqueVersements) {
        this.historiqueVersements = historiqueVersements;
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



    public List<Versement> getVersements() {
        return versements;
    }

    public void setVersements(List<Versement> versements) {
        this.versements = versements;
    }

    private String telephone;
    @ManyToOne
    @JoinColumn(name = "tontine_id")
    @JsonIgnoreProperties("membres")
    private Tontine tontine;




    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "Membre_versement")
    private List<Versement> versements;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable (name = "Membre_tirage")
    private Tirage tirage;

    @OneToMany
    @JoinTable (name = "compte_id")
    @JsonIgnoreProperties("membres")
    private List<Compte> comptes;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'UTILISATEUR_STANDARD'")
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "Membre_notification")
    private List<Notification> notifications;


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

    @Override
    public String toString() {
        return "Membre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }


}
