package ma.enset.immatriculationservice.service;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.mapper.ProprietaireMapper;
import ma.enset.immatriculationservice.repositories.ProprietaireRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProprietaireServiceImpl implements ServiceImplementation<ProprietaireDTO>{
    ProprietaireRepository proprietaireRepository;
    ProprietaireMapper proprietaireMapper;
    @Override
    public ProprietaireDTO findById(Long id) {
        Proprietaire proprietaire = proprietaireRepository.findById(id).get();
        ProprietaireDTO proprietaireDTO =proprietaireMapper.from(proprietaire);
        return proprietaireDTO;
    }

    @Override
    public List<ProprietaireDTO> findAll() {
        return proprietaireRepository.findAll().stream().map(proprietaireMapper::from).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        proprietaireRepository.deleteById(id);
    }

    @Override
    public ProprietaireDTO update(Long id, ProprietaireDTO proprietaireDTO) {
        Proprietaire proprietaire = proprietaireRepository.findById(id).get();

        if (proprietaireDTO.getNom() != null) proprietaire.setNom(proprietaireDTO.getNom());
        if (proprietaireDTO.getEmail() != null) proprietaire.setEmail(proprietaireDTO.getEmail());
        if (proprietaireDTO.getDate_naissance() != null) proprietaire.setDate_naissance(proprietaireDTO.getDate_naissance());

        ProprietaireDTO proprietaireDTO1 = proprietaireMapper.from(proprietaire);
        save(proprietaireDTO1);

        return proprietaireDTO1;
    }

    @Override
    public ProprietaireDTO save(ProprietaireDTO proprietaireDTO) {
        Proprietaire proprietaire = proprietaireMapper.from(proprietaireDTO);
        Proprietaire prop = proprietaireRepository.save(proprietaire);

        ProprietaireDTO proprietaireDTO1 = proprietaireMapper.from(prop);

        return proprietaireDTO1;
    }
}
