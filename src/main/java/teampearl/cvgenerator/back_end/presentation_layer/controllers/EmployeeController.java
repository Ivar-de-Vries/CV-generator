package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Employee;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.EmployeeRepository;
import teampearl.cvgenerator.back_end.presentation_layer.controllers.abstract_controllers.AbstractController;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.EmployeeMapper;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EmployeeDTO;

@RestController
@RequestMapping("/cv")
public class EmployeeController extends AbstractController<Employee, EmployeeDTO> {
    EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper){
        super(employeeRepository);
        this.employeeMapper = employeeMapper;
    }

    @Override
    protected Employee dtoToEntity(EmployeeDTO employeeDTO) {
        return employeeMapper.employeeDTOToEmployee(employeeDTO);
    }

    @Override
    protected EmployeeDTO entityToDTO(Employee employee) {
        return employeeMapper.employeeToEmployeeDTO(employee);
    }
}
