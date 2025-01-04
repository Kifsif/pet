package gift.academic.pet.services;

import gift.academic.pet.dtos.UserDto;
import gift.academic.pet.exceptions.UserNotFoundException;
import gift.academic.pet.models.User;
import gift.academic.pet.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResponseManager {

    private final UserRepository userRepository;

    public ResponseManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, Map<String, List<UserDto>>> getUserResponse(int id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());

        List<UserDto> userList = new ArrayList();
        userList.add(new UserDto(user));

        Map<String, List<UserDto>> userMap = new HashMap<>();
        userMap.put("user", userList);

        Map<String, Map<String, List<UserDto>>> response = new HashMap<>();
        response.put("data", userMap);

        return response;
    }

    public Map<String, Map<String, String>> getLoginResponse(){
        Map<String, String> token = new HashMap<>();
        token.put("token", "tokenBody");

        Map<String, Map<String, String>> response = new HashMap<>();
        response.put("data", token);

        return response;
    }

}
