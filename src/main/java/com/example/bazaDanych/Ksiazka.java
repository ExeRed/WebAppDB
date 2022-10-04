package com.example.bazaDanych;

import javax.persistence.*;

@Entity
@Table(name="Ksiazki")
public class Ksiazka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imieAutora;
    private String nazwiskoAutora;
    @Column(name="nazwa", nullable=false)
    private String nazwa;
    private String gatunek;

    @ManyToOne
    private Gatunek1 gatunek1;

    public Ksiazka(String imieAutora, String nazwiskoAutora, String nazwa, String gatunek, boolean nowy) {
        this.imieAutora = imieAutora;
        this.nazwiskoAutora = nazwiskoAutora;
        this.nazwa = nazwa;
        this.gatunek = gatunek;
        this.nowy = nowy;
    }

    public Ksiazka(Integer id, String imieAutora, String nazwiskoAutora, String nazwa, String gatunek, boolean nowy) {
        this.id = id;
        this.imieAutora = imieAutora;
        this.nazwiskoAutora = nazwiskoAutora;
        this.nazwa = nazwa;
        this.gatunek = gatunek;
        this.nowy = nowy;
    }

    public Ksiazka(){
    }

    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", imieAutora='" + imieAutora + '\'' +
                ", nazwiskoAutora='" + nazwiskoAutora + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", nowy=" + nowy +
                '}';
    }

    @Transient
    boolean  nowy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImieAutora() {
        return imieAutora;
    }

    public void setImieAutora(String imieAutora) {
        this.imieAutora = imieAutora;
    }

    public String getNazwiskoAutora() {
        return nazwiskoAutora;
    }

    public void setNazwiskoAutora(String nazwiskoAutora) {
        this.nazwiskoAutora = nazwiskoAutora;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }
}


