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
 * @since 2022-04-28
 */
public class Recommend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推荐表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 推荐的商品id
     */
    private Integer pid;

    /**
     * 推荐商品所在楼层
     */
    private Integer floor;

    /**
     * 推荐商品的图片
     */
    private String pimg;

    /**
     * 推荐的商品名
     */
    private String pname;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 是否取消推荐；默认0，不取消；-1：取消推荐
     */
    private Integer isCancel;

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
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    @Override
    public String toString() {
        return "Recommend{" +
            "id=" + id +
            ", pid=" + pid +
            ", floor=" + floor +
            ", pimg=" + pimg +
            ", pname=" + pname +
            ", price=" + price +
            ", createTime=" + createTime +
            ", modifiedTime=" + modifiedTime +
            ", isCancel=" + isCancel +
        "}";
    }
}
