package hu.nwh9yb.loginapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
    @NotEmpty
    String fullName;
    @NotEmpty @Size(min = 6, message = "Username min 6 characters!")
    String username;
    @NotEmpty
    @Size(min = 8, message = "password min 8 character!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z A-Z]).*$", message = "Password must contains numbers and letters too!")
    String password;
}