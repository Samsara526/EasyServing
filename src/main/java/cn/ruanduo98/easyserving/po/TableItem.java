package cn.ruanduo98.easyserving.po;

import javax.persistence.*;
import java.util.Date;

@Entity
@javax.persistence.Table(name = "table_item")
public class TableItem {
    @Id
    @GeneratedValue
    private Long id;
    private Byte size;
    //餐桌状态 0表示空闲 1表示用餐中 2表示预定
    private Byte state;
    private Date orderBeginTime;
    private Date orderEndTime;
    private Date serverBeginTime;
    private Date serverEndTime;

    public TableItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getSize() {
        return size;
    }

    public void setSize(Byte size) {
        this.size = size;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getOrderBeginTime() {
        return orderBeginTime;
    }

    public void setOrderBeginTime(Date orderBeginTime) {
        this.orderBeginTime = orderBeginTime;
    }

    public Date getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(Date orderEndTime) {
        this.orderEndTime = orderEndTime;
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

    @Override
    public String toString() {
        return "TableItem{" +
                "id=" + id +
                ", size=" + size +
                ", state=" + state +
                ", orderBeginTime=" + orderBeginTime +
                ", orderEndTime=" + orderEndTime +
                ", serverBeginTime=" + serverBeginTime +
                ", serverEndTime=" + serverEndTime +
                '}';
    }
}
