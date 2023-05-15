package ma.enset.immatriculationservice.web;

import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.service.ProprietaireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProprietaireRestController {

    private ProprietaireServiceImpl proprietaireService;


    @GetMapping("/proprietaires/{id}")
    public ProprietaireDTO findById(@PathVariable Long id){
        ProprietaireDTO proprietaireDTO = proprietaireService.findById(id);
        return proprietaireDTO;
    }

    @GetMapping("/proprietaires")
    public List<ProprietaireDTO> findAll(){
        return proprietaireService.findAll();
    }

    @DeleteMapping("/proprietaires/{id}")
    public void deleteById(@PathVariable Long id){
        proprietaireService.deleteById(id);
    }

    @PostMapping("/proprietaires")
    public ProprietaireDTO save(ProprietaireDTO proprietaireDTO){
        return proprietaireService.save(proprietaireDTO);
    }

    @PutMapping("/proprietaires/{id}")
    public ProprietaireDTO update(@PathVariable Long id, @RequestBody ProprietaireDTO proprietaireDTO){
        return proprietaireService.update(id, proprietaireDTO);
    }
}
