package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.Role;
import teampearl.cvgenerator.back_end.presentation_layer.dto.RoleDTO;

@Mapper(
        componentModel = "spring"
)
public interface RoleMapper {
    RoleDTO roleToRoleDTO(Role role);
}
