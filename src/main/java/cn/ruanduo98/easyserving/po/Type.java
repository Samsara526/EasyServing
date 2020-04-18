package cn.ruanduo98.easyserving.po;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu_type")
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String icon;
    private String color;
    @OneToMany(mappedBy = "type")
    private List<Product> products;

    public Type() {
    }

    public Type(Long id, String name, String icon, String color, List<Product> products) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.color = color;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", color='" + color + '\'' +
                ", products=" + products +
                '}';
    }
}
