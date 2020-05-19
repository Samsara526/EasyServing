package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.TableItem;

import java.util.Date;
import java.util.List;

public interface TableService {
    List<TableItem> findAll();

    List<TableItem> findAllWithFront();

    Byte countAllByState(Byte state);

    void updateTableStatueById(Long id, Byte statue);

    TableItem getOneTableById(Long id);

    Date getServingTimeById(Long id);

    void updateTableServingBeginTimeById(Long id, Date date);
}
