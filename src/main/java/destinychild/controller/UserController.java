package destinychild.controller;

import com.github.saphyra.encryption.impl.PasswordService;
import com.github.saphyra.exceptionhandling.exception.NotFoundException;
import destinychild.auth.PropertySourceImpl;
import destinychild.controller.request.OneStringParamRequest;
import destinychild.controller.request.RegisterUserRequest;
import destinychild.controller.request.SolarCoordinateRequest;
import destinychild.controller.view.FullSolarView;
import destinychild.controller.view.SolarView;
import destinychild.controller.view.UserView;
import destinychild.domain.MsUser;
import destinychild.domain.SolarSystem;
import destinychild.generator.coordinateGenerator;
import destinychild.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final SolarSystemRepository solarSystemRepository;
    private final PasswordService passwordService;
    private final CoordinateGeneratorRepository coordinateGeneratorRepository;
    private final CoordinateRepository coordinateRepository;
    private final CoordinateFullRepository coordinateFullRepository;

    @GetMapping("/user")
    public UserView getUser(@CookieValue(PropertySourceImpl.COOKIE_USER_ID) Long userId) {
        Optional<MsUser> userOptional = userRepository.findById(userId);
        return userOptional.map(msUser -> UserView.builder()
                .id(msUser.getId())
                .userName(msUser.getUserName())
                .email(msUser.getEmail())
                .tp(msUser.getTp())
                .planetNumber(msUser.getPlanetNumber())
                .build()
        ).orElseThrow(() -> new NotFoundException("User not found wih id " + userId));
    }
    @GetMapping("/solar")
    public List<SolarView> getSolar(@CookieValue(PropertySourceImpl.COOKIE_USER_ID) Long userId) {
        List<SolarSystem> coordinateOptional = coordinateRepository.findByuserId(userId);
        return coordinateOptional.stream().map(solarSystem -> SolarView.builder()
                .coordinateFull(solarSystem.getCoordinateFull())
                .build()
        ).collect(Collectors.toList());
    }
    @GetMapping("/fullsolar")
    public List<FullSolarView> getFullSolar() {
        List<SolarSystem> fullcoordinateOptional = coordinateFullRepository.findAll();
        return fullcoordinateOptional.stream().map(solarSystem -> FullSolarView.builder()
                .coordinateFull(solarSystem.getCoordinateFull())
                .build()
        ).collect(Collectors.toList());
    }
    @GetMapping("returnfound")
    public List<FullSolarView> getReturnSolarList() {
        List<SolarSystem> returnList = solarSystemRepository.
                findByCoordinateUniverseAndCoordinateSystem(1,302);
        return returnList.stream().map(solarSystem -> FullSolarView.builder()
                .coordinateFull(solarSystem.getCoordinateFull())
                .build()
        ).collect(Collectors.toList());
    }

    @PostMapping("fullsolarsearch")
    public List<FullSolarView> solarquery(@RequestBody SolarCoordinateRequest request){
        List<SolarSystem> universenumberAndSystemnumberList = solarSystemRepository.
                findByCoordinateUniverseAndCoordinateSystem(request.getUniversenumber(),request.getSystemnumber());
        return universenumberAndSystemnumberList.stream().map(solarSystem -> FullSolarView.builder()
            .coordinateFull(solarSystem.getCoordinateFull())
            .build()
        ).collect(Collectors.toList());
    }
    @PostMapping("/user/name/exist")
    public ResponseEntity<Void> isUserNameExist(@RequestBody OneStringParamRequest request) {
        Optional<MsUser> userOptional = userRepository.findByUserName(request.getValue());

        ResponseEntity<Void> responseEntity;
        if (userOptional.isPresent()) {
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return responseEntity;
    }

    @PostMapping("/register")
    public void registerUser(@Valid @RequestBody RegisterUserRequest request) {
        MsUser msUser = new MsUser();
        msUser.setUserName(request.getUserName());
        msUser.setPassword(passwordService.hashPassword(request.getPassword()));
        msUser.setEmail(request.getEmail());
        msUser.setTp("a:2:{i:0;i:0;i:1;i:0;}");
        msUser.setNyersanyagok("a:5:{i:0;i:20000;i:1;i:15000;i:2;i:10000;i:3;i:5000;i:4;i:0;}");
        msUser.setSzovetseg("a:2:{i:0;i:0;i:1;i:0;}");
        msUser.setPlanetNumber("1");
        MsUser registeredUser = userRepository.save(msUser);

        coordinateGenerator generator = new coordinateGenerator();
        String coordFull = "";
        Integer primarysystemrandom = 0;
        Integer primaryplantnumberrandom = 0;
        Optional<SolarSystem> coordinateOptional;
        do{
            coordFull = generator.getCoordfull();
            primarysystemrandom = generator.getCoordsyst();
            primaryplantnumberrandom = generator.getCoordplan();
            coordinateOptional = coordinateGeneratorRepository.findByCoordinateFull(coordFull);
        }while (coordinateOptional.isPresent());

        SolarSystem solarsystem = new SolarSystem();
        solarsystem.setUserId(msUser.getId());
        solarsystem.setCoordinateFull(coordFull);
        solarsystem.setCoordinateUniverse(1);
        solarsystem.setCoordinateSystem(primarysystemrandom);
        solarsystem.setCoordinatePlanetnumber(primaryplantnumberrandom);

        SolarSystem registeredPlanet = solarSystemRepository.save(solarsystem);


        log.info("Registered user: {}", registeredUser);
        log.info("Registered user: {}", registeredPlanet);

    }
}