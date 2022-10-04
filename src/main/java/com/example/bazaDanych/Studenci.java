package com.example.bazaDanych;

import javax.persistence.*;

@Entity
@Table(name="Studenci")
public class Studenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStudenta;
    private String imie;
    private String nazwisko;

    @OneToOne
    private Ksiazka ksiazka;

    public Studenci(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Studenci(){
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void setKsiazka(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }



}