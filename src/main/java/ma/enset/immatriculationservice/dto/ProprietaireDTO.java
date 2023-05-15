package ma.enset.immatriculationservice.dto;


import lombok.Data;

import java.util.Date;

@Data
public class ProprietaireDTO {
    private Long id;
    private String nom;
    private Date date_naissance;
    private String email;
}
