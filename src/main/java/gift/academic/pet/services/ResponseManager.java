package gift.academic.pet.services;

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

    public Map<String, Map<String, List<User>>> getUserResponse(int id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());

        List<User> userList = new ArrayList();
        userList.add(user);

        Map<String, List<User>> userMap = new HashMap<>();
        userMap.put("user", userList);

        Map<String, Map<String, List<User>>> response = new HashMap<>();
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

    public Map<String, Map<String, Object>> getOkStatus(){
        Map<String, Object> status = new HashMap<>();
        status.put("status", "ok");

        Map<String, Map<String, Object>> response = new HashMap<>();
        response.put("data", status);

        return response;
    }

    public Map<String, Map<String, Object>> getOkWithIdStatus(int id){
        Map<String, Map<String, Object>> response = getOkStatus();

        response.get("data").put("id", id);
        return response;
    }
}
