package teampearl.cvgenerator.back_end.presentation_layer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teampearl.cvgenerator.back_end.data_access_layer.entities.User;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.UserRepository;
import teampearl.cvgenerator.back_end.presentation_layer.dto.UserDTO;
import teampearl.cvgenerator.back_end.presentation_layer.mappers.UserMapper;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    UserMapper userMapper;
    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping("/{emailAddress}")
    public ResponseEntity<UserDTO> getUserByEmailAddress(@PathVariable String emailAddress){
        User user = findUser(emailAddress);
        UserDTO userDTO = userMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{emailAddress}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable String emailAddress) {
        User user = findUser(emailAddress);
        user.setEmployee(userMapper.userDTOToUser(userDTO).getEmployee());
        user = userRepository.save(user);
        userDTO = userMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{emailAddress}/resetEmployee")
    public ResponseEntity<UserDTO> updateEmployeeIdInUser(@RequestBody UserDTO userDTO, @PathVariable String emailAddress) {
        User user = findUser(emailAddress);
        user.setEmployee(null);
        user = userRepository.save(user);
        userDTO = userMapper.userToUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    private User findUser(String emailAddress){
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);
        user.orElseThrow(() -> new EntityNotFoundException("E-mailaddress not found: " + emailAddress));
        return user.get();
    }
}
