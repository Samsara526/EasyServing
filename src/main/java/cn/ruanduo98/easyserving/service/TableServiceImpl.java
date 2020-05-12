package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.dao.TableRepository;
import cn.ruanduo98.easyserving.po.TableItem;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    private final TableRepository tableRepository;

    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public List<TableItem> findAll() {
        return tableRepository.findAll();
    }

    @Override
    public List<TableItem> findAllWithFront() {
        List<TableItem> tableItems = findAll();
        for (TableItem tableItem : tableItems) {
            //假如状态为就餐中
            if (tableItem.getState() == 1) {
                Long now = new Date().getTime();
                Long beginTime = tableItem.getServerBeginTime().getTime();
                tableItem.setServerBeginTime(new Date(now - beginTime));
            }
        }
        return tableItems;
    }

    @Override
    public Byte countAllByState(Byte state) {
        return tableRepository.countAllByState(state);
    }

    @Override
    public void updateTableStatueById(Long id, Byte state) {
        TableItem tableItem = tableRepository.getOne(id);
        //当设置餐桌状态为就餐中
        if (state == 1 && tableItem.getState() != 1) {
            tableItem.setServerBeginTime(new Date());
        }
        //当设置餐桌状态为空闲
        if (state == 0) {
            tableItem.setServerBeginTime(null);
        }
        tableItem.setState(state);
        tableRepository.save(tableItem);
    }
}
