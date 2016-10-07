package hyderabad.threadspeaks.FeaturesRecycler;

/**
 * Created by Pavithran on 25-09-2016.
 */
public class FeaturesDataModel {
    public String feature;

    public boolean isSelected;

    public FeaturesDataModel(String feature, boolean isSelected) {
        this.feature = feature;
        this.isSelected = isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public FeaturesDataModel setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        return this;
    }

    public String getFeature() {
        return feature;
    }

    public FeaturesDataModel setFeature(String feature) {
        this.feature = feature;
        return this;
    }
}
