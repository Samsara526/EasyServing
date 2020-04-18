package cn.ruanduo98.easyserving.po;

import javax.persistence.*;

@Entity
@Table(name = "menu_item")
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String image;
    @ManyToOne
    private Package aPackage;

    public Item() {
    }

    public Item(Long id, String name, String image, Package aPackage) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.aPackage = aPackage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", aPackage=" + aPackage +
                '}';
    }
}
