package hu.nwh9yb.loginapp.controller;

import hu.nwh9yb.loginapp.dto.UserDTO;
import hu.nwh9yb.loginapp.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final ILoginService loginService;

    /**
     * User regisztráció
     *
     * @param user regisztrálni kívánó user
     * @return regisztrálni kívánt user
     */
    @PostMapping("/register")     // POST Method for Create operation
    public String register(@Valid @RequestBody UserDTO user) {
        return loginService.register(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody String userName,
            @RequestBody String password)
            throws AuthenticationException {

        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
            throw new AuthenticationException("Username and password cannot be empty!");
        }
        return loginService.login(userName, password);

    }
}
