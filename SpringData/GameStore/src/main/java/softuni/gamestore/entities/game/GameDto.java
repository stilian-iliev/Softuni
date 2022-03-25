package softuni.gamestore.entities.game;

import softuni.gamestore.exceptions.ValidationException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameDto {
    private String title;

    private String trailer;

    private String image;

    private double size;

    private BigDecimal price;

    private String description;

    private LocalDate releaseDate;

    public GameDto(String[] tokens) {
        setTitle(tokens[1]);
        setPrice(new BigDecimal(tokens[2]));
        setSize(Double.parseDouble(tokens[3]));
        setTrailer(tokens[4]);
        setImage(tokens[5]);
        setDescription(tokens[6]);
        setReleaseDate(tokens[7]);
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

    public void setReleaseDate(String releaseDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.releaseDate = LocalDate.parse(releaseDate, formatter);
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
}
