package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Language;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.LanguageRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.LanguageMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LanguageControllerTest {
    LanguageController sut;
    LanguageRepository languageRepository;
    LanguageMapper languageMapper;
    LanguageDTO languageDTO;
    Language languageEntity;
    List<Language> languageList;
    List<LanguageDTO> languageDTOList;

    @BeforeEach
    void setUp() {
        languageDTO = mock(LanguageDTO.class);
        languageEntity = mock(Language.class);
        languageList = List.of(languageEntity);
        languageDTOList = List.of(languageDTO);
        languageRepository = mock(LanguageRepository.class);
        languageMapper = mock(LanguageMapper.class);
        sut = new LanguageController(languageRepository, languageMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(languageMapper.languageDTOToLanguage(languageDTO)).thenReturn(languageEntity);
        //Act
        var returnedValue = sut.dtoToEntity(languageDTO);
        //Assert
        Mockito.verify(languageMapper).languageDTOToLanguage(languageDTO);
        Assertions.assertEquals(languageEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(languageMapper.languageToLanguageDTO(languageEntity)).thenReturn(languageDTO);
        //Act
        var returnedValue = sut.entityToDTO(languageEntity);
        //Assert
        Mockito.verify(languageMapper).languageToLanguageDTO(languageEntity);
        Assertions.assertEquals(languageDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(languageMapper.languagesToLanguageDTOs(languageList)).thenReturn(languageDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(languageList);
        //Assert
        Mockito.verify(languageMapper).languagesToLanguageDTOs(languageList);
        Assertions.assertEquals(languageDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(languageMapper.languageDTOsToLanguages(languageDTOList)).thenReturn(languageList);
        //Act
        var returnedValue = sut.DTOsToEntities(languageDTOList);
        //Assert
        Mockito.verify(languageMapper).languageDTOsToLanguages(languageDTOList);
        Assertions.assertEquals(languageList, returnedValue);
    }

}
