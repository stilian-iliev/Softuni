package bg.softuni.mobilele.user;

import bg.softuni.mobilele.models.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private String name;
    private boolean isLogged;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public void login(User user) {
        this.name = user.getFirstName() + " " + user.getLastName();
        this.isLogged = true;
    }

    public void logout() {
        this.name = null;
        this.isLogged = false;
    }
}
