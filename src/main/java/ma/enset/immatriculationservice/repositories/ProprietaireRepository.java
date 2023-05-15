package ma.enset.immatriculationservice.repositories;

import ma.enset.immatriculationservice.entities.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Long> {
}
