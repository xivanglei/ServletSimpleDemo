package demo.bean;

import java.io.Serializable;

/**
 * Author:xianglei
 * Date: 2019-12-24 08:55
 * Description:
 */
public class BookBean implements Serializable {

    private String id;
    private String name;

    public BookBean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
