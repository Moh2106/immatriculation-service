package ma.enset.immatriculationservice.web;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.service.ProprietaireServiceImpl;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProprietaireGraphQLController {
    ProprietaireServiceImpl proprietaireService;

    @QueryMapping
    public List<ProprietaireDTO> listProprietaire(){
        return proprietaireService.findAll();
    }

    @QueryMapping
    public ProprietaireDTO getProprietaireById(@Argument Long id){
        return proprietaireService.findById(id);
    }

    @MutationMapping
    public ProprietaireDTO saveProprietaire(@Argument ProprietaireDTO prop){
        return proprietaireService.save(prop);
    }

    @MutationMapping
    public ProprietaireDTO updateProprietaire(@Argument Long id, @Argument ProprietaireDTO prop){
        return proprietaireService.update(id, prop);
    }

    @MutationMapping
    public void deleteProprietaire(@Argument Long id){
        proprietaireService.deleteById(id);
    }
}
