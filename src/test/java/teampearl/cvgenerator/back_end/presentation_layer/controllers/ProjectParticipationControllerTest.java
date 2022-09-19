package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Project;
import teampearl.cvgenerator.back_end.data_access_layer.entities.ProjectParticipation;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.ProjectParticipationRepository;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.ProjectRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.ProjectDTO;
import teampearl.cvgenerator.back_end.presentation_layer.dto.ProjectParticipationDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.ProjectMapper;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.ProjectParticipationMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectParticipationControllerTest {
    ProjectParticipationController sut;
    ProjectParticipationRepository projectRepository;
    ProjectParticipationMapper projectMapper;
    ProjectParticipationDTO projectDTO;
    ProjectParticipation projectEntity;
    List<ProjectParticipation> projectList;
    List<ProjectParticipationDTO> projectDTOList;

    @BeforeEach
    void setUp() {
        projectDTO = mock(ProjectParticipationDTO.class);
        projectEntity = mock(ProjectParticipation.class);
        projectList = List.of(projectEntity);
        projectDTOList = List.of(projectDTO);
        projectRepository = mock(ProjectParticipationRepository.class);
        projectMapper = mock(ProjectParticipationMapper.class);
        sut = new ProjectParticipationController(projectRepository, projectMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectParticipationDTOToProjectParticipation(projectDTO)).thenReturn(projectEntity);
        //Act
        var returnedValue = sut.dtoToEntity(projectDTO);
        //Assert
        Mockito.verify(projectMapper).projectParticipationDTOToProjectParticipation((projectDTO));
        Assertions.assertEquals(projectEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectParticipationToProjectParticipationDTO(projectEntity)).thenReturn(projectDTO);
        //Act
        var returnedValue = sut.entityToDTO(projectEntity);
        //Assert
        Mockito.verify(projectMapper).projectParticipationToProjectParticipationDTO(projectEntity);
        Assertions.assertEquals(projectDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectParticipationsToProjectParticipationDTOs(projectList)).thenReturn(projectDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(projectList);
        //Assert
        Mockito.verify(projectMapper).projectParticipationsToProjectParticipationDTOs(projectList);
        Assertions.assertEquals(projectDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectParticipationDTOsToProjectParticipations(projectDTOList)).thenReturn(projectList);
        //Act
        var returnedValue = sut.DTOsToEntities(projectDTOList);
        //Assert
        Mockito.verify(projectMapper).projectParticipationDTOsToProjectParticipations(projectDTOList);
        Assertions.assertEquals(projectList, returnedValue);
    }
}