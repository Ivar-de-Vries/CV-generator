package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CertificateDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty ("name")
    private String name;

    @JsonProperty ("courseName")
    private String courseName;

    @JsonProperty ("acquired")
    private LocalDate acquired;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getAcquired() {
        return acquired;
    }

    public void setAcquired(LocalDate acquired) {
        this.acquired = acquired;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
