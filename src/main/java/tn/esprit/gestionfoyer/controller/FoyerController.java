package tn.esprit.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.services.FoyerServiceImpl;
import tn.esprit.gestionfoyer.services.IFoyerServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foyer")
@AllArgsConstructor
public class FoyerController {

    IFoyerServices foyerServices;

    @PostMapping("/savefoyer")
    public Foyer saveFoyer(@RequestBody Foyer foyer) {
        System.out.println("Received Foyer: " + foyer);
        return foyerServices.addFoyer(foyer);
    }


    // Get all Foyers
    @GetMapping("/allfoyers")
    public List<Foyer> getAllFoyers() {
        return foyerServices.findALL();
    }

    // Get a specific Foyer by ID
    @GetMapping("/{idFoyer}")
    public Foyer getFoyerById(@PathVariable long idFoyer) {
        return foyerServices.findById(idFoyer);
    }

    // Update an existing Foyer
    @PutMapping("/updatefoyer")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerServices.updateFoyer(foyer);
    }

    // Delete a Foyer by ID
    @DeleteMapping("/removefoyer/{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) {
        foyerServices.removeFoyer(idFoyer);
    }

    // Add a Foyer and assign it to a Universite
    @PostMapping("/addFoyerToUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return foyerServices.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }


}
