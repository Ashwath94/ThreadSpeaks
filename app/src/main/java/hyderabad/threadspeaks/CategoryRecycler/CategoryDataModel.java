package hyderabad.threadspeaks.CategoryRecycler;

/**
 * Created by Pavithran on 24-09-2016.
 */
public class CategoryDataModel {
    private int image;
    private String name;

    public CategoryDataModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public CategoryDataModel setImage(int image) {
        this.image = image;
        return this;
    }

    public String getName() {
        return name;
    }

    public CategoryDataModel setName(String name) {
        this.name = name;
        return this;
    }
}
