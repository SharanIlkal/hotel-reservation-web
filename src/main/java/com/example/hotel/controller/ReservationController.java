package com.example.hotel.controller;

import com.example.hotel.model.Reservation;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class ReservationController {
    private final ReservationRepository repo;

    public ReservationController(ReservationRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String listReservations(Model model) {
        model.addAttribute("reservations", repo.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "form";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        repo.save(reservation);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editReservation(@PathVariable Integer id, Model model) {
        Optional<Reservation> r = repo.findById(id);
        if (r.isPresent()) {
            model.addAttribute("reservation", r.get());
            return "form";
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/room/{id}")
    @ResponseBody
    public String getRoomNumber(@PathVariable Integer id) {
        return repo.findById(id)
                .map(res -> "Room number for Reservation Id " + id + " is: " + res.getRoomNumber())
                .orElse("Reservation not found");
    }
}
