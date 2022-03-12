package com.zfx.bsshop.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zfx
 * @since 2022-03-06
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String uid;

    private String nickname;

    private String uname;

    private String password;

    private String phone;

    private Integer sex;

    private Integer headImg;

    private String email;

    private String birthday;

    private Integer address;

    /**
     * 1:正常登录；-1：冻结；
     */
    private Integer userStatus;

    private LocalDateTime createdTime;

    private LocalDateTime modifiedTime;

    /**
     * 0：未删除；1：已删除
     */
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Integer getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Integer headImg) {
        this.headImg = headImg;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }
    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + id +
            ", uid=" + uid +
            ", nickname=" + nickname +
            ", uname=" + uname +
            ", password=" + password +
            ", phone=" + phone +
            ", sex=" + sex +
            ", headImg=" + headImg +
            ", email=" + email +
            ", birthday=" + birthday +
            ", address=" + address +
            ", userStatus=" + userStatus +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", isDelete=" + isDelete +
        "}";
    }
}
