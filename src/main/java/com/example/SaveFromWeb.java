package com.example;
import com.example.bazaDanych.Ksiazka;
import com.example.bazaDanych.KsiazkiRepo;
import com.example.bazaDanych.Studenci;
import com.example.bazaDanych.StudenciRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class SaveFromWeb {
    private KsiazkiRepo ksiazkiRepo;
    private StudenciRepo studenciRepo;
    @Autowired
    public SaveFromWeb(KsiazkiRepo ksiazkiRepo, StudenciRepo studenciRepo){
        this.ksiazkiRepo = ksiazkiRepo;
        this.studenciRepo = studenciRepo;
    }
    @RequestMapping("/save")
    public String dodajemyDane(@RequestParam("imie") String imie, @RequestParam("nazwisko") String nazwisko)
            throws Exception
    {
        Studenci studenci = new Studenci(imie, nazwisko);

        studenciRepo.save(studenci);


        return "studenci: "+studenci;
    }
}
