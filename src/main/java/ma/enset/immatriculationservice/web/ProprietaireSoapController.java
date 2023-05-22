package ma.enset.immatriculationservice.web;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import ma.enset.immatriculationservice.dto.ProprietaireDTO;
import ma.enset.immatriculationservice.service.ProprietaireServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@WebService(serviceName = "proprietairesWS")
@AllArgsConstructor
public class ProprietaireSoapController {

    private ProprietaireServiceImpl proprietaireService;

    @WebMethod
    public ProprietaireDTO findById(@WebParam(name = "id") Long id){
        ProprietaireDTO proprietaireDTO = proprietaireService.findById(id);
        return proprietaireDTO;
    }

    @WebMethod
    public List<ProprietaireDTO> findAll(){
        return proprietaireService.findAll();
    }

    @WebMethod
    public void deleteById(@WebParam(name = "id") Long id){
        proprietaireService.deleteById(id);
    }

    @WebMethod
    public ProprietaireDTO save(ProprietaireDTO proprietaireDTO){
        return proprietaireService.save(proprietaireDTO);
    }


    @WebMethod
    public ProprietaireDTO update(@WebParam(name = "id") Long id, @WebParam(name = "proprietaireDTO") ProprietaireDTO proprietaireDTO){
        return proprietaireService.update(id, proprietaireDTO);
    }
}
