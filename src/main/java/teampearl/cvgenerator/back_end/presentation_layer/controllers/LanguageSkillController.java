package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageSkill;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.LanguageSkillRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageSkillDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.LanguageSkillMapper;

import java.util.List;

@RestController
@RequestMapping("/languageskill")
public class LanguageSkillController extends AbstractWithReadAllController<LanguageSkill, LanguageSkillDTO> {
    LanguageSkillMapper languageSkillMapper;

    public LanguageSkillController(LanguageSkillRepository languageSkillRepository, LanguageSkillMapper languageSkillMapper) {
        super(languageSkillRepository);
        this.languageSkillMapper = languageSkillMapper;
    }

    @Override
    public LanguageSkill dtoToEntity(LanguageSkillDTO languageSkillDTO) {
        return languageSkillMapper.languageSkillDTOToLanguageSkill(languageSkillDTO);
    }

    @Override
    public LanguageSkillDTO entityToDTO(LanguageSkill languageSkill) {
        return languageSkillMapper.languageSkillToLanguageSkillDTO(languageSkill);
    }

    @Override
    public List<LanguageSkill> DTOsToEntities(List<LanguageSkillDTO> languageSkillDTOS) {
        return languageSkillMapper.languageSkillDTOsToLanguageSkills(languageSkillDTOS);
    }

    @Override
    public List<LanguageSkillDTO> entitiesToDTOs(List<LanguageSkill> languageSkills) {
        return languageSkillMapper.languageSkillsToLanguageSkillDTOs(languageSkills);
    }
}
