package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.EducationParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.EducationParticipationRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EducationParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.EducationParticipationMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EducationParticipationControllerTest {
    EducationParticipationController sut;
    EducationParticipationRepository educationParticipationRepository;
    EducationParticipationMapper educationParticipationMapper;
    EducationParticipationDTO educationParticipationDTO;
    EducationParticipation educationParticipationEntity;
    List<EducationParticipation> educationParticipationList;
    List<EducationParticipationDTO> educationParticipationDTOList;

    @BeforeEach
    void setUp() {
        educationParticipationDTO = mock(EducationParticipationDTO.class);
        educationParticipationEntity = mock(EducationParticipation.class);
        educationParticipationList = List.of(educationParticipationEntity);
        educationParticipationDTOList = List.of(educationParticipationDTO);
        educationParticipationRepository = mock(EducationParticipationRepository.class);
        educationParticipationMapper = mock(EducationParticipationMapper.class);
        sut = new EducationParticipationController(educationParticipationRepository, educationParticipationMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(educationParticipationMapper.educationParticipationDTOToEducationParticipation(educationParticipationDTO)).thenReturn(educationParticipationEntity);
        //Act
        var returnedValue = sut.dtoToEntity(educationParticipationDTO);
        //Assert
        Mockito.verify(educationParticipationMapper).educationParticipationDTOToEducationParticipation(educationParticipationDTO);
        Assertions.assertEquals(educationParticipationEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(educationParticipationMapper.educationParticipationToEducationParticipationDTO(educationParticipationEntity)).thenReturn(educationParticipationDTO);
        //Act
        var returnedValue = sut.entityToDTO(educationParticipationEntity);
        //Assert
        Mockito.verify(educationParticipationMapper).educationParticipationToEducationParticipationDTO(educationParticipationEntity);
        Assertions.assertEquals(educationParticipationDTO, returnedValue);
    }

    @Test
    void entitiesToDTOsShouldCallMapperFunction() {
        //Arrange
        when(educationParticipationMapper.educationParticipationsToEducationParticipationDTOs(educationParticipationList)).thenReturn(educationParticipationDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(educationParticipationList);
        //Assert
        Mockito.verify(educationParticipationMapper).educationParticipationsToEducationParticipationDTOs(educationParticipationList);
        Assertions.assertEquals(educationParticipationDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(educationParticipationMapper.educationParticipationDTOsToEducationParticipations(educationParticipationDTOList)).thenReturn(educationParticipationList);
        //Act
        var returnedValue = sut.DTOsToEntities(educationParticipationDTOList);
        //Assert
        Mockito.verify(educationParticipationMapper).educationParticipationDTOsToEducationParticipations(educationParticipationDTOList);
        Assertions.assertEquals(educationParticipationList, returnedValue);
    }

    @Test
    void readAllEmployees() {
        //Arrange
        when(educationParticipationRepository.findAllByEmployeeId(1)).thenReturn(educationParticipationList);
        //Act
        var returnedValue = sut.readAllEmployee(1);
        //
        Mockito.verify(educationParticipationRepository).findAllByEmployeeId(1);
        Assertions.assertEquals(educationParticipationList, returnedValue);
    }
}
