package ma.enset.immatriculationservice.dto;


import jakarta.persistence.OneToOne;
import lombok.Data;
import ma.enset.immatriculationservice.entities.Proprietaire;

@Data
public class VehiculeDTO {
    private Long id;
    private String numero_immatrication;
    private String marque;
    private Double puissance_fiscale;
    private String model;
    @OneToOne
    private Proprietaire proprietaire;
}
