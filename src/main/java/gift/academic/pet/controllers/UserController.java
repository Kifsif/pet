package gift.academic.pet.controllers;


import gift.academic.pet.dtos.EmailDto;
import gift.academic.pet.dtos.LoginDto;
import gift.academic.pet.dtos.PhoneDto;
import gift.academic.pet.exceptions.UserNotFoundException;
import gift.academic.pet.exceptions.ValidationException;
import gift.academic.pet.models.User;
import gift.academic.pet.repositories.UserRepository;
import gift.academic.pet.services.ErrorResponseManager;
import gift.academic.pet.services.ResponseManager;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public Map<String, Map<String, List<User>>> getUser(@PathVariable Integer id) throws UserNotFoundException {
        // Информация о пользователе

        var response = responseManager.getUserResponse(id);

        return response;
    }

    @PatchMapping({"/users/{id}/phone", "/users/{id}/phone/"})
    public Map<String, Map<String, String>> updatePhone(@Valid @RequestBody PhoneDto phoneDto,
                                                        BindingResult bindingResult,
                                                        @PathVariable Integer id) throws UserNotFoundException,
            ValidationException {
        // Изменение номера телефона

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        user.setPhone(phoneDto.getPhone());
        userRepository.save(user);

        return responseManager.getOkStatus();
    }

    @PatchMapping({"/users/{id}/email", "/users/{id}/email/"})
    public Map<String, Map<String, String>> updateEmail(@Valid @RequestBody EmailDto emailDto,
                                                        BindingResult bindingResult,
                                                        @PathVariable Integer id) throws UserNotFoundException,
            ValidationException {
        // Изменение адреса электронной почты

        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        user.setEmail(emailDto.getEmail());
        userRepository.save(user);

        return responseManager.getOkStatus();
    }


    @PostMapping({"/register", "/register"})
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void registerUser(@Valid @RequestBody User user,
             BindingResult bindingResult) throws ValidationException {

        // Запрос для регистрации нового пользователя в системе.

        if (bindingResult.hasErrors()) {

            throw new ValidationException(bindingResult);
        }

        userRepository.save(user);
    }

    @PostMapping({"/login", "/login/"})
    public Map<String, Map<String, String>> login(@Valid @RequestBody LoginDto loginDto){



        Map<String, Map<String, String>> result = responseManager.getLoginResponse();
        return result;
    }
}
