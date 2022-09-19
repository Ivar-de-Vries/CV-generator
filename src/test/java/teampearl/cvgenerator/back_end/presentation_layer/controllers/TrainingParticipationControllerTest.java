package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import teampearl.cvgenerator.back_end.data_access_layer.entities.TrainingParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Employee;
import teampearl.cvgenerator.back_end.data_access_layer.entities.TrainingParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.TrainingParticipationRepository;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.TrainingParticipationRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.TrainingParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.dto.TrainingParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.TrainingParticipationMapper;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.TrainingParticipationMapper;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TrainingParticipationControllerTest {
    TrainingParticipationController sut;
    TrainingParticipationRepository trainingParticipationRepository;
    TrainingParticipationMapper trainingParticipationMapper;
    TrainingParticipationDTO trainingParticipationDTO;
    TrainingParticipation trainingParticipationEntity;
    List<TrainingParticipation> trainingParticipationList;
    List<TrainingParticipationDTO> trainingParticipationDTOList;

    @BeforeEach
    void setUp() {
        trainingParticipationDTO = mock(TrainingParticipationDTO.class);
        trainingParticipationEntity = mock(TrainingParticipation.class);
        trainingParticipationList = List.of(trainingParticipationEntity);
        trainingParticipationDTOList = List.of(trainingParticipationDTO);
        trainingParticipationRepository = mock(TrainingParticipationRepository.class);
        trainingParticipationMapper = mock(TrainingParticipationMapper.class);
        sut = new TrainingParticipationController(trainingParticipationRepository, trainingParticipationMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(trainingParticipationMapper.trainingParticipationDTOToTrainingParticipation(trainingParticipationDTO)).thenReturn(trainingParticipationEntity);
        //Act
        var returnedValue = sut.dtoToEntity(trainingParticipationDTO);
        //Assert
        Mockito.verify(trainingParticipationMapper).trainingParticipationDTOToTrainingParticipation(trainingParticipationDTO);
        Assertions.assertEquals(trainingParticipationEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(trainingParticipationMapper.trainingParticipationToTrainingParticipationDTO(trainingParticipationEntity)).thenReturn(trainingParticipationDTO);
        //Act
        var returnedValue = sut.entityToDTO(trainingParticipationEntity);
        //Assert
        Mockito.verify(trainingParticipationMapper).trainingParticipationToTrainingParticipationDTO(trainingParticipationEntity);
        Assertions.assertEquals(trainingParticipationDTO, returnedValue);
    }

    @Test
    void entitiesToDTOsShouldCallMapperFunction() {
        //Arrange
        when(trainingParticipationMapper.trainingParticipationsToTrainingParticipationDTOs(trainingParticipationList)).thenReturn(trainingParticipationDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(trainingParticipationList);
        //Assert
        Mockito.verify(trainingParticipationMapper).trainingParticipationsToTrainingParticipationDTOs(trainingParticipationList);
        Assertions.assertEquals(trainingParticipationDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(trainingParticipationMapper.trainingParticipationDTOsToTrainingParticipations(trainingParticipationDTOList)).thenReturn(trainingParticipationList);
        //Act
        var returnedValue = sut.DTOsToEntities(trainingParticipationDTOList);
        //Assert
        Mockito.verify(trainingParticipationMapper).trainingParticipationDTOsToTrainingParticipations(trainingParticipationDTOList);
        Assertions.assertEquals(trainingParticipationList, returnedValue);
    }

    @Test
    void readAllEmployees() {
        //Arrange
        when(trainingParticipationRepository.findAllByEmployeeId(1)).thenReturn(trainingParticipationList);
        //Act
        var returnedValue = sut.readAllEmployee(1);
        //
        Mockito.verify(trainingParticipationRepository).findAllByEmployeeId(1);
        Assertions.assertEquals(trainingParticipationList, returnedValue);
    }
}
