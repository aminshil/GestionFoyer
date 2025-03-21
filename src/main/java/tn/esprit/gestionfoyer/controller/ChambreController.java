package tn.esprit.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.services.IChambreService;

import java.util.List;

@RestController
@RequestMapping("/chambre")
@AllArgsConstructor
public class ChambreController {

    IChambreService chambreService;

    // Save a new Chambre
    @PostMapping("/savechambre")
    public Chambre saveChambre(@RequestBody Chambre chambre) {
        System.out.println("Received Chambre: " + chambre);
        return chambreService.addChambre(chambre);
    }

    // Get all Chambres
    @GetMapping("/allchambres")
    public List<Chambre> getAllChambres() {
        return chambreService.findAll();
    }

    // Get a specific Chambre by ID
    @GetMapping("/{idChambre}")
    public Chambre getChambreById(@PathVariable long idChambre) {
        return chambreService.findById(idChambre);
    }

    // Update an existing Chambre
    @PutMapping("/updatechambre")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    // Delete a Chambre by ID
    @DeleteMapping("/removechambre/{idChambre}")
    public void removeChambre(@PathVariable long idChambre) {
        chambreService.removeChambre(idChambre);
    }
}
