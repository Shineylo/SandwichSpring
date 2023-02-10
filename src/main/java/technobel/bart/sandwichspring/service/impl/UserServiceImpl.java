package technobel.bart.sandwichspring.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.repository.UserRepository;
import technobel.bart.sandwichspring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean checkEmailNotTaken(String email){
        return !userRepository.existsByEmail(email);
    }
}
