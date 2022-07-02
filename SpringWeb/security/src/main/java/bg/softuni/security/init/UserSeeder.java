package bg.softuni.security.init;

import bg.softuni.security.models.User;
import bg.softuni.security.models.UserRole;
import bg.softuni.security.models.enums.UserRoleEnum;
import bg.softuni.security.repositories.UserRepo;
import bg.softuni.security.repositories.UserRoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSeeder implements CommandLineRunner {
    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;
    private final PasswordEncoder passwordEncoder;

    public UserSeeder(UserRepo userRepo, UserRoleRepo userRoleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.count() == 0) {
            UserRole adminrole = new UserRole(UserRoleEnum.ADMIN);
            UserRole moderatorrole = new UserRole(UserRoleEnum.MODERATOR);

            userRoleRepo.save(adminrole);
            userRoleRepo.save(moderatorrole);

            User user = new User();
            user.setEmail("s@s.s");
            user.setPassword(passwordEncoder.encode("topsecret"));
            user.setRoles(List.of(adminrole, moderatorrole));
            userRepo.save(user);
        }
    }
}
