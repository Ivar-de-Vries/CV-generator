package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Skill;
import teampearl.cvgenerator.back_end.presentation_layer.dto.SkillDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)

public interface SkillMapper {
    SkillDTO skillToSkillDTO (Skill skill);

    List<SkillDTO> skillsToSkillDTOs (List<Skill> skill);

    Skill skillDTOToSkill(SkillDTO skillDTO);

    List<Skill> skillDTOsToSkills(List<SkillDTO> skillDTOs);
}
