package ma.enset.immatriculationservice.service;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.dto.VehiculeDTO;
import ma.enset.immatriculationservice.entities.Proprietaire;
import ma.enset.immatriculationservice.entities.Vehicule;
import ma.enset.immatriculationservice.mapper.ProprietaireMapper;
import ma.enset.immatriculationservice.mapper.VehiculeMapper;
import ma.enset.immatriculationservice.repositories.ProprietaireRepository;
import ma.enset.immatriculationservice.repositories.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class VehivuleServiceImpl implements ServiceImplementation<VehiculeDTO>{
    VehiculeRepository vehiculeRepository;
    VehiculeMapper vehiculeMapper;

    @Override
    public VehiculeDTO findById(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id).get();
        VehiculeDTO vehiculeDTO = vehiculeMapper.from(vehicule);
        return  vehiculeDTO;
    }

    @Override
    public List<VehiculeDTO> findAll() {
        return vehiculeRepository.findAll().stream().map(VehiculeMapper::from).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public VehiculeDTO update(Long id, VehiculeDTO vehiculeDTO) {
        Vehicule vehicule = vehiculeRepository.findById(id).get();

        if (vehiculeDTO.getMarque() != null) vehicule.setMarque(vehiculeDTO.getMarque());
        if (vehiculeDTO.getModel() != null) vehicule.setModel(vehiculeDTO.getModel());
        if (vehiculeDTO.getPuissance_fiscale() != null) vehicule.setPuissance_fiscale(vehiculeDTO.getPuissance_fiscale());
        if (vehiculeDTO.getProprietaire() != null) vehicule.setProprietaire(vehiculeDTO.getProprietaire());

        VehiculeDTO vehiculeDTO1 = vehiculeMapper.from(vehicule);
        save(vehiculeDTO1);
        return vehiculeDTO1;
    }

    @Override
    public VehiculeDTO save(VehiculeDTO vehiculeDTO) {
        Vehicule vehicule = vehiculeMapper.from(vehiculeDTO);
        Vehicule vehicule1 = vehiculeRepository.save(vehicule);

        VehiculeDTO vehiculeDTO1 = vehiculeMapper.from(vehicule1);

        return vehiculeDTO1;
    }
}
