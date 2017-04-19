package Pages.HBBusiness;

/**
 * Created by liana on 4/14/17.
 */
public class HBBusiness {
    private String name;
    private String image;

    public HBBusiness(){}
    public HBBusiness(String name, String image){
        this.name = name;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
