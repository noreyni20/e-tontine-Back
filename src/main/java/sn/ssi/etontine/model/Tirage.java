package sn.ssi.etontine.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Date dateTirage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable (name = "tirage_membre")
    private Membre membre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable (name = "tirage_tontine")
    private Tontine tontine;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTirage() {
        return dateTirage;
    }

    public void setDateTirage(Date dateTirage) {
        this.dateTirage = dateTirage;
    }
}
