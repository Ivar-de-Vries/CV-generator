package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Project;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.ProjectRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.ProjectDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.ProjectMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProjectControllerTest {
    ProjectController sut;
    ProjectRepository projectRepository;
    ProjectMapper projectMapper;
    ProjectDTO projectDTO;
    Project projectEntity;
    List<Project> projectList;
    List<ProjectDTO> projectDTOList;

    @BeforeEach
    void setUp() {
        projectDTO = mock(ProjectDTO.class);
        projectEntity = mock(Project.class);
        projectList = List.of(projectEntity);
        projectDTOList = List.of(projectDTO);
        projectRepository = mock(ProjectRepository.class);
        projectMapper = mock(ProjectMapper.class);
        sut = new ProjectController(projectRepository, projectMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectDTOtoProject(projectDTO)).thenReturn(projectEntity);
        //Act
        var returnedValue = sut.dtoToEntity(projectDTO);
        //Assert
        Mockito.verify(projectMapper).projectDTOtoProject((projectDTO));
        Assertions.assertEquals(projectEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectToProjectDTO(projectEntity)).thenReturn(projectDTO);
        //Act
        var returnedValue = sut.entityToDTO(projectEntity);
        //Assert
        Mockito.verify(projectMapper).projectToProjectDTO(projectEntity);
        Assertions.assertEquals(projectDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectsToProjectDTOs(projectList)).thenReturn(projectDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(projectList);
        //Assert
        Mockito.verify(projectMapper).projectsToProjectDTOs(projectList);
        Assertions.assertEquals(projectDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(projectMapper.projectDTOsToProjects(projectDTOList)).thenReturn(projectList);
        //Act
        var returnedValue = sut.DTOsToEntities(projectDTOList);
        //Assert
        Mockito.verify(projectMapper).projectDTOsToProjects(projectDTOList);
        Assertions.assertEquals(projectList, returnedValue);
    }

}