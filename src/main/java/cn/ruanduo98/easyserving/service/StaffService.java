package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.Role;
import cn.ruanduo98.easyserving.po.Staff;

import java.util.List;

public interface StaffService {
    Staff checkAdminUser(String username, String password);

    Staff checkServingUser(String username, String password);

    List<Staff> findAllStaff();

    List<Role> findAllRole();
}
