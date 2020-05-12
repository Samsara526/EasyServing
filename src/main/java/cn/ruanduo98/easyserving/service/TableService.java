package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.TableItem;

import java.util.List;

public interface TableService {
    List<TableItem> findAll();

    List<TableItem> findAllWithFront();

    Byte countAllByState(Byte state);

    void updateTableStatueById(Long id, Byte statue);
}
