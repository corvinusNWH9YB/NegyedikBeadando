package hu.nwh9yb.loginapp.service;

import hu.nwh9yb.loginapp.dao.UserEntity;
import hu.nwh9yb.loginapp.dao.UserRepository;
import hu.nwh9yb.loginapp.dto.UserDTO;
import hu.nwh9yb.loginapp.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl  implements ILoginService{
    private final UserRepository userRepository;

    @Override
    public UserDTO register(UserDTO user) {
        if(userRepository.findUserEntityByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistsException(user.getUsername());
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setFullName(user.getFullName());
        userRepository.save(userEntity);
        return user;
    }
}
