package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.LanguageSkill;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.LanguageSkillRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.LanguageSkillDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.LanguageSkillMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LanguageSkillControllerTest {
    LanguageSkillController sut;
    LanguageSkillRepository languageSkillRepository;
    LanguageSkillMapper languageSkillMapper;
    LanguageSkillDTO languageSkillDTO;
    LanguageSkill languageSkillEntity;
    List<LanguageSkill> languageSkillList;
    List<LanguageSkillDTO> languageSkillDTOList;

    @BeforeEach
    void setUp() {
        languageSkillDTO = mock(LanguageSkillDTO.class);
        languageSkillEntity = mock(LanguageSkill.class);
        languageSkillList = List.of(languageSkillEntity);
        languageSkillDTOList = List.of(languageSkillDTO);
        languageSkillRepository = mock(LanguageSkillRepository.class);
        languageSkillMapper = mock(LanguageSkillMapper.class);
        sut = new LanguageSkillController(languageSkillRepository, languageSkillMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(languageSkillMapper.languageSkillDTOToLanguageSkill(languageSkillDTO)).thenReturn(languageSkillEntity);
        //Act
        var returnedValue = sut.dtoToEntity(languageSkillDTO);
        //Assert
        Mockito.verify(languageSkillMapper).languageSkillDTOToLanguageSkill(languageSkillDTO);
        Assertions.assertEquals(languageSkillEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(languageSkillMapper.languageSkillToLanguageSkillDTO(languageSkillEntity)).thenReturn(languageSkillDTO);
        //Act
        var returnedValue = sut.entityToDTO(languageSkillEntity);
        //Assert
        Mockito.verify(languageSkillMapper).languageSkillToLanguageSkillDTO(languageSkillEntity);
        Assertions.assertEquals(languageSkillDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(languageSkillMapper.languageSkillsToLanguageSkillDTOs(languageSkillList)).thenReturn(languageSkillDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(languageSkillList);
        //Assert
        Mockito.verify(languageSkillMapper).languageSkillsToLanguageSkillDTOs(languageSkillList);
        Assertions.assertEquals(languageSkillDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(languageSkillMapper.languageSkillDTOsToLanguageSkills(languageSkillDTOList)).thenReturn(languageSkillList);
        //Act
        var returnedValue = sut.DTOsToEntities(languageSkillDTOList);
        //Assert
        Mockito.verify(languageSkillMapper).languageSkillDTOsToLanguageSkills(languageSkillDTOList);
        Assertions.assertEquals(languageSkillList, returnedValue);
    }

}
