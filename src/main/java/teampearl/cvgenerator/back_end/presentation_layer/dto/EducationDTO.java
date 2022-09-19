package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EducationDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("instituteId")
    private InstituteDTO instituteId;

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

    public InstituteDTO getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(InstituteDTO instituteId) {
        this.instituteId = instituteId;
    }
}
