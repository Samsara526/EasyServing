package cn.ruanduo98.easyserving.po;

import javax.persistence.*;

@Entity
@Table(name = "order_products")
public class OrderProducts {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "order_id")
    private Long oid;
    @Column(name = "product_id")
    private Long pid;
    private Byte productNumber;
    private Double productPrice;

    public OrderProducts() {
    }

    public OrderProducts(Long id, Long oid, Long pid, Byte productNumber, Double productPrice) {
        this.id = id;
        this.oid = oid;
        this.pid = pid;
        this.productNumber = productNumber;
        this.productPrice = productPrice;
    }

    public OrderProducts(Long oid, Long pid, Byte productNumber, Double productPrice) {
        this.oid = oid;
        this.pid = pid;
        this.productNumber = productNumber;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Byte getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Byte productNumber) {
        this.productNumber = productNumber;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", oid=" + oid +
                ", pid=" + pid +
                ", productNumber=" + productNumber +
                ", productPrice=" + productPrice +
                '}';
    }
}
