package gift.academic.pet.controllers;


import gift.academic.pet.dtos.UserDto;

import gift.academic.pet.dtos.UserRegistrationDto;
import gift.academic.pet.exceptions.UserNotFoundException;
import gift.academic.pet.exceptions.UserRegistrationValidationException;
import gift.academic.pet.models.User;

import gift.academic.pet.repositories.UserRepository;
import gift.academic.pet.services.ErrorResponseManager;
import gift.academic.pet.services.ResponseManager;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api"
        ,
                consumes = MediaType.APPLICATION_JSON_VALUE
)
public class UserController {

    private final ResponseManager responseManager;
    private final ErrorResponseManager errorResponseManager;
    private final UserRepository userRepository;

    public UserController(ResponseManager responseManager, ErrorResponseManager errorResponseManager, UserRepository userRepository) {
        this.responseManager = responseManager;
        this.errorResponseManager = errorResponseManager;
        this.userRepository = userRepository;
    }


    @GetMapping({"/users/{id}", "/users/{id}/"})
    public Map<String, Map<String, List<UserDto>>> getUser(@PathVariable Integer id) throws UserNotFoundException {
        // Информация о пользователе

        var response = responseManager.getUserResponse(id);

        return response;
    }

    @PatchMapping({"/users/{id}/phone", "/users/{id}/phone/"})
    public User updatePhone(@PathVariable Integer id) {
        // Изменение номера телефона


        return null;
    }


    @PostMapping({"/register", "/register"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void registerUsre(@Valid @RequestBody UserRegistrationDto userRegistrationDto,
             BindingResult bindingResult) throws UserRegistrationValidationException {

        // Запрос для регистрации нового пользователя в системе.

        if (bindingResult.hasErrors()) {

            throw new UserRegistrationValidationException(bindingResult);
        }

        User user = new User(userRegistrationDto);
        userRepository.save(user);
    }
}
