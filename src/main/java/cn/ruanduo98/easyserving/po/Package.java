package cn.ruanduo98.easyserving.po;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu_package")
public class Package {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String icon;
    private String color;
    private Double price;
    private String content;
    @OneToMany(mappedBy = "aPackage")
    private List<Item> items;

    public Package() {
    }

    public Package(Long id, String name, String icon, String color, Double price, String content, List<Item> items) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.price = price;
        this.content = content;
        this.items = items;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", content='" + content + '\'' +
                ", items=" + items +
                '}';
    }
}
