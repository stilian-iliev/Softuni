package bg.softuni.mvcdemo.web;

import bg.softuni.mvcdemo.models.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UserController {
    @GetMapping("/user")
    public String getCreateUser() {
        return "usercreate";
    }

    @PostMapping("/user")
    public String createUser(UserDto userDto) {
        System.out.println(userDto);
        return "redirect:/usercreatesuccess";
    }

    @GetMapping("/usercreatesuccess")
    public String postCreation() {
        return "usercreatesuccess";
    }
}
