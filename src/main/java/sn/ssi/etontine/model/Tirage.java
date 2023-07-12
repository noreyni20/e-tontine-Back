package sn.ssi.etontine.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Tirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate dateTirage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable (name = "Tirage_membre")
    private Membre membre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable (name = "Tirage_tontine")
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

    public LocalDate getDateTirage() {
        return dateTirage;
    }

    public void setDateTirage(LocalDate dateTirage) {
        this.dateTirage = dateTirage;
    }
}
