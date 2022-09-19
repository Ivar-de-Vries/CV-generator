package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import teampearl.cvgenerator.back_end.presentation_layer.exceptions.DateIsInFutureException;

import java.time.LocalDate;

public class TrainingParticipationDTO extends Participation{
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    @JsonProperty("training")
    private TrainingDTO training;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public TrainingDTO getTraining() {
        return training;
    }

    public void setTraining(TrainingDTO training) {
        this.training = training;
    }

}
