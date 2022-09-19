package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageSkill;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageSkillDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)       
public interface LanguageSkillMapper {
    LanguageSkillDTO languageSkillToLanguageSkillDTO(LanguageSkill languageSkill);

    LanguageSkill languageSkillDTOToLanguageSkill(LanguageSkillDTO languageSkillDTO);

    List<LanguageSkillDTO> languageSkillsToLanguageSkillDTOs(List<LanguageSkill> languageSkill);

    List<LanguageSkill> languageSkillDTOsToLanguageSkills(List<LanguageSkillDTO> languageSkillDTO);
}
