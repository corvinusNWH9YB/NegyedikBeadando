package hu.nwh9yb.loginapp.service;

import hu.nwh9yb.loginapp.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface ILoginService {
    String register(UserDTO user);
    String login(String userName, String password);
}
