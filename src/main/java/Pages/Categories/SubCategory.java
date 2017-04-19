package Pages.Categories;

import java.util.List;

/**
 * Created by liana on 4/13/17.
 */
public class SubCategory {
    private String name = null;
    private List<String> images = null;//TODO
    private boolean isShown;

    public SubCategory(String name, List<String> images, boolean isShown){
        this.name = name;
        this.images = images;
        this.isShown = isShown;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
    public boolean getIsShown() {
        return isShown;
    }
    public void setIsShown(boolean isShown) {
        this.isShown = isShown;
    }
}
