package ma.enset.immatriculationservice.web;

import ma.enset.immatriculationservice.dto.VehiculeDTO;
import ma.enset.immatriculationservice.service.VehivuleServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehiculeGraphQLController {
    VehivuleServiceImpl vehivuleService;

    @QueryMapping
    public List<VehiculeDTO> listVehicule(){
        return vehivuleService.findAll();
    }

    @QueryMapping
    public VehiculeDTO getVehiculeById(@Argument Long id){
        return vehivuleService.findById(id);
    }

    @MutationMapping
    public VehiculeDTO saveVehicule(@Argument VehiculeDTO vehicule){
        return vehivuleService.save(vehicule);
    }

    @MutationMapping
    public VehiculeDTO updateVehicule(@Argument Long id, @Argument VehiculeDTO vehicule){
        return vehivuleService.update(id, vehicule);
    }

    @MutationMapping
    public void deleteVehicule(@Argument Long id){
        vehivuleService.deleteById(id);
    }
}
