package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageLevel;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageLevelDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface LanguageLevelMapper {
        LanguageLevelDTO languageLevelToLanguageLevelDTO(LanguageLevel languageLevel);

        LanguageLevel languageLevelDTOToLanguageLevel(LanguageLevelDTO languageLevelDTO);

        List<LanguageLevelDTO> languageLevelsToLanguageLevelDTOs(List<LanguageLevel> languageLevel);

        List<LanguageLevel> languageLevelDTOsToLanguageLevels(List<LanguageLevelDTO> languageLevelDTO);
}
