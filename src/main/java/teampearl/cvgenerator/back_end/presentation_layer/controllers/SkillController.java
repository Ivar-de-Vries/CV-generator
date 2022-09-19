package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Skill;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.SkillRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.SkillDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.SkillMapper;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController extends AbstractWithReadAllController<Skill, SkillDTO> {
    SkillMapper skillMapper;

    public SkillController(SkillRepository skillRepository, SkillMapper skillMapper) {
        super(skillRepository);
        this.skillMapper = skillMapper;
    }

    @Override
    public Skill dtoToEntity(SkillDTO skillDTO) {
        return skillMapper.skillDTOToSkill(skillDTO);
    }

    @Override
    public SkillDTO entityToDTO(Skill skill) {
        return skillMapper.skillToSkillDTO(skill);
    }

    @Override
    public List<Skill> DTOsToEntities(List<SkillDTO> skillDTOS) {
        return skillMapper.skillDTOsToSkills(skillDTOS);
    }

    @Override
    public List<SkillDTO> entitiesToDTOs(List<Skill> skills) {
        return skillMapper.skillsToSkillDTOs(skills);
    }
}
