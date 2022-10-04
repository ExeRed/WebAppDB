package com.example.bazaDanych;
import javax.persistence.*;
import java.util.List;

@Entity
public class Gatunek1 {
    @GeneratedValue
    @Id
    private int id;

    @Column
    private String gatunek1;

    @OneToMany(mappedBy = "gatunek1")
    private List<Ksiazka> ksiazka;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGatunek1() {
        return gatunek1;
    }

    public void setGatunek1(String gatunek1) {
        this.gatunek1 = gatunek1;
    }

    @Override
    public String toString() {
        return "gatunek1{" +
                "id=" + id +
                ", gatunek1='" + gatunek1 + '\'' +
                '}';
    }

    public List<Ksiazka> getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka[] ksiazka) {
        this.ksiazka = List.of(ksiazka);
    }
}

