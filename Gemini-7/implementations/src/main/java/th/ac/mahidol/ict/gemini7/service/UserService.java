package th.ac.mahidol.ict.gemini7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.mahidol.ict.gemini7.model.User.User;
import th.ac.mahidol.ict.gemini7.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signupUser(String name, String password, String email){
        boolean emailExists = userRepository.findByEmail(email).isPresent();
        boolean nameExists = userRepository.findByName(name).isPresent();

        System.out.println("Email exists: " + emailExists);
        System.out.println("Name exists: " + nameExists);
        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || userRepository.findByName(name).isPresent() || userRepository.findByEmail(email).isPresent()){
            return null;
        } else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            User savedUser = userRepository.save(user);
            System.out.println("Saved user: " + savedUser);
            return savedUser;
        }
    }

    public User loginUser(String name, String password){
        System.out.println("Checking login for: " + name + ", " + password);
        return userRepository.findByNameAndPassword(name, password).orElse(null);
    }
}
