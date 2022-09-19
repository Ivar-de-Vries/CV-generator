package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Job;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.JobRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.JobDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.JobMapper;

import java.util.List;

import static org.mockito.Mockito.*;

class JobControllerTest {
    JobController sut;
    JobRepository jobRepository;
    JobMapper jobMapper;
    JobDTO jobDTO;
    Job jobEntity;
    List<Job> jobList;
    List<JobDTO> jobDTOList;

    @BeforeEach
    void setup(){
        jobDTO = mock(JobDTO.class);
        jobEntity = mock(Job.class);
        jobRepository = mock(JobRepository.class);
        jobMapper = mock(JobMapper.class);
        sut = new JobController(jobRepository, jobMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(jobMapper.jobDTOtoJob(jobDTO)).thenReturn(jobEntity);
        //Act
        var returnedValue = sut.dtoToEntity(jobDTO);
        //Assert
        Mockito.verify(jobMapper).jobDTOtoJob(jobDTO);
        Assertions.assertEquals(jobEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(jobMapper.jobToJobDTO(jobEntity)).thenReturn(jobDTO);
        //Act
        var returnedValue = sut.entityToDTO(jobEntity);
        //Assert
        Mockito.verify(jobMapper).jobToJobDTO(jobEntity);
        Assertions.assertEquals(jobDTO, returnedValue);
    }

    @Test
    void entitiesToDTOsShouldCallMapperFunction() {
        //Arrange
        when(jobMapper.jobsToJobsDTOs(jobList)).thenReturn(jobDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(jobList);
        //Assert
        Mockito.verify(jobMapper).jobsToJobsDTOs(jobList);
        Assertions.assertEquals(jobDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(jobMapper.jobDTOsToJobs(jobDTOList)).thenReturn(jobList);
        //Act
        var returnedValue = sut.DTOsToEntities(jobDTOList);
        //Assert
        Mockito.verify(jobMapper).jobDTOsToJobs(jobDTOList);
        Assertions.assertEquals(jobList, returnedValue);
    }

    @Test
    void readAllEmployees() {
        //Arrange
        when(jobRepository.findAllByEmployeeId(1)).thenReturn(jobList);
        //Act
        var returnedValue = sut.readAllEmployee(1);
        //
        Mockito.verify(jobRepository).findAllByEmployeeId(1);
        Assertions.assertEquals(jobList, returnedValue);
    }
}