package tn.esprit.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Universite;
import tn.esprit.gestionfoyer.services.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
@AllArgsConstructor
public class UniversiteController {

    IUniversiteService universiteService;

    // Add a new Universite
    @PostMapping("/saveuniversite")
    public Universite saveUniversite(@RequestBody Universite universite) {
        System.out.println("Received Universite: " + universite);
        return universiteService.addUniversite(universite);
    }

    // Get all Universites
    @GetMapping("/alluniversites")
    public List<Universite> getAllUniversites() {
        return universiteService.findAll();
    }

    // Get a specific Universite by ID
    @GetMapping("/{idUniversite}")
    public Universite getUniversiteById(@PathVariable long idUniversite) {
        return universiteService.findById(idUniversite);
    }

    // Update an existing Universite
    @PutMapping("/updateuniversite")
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    // Delete a Universite by ID
    @DeleteMapping("/removeuniversite/{idUniversite}")
    public void removeUniversite(@PathVariable long idUniversite) {
        universiteService.removeUniversite(idUniversite);
    }

    // Endpoint to affect a Foyer to a Universite
    @PostMapping("/affecterfoyer/{foyerId}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long foyerId, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(foyerId, nomUniversite);
    }

    // Endpoint to desaffect a Foyer from a Universite
    @PostMapping("/desaffecterfoyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }

}
