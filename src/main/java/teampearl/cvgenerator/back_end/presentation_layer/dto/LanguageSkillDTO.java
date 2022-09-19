package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LanguageSkillDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("value")
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
