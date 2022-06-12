package bg.softuni.pathfinder.user;

import bg.softuni.pathfinder.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private User user;

    public void login(User user) {
        this.user = user;
    }

    private void logout() {
        this.user = null;
    }

    public User getUser() {
        return user;
    }

    public boolean isLogged() {
        return this.user != null;
    }
}
