package hyderabad.threadspeaks.AllCategoriesRecycler;

/**
 * Created by Pavithran on 24-09-2016.
 */
public class Album {
    private String name;
    private int thumbnail;

    public Album() {
    }

    public Album(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

}
