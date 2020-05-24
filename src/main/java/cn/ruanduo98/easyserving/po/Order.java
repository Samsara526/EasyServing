package cn.ruanduo98.easyserving.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "order_item")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Long tid;
    private Double payPrice;
    private Date serverBeginTime;
    private Date serverEndTime;
    private Byte tableSize;

    public Order() {
    }

    public Order(Long id, Long tid, Double payPrice, Date serverBeginTime, Date serverEndTime, Byte tableSize) {
        this.id = id;
        this.tid = tid;
        this.payPrice = payPrice;
        this.serverBeginTime = serverBeginTime;
        this.serverEndTime = serverEndTime;
        this.tableSize = tableSize;
    }

    public Order(Long tid, Double payPrice, Date serverBeginTime, Date serverEndTime, Byte tableSize) {
        this.tid = tid;
        this.payPrice = payPrice;
        this.serverBeginTime = serverBeginTime;
        this.serverEndTime = serverEndTime;
        this.tableSize = tableSize;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Double getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Double payPrice) {
        this.payPrice = payPrice;
    }

    public Date getServerBeginTime() {
        return serverBeginTime;
    }

    public void setServerBeginTime(Date serverBeginTime) {
        this.serverBeginTime = serverBeginTime;
    }

    public Date getServerEndTime() {
        return serverEndTime;
    }

    public void setServerEndTime(Date serverEndTime) {
        this.serverEndTime = serverEndTime;
    }

    public Byte getTableSize() {
        return tableSize;
    }

    public void setTableSize(Byte tableSize) {
        this.tableSize = tableSize;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", tid=" + tid +
                ", payPrice=" + payPrice +
                ", serverBeginTime=" + serverBeginTime +
                ", serverEndTime=" + serverEndTime +
                ", tableSize=" + tableSize +
                '}';
    }
}
