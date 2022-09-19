package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageLevel;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.LanguageLevelRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageLevelDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.LanguageLevelMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LanguageLevelControllerTest {
    LanguageLevelController sut;
    LanguageLevelRepository languageLevelRepository;
    LanguageLevelMapper languageLevelMapper;
    LanguageLevelDTO languageLevelDTO;
    LanguageLevel languageLevelEntity;
    List<LanguageLevel> languageLevelList;
    List<LanguageLevelDTO> languageLevelDTOList;

    @BeforeEach
    void setUp() {
        languageLevelDTO = mock(LanguageLevelDTO.class);
        languageLevelEntity = mock(LanguageLevel.class);
        languageLevelList = List.of(languageLevelEntity);
        languageLevelDTOList = List.of(languageLevelDTO);
        languageLevelRepository = mock(LanguageLevelRepository.class);
        languageLevelMapper = mock(LanguageLevelMapper.class);
        sut = new LanguageLevelController(languageLevelRepository, languageLevelMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(languageLevelMapper.languageLevelDTOToLanguageLevel(languageLevelDTO)).thenReturn(languageLevelEntity);
        //Act
        var returnedValue = sut.dtoToEntity(languageLevelDTO);
        //Assert
        Mockito.verify(languageLevelMapper).languageLevelDTOToLanguageLevel(languageLevelDTO);
        Assertions.assertEquals(languageLevelEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(languageLevelMapper.languageLevelToLanguageLevelDTO(languageLevelEntity)).thenReturn(languageLevelDTO);
        //Act
        var returnedValue = sut.entityToDTO(languageLevelEntity);
        //Assert
        Mockito.verify(languageLevelMapper).languageLevelToLanguageLevelDTO(languageLevelEntity);
        Assertions.assertEquals(languageLevelDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(languageLevelMapper.languageLevelsToLanguageLevelDTOs(languageLevelList)).thenReturn(languageLevelDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(languageLevelList);
        //Assert
        Mockito.verify(languageLevelMapper).languageLevelsToLanguageLevelDTOs(languageLevelList);
        Assertions.assertEquals(languageLevelDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(languageLevelMapper.languageLevelDTOsToLanguageLevels(languageLevelDTOList)).thenReturn(languageLevelList);
        //Act
        var returnedValue = sut.DTOsToEntities(languageLevelDTOList);
        //Assert
        Mockito.verify(languageLevelMapper).languageLevelDTOsToLanguageLevels(languageLevelDTOList);
        Assertions.assertEquals(languageLevelList, returnedValue);
    }

    @Test
    void readAllEmployees() {
        //Arrange
        when(languageLevelRepository.findAllByEmployeeId(1)).thenReturn(languageLevelList);
        //Act
        var returnedValue = sut.readAllEmployee(1);
        //
        Mockito.verify(languageLevelRepository).findAllByEmployeeId(1);
        Assertions.assertEquals(languageLevelList, returnedValue);
    }
}
