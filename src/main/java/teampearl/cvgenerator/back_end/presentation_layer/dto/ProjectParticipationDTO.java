package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class ProjectParticipationDTO extends Participation {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    @JsonProperty("project")
    private ProjectDTO project;

    @JsonProperty("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO projectId) {
        this.project = projectId;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employeeId) {
        this.employee = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
