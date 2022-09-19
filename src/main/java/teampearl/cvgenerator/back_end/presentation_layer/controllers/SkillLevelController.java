package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.SkillLevel;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.SkillLevelRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithEmployeeController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.SkillLevelDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.SkillLevelMapper;

import java.util.List;

@RestController
@RequestMapping("/cv/{employeeId}/skill")
public class SkillLevelController extends AbstractWithEmployeeController<SkillLevel, SkillLevelDTO> {
    SkillLevelMapper skillLevelMapper;

    public SkillLevelController(SkillLevelRepository skillLevelRepository, SkillLevelMapper skillLevelMapper) {
        super(skillLevelRepository);
        this.skillLevelMapper = skillLevelMapper;
    }

    @Override
    public SkillLevel dtoToEntity(SkillLevelDTO skillLevelDTO) {
        return skillLevelMapper.skillLevelDTOToSkillLevel(skillLevelDTO);
    }

    @Override
    public SkillLevelDTO entityToDTO(SkillLevel skillLevel) {
        return skillLevelMapper.skillLevelToSkillLevelDTO(skillLevel);
    }

    @Override
    public List<SkillLevel> DTOsToEntities(List<SkillLevelDTO> skillLevelDTOS) {
        return skillLevelMapper.skillLevelDTOsToSkillLevels(skillLevelDTOS);
    }

    @Override
    public List<SkillLevelDTO> entitiesToDTOs(List<SkillLevel> skillLevels) {
        return skillLevelMapper.skillLevelsToSkillLevelDTOs(skillLevels);
    }

    @Override
    public List<SkillLevel> readAllEmployee(int employeeId) {
        return ((SkillLevelRepository) jpaRepository).findAllByEmployeeId(employeeId);
    }
}