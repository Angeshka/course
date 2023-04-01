package com.kursach.controller;

import com.kursach.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Controller
public class TripAEDCont extends Global {
    @GetMapping("/trip/add")
    public String gettripAdd(Model model) {
        AddAttributes(model);
        return "/tripAdd";
    }

    @GetMapping("trip/{id}/delete")
    public String tripDelete(@PathVariable Long id) {
        Trip trip = repoTrip.getById(id);
        repoTrip.delete(trip);
        repoPribl.delete(repoPribl.findByIdTrip(id));
        repoZatraty.delete(repoZatraty.findByIdTrip(id));
        repoDohod.delete(repoDohod.findByIdTrip(id));
        return "redirect:/catalog-page";
    }

    @PostMapping("/trip/add")
    public String tripAdd(Model model, @RequestParam String name, @RequestParam String passport, @RequestParam String tickets, @RequestParam String insurance, @RequestParam String country, @RequestParam String quantity, @RequestParam String price, @RequestParam MultipartFile poster, @RequestParam String one_client, @RequestParam String duration, @RequestParam String transport, @RequestParam String hotel, @RequestParam String escort, @RequestParam String wage_escort) {
        Trip trip = new Trip(country, price, quantity, name);

        if (poster != null && !Objects.requireNonNull(poster.getOriginalFilename()).isEmpty()) {
            String uuidFile = UUID.randomUUID().toString();
            boolean createDir = true;
            String res = "";
            try {
                File uploadDir = new File(uploadImg);
                if (!uploadDir.exists()) createDir = uploadDir.mkdir();
                if (createDir) {
                    res = "posters/" + uuidFile + "_" + poster.getOriginalFilename();
                    poster.transferTo(new File(uploadImg + "/" + res));
                }
            } catch (IOException e) {
                model.addAttribute("message", "Слишком большой размер аватарки");
                AddAttributes(model);
                return "tripAdd";
            }
            trip.setPoster(res);
        }

        trip = repoTrip.saveAndFlush(trip);

        Dohod dohod = new Dohod(price, quantity);
        dohod.setIdTrip(trip.getId());
        repoDohod.save(dohod);

        Docs docs = new Docs(passport, tickets, insurance);
        docs.setIdTrip(trip.getId());
        repoDocs.save(docs);

        Zatraty zatraty = new Zatraty(one_client, duration, transport, hotel, escort, wage_escort);
        zatraty.setIdTrip(trip.getId());
        repoZatraty.save(zatraty);

        int a = (Integer.parseInt(price) - Integer.parseInt(one_client) - Integer.parseInt(wage_escort)) * Integer.parseInt(quantity);
        a *= 0.87;
        Pribl pribl = new Pribl(String.valueOf(a), one_client, wage_escort);
        pribl.setIdTrip(trip.getId());
        repoPribl.save(pribl);

        return "redirect:/catalog-page";
    }

    @GetMapping("/trip/{id}/edit")
    public String tripEdit(Model model, @PathVariable Long id) {
        AddAttributes(model);
        model.addAttribute("trip", repoTrip.getById(id));
        model.addAttribute("dohod", repoDohod.findByIdTrip(id));
        model.addAttribute("docs", repoDocs.findByIdTrip(id));
        model.addAttribute("zatraty", repoZatraty.findByIdTrip(id));
        model.addAttribute("pribl", repoPribl.findByIdTrip(id));
        return "tripEdit";
    }

    @PostMapping("/trip/{id}/edit")
    public String tripEdit(Model model, @PathVariable Long id, @RequestParam String name, @RequestParam String passport, @RequestParam String tickets, @RequestParam String insurance, @RequestParam String country, @RequestParam String quantity, @RequestParam String price, @RequestParam MultipartFile poster, @RequestParam String one_client, @RequestParam String duration, @RequestParam String transport, @RequestParam String hotel, @RequestParam String escort, @RequestParam String wage_escort) {
        Trip trip = repoTrip.getById(id);
        trip.setCountry(country);
        trip.setPrice(price);
        trip.setQuantity(quantity);
        trip.setName(name);

        if (poster != null && !Objects.requireNonNull(poster.getOriginalFilename()).isEmpty()) {
            String uuidFile = UUID.randomUUID().toString();
            boolean createDir = true;
            String res = "";
            try {
                File uploadDir = new File(uploadImg);
                if (!uploadDir.exists()) createDir = uploadDir.mkdir();
                if (createDir) {
                    res = "posters/" + uuidFile + "_" + poster.getOriginalFilename();
                    poster.transferTo(new File(uploadImg + "/" + res));
                }
            } catch (IOException e) {
                model.addAttribute("message", "Слишком большой размер аватарки");
                AddAttributes(model);
                return "tripAdd";
            }
            trip.setPoster(res);
        }

        repoTrip.save(trip);

        Dohod dohod = repoDohod.findByIdTrip(trip.getId());
        dohod.setPrice(price);
        dohod.setQuantity(quantity);
        repoDohod.save(dohod);

        Docs docs = repoDocs.findByIdTrip(trip.getId());
        docs.setPassport(passport);
        docs.setTickets(tickets);
        docs.setInsurance(insurance);
        repoDocs.save(docs);

        Zatraty zatraty = repoZatraty.findByIdTrip(trip.getId());
        zatraty.setOne_client(one_client);
        zatraty.setDuration(duration);
        zatraty.setTransport(transport);
        zatraty.setHotel(hotel);
        zatraty.setEscort(escort);
        zatraty.setWage_escort(wage_escort);
        repoZatraty.save(zatraty);

        int a = (Integer.parseInt(price) - Integer.parseInt(one_client) - Integer.parseInt(wage_escort)) * Integer.parseInt(quantity);
        a *= 0.87;
        Pribl pribl = repoPribl.findByIdTrip(id);
        pribl.setDohod(String.valueOf(a));
        pribl.setOne_client(one_client);
        pribl.setWage_escort(wage_escort);
        repoPribl.save(pribl);

        return "redirect:/catalog-page";
    }
}
