package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Project;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.ProjectRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.ProjectDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.ProjectMapper;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController extends AbstractWithReadAllController<Project, ProjectDTO> {
    ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        super(projectRepository);
        this.projectMapper = projectMapper;
    }

    @Override
    protected Project dtoToEntity(ProjectDTO dto) {
        return projectMapper.projectDTOtoProject(dto);
    }

    @Override
    protected ProjectDTO entityToDTO(Project entity) {
        return projectMapper.projectToProjectDTO(entity);
    }

    @Override
    protected List<Project> DTOsToEntities(List<ProjectDTO> listOfDto) {
        return projectMapper.projectDTOsToProjects(listOfDto);
    }

    @Override
    protected List<ProjectDTO> entitiesToDTOs(List<Project> entities) {
        return projectMapper.projectsToProjectDTOs(entities);
    }
}
