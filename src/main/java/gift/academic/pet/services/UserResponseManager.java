package gift.academic.pet.services;

import gift.academic.pet.dtos.UserDto;
import gift.academic.pet.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserResponseManager {
    public Map<String, Map<String, List<UserDto>>> getUserDetail(User user) {

        List<User> users = new ArrayList<>();
        users.add(user);

        List<UserDto> userDtos = users.stream().map(aUser -> {
            return new UserDto(aUser);
        }).toList();


        Map<String, Map<String, List<UserDto>>> response = new HashMap<>();
        Map<String, List<UserDto>> result = new HashMap<>();
        result.put("user", userDtos);


        response.put("data", result);

        return response;
    }
}
