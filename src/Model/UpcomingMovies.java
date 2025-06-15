
package Model;

/**
 *
 * @author it solution
 */
public class UpcomingMovies {
     private String title;
    private String releaseDate;
    private String imagePath;
    private String description;

    
    public UpcomingMovies(String title, String releaseDate, String imagePath, String description) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.imagePath = imagePath;
        this.description = description;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


