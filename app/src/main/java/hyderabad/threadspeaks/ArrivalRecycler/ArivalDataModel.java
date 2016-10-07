package hyderabad.threadspeaks.ArrivalRecycler;

/**
 * Created by Pavithran on 24-09-2016.
 */
public class ArivalDataModel {
    private int image;
    private String name;

    public ArivalDataModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public ArivalDataModel setImage(int image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public ArivalDataModel setName(String name) {
        this.name = name;
        return this;
    }
}
