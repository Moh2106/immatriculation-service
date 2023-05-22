package ma.enset.immatriculationservice.dto;


import lombok.Data;
import ma.enset.immatriculationservice.entities.Proprietaire;

@Data
public class VehiculeDTO {
    //private Long id;
    private String numero_immatrication;
    private String marque;
    private Double puissance_fiscale;
    private String model;
    private Proprietaire proprietaire;
}
