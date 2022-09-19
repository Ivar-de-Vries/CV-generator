package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Training;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.TrainingRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.TrainingDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.TrainingMapper;

import java.util.List;

import static org.mockito.Mockito.*;

class TrainingControllerTest {
    TrainingController sut;
    TrainingRepository trainingRepository;
    TrainingMapper trainingMapper;
    TrainingDTO trainingDTO;
    Training trainingEntity;
    List<Training> trainingList;
    List<TrainingDTO> trainingDTOList;

    @BeforeEach
    void setUp() {
        trainingDTO = mock(TrainingDTO.class);
        trainingEntity = mock(Training.class);
        trainingList = List.of(trainingEntity);
        trainingDTOList = List.of(trainingDTO);
        trainingRepository = mock(TrainingRepository.class);
        trainingMapper = mock(TrainingMapper.class);
        sut = new TrainingController(trainingRepository, trainingMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(trainingMapper.trainingDTOToTraining(trainingDTO)).thenReturn(trainingEntity);
        //Act
        var returnedValue = sut.dtoToEntity(trainingDTO);
        //Assert
        Mockito.verify(trainingMapper).trainingDTOToTraining(trainingDTO);
        Assertions.assertEquals(trainingEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(trainingMapper.trainingToTrainingDTO(trainingEntity)).thenReturn(trainingDTO);
        //Act
        var returnedValue = sut.entityToDTO(trainingEntity);
        //Assert
        Mockito.verify(trainingMapper).trainingToTrainingDTO(trainingEntity);
        Assertions.assertEquals(trainingDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(trainingMapper.trainingsToTrainingDTOs(trainingList)).thenReturn(trainingDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(trainingList);
        //Assert
        Mockito.verify(trainingMapper).trainingsToTrainingDTOs(trainingList);
        Assertions.assertEquals(trainingDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(trainingMapper.trainingDTOsToTrainings(trainingDTOList)).thenReturn(trainingList);
        //Act
        var returnedValue = sut.DTOsToEntities(trainingDTOList);
        //Assert
        Mockito.verify(trainingMapper).trainingDTOsToTrainings(trainingDTOList);
        Assertions.assertEquals(trainingList, returnedValue);
    }
}