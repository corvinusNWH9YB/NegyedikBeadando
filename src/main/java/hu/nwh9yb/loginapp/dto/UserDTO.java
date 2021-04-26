package hu.nwh9yb.loginapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
    @NotEmpty
    String fullName;
    @NotEmpty @Size(min = 6, message = "Username min 6 character!")
    String username;
    @NotEmpty
    String password;
}