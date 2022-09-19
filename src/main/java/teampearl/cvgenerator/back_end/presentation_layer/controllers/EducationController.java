package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Education;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.EducationRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EducationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.EducationMapper;

import java.util.List;

@RestController
@RequestMapping("/educations")
public class EducationController extends AbstractWithReadAllController<Education, EducationDTO> {
    EducationMapper educationMapper;

    public EducationController(EducationRepository educationRepository, EducationMapper educationMapper) {
        super(educationRepository);
        this.educationMapper = educationMapper;
    }

    @Override
    public Education dtoToEntity(EducationDTO educationDTO) {
        return educationMapper.educationDTOToEducation(educationDTO);
    }

    @Override
    public EducationDTO entityToDTO(Education education) {
        return educationMapper.educationToEducationDTO(education);
    }

    @Override
    public List<Education> DTOsToEntities(List<EducationDTO> educationDTOS) {
        return educationMapper.educationDTOsToEducations(educationDTOS);
    }

    @Override
    public List<EducationDTO> entitiesToDTOs(List<Education> educations) {
        return educationMapper.educationsToEducationDTOs(educations);
    }
}
