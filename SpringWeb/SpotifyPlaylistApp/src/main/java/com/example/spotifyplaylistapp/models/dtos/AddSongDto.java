package com.example.spotifyplaylistapp.models.dtos;

import com.example.spotifyplaylistapp.models.enums.StyleEnum;
import com.example.spotifyplaylistapp.validation.UniquePerformer;
import com.example.spotifyplaylistapp.validation.ValidStyle;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class AddSongDto {
    @NotBlank
    @UniquePerformer
    @Length(min = 3, max = 20)
    private String performer;

    @NotBlank
    @Length(min = 3, max = 20)
    private String title;
    @NotNull
    @Positive
    private int duration;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @NotNull
    @ValidStyle
    private StyleEnum style;


    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public StyleEnum getStyle() {
        return style;
    }

    public void setStyle(StyleEnum style) {
        this.style = style;
    }
}
