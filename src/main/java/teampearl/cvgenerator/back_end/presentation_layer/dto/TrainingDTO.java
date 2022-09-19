package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrainingDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("instituteId")
    private InstituteDTO institute;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InstituteDTO getInstitute() {
        return institute;
    }

    public void setInstitute(InstituteDTO institute) {
        this.institute = institute;
    }
}
