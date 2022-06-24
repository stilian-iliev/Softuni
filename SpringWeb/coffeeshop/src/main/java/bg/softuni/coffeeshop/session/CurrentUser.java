package bg.softuni.coffeeshop.session;

import bg.softuni.coffeeshop.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@SessionScope
@Component
public class CurrentUser {
    private UUID id;

    private boolean active;

    public void login(User user) {
        this.id = user.getId();
        this.active = true;
    }

    public void logout() {
        this.id = null;
        this.active = false;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
