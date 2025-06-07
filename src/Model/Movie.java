package Model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration; // in minutes
    private String director;
    private double rating;

    @ElementCollection
    private List<String> genres;

    @Column(length = 1000)
    private String synopsis;

    @ElementCollection
    private List<String> cast;

    @ElementCollection
    private List<String> photos;

    // Constructors
    public Movie() {}

    public Movie(String title, int duration, String director, double rating, List<String> genres, String synopsis, List<String> cast, List<String> photos) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.rating = rating;
        this.genres = genres;
        this.synopsis = synopsis;
        this.cast = cast;
        this.photos = photos;
    }

    // Getters and Setters
    // ... (generate via IDE)
}
