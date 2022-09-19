package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Education;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EducationDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface EducationMapper {
    EducationDTO educationToEducationDTO(Education education);

    Education educationDTOToEducation(EducationDTO educationDTO);

    List<EducationDTO> educationsToEducationDTOs(List<Education> educations);

    List<Education> educationDTOsToEducations(List<EducationDTO> educationDTOs);
}
