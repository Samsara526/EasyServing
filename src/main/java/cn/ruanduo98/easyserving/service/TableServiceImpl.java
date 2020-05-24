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
                long now = new Date().getTime();
                long beginTime = tableItem.getServerBeginTime().getTime();
                tableItem.setServerBeginTime(new Date(now - beginTime - 28800000));
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
        tableItem.setState(state);
        tableRepository.save(tableItem);
    }

    @Override
    public void updateTableServingBeginTimeById(Long id, Date date) {
        TableItem tableItem = tableRepository.getOne(id);
        tableItem.setServerBeginTime(date);
        tableRepository.save(tableItem);
    }

    @Override
    public TableItem getOneTableById(Long id) {
        return tableRepository.getOne(id);
    }

    @Override
    public Date getServingTimeById(Long id) {
        return new Date(new Date().getTime() - getOneTableById(id).getServerBeginTime().getTime() - 28800000);
    }

    @Override
    public void save(TableItem table) {
        tableRepository.save(table);
    }

    @Override
    public void deleteById(Long id) {
        tableRepository.deleteById(id);
    }
}
