package ma.enset.immatriculationservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero_immatrication;
    private String marque;
    private Double puissance_fiscale;
    private String model;
    @OneToOne
    private Proprietaire proprietaire;
}
