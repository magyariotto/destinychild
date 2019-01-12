package destinychild.controller;

import com.github.saphyra.encryption.impl.PasswordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import destinychild.controller.request.RegisterUserRequest;
import destinychild.domain.MsUser;
import destinychild.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordService passwordService;


    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody RegisterUserRequest request){
        MsUser msUser = new MsUser();
        msUser.setUserName(request.getUserName());
        msUser.setPassword(passwordService.hashPassword(request.getPassword()));
        MsUser registeredUser = userRepository.save(msUser);
        log.info("Registered user: {}", registeredUser);
    }

    @GetMapping("/user")
    public List<MsUser> getUser(){
        return userRepository.findAll();
    }
}