package technobel.bart.sandwichspring.service.impl;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.exception.EmailAlreadyTakenException;
import technobel.bart.sandwichspring.models.entity.User;
import technobel.bart.sandwichspring.models.form.user.RegisterForm;
import technobel.bart.sandwichspring.repository.UserRepository;
import technobel.bart.sandwichspring.service.AuthService;
import technobel.bart.sandwichspring.service.mapper.UserMapper;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void register(RegisterForm form) {

        if( userRepository.existsByEmail(form.getEmail()) )
            throw new EmailAlreadyTakenException();

        User user = userMapper.toEntity(form);
        user.setRole("CUSTOMER");

        userRepository.save( user );

    }

}
