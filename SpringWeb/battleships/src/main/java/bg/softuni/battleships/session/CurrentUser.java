package bg.softuni.battleships.session;

import bg.softuni.battleships.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class CurrentUser {
    private long id;

    private User user;
    private boolean active;

    public void login(User user) {
        this.id = user.getId();
        this.user = user;
        this.active = true;
    }

    public void logout() {
        this.id = 0;
        this.user = null;
        this.active = false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
