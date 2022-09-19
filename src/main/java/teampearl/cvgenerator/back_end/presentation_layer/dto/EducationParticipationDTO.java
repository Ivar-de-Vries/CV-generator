package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class EducationParticipationDTO extends Participation{
    @JsonProperty("id")
    private int id;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    @JsonProperty("education")
    private EducationDTO education;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public EducationDTO getEducation() {
        return education;
    }

    public void setEducation(EducationDTO education) {
        this.education = education;
    }

}
