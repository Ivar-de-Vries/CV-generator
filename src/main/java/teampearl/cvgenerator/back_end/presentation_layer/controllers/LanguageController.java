package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Language;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.LanguageRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractWithReadAllController;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.LanguageMapper;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController extends AbstractWithReadAllController<Language, LanguageDTO> {
    LanguageMapper languageMapper;

    public LanguageController(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        super(languageRepository);
        this.languageMapper = languageMapper;
    }

    @Override
    public Language dtoToEntity(LanguageDTO languageDTO) {
        return languageMapper.languageDTOToLanguage(languageDTO);
    }

    @Override
    public LanguageDTO entityToDTO(Language language) {
        return languageMapper.languageToLanguageDTO(language);
    }

    @Override
    public List<Language> DTOsToEntities(List<LanguageDTO> languageDTOS) {
        return languageMapper.languageDTOsToLanguages(languageDTOS);
    }

    @Override
    public List<LanguageDTO> entitiesToDTOs(List<Language> languages) {
        return languageMapper.languagesToLanguageDTOs(languages);
    }
}
