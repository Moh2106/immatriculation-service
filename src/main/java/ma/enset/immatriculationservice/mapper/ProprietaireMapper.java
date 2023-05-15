package ma.enset.immatriculationservice.mapper;

import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.entities.Proprietaire;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProprietaireMapper {
    ModelMapper modelMapper = new ModelMapper();

    public ProprietaireDTO from(Proprietaire proprietaire){
        return modelMapper.map(proprietaire, ProprietaireDTO.class);
    }

    public Proprietaire from(ProprietaireDTO proprietaire){
        return modelMapper.map(proprietaire, Proprietaire.class);
    }
}
