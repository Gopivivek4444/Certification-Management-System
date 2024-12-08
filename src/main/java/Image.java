public class Image {
    private String url;
    private String title;
    private String description;

    // Constructor
    public Image(String url, String title, String description) {
        this.url = url;
        this.title = title;
        this.description = description;
    }

    // Getters
    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
