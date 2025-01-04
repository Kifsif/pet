//package gift.academic.pet.security;
//
//
//import gift.academic.pet.models.User;
//import gift.academic.pet.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        // Find the user by email
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//
//        // Create a collection of authorities. Adjust as needed (roles, permissions, etc.)
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
//
//        // Return a CustomUserDetails object
//        return new CustomUserDetails(user.getEmail(), user.getPassword(),
//                user.getConfirm(), Collections.singletonList(authority));
//    }
//}