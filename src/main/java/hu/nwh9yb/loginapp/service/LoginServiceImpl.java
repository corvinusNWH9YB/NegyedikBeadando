package hu.nwh9yb.loginapp.service;

import hu.nwh9yb.loginapp.dao.UserEntity;
import hu.nwh9yb.loginapp.dao.UserRepository;
import hu.nwh9yb.loginapp.dto.UserDTO;
import hu.nwh9yb.loginapp.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl  implements ILoginService{
    private final UserRepository userRepository;

    @Override
    public String register(UserDTO user) {
        if(userRepository.findUserEntityByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistsException(user.getUsername());
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFullName(user.getFullName());
        userRepository.save(userEntity);
        return MessageFormat.format("{0} sucessfully registered with username: {1}!",user.getFullName(), user.getUsername());
    }

    @Override
    public String login(String userName, String password) {
        UserEntity userEntity = userRepository.findUserEntityByUsername(userName);
        if(userEntity.getPassword().equals(password)){
            return MessageFormat.format("Welcome {0}!", userEntity.getFullName());
        }
        throw new SecurityException("Wrong username or password!");
    }
}
