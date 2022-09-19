package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Certificate;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.CertificateRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.CertificateDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.CertificateMapper;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CertificateControllerTest {
    CertificateController sut;
    CertificateRepository certificateRepository;
    CertificateMapper certificateMapper;
    CertificateDTO certificateDTO;
    Certificate certificateEntity;
    List<Certificate> certificateList;
    List<CertificateDTO> certificateDTOList;

    @BeforeEach
    void setUp() {
        certificateDTO = mock(CertificateDTO.class);
        certificateEntity = mock(Certificate.class);
        certificateList = List.of(certificateEntity);
        certificateDTOList = List.of(certificateDTO);
        certificateRepository = mock(CertificateRepository.class);
        certificateMapper = mock(CertificateMapper.class);
        sut = new CertificateController(certificateRepository, certificateMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(certificateMapper.certificateDTOtoCertificate(certificateDTO)).thenReturn(certificateEntity);
        //Act
        var returnedValue = sut.dtoToEntity(certificateDTO);
        //Assert
        Mockito.verify(certificateMapper).certificateDTOtoCertificate(certificateDTO);
        Assertions.assertEquals(certificateEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(certificateMapper.certificateToCertificateDTO(certificateEntity)).thenReturn(certificateDTO);
        //Act
        var returnedValue = sut.entityToDTO(certificateEntity);
        //Assert
        Mockito.verify(certificateMapper).certificateToCertificateDTO(certificateEntity);
        Assertions.assertEquals(certificateDTO, returnedValue);
    }

    @Test
    void entitiesToDtosShouldCallMapperFunction() {
        //Arrange
        when(certificateMapper.certificatesToCertificateDTOs(certificateList)).thenReturn(certificateDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(certificateList);
        //Assert
        Mockito.verify(certificateMapper).certificatesToCertificateDTOs(certificateList);
        Assertions.assertEquals(certificateDTOList, returnedValue);
    }

    @Test
    void dtosToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(certificateMapper.certificateDTOsToCertificates(certificateDTOList)).thenReturn(certificateList);
        //Act
        var returnedValue = sut.DTOsToEntities(certificateDTOList);
        //Assert
        Mockito.verify(certificateMapper).certificateDTOsToCertificates(certificateDTOList);
        Assertions.assertEquals(certificateList, returnedValue);
    }

    @Test
    void readAllEmployees() {
        //Arrange
        when(certificateRepository.findAllByEmployeeId(1)).thenReturn(certificateList);
        //Act
        var returnedValue = sut.readAllEmployee(1);
        //
        Mockito.verify(certificateRepository).findAllByEmployeeId(1);
        Assertions.assertEquals(certificateList, returnedValue);
    }
}
