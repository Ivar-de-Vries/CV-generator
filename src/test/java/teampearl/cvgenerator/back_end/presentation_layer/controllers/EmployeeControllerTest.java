package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Employee;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.EmployeeRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EmployeeDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.EmployeeMapper;

import static org.mockito.Mockito.*;

class EmployeeControllerTest {
    EmployeeController sut;
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    EmployeeDTO employeeDTO;
    Employee employeeEntity;

    @BeforeEach
    void setUp() {
        employeeDTO = mock(EmployeeDTO.class);
        employeeEntity = mock(Employee.class);
        employeeRepository = mock(EmployeeRepository.class);
        employeeMapper = mock(EmployeeMapper.class);
        sut = new EmployeeController(employeeRepository, employeeMapper);
    }

    @Test
    void dtoToEntityShouldCallMapperFunction() {
        //Arrange
        when(employeeMapper.employeeDTOToEmployee(employeeDTO)).thenReturn(employeeEntity);
        //Act
        sut.dtoToEntity(employeeDTO);
        //Assert
        Mockito.verify(employeeMapper).employeeDTOToEmployee(employeeDTO);
    }

    @Test
    void entityToDtoShouldCallMapperFunction() {
        //Arrange
        when(employeeMapper.employeeToEmployeeDTO(employeeEntity)).thenReturn(employeeDTO);
        //Act
        sut.entityToDTO(employeeEntity);
        //Assert
        Mockito.verify(employeeMapper).employeeToEmployeeDTO(employeeEntity);
    }
}
