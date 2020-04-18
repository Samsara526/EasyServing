package cn.ruanduo98.easyserving.dao;

import cn.ruanduo98.easyserving.po.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findByUsernameAndPassword(String username,String password);
}
