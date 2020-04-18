package cn.ruanduo98.easyserving.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff_role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "role_name")
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<Staff> staffs = new ArrayList<>();

    public Role() {
    }

    public Role(Long id, String roleName, List<Staff> staff) {
        this.id = id;
        this.roleName = roleName;
        this.staffs = staff;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
