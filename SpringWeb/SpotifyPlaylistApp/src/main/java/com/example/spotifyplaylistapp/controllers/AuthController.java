package com.example.spotifyplaylistapp.controllers;

import com.example.spotifyplaylistapp.models.dtos.LoginDto;
import com.example.spotifyplaylistapp.models.dtos.RegisterDto;
import com.example.spotifyplaylistapp.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ModelAttribute("registerDto")
    public RegisterDto registerDto() {
        return new RegisterDto();
    }

    @GetMapping("/register")
    public String getRegister() {
        if (authService.isActive()) return "redirect:/";
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid RegisterDto registerDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (authService.isActive()) return "redirect:/";

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerDto", registerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDto", bindingResult);
            return "redirect:/register";
        }
        authService.register(registerDto);
        return "redirect:/login";
    }

    @ModelAttribute("loginDto")
    public LoginDto loginDto() {
        return new LoginDto();
    }

    @GetMapping("/login")
    public String getLogin() {
        if (authService.isActive()) return "redirect:/";
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDto loginDto,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes,
                        Model model) {
        if (authService.isActive()) return "redirect:/";

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDto", bindingResult);
            return "redirect:/login";
        }
        if (!authService.login(loginDto)) {
            redirectAttributes.addFlashAttribute("invalidCreds", true);
            redirectAttributes.addFlashAttribute("loginDto", loginDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDto", bindingResult);
            return "redirect:/login";
        }


        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        authService.logout();
        return "redirect:/";
    }
}
