package Pages.JoinUs;

import java.util.List;

/**
 * Created by liana on 4/14/17.
 */
public class JoinUs {
    String name;
    String mainImage;
    List<String> sliderImages;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMainImage() {
        return mainImage;
    }
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
    public List<String> getSliderImages() {
        return sliderImages;
    }
    public void setSliderImages(List<String> sliderImages) {
        this.sliderImages = sliderImages;
    }
}