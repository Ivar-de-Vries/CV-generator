package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Institute;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.InstituteRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.InstituteDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.InstituteMapper;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.InstituteMapperImpl;

import java.util.List;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {
        InstituteMapperImpl.class
})
@SpringBootTest
class InstituteControllerTest {
    InstituteController sut;
    InstituteRepository instituteRepository;
    InstituteMapper instituteMapper;
    InstituteDTO instituteDTO;
    Institute instituteEntity;
    List<Institute> instituteList;
    List<InstituteDTO> instituteDTOList;
    
    @BeforeEach
    void setUp() {
        instituteDTO = mock(InstituteDTO.class);
        instituteEntity = mock(Institute.class);
        instituteList = List.of(instituteEntity);
        instituteDTOList = List.of(instituteDTO);
        instituteRepository = mock(InstituteRepository.class);
        instituteMapper = mock(InstituteMapper.class);
        sut = new InstituteController(instituteRepository, instituteMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(instituteMapper.instituteDTOtoInstitute(instituteDTO)).thenReturn(instituteEntity);
        //Act
        var returnedValue = sut.dtoToEntity(instituteDTO);
        //Assert
        Mockito.verify(instituteMapper).instituteDTOtoInstitute((instituteDTO));
        Assertions.assertEquals(instituteEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(instituteMapper.instituteToInstituteDTO(instituteEntity)).thenReturn(instituteDTO);
        //Act
        var returnedValue = sut.entityToDTO(instituteEntity);
        //Assert
        Mockito.verify(instituteMapper).instituteToInstituteDTO(instituteEntity);
        Assertions.assertEquals(instituteDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(instituteMapper.institutesToInstituteDTOs(instituteList)).thenReturn(instituteDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(instituteList);
        //Assert
        Mockito.verify(instituteMapper).institutesToInstituteDTOs(instituteList);
        Assertions.assertEquals(instituteDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(instituteMapper.instituteDTOstoInstitutes(instituteDTOList)).thenReturn(instituteList);
        //Act
        var returnedValue = sut.DTOsToEntities(instituteDTOList);
        //Assert
        Mockito.verify(instituteMapper).instituteDTOstoInstitutes(instituteDTOList);
        Assertions.assertEquals(instituteList, returnedValue);
    }
}