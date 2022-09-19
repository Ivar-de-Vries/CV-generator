package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.EducationParticipation;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EducationParticipationDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface EducationParticipationMapper {
    EducationParticipationDTO educationParticipationToEducationParticipationDTO(EducationParticipation educationParticipation);

    EducationParticipation educationParticipationDTOToEducationParticipation(EducationParticipationDTO educationParticipationDTO);

    List<EducationParticipationDTO> educationParticipationsToEducationParticipationDTOs(List<EducationParticipation> educationParticipations);

    List<EducationParticipation> educationParticipationDTOsToEducationParticipations(List<EducationParticipationDTO> educationParticipationDTOs);
}
