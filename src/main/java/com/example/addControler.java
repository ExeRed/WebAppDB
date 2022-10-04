package com.example;

import com.example.bazaDanych.GatRepo;
import com.example.bazaDanych.Gatunek1;
import com.example.bazaDanych.Ksiazka;
import com.example.bazaDanych.KsiazkiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class addControler {
    private KsiazkiRepo ksiazkiRepo;
    @Autowired
    public addControler(KsiazkiRepo ksiazkiRepo) {
        this.ksiazkiRepo = ksiazkiRepo;
    }

    @Autowired
    public GatRepo gatRepo;

    @RequestMapping("/gat")
    @ResponseBody
    public String projectsAndTasks() {
        StringBuilder response = new StringBuilder();

        for(Gatunek1 gatunek1: gatRepo.findAll()) {
            response.append(gatunek1).append("<br>");
            for(Ksiazka ksiazka: gatunek1.getKsiazka()) {      // 1
                response.append("- ").append(ksiazka).append("<br>");
            }
        }

        return response.toString();
    }

    @RequestMapping("dodajkz")
    public String dodajkz1(){
        return "dodawanie";
    }
    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("imieAutora") String imieAutora,
            @RequestParam("nazwiskoAutora") String nazwiskoAutora,
            @RequestParam("nazwa") String nazwa,
            @RequestParam("gatunek") String gatunek,
            Model model)
            throws Exception {
        Ksiazka ksiazka = new Ksiazka(imieAutora, nazwiskoAutora, nazwa, gatunek, true);
        System.out.println(ksiazka);
        ksiazkiRepo.save(ksiazka); // ZAPIS DO BAZY !!!!
        model.addAttribute("ksiazka", ksiazka);
        return "Widok";
    }

    @RequestMapping("/pokaz")
    public String pokaz( Model model){
        model.addAttribute("ksiazka", ksiazkiRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        ksiazkiRepo.deleteById(id);
        model.addAttribute("ksiazka", ksiazkiRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("Nazwa") String Nazwa, Model model){
        model.addAttribute("ksiazka", ksiazkiRepo.findAllByNazwa(Nazwa));
        return "pokaz";
    }

    @RequestMapping("/przekieruj")
    public String przekieruj(
            @RequestParam("id") Integer id, Model model)
            throws Exception {
        System.out.println(ksiazkiRepo.findById(id));
        model.addAttribute("ksiazka", ksiazkiRepo.findById(id));
        return "aktualizuj";
    }

    @RequestMapping("/aktualizuj")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("imieAutora") String imieAutora,
            @RequestParam("nazwiskoAutora") String nazwiskoAutora,
            @RequestParam("nazwa") String nazwa,
            @RequestParam("gatunek") String gatunek, Model model)
            throws Exception {
        Ksiazka ksiazka = new Ksiazka(id, imieAutora, nazwiskoAutora, nazwa, gatunek, true);
        System.out.println(ksiazka);
        ksiazkiRepo.save(ksiazka); // ZAPIS DO BAZY !!!!
        model.addAttribute("ksiazka", ksiazka);
        return "pokaz";
    }

}