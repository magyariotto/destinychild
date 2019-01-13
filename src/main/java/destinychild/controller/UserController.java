package destinychild.controller;

import com.github.saphyra.encryption.impl.PasswordService;
import destinychild.controller.request.OneStringParamRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import destinychild.controller.request.RegisterUserRequest;
import destinychild.domain.MsUser;
import destinychild.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @PostMapping("/user/name/exist")
    public ResponseEntity<Void> isUserNameExist(@RequestBody OneStringParamRequest request){
        Optional<MsUser> userOptional = userRepository.findByUserName(request.getValue());

        ResponseEntity<Void> responseEntity;
        if(userOptional.isPresent()){
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        }else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody RegisterUserRequest request){
        MsUser msUser = new MsUser();
        msUser.setUserName(request.getUserName());
        msUser.setPassword(passwordService.hashPassword(request.getPassword()));
        msUser.setEmail(request.getEmail());
        msUser.setTp("a:2:{i:0;i:0;i:1;i:0;}");
        msUser.setSzint("0");
        MsUser registeredUser = userRepository.save(msUser);

        log.info("Registered user: {}", registeredUser);
    }

    @GetMapping("/user")
    public List<MsUser> getUser(){
        return userRepository.findAll();
    }
}