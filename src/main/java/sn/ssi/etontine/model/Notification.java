package sn.ssi.etontine.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;

    private Date dateEnvoi;
    private  String destinationSMSNumber;

    public String getDestinationSMSNumber() {
        return destinationSMSNumber;
    }

    public void setDestinationSMSNumber(String destinationSMSNumber) {
        this.destinationSMSNumber = destinationSMSNumber;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable (name = "Notification_membre")

    private List<Membre> membres;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }
}
