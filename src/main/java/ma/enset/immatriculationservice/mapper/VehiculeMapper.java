package ma.enset.immatriculationservice.mapper;

import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.dto.VehiculeDTO;
import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.entities.Vehicule;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VehiculeMapper {
    static ModelMapper modelMapper = new ModelMapper();

    public static VehiculeDTO from(Vehicule vehicule){
        return modelMapper.map(vehicule, VehiculeDTO.class);
    }

    public Vehicule from(VehiculeDTO vehiculeDTO){
        return modelMapper.map(vehiculeDTO, Vehicule.class);
    }
}
