package softuni.gamestore.services;

import softuni.gamestore.entities.user.UserDto;

public interface UserService {
    void registerUser(UserDto userInfo);

    void loginUser(String email, String pass);

    void logout();
}
