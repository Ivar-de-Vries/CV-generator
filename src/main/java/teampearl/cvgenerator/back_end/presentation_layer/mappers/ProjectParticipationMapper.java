package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.EducationParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.entities.ProjectParticipation;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EducationParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.dto.ProjectParticipationDTO;

import java.util.List;
@Mapper(
        componentModel = "spring"
)
public interface ProjectParticipationMapper {

    ProjectParticipationDTO projectParticipationToProjectParticipationDTO(ProjectParticipation projectParticipation);

    ProjectParticipation projectParticipationDTOToProjectParticipation(ProjectParticipationDTO projectParticipationDTO);

    List<ProjectParticipationDTO> projectParticipationsToProjectParticipationDTOs(List<ProjectParticipation> projectParticipations);

    List<ProjectParticipation> projectParticipationDTOsToProjectParticipations(List<ProjectParticipationDTO> projectParticipationDTOs);

}
