package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Project;
import teampearl.cvgenerator.back_end.presentation_layer.dto.ProjectDTO;

import java.util.List;
@Mapper(
        componentModel = "spring"
)
public interface ProjectMapper {
    ProjectDTO projectToProjectDTO(Project project);

    Project projectDTOtoProject(ProjectDTO projectDTO);

    List<ProjectDTO> projectsToProjectDTOs(List<Project> projects);

    List<Project> projectDTOsToProjects(List<ProjectDTO> projectDTOs);
}
