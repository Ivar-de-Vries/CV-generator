package teampearl.cvgenerator.back_end.presentation_layer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoleDTO {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("role")
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
