package technobel.bart.sandwichspring.service.mapper;

import org.springframework.stereotype.Service;
import technobel.bart.sandwichspring.models.dto.SandwichDTO;
import technobel.bart.sandwichspring.models.dto.UserDTO;
import technobel.bart.sandwichspring.models.entity.User;
import technobel.bart.sandwichspring.models.form.user.RegisterForm;

@Service
public class UserMapper {
    public User toEntity(RegisterForm form){
        if( form == null )
            return null;

        User user = new User();

        user.setEmail( form.getEmail() );
        user.setPassword( form.getPassword() );
        user.setFirstName( form.getFirstName() );
        user.setLastName( form.getLastName() );
        user.setBirthDate( form.getBirthDate() );

        return user;
    }
}
