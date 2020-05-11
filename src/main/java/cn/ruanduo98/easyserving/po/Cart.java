package cn.ruanduo98.easyserving.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_cart")
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    private Byte tableId;
    private Long itemId;
    private Byte number;
}
