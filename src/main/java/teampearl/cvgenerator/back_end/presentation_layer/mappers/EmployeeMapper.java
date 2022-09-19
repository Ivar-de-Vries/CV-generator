package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Employee;
import teampearl.cvgenerator.back_end.presentation_layer.dto.EmployeeDTO;

@Mapper(
        componentModel = "spring"
)
public interface EmployeeMapper {
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
}
