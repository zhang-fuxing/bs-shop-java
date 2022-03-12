package com.zfx.bsshop.model;

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
 * @author zfx
 * @since 2022-03-06
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer categoryId;

    private String pname;

    private String description;

    private BigDecimal unitPrice;

    /**
     * 售卖产品的分类，如上面颜色，什么口味等
     */
    private Integer prdCategory;

    private Integer prdImg;

    private Integer inventoryNum;

    /**
     * 店铺名，说明商品属于哪家店铺
     */
    private String storeName;

    private LocalDateTime createdTime;

    private LocalDateTime modifiedTime;

    private String createdUser;

    private String modifiedUser;

    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getPrdCategory() {
        return prdCategory;
    }

    public void setPrdCategory(Integer prdCategory) {
        this.prdCategory = prdCategory;
    }
    public Integer getPrdImg() {
        return prdImg;
    }

    public void setPrdImg(Integer prdImg) {
        this.prdImg = prdImg;
    }
    public Integer getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(Integer inventoryNum) {
        this.inventoryNum = inventoryNum;
    }
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
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
    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
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
        return "Product{" +
            "id=" + id +
            ", categoryId=" + categoryId +
            ", pname=" + pname +
            ", description=" + description +
            ", unitPrice=" + unitPrice +
            ", prdCategory=" + prdCategory +
            ", prdImg=" + prdImg +
            ", inventoryNum=" + inventoryNum +
            ", storeName=" + storeName +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", createdUser=" + createdUser +
            ", modifiedUser=" + modifiedUser +
            ", isDelete=" + isDelete +
        "}";
    }
}
