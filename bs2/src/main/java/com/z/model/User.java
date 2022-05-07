package com.z.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author z
 * @since 2022-04-19
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户内部id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 程序生成的用户id
     */
    private String uid;

    /**
     * 用户的昵称
     */
    private String nickname;

    /**
     * 用户名，不能重复
     */
    private String uname;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 用户的联系电话
     */
    private String phone;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 头像id
     */
    private String headImg;

    /**
     * 用户邮件地址
     */
    private String email;

    /**
     * 用户生日
     */
    private String birthday;

    /**
     * 使用的收货地址id
     */
    private Integer address;

    /**
     * 用户账号状态；1:正常登录；-1：冻结
     */
    private Integer userStatus;

    /**
     * 用户注册时间
     */
    private LocalDateTime createdTime;

    /**
     * 用户修改信息的时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 账号是否删除：0：未删除；1：已删除
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

    public String getHeadImg() {
        return headImg;
    }
    public void setHeadImg(String headImg) {
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
        return "User{" +
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
