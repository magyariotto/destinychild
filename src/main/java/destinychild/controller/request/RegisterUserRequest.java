package destinychild.controller.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterUserRequest {
    @NotNull
    @Size(min = 5, max = 15)
    private String userName;

    @NotNull
    @Size(min = 5, max = 15)
    private String password;

    @NotNull
    @Email
    @Size(min = 1)
    private String email;
}