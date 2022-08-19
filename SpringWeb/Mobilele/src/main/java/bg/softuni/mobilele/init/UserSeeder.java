package bg.softuni.mobilele.init;

import bg.softuni.mobilele.models.User;
import bg.softuni.mobilele.models.UserRole;
import bg.softuni.mobilele.models.enums.Role;
import bg.softuni.mobilele.repositories.UserRepository;
import bg.softuni.mobilele.repositories.UserRoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class UserSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSeeder(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(Role.values()).filter(r -> userRoleRepository.findByRole(r).isEmpty())
                .forEach(r -> {
                    UserRole ur = new UserRole();
                    ur.setRole(r);
                    userRoleRepository.save(ur);
                });

        if (userRepository.count() == 0) {
            User user = new User();
            user.setCreated(LocalDateTime.now());
            user.setActive(true);
            user.setFirstName("Admin");
            user.setLastName("Adminov");
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("asdfasdf"));
            user.addRole(userRoleRepository.findById(1L).get());
            user.addRole(userRoleRepository.findById(2L).get());
            userRepository.save(user);
        }
    }
}
