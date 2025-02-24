package tn.esprit.gestionfoyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.gestionfoyer.entities.Chambre;
import tn.esprit.gestionfoyer.entities.TypeChambre;
import tn.esprit.gestionfoyer.repository.ChambreRepository;


@SpringBootApplication
public class GestionFoyerApplication implements CommandLineRunner {

    @Autowired
    private ChambreRepository chambreRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionFoyerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
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
