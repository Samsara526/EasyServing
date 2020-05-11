package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.TableItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableRepository extends JpaRepository<TableItem, Long> {
    List<TableItem> findAll();

    Byte countAllByState(Byte state);
}
