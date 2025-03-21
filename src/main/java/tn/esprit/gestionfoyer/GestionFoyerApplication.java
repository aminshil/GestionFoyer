package tn.esprit.gestionfoyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.gestionfoyer.entities.Foyer;
import tn.esprit.gestionfoyer.repository.IChambreRepository;
import tn.esprit.gestionfoyer.repository.IFoyerRepository;


@SpringBootApplication
public class GestionFoyerApplication {
public static void main(String[] args) { SpringApplication.run(GestionFoyerApplication.class, args); }
}
//    @Override
//    public void run(String... args) throws Exception {
//        // Creating a test Foyer object
//        Foyer foyer = new Foyer();
//        foyer.setNomFoyer("Foyer A");
//        foyer.setCapaciteFoyer(100);
//
//        // Save the foyer to the repository
//        foyerRepository.save(foyer);
//
//        // Fetch and print all foyers to verify insertion
//        System.out.println("Foyers in Database: " + foyerRepository.findAll());
//    }
//}
//    @Override
//    public void run(String... args) throws Exception {
//        // Insert test data
//        Chambre chambre = new Chambre();
//        chambre.setNumero(String.valueOf(666));
//        chambre.setType(TypeChambre.DOUBLE);
//
//        chambreRepository.save(chambre);
//
//        // Print all chambres to verify insertion
//        System.out.println("Chambres in Database: " + chambreRepository.findAll());
//    }
//}


//public class GestionFoyerApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(GestionFoyerApplication.class, args);
//    }
//
//}
