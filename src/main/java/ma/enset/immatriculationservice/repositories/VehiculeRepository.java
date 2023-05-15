package ma.enset.immatriculationservice.repositories;

import ma.enset.immatriculationservice.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
