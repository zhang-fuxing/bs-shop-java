package com.z.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author z
 * @since 2022-05-05
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品名
     */
    private String pname;

    /**
     * 商品图
     */
    private String pimg;

    /**
     * 购买数量
     */
    private Integer buyNum;

    /**
     * 订单价格
     */
    private BigDecimal priceCount;

    /**
     * 地址名
     */
    private String addressName;

    /**
     * 收货人名字
     */
    private String receiveName;

    /**
     * 收货人电话
     */
    private String receivePhone;

    /**
     * 收货地址——省/直辖市
     */
    private String province;

    /**
     * 收货地址——城市
     */
    private String city;

    /**
     * 收货地址——地区
     */
    private String region;

    /**
     * 收货地址——详细地址
     */
    private String detailAddress;

    /**
     * 订单状态；0：待发货，1：已发货，2：已收货
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;

    /**
     * 订单修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 订单创建者
     */
    private String createUser;

    /**
     * 订单修改者
     */
    private String modifiedUser;

    /**
     * 订单是否对用户可见，即用户是否删除订单
     */
    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }
    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }
    public BigDecimal getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(BigDecimal priceCount) {
        this.priceCount = priceCount;
    }
    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }
    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Orders{" +
            "id=" + id +
            ", pid=" + pid +
            ", uid=" + uid +
            ", pname=" + pname +
            ", pimg=" + pimg +
            ", buyNum=" + buyNum +
            ", priceCount=" + priceCount +
            ", addressName=" + addressName +
            ", receiveName=" + receiveName +
            ", receivePhone=" + receivePhone +
            ", province=" + province +
            ", city=" + city +
            ", region=" + region +
            ", detailAddress=" + detailAddress +
            ", status=" + status +
            ", createTime=" + createTime +
            ", modifiedTime=" + modifiedTime +
            ", createUser=" + createUser +
            ", modifiedUser=" + modifiedUser +
            ", isDelete=" + isDelete +
        "}";
    }
}
