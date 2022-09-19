package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.SkillLevel;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.SkillLevelRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.SkillLevelDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.SkillLevelMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SkillLevelControllerTest {
    SkillLevelController sut;
    SkillLevelRepository skillLevelRepository;
    SkillLevelMapper skillLevelMapper;
    SkillLevelDTO skillLevelDTO;
    SkillLevel skillLevelEntity;
    List<SkillLevel> skillLevelList;
    List<SkillLevelDTO> skillLevelDTOList;

    @BeforeEach
    void setUp() {
        skillLevelDTO = mock(SkillLevelDTO.class);
        skillLevelEntity = mock(SkillLevel.class);
        skillLevelList = List.of(skillLevelEntity);
        skillLevelDTOList = List.of(skillLevelDTO);
        skillLevelRepository = mock(SkillLevelRepository.class);
        skillLevelMapper = mock(SkillLevelMapper.class);
        sut = new SkillLevelController(skillLevelRepository, skillLevelMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(skillLevelMapper.skillLevelDTOToSkillLevel(skillLevelDTO)).thenReturn(skillLevelEntity);
        //Act
        var returnedValue = sut.dtoToEntity(skillLevelDTO);
        //Assert
        Mockito.verify(skillLevelMapper).skillLevelDTOToSkillLevel(skillLevelDTO);
        Assertions.assertEquals(skillLevelEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(skillLevelMapper.skillLevelToSkillLevelDTO(skillLevelEntity)).thenReturn(skillLevelDTO);
        //Act
        var returnedValue = sut.entityToDTO(skillLevelEntity);
        //Assert
        Mockito.verify(skillLevelMapper).skillLevelToSkillLevelDTO(skillLevelEntity);
        Assertions.assertEquals(skillLevelDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(skillLevelMapper.skillLevelsToSkillLevelDTOs(skillLevelList)).thenReturn(skillLevelDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(skillLevelList);
        //Assert
        Mockito.verify(skillLevelMapper).skillLevelsToSkillLevelDTOs(skillLevelList);
        Assertions.assertEquals(skillLevelDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(skillLevelMapper.skillLevelDTOsToSkillLevels(skillLevelDTOList)).thenReturn(skillLevelList);
        //Act
        var returnedValue = sut.DTOsToEntities(skillLevelDTOList);
        //Assert
        Mockito.verify(skillLevelMapper).skillLevelDTOsToSkillLevels(skillLevelDTOList);
        Assertions.assertEquals(skillLevelList, returnedValue);
    }

    @Test
    void readAllEmployees() {
        //Arrange
        when(skillLevelRepository.findAllByEmployeeId(1)).thenReturn(skillLevelList);
        //Act
        var returnedValue = sut.readAllEmployee(1);
        //
        Mockito.verify(skillLevelRepository).findAllByEmployeeId(1);
        Assertions.assertEquals(skillLevelList, returnedValue);
    }
}