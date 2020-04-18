package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findAll();
}
