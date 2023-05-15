package ma.enset.immatriculationservice.web;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.dto.VehiculeDTO;
import ma.enset.immatriculationservice.service.ProprietaireServiceImpl;
import ma.enset.immatriculationservice.service.VehivuleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VehiculeRestController {
    ProprietaireServiceImpl proprietaireService;
    VehivuleServiceImpl vehivuleService;

    @GetMapping("/vehicules/{id}")
    public VehiculeDTO findById(@PathVariable Long id){
        VehiculeDTO vehiculeDTO = vehivuleService.findById(id);
        return vehiculeDTO;
    }

    @GetMapping("/vehicules")
    public List<VehiculeDTO> findAll(){
        return vehivuleService.findAll();
    }

    @DeleteMapping("/vehicules/{id}")
    public void deleteById(@PathVariable Long id){
        vehivuleService.deleteById(id);
    }

    @PostMapping("/vehicules")
    public VehiculeDTO save(VehiculeDTO vehiculeDTO){
        return vehivuleService.save(vehiculeDTO);
    }

    @PutMapping("/vehicules/{id}")
    public VehiculeDTO  update(@PathVariable Long id, @RequestBody VehiculeDTO vehiculeDTO){
        return vehivuleService.update(id, vehiculeDTO);
    }
}
