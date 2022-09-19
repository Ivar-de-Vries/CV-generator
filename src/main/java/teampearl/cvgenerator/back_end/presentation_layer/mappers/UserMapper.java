package teampearl.cvgenerator.back_end.presentation_layer.mappers;

import org.mapstruct.Mapper;
import teampearl.cvgenerator.back_end.data_access_layer.entities.User;
import teampearl.cvgenerator.back_end.presentation_layer.dto.UserDTO;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
