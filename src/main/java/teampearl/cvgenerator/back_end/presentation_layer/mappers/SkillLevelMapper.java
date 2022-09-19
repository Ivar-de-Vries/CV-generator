package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.SkillLevel;
import teampearl.cvgenerator.back_end.presentation_layer.dto.SkillLevelDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)

public interface SkillLevelMapper {
    SkillLevelDTO skillLevelToSkillLevelDTO(SkillLevel skillLevel);

    List<SkillLevelDTO> skillLevelsToSkillLevelDTOs(List<SkillLevel> skillLevel);

    SkillLevel skillLevelDTOToSkillLevel(SkillLevelDTO skillLevelDTO);

    List<SkillLevel> skillLevelDTOsToSkillLevels(List<SkillLevelDTO> skillLevelDTO);
}
