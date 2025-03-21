package tn.esprit.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Etudiant;
import tn.esprit.gestionfoyer.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {

    IEtudiantService etudiantService;

    // Add a new Etudiant
    @PostMapping("/saveetudiant")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
        System.out.println("Received Etudiant: " + etudiant.toString());
        return etudiantService.addEtudiant(etudiant);
    }

    // Get all Etudiants
    @GetMapping("/alletudiants")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.findAll();
    }

    // Get a specific Etudiant by ID
    @GetMapping("/{idEtudiant}")
    public Etudiant getEtudiantById(@PathVariable long idEtudiant) {
        return etudiantService.findById(idEtudiant);
    }

    // Update an existing Etudiant
    @PutMapping("/updateetudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    // Delete an Etudiant by ID
    @DeleteMapping("/removeetudiant/{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant) {
        etudiantService.removeEtudiant(idEtudiant);
    }
}
