package cn.ruanduo98.easyserving.po;

import javax.persistence.*;

@Entity
@Table(name = "table_cart")
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    private Long tableId;
    private Long productId;
    private Byte number;
    //状态码 0未下单 1已下单
    private Byte status;

    public Cart() {
    }

    public Cart(Long id, Long tableId, Long productId, Byte number, Byte status) {
        this.id = id;
        this.tableId = tableId;
        this.productId = productId;
        this.number = number;
        this.status = status;
    }

    public Cart(Long tableId, Long productId, Byte number, Byte status) {
        this.tableId = tableId;
        this.productId = productId;
        this.number = number;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Byte getNumber() {
        return number;
    }

    public void setNumber(Byte number) {
        this.number = number;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", tableId=" + tableId +
                ", productId=" + productId +
                ", number=" + number +
                ", status=" + status +
                '}';
    }
}
