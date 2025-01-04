package gift.academic.pet.services;

import gift.academic.pet.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    private final UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String selectOrGenerateToken(){
        return "ddd";
    }
}
