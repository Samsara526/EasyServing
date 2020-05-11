package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.TableItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TableServiceImplTest {

    @Autowired
    TableService tableService;

    @Test
    void findAll() {
        List<TableItem> tableItems = tableService.findAll();
        for (TableItem tableItem : tableItems) {
            System.out.println(tableItem);
        }
    }
}