package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teampearl.cvgenerator.back_end.data_access_layer.entities.ProjectParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.ProjectParticipationRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithEmployeeController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.ProjectParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.ProjectParticipationMapper;

import java.util.List;

@RestController
@RequestMapping("/cv/{employeeId}/projectparticipation")
public class ProjectParticipationController extends AbstractWithEmployeeController<ProjectParticipation, ProjectParticipationDTO> {
    ProjectParticipationMapper projectParticipationMapper;

    public ProjectParticipationController(ProjectParticipationRepository projectParticipationRepository, ProjectParticipationMapper projectParticipationMapper) {
        super(projectParticipationRepository);
        this.projectParticipationMapper = projectParticipationMapper;
    }

    @Override
    protected ProjectParticipation dtoToEntity(ProjectParticipationDTO dto) {
        return projectParticipationMapper.projectParticipationDTOToProjectParticipation(dto);
    }

    @Override
    protected ProjectParticipationDTO entityToDTO(ProjectParticipation entity) {
        return projectParticipationMapper.projectParticipationToProjectParticipationDTO(entity);
    }

    @Override
    protected List<ProjectParticipation> DTOsToEntities(List<ProjectParticipationDTO> listOfDto) {
        return projectParticipationMapper.projectParticipationDTOsToProjectParticipations(listOfDto);
    }

    @Override
    protected List<ProjectParticipationDTO> entitiesToDTOs(List<ProjectParticipation> entities) {
        return projectParticipationMapper.projectParticipationsToProjectParticipationDTOs(entities);
    }

    @Override
    protected List<ProjectParticipation> readAllEmployee(int employeeId) {
        return ((ProjectParticipationRepository)jpaRepository).findAllByEmployeeId(employeeId);
    }
}
