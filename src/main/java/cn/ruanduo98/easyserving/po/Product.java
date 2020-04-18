package cn.ruanduo98.easyserving.po;

import javax.persistence.*;

@Entity
@Table(name = "menu_product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
    @Column(name = "is_sale")
    private boolean isSale;
    private String content;
    private String image;
    @ManyToOne
    private Type type;

    public Product() {
    }

    public Product(Long id, String name, Double price, boolean isSale, String content, String image, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isSale = isSale;
        this.content = content;
        this.image = image;
        this.type = type;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isSale=" + isSale +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", type=" + type +
                '}';
    }
}
