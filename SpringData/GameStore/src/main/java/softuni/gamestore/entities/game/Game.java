package softuni.gamestore.entities.game;

import softuni.gamestore.exceptions.ValidationException;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String trailer;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private double size;

    @Column(nullable = false)
    private BigDecimal price;

    private String description;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    public Game() {}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTrailer() {
        return trailer;
    }

    public String getImage() {
        return image;
    }

    public double getSize() {
        return size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        if (!Character.isUpperCase(title.charAt(0)) || title.length() < 3 || title.length() > 100) {
            throw new ValidationException("Incorrect game title.");
        }
        this.title = title;
    }

    public void setTrailer(String trailer) {
        if (trailer.length() != 11) {
            throw new ValidationException("Invalid trailer.");
        }
        this.trailer = trailer;
    }

    public void setImage(String image) {
        Pattern p = Pattern.compile("^http[s]?:\\/\\/.*");
        Matcher m = p.matcher(image);
        if (!m.matches()) {
            throw new ValidationException("Invalid image.");
        }
        this.image = image;
    }

    public void setSize(double size) {
        if (size < 0) {
            throw new ValidationException("Size cannot be negative");
        }
        this.size = size;
    }

    public void setPrice(BigDecimal price) {
        if (price.signum() < 0) {
            throw new ValidationException("Price cannot be negative.");
        }
        this.price = price;
    }

    public void setDescription(String description) {
        if (description.length() < 20) {
            throw new ValidationException("Description too short");
        }
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Title = " + title + "\n" +
                "Trailer = " + trailer + "\n" +
                "Image = " + image + "\n" +
                "Size = " + size + "\n" +
                "Price = " + price + "\n" +
                "Description = " + description + '\n' +
                "Release Date = " + releaseDate + "\n";
    }
}
