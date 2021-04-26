package hu.nwh9yb.loginapp.service;

import hu.nwh9yb.loginapp.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface ILoginService {
    UserDTO register(UserDTO user);
}
