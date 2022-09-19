package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Company;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Employee;

import java.time.LocalDate;


public class JobDTO extends Participation{
    @JsonProperty("id")
    private int id;

    @JsonProperty("company")
    private CompanyDTO company;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    @JsonProperty("function")
    private String function;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
