package bg.softuni.musicdb.web;

import bg.softuni.musicdb.models.Album;
import bg.softuni.musicdb.repositories.AlbumRepository;
import bg.softuni.musicdb.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final AlbumRepository albumRepository;

    public HomeController(CurrentUser currentUser, AlbumRepository albumRepository) {
        this.currentUser = currentUser;
        this.albumRepository = albumRepository;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        if (!model.containsAttribute("albums")) {
            model.addAttribute("albums", albumRepository.findAllByOrderByCopiesDesc());
        }
        if (!model.containsAttribute("totalCopies")) {
            model.addAttribute("totalCopies", albumRepository.findAllByOrderByCopiesDesc().stream().mapToInt(Album::getCopies).sum());
        }
        return currentUser.isActive() ? "home" : "index";
    }
}
