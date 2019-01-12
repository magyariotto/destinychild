package destinychild.controller.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegisterUserRequest {
    @NotNull
    private String userName;

    @NotNull
    private String password;
}