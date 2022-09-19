package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.EducationParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.EducationParticipationRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithEmployeeController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EducationParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.EducationParticipationMapper;

import java.util.List;

@RestController
@RequestMapping("/cv/{employeeId}/education")
public class EducationParticipationController extends AbstractWithEmployeeController<EducationParticipation, EducationParticipationDTO> {
    EducationParticipationMapper educationParticipationMapper;

    public EducationParticipationController(EducationParticipationRepository educationParticipationRepository, EducationParticipationMapper educationParticipationMapper) {
        super(educationParticipationRepository);
        this.educationParticipationMapper = educationParticipationMapper;
    }

    @Override
    public EducationParticipation dtoToEntity(EducationParticipationDTO educationParticipationDTO) {
        return educationParticipationMapper.educationParticipationDTOToEducationParticipation(educationParticipationDTO);
    }

    @Override
    public EducationParticipationDTO entityToDTO(EducationParticipation educationParticipation) {
        return educationParticipationMapper.educationParticipationToEducationParticipationDTO(educationParticipation);
    }

    @Override
    public List<EducationParticipation> DTOsToEntities(List<EducationParticipationDTO> educationParticipationDTOS) {
        return educationParticipationMapper.educationParticipationDTOsToEducationParticipations(educationParticipationDTOS);
    }

    @Override
    public List<EducationParticipationDTO> entitiesToDTOs(List<EducationParticipation> educationParticipations) {
        return educationParticipationMapper.educationParticipationsToEducationParticipationDTOs(educationParticipations);
    }

    @Override
    public List<EducationParticipation> readAllEmployee(int employeeId) {
        return ((EducationParticipationRepository) jpaRepository).findAllByEmployeeId(employeeId);
    }
}
