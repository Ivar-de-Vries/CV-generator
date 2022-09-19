package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Institute;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.InstituteRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.InstituteDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.InstituteMapper;

import java.util.List;

@RestController
@RequestMapping("/institute")
public class InstituteController extends AbstractWithReadAllController<Institute, InstituteDTO> {
    InstituteMapper instituteMapper;

    public InstituteController(InstituteRepository instituteRepository, InstituteMapper instituteMapper) {
        super(instituteRepository);
        this.instituteMapper = instituteMapper;
    }

    @Override
    public Institute dtoToEntity(InstituteDTO instituteDTO) {
        return instituteMapper.instituteDTOtoInstitute(instituteDTO);
    }

    @Override
    public InstituteDTO entityToDTO(Institute entity) {
        return instituteMapper.instituteToInstituteDTO(entity);
    }

    @Override
    public List<Institute> DTOsToEntities(List<InstituteDTO> instituteDTOS) {
        return instituteMapper.instituteDTOstoInstitutes(instituteDTOS);
    }

    @Override
    public List<InstituteDTO> entitiesToDTOs(List<Institute> institutes) {
        return instituteMapper.institutesToInstituteDTOs(institutes);
    }
}
