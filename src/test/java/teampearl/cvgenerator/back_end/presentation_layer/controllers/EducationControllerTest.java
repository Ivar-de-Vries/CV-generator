package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Education;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.EducationRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EducationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.EducationMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EducationControllerTest {
    EducationController sut;
    EducationRepository educationRepository;
    EducationMapper educationMapper;
    EducationDTO educationDTO;
    Education educationEntity;
    List<Education> educationList;
    List<EducationDTO> educationDTOList;

    @BeforeEach
    void setUp() {
        educationDTO = mock(EducationDTO.class);
        educationEntity = mock(Education.class);
        educationList = List.of(educationEntity);
        educationDTOList = List.of(educationDTO);
        educationRepository = mock(EducationRepository.class);
        educationMapper = mock(EducationMapper.class);
        sut = new EducationController(educationRepository, educationMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(educationMapper.educationDTOToEducation(educationDTO)).thenReturn(educationEntity);
        //Act
        var returnValue = sut.dtoToEntity(educationDTO);
        //Assert
        Mockito.verify(educationMapper).educationDTOToEducation(educationDTO);
        Assertions.assertEquals(educationEntity, returnValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(educationMapper.educationToEducationDTO(educationEntity)).thenReturn(educationDTO);
        //Act
        var returnValue = sut.entityToDTO(educationEntity);
        //Assert
        Mockito.verify(educationMapper).educationToEducationDTO(educationEntity);
        Assertions.assertEquals(educationDTO, returnValue);
    }

    @Test
    void entitiesToDTOsShouldCallMapperFunction() {
        //Arrange
        when(educationMapper.educationsToEducationDTOs(educationList)).thenReturn(educationDTOList);
        //Act
        var returnValue = sut.entitiesToDTOs(educationList);
        //Assert
        Mockito.verify(educationMapper).educationsToEducationDTOs(educationList);
        Assertions.assertEquals(educationDTOList, returnValue);
    }

    @Test
    void dtosToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(educationMapper.educationDTOsToEducations(educationDTOList)).thenReturn(educationList);
        //Act
        var returnValue = sut.DTOsToEntities(educationDTOList);
        //Assert
        Mockito.verify(educationMapper).educationDTOsToEducations(educationDTOList);
        Assertions.assertEquals(educationList, returnValue);
    }
}
