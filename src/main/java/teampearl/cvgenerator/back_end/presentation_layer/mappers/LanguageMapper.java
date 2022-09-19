package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Language;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface LanguageMapper {
    LanguageDTO languageToLanguageDTO(Language language);

    Language languageDTOToLanguage(LanguageDTO languageDTO);

    List<LanguageDTO> languagesToLanguageDTOs(List<Language> language);

    List<Language> languageDTOsToLanguages(List<LanguageDTO> languageDTO);
}
