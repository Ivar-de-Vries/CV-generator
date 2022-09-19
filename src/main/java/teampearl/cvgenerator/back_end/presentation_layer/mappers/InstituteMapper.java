package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Institute;
import teampearl.cvgenerator.back_end.presentation_layer.dto.InstituteDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface InstituteMapper {
    InstituteDTO instituteToInstituteDTO(Institute institute);

    List<InstituteDTO> institutesToInstituteDTOs(List<Institute> institutes);

    Institute instituteDTOtoInstitute(InstituteDTO instituteDTO);

    List<Institute> instituteDTOstoInstitutes(List<InstituteDTO> instituteDTOs);
}
