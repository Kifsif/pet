package gift.academic.pet.controllers;

import gift.academic.pet.dtos.UserDto;
import gift.academic.pet.exceptions.UnauthorizedException;
import gift.academic.pet.services.UserResponseManager;
import gift.academic.pet.models.User;
import gift.academic.pet.repositories.UserRepository;
import gift.academic.pet.validators.UserValidator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value="/api/users", consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserRepository userRepository;
    private final UserResponseManager userResponseManager;
    private final UserValidator userValidator;

    public UserController(UserRepository userRepository, UserResponseManager userResponseManager, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userResponseManager = userResponseManager;
        this.userValidator = userValidator;
    }

    @GetMapping({"/{id}", "/{id}/"})
    public Map<String, Map<String, List<UserDto>>> getUser(@RequestHeader(value="Authorization") String aurhorization,
                                                           @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UnauthorizedException());
        userValidator.validateUser(user, "d");

        var response = userResponseManager.getUserDetail(user);
        return response;
    }
}
