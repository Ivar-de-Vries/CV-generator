package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Employee;

public class SkillLevelDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("employee")
    private EmployeeDTO employee;

    @JsonProperty("skill")
    private SkillDTO skill;

    @JsonProperty("score")
    private int score;

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

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
