package th.ac.mahidol.ict.gemini7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.mahidol.ict.gemini7.model.User.User;
import th.ac.mahidol.ict.gemini7.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signupUser(String username, String name, String surname, String email, String password, String role) {

        boolean usernameExists = userRepository.findByUsername(username).isPresent();
        boolean emailExists = userRepository.findByEmail(email).isPresent();

        System.out.println("Username exists: " + usernameExists);
        System.out.println("Email exists: " + emailExists);

        if(username.isEmpty() || name.isEmpty() || surname.isEmpty() || password.isEmpty() || email.isEmpty() || role.isEmpty() || userRepository.findByUsername(username).isPresent() || userRepository.findByEmail(email).isPresent()){
            return null;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setName(name);
            user.setSurname(surname);
            user.setPassword(password);
            user.setEmail(email);
            user.setRole(role);
            User savedUser = userRepository.save(user);
            System.out.println("Saved user: " + savedUser);
            return savedUser;
        }
    }

    public User loginUser(String username, String password){
        System.out.println("Checking login for: " + username + ", " + password);
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}
