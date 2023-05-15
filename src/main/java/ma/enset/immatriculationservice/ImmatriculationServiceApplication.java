package ma.enset.immatriculationservice;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.entities.Vehicule;
import ma.enset.immatriculationservice.repositories.ProprietaireRepository;
import ma.enset.immatriculationservice.repositories.VehiculeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class ImmatriculationServiceApplication implements CommandLineRunner {

    ProprietaireRepository proprietaireRepository;
    VehiculeRepository vehiculeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ImmatriculationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i=0; i<10; i++){
            Proprietaire proprietaire = Proprietaire.builder()
                    .nom(UUID.randomUUID().toString())
                    .date_naissance(new Date())
                    .email("email"+(i+1)+ "@gmail.com")
                    .build();

            Vehicule vehicule = Vehicule.builder()
                    .numero_immatrication(UUID.randomUUID().toString())
                    .puissance_fiscale(Math.random()*2000)
                    .model("M"+Math.random()*10)
                    .marque("FER"+Math.random()*10)
                    .build();

            proprietaireRepository.save(proprietaire);
            vehiculeRepository.save(vehicule);
        }
    }
}
