package Giulio_Marra.entities;


import Giulio_Marra.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue

    private UUID id;

    @Column(name = "titolo")
    private String titoloEventp;
    @Column(name = "data_evento")
    private LocalDate dataEevento;
    @Column(name = "descrizione")
    private String descrizioneEvento;
    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoevento;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Evento() {

    }

    public Evento(String titoloEventp, LocalDate dataEevento, String descrizioneEvento, TipoEvento tipoevento) {
        this.titoloEventp = titoloEventp;
        this.dataEevento = dataEevento;
        this.descrizioneEvento = descrizioneEvento;
        this.tipoevento = tipoevento;
    }

    public UUID getId() {
        return id;
    }

    public String getTitoloEventp() {
        return titoloEventp;
    }

    public void setTitoloEventp(String titoloEventp) {
        this.titoloEventp = titoloEventp;
    }

    public LocalDate getDataEevento() {
        return dataEevento;
    }

    public void setDataEevento(LocalDate dataEevento) {
        this.dataEevento = dataEevento;
    }

    public String getDescrizioneEvento() {
        return descrizioneEvento;
    }

    public void setDescrizioneEvento(String descrizioneEvento) {
        this.descrizioneEvento = descrizioneEvento;
    }

    public TipoEvento getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento(TipoEvento tipoevento) {
        this.tipoevento = tipoevento;
    }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titoloEventp='" + titoloEventp + '\'' +
                ", dataEevento=" + dataEevento +
                ", descrizioneEvento='" + descrizioneEvento + '\'' +
                ", tipoevento=" + tipoevento +
                ", partecipazioni=" + partecipazioni +
                ", location=" + location +
                '}';
    }
}
