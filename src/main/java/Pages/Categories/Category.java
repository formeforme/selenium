package Pages.Categories;

import java.util.List;

/**
 * Created by liana on 4/12/17.
 */
public class Category {
    private String name = null;
    private List<String> images = null;//TODO
    private String type = null;//TODO

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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
