package byc.by.com.testten.wode.bean;

/**
 * Created by 白玉春 on 2017/11/13.
 */

public class MyShijian {
    String name;
    String passworld;

    public MyShijian(String name, String passworld) {
        this.name = name;
        this.passworld = passworld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }
}
