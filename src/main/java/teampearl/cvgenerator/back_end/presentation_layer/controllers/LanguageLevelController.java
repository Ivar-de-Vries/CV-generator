package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageLevel;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.LanguageLevelRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithEmployeeController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageLevelDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.LanguageLevelMapper;

import java.util.List;

@RestController
@RequestMapping("/cv/{employeeId}/languagelevel")
public class LanguageLevelController extends AbstractWithEmployeeController<LanguageLevel, LanguageLevelDTO> {
    LanguageLevelMapper languageLevelMapper;

    public LanguageLevelController(LanguageLevelRepository languageLevelRepository, LanguageLevelMapper languageLevelMapper) {
        super(languageLevelRepository);
        this.languageLevelMapper = languageLevelMapper;
    }

    @Override
    public LanguageLevel dtoToEntity(LanguageLevelDTO languageLevelDTO) {
        return languageLevelMapper.languageLevelDTOToLanguageLevel(languageLevelDTO);
    }

    @Override
    public LanguageLevelDTO entityToDTO(LanguageLevel languageLevel) {
        return languageLevelMapper.languageLevelToLanguageLevelDTO(languageLevel);
    }

    @Override
    public List<LanguageLevel> DTOsToEntities(List<LanguageLevelDTO> languageLevelDTOS) {
        return languageLevelMapper.languageLevelDTOsToLanguageLevels(languageLevelDTOS);
    }

    @Override
    public List<LanguageLevelDTO> entitiesToDTOs(List<LanguageLevel> languageLevels) {
        return languageLevelMapper.languageLevelsToLanguageLevelDTOs(languageLevels);
    }

    @Override
    public List<LanguageLevel> readAllEmployee(int employeeId) {
        return ((LanguageLevelRepository) jpaRepository).findAllByEmployeeId(employeeId);
    }
}
