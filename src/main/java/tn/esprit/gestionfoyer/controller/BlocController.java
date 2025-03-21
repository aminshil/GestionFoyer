package tn.esprit.gestionfoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.entities.Bloc;
import tn.esprit.gestionfoyer.services.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
@AllArgsConstructor
public class BlocController {

   IBlocService blocService;

    // Save a new Bloc
    @PostMapping("/savebloc")
    public Bloc saveBloc(@RequestBody Bloc bloc) {
        System.out.println("Received Bloc: " + bloc);
        return blocService.addBloc(bloc);
    }

    // Get all Blocs
    @GetMapping("/allblocs")
    public List<Bloc> getAllBlocs() {
        return blocService.findAll();
    }

    // Get a specific Bloc by ID
    @GetMapping("/{idBloc}")
    public Bloc getBlocById(@PathVariable long idBloc) {
        return blocService.findById(idBloc);
    }

    // Update an existing Bloc
    @PutMapping("/updatebloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    // Delete a Bloc by ID
    @DeleteMapping("/removebloc/{idBloc}")
    public void removeBloc(@PathVariable long idBloc) {
        blocService.removeBloc(idBloc);
    }

    // Assign a Bloc to a Foyer
    @PostMapping("/assignbloc/{foyerId}")
    public Bloc assignBlocToFoyer(@RequestBody Bloc bloc, @PathVariable Long foyerId) {
        return blocService.assignBlocToFoyer(bloc, foyerId);
    }

    @PostMapping("/affecterChambres/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc) {
        return blocService.affecterChambresABloc(numChambre, idBloc);
    }

}
