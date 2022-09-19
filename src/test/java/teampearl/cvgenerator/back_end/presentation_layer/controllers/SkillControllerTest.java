package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Skill;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.SkillRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.SkillDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.SkillMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SkillControllerTest {
    SkillController sut;
    SkillRepository skillRepository;
    SkillMapper skillMapper;
    SkillDTO skillDTO;
    Skill skillEntity;
    List<Skill> skillList;
    List<SkillDTO> skillDTOList;

    @BeforeEach
    void setUp() {
        skillDTO = mock(SkillDTO.class);
        skillEntity = mock(Skill.class);
        skillList = List.of(skillEntity);
        skillDTOList = List.of(skillDTO);
        skillRepository = mock(SkillRepository.class);
        skillMapper = mock(SkillMapper.class);
        sut = new SkillController(skillRepository, skillMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(skillMapper.skillDTOToSkill(skillDTO)).thenReturn(skillEntity);
        //Act
        sut.dtoToEntity(skillDTO);
        //Assert
        Mockito.verify(skillMapper).skillDTOToSkill(skillDTO);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(skillMapper.skillToSkillDTO(skillEntity)).thenReturn(skillDTO);
        //Act
        sut.entityToDTO(skillEntity);
        //Assert
        Mockito.verify(skillMapper).skillToSkillDTO(skillEntity);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(skillMapper.skillsToSkillDTOs(skillList)).thenReturn(skillDTOList);
        //Act
        sut.entitiesToDTOs(skillList);
        //Assert
        Mockito.verify(skillMapper).skillsToSkillDTOs(skillList);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(skillMapper.skillDTOsToSkills(skillDTOList)).thenReturn(skillList);
        //Act
        sut.DTOsToEntities(skillDTOList);
        //Assert
        Mockito.verify(skillMapper).skillDTOsToSkills(skillDTOList);
    }
}