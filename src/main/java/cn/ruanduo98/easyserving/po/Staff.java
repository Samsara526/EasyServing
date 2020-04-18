package cn.ruanduo98.easyserving.po;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "staff_user")
public class Staff {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String avatar;
    private String telephone;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;
    @ManyToOne()
    private Role role;

    public Staff() {
    }

    public Staff(Long id, String username, String password, String avatar, String telephone, Date creatTime, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.telephone = telephone;
        this.creatTime = creatTime;
        this.role = role;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", telephone='" + telephone + '\'' +
                ", creatTime=" + creatTime +
                ", role=" + role.toString() +
                '}';
    }
}
