package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Company;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.CompanyRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.CompanyDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.CompanyMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompanyControllerTest {
    CompanyController sut;
    CompanyRepository companyRepository;
    CompanyMapper companyMapper;
    CompanyDTO companyDTO;
    Company companyEntity;
    List<Company> companyList;
    List<CompanyDTO> companyDTOList;

    @BeforeEach
    void setup(){
        companyDTO = mock(CompanyDTO.class);
        companyEntity = mock(Company.class);
        companyRepository = mock(CompanyRepository.class);
        companyMapper = mock(CompanyMapper.class);
        sut = new CompanyController(companyRepository, companyMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(companyMapper.companyDTOToCompany(companyDTO)).thenReturn(companyEntity);
        //Act
        var returnedValue = sut.dtoToEntity(companyDTO);
        //Assert
        Mockito.verify(companyMapper).companyDTOToCompany(companyDTO);
        Assertions.assertEquals(companyEntity, returnedValue);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(companyMapper.companyToCompanyDTO(companyEntity)).thenReturn(companyDTO);
        //Act
        var returnedValue = sut.entityToDTO(companyEntity);
        //Assert
        Mockito.verify(companyMapper).companyToCompanyDTO(companyEntity);
        Assertions.assertEquals(companyDTO, returnedValue);
    }

    @Test
    void entitiesToDTOsShouldCallMapperFunction() {
        //Arrange
        when(companyMapper.companiesToCompanyDTOs(companyList)).thenReturn(companyDTOList);
        //Act
        var returnedValue = sut.entitiesToDTOs(companyList);
        //Assert
        Mockito.verify(companyMapper).companiesToCompanyDTOs(companyList);
        Assertions.assertEquals(companyDTOList, returnedValue);
    }

    @Test
    void DTOsToEntitiesShouldCallMapperFunction() {
        //Arrange
        when(companyMapper.companyDTOsToCompanies(companyDTOList)).thenReturn(companyList);
        //Act
        var returnedValue = sut.DTOsToEntities(companyDTOList);
        //Assert
        Mockito.verify(companyMapper).companyDTOsToCompanies(companyDTOList);
        Assertions.assertEquals(companyList, returnedValue);
    }
}