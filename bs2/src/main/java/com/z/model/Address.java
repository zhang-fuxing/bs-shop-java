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
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 地址id，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id，自增
     */
    private Integer uid;

    /**
     * 用户所在地区
     */
    private String region;

    /**
     * 用户详细地址
     */
    private String detail;

    /**
     * 收件人，接收快递的人的名字
     */
    private String consignee;

    /**
     * 收件人联系电话
     */
    private String phone;

    /**
     * 地址创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 地址修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 是不是默认地址，0:不默认；1默认
     */
    private Integer defaultStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    @Override
    public String toString() {
        return "Address{" +
            "id=" + id +
            ", uid=" + uid +
            ", region=" + region +
            ", detail=" + detail +
            ", consignee=" + consignee +
            ", phone=" + phone +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", defaultStatus=" + defaultStatus +
        "}";
    }
}
