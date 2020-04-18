package cn.ruanduo98.easyserving.service;

import cn.ruanduo98.easyserving.dao.StaffRepository;
import cn.ruanduo98.easyserving.po.Staff;
import cn.ruanduo98.easyserving.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

    StaffRepository staffRepository;

    @Autowired
    public void setStaffRepository(StaffRepository staffRepository){
        this.staffRepository=staffRepository;
    }

    @Override
    public Staff checkAdminUser(String username, String password) {
        Staff staff = staffRepository.findByUsernameAndPassword(username, MD5Utils.encodeByMd5(password));
        if (staff != null && staff.getRole().getRoleName().equals("管理员")) {
            return staff;
        }
        return null;
    }

    @Override
    public Staff checkServingUser(String username, String password) {
        return null;
    }

}
