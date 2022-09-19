package teampearl.cvgenerator.back_end.presentation_layer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import teampearl.cvgenerator.back_end.data_access_layer.entities.User;
import teampearl.cvgenerator.back_end.data_access_layer.repositories.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmailAddress(emailAddress);
        user.orElseThrow(() -> new UsernameNotFoundException("E-mailaddress not found: " + emailAddress));
        return user.get();
    }
}
