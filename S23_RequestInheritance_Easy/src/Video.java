/**
 * Video - an Object that has a URL, Title, and Author.
 */
public class Video {
    /**
     * The Url.
     */
    private String URL;
    /**
     * The Title.
     */
    private String title;
    /**
     * The Author.
     */
    private String author;

    /**
     * Instantiates a new Video.
     * @param URL    a random Universal Resource Locator of a Video object.
     * @param title  a random Title of a Video object.
     * @param author a random Author of a Video object.
     */
    public Video(String URL, String title, String author){
        this.URL = URL;
        this.title = title;
        this.author = author;
    }

    /**
     * ToString output.
     * @return output String using overridden toString to display information about the Video object.
     */
    @Override
    public String toString(){
        return ("\n-Video Info-\nUniversal Resource Locator (URL): " + getURL() + "\nTitle: " + getTitle() + "\nAuthor: " + getAuthor());
    }

    /**
     * Gets url.
     * @return the random URL of the object.
     */
    public String getURL() {
        return URL;
    }

    /**
     * Gets title.
     * @return the random Title of the object.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets author.
     * @return the random Author of the object.
     */
    public String getAuthor() {
        return author;
    }
}