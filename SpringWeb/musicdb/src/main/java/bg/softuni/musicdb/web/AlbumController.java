package bg.softuni.musicdb.web;

import bg.softuni.musicdb.models.Album;
import bg.softuni.musicdb.models.dtos.AddAlbumDto;
import bg.softuni.musicdb.repositories.AlbumRepository;
import bg.softuni.musicdb.services.AlbumService;
import bg.softuni.musicdb.services.ArtistService;
import bg.softuni.musicdb.session.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class AlbumController {
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final CurrentUser currentUser;
    private final AlbumRepository albumRepository;

    public AlbumController(ArtistService artistService, AlbumService albumService, CurrentUser currentUser, AlbumRepository albumRepository) {
        this.artistService = artistService;
        this.albumService = albumService;
        this.currentUser = currentUser;
        this.albumRepository = albumRepository;
    }

    @GetMapping("/albums/add")
    public String getAdd(Model model) {
        if (!currentUser.isActive()) return "redirect:/login";

        if (!model.containsAttribute("addAlbumDto")) {
            model.addAttribute("addAlbumDto", new AddAlbumDto());
        }
        if (!model.containsAttribute("artists")) {
            model.addAttribute("artists", artistService.getAll());
        }

        return "add-album";
    }

    @PostMapping("/albums/add")
    public String add(@Valid AddAlbumDto addAlbumDto,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes) {
        if (!currentUser.isActive()) return "redirect:/login";

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addAlbumDto", addAlbumDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addAlbumDto", bindingResult);
            return "redirect:/albums/add";
        }
        albumService.add(addAlbumDto);
        return "redirect:/";
    }
    @GetMapping("/albums")
    public String getHome(Model model) {

        if (!currentUser.isActive()) return "redirect:/login";

        if (!model.containsAttribute("albums")) {
            model.addAttribute("albums", albumRepository.findAllByOrderByCopiesDesc());
        }
        if (!model.containsAttribute("totalCopies")) {
            model.addAttribute("totalCopies", albumRepository.findAllByOrderByCopiesDesc().stream().mapToInt(Album::getCopies).sum());
        }
        return "home" ;
    }

    @GetMapping("/albums/{id}/delete")
    public String deleteCompany(@PathVariable("id") long id) {
        if (!currentUser.isActive()) return "redirect:/login";
        albumService.removeById(id);
        return "redirect:/";
    }
}
