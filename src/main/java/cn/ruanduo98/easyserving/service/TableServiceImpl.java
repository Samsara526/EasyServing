package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.dao.TableRepository;
import cn.ruanduo98.easyserving.po.TableItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    private TableRepository tableRepository;

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
}
