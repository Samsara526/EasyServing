package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.po.Staff;

public interface StaffService {
    Staff checkAdminUser(String username, String password);

    Staff checkServingUser(String username, String password);

}
