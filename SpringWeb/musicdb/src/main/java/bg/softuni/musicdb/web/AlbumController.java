package bg.softuni.musicdb.web;

import bg.softuni.musicdb.models.dtos.AddAlbumDto;
import bg.softuni.musicdb.services.AlbumService;
import bg.softuni.musicdb.services.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AlbumController {
    private final ArtistService artistService;
    private final AlbumService albumService;

    public AlbumController(ArtistService artistService, AlbumService albumService) {
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping("/albums/add")
    public String getAdd(Model model) {
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
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addAlbumDto", addAlbumDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addAlbumDto", bindingResult);
            return "redirect:/albums/add";
        }
        albumService.add(addAlbumDto);
        return "redirect:/";
    }
}
