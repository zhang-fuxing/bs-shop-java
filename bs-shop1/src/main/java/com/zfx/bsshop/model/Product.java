package com.zfx.bsshop.model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private Integer categoryId;

    private String pname;

    private String description;

    private BigDecimal unitPrice;

    private Integer prdAttr;

    private Integer prdImg;

    private Integer inventoryNum;

    private String storeName;

    private Date createdTime;

    private Date modifiedTime;

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

    public Integer getPrdAttr() {
        return prdAttr;
    }

    public void setPrdAttr(Integer prdAttr) {
        this.prdAttr = prdAttr;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
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
                ", pname='" + pname + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", prdAttr=" + prdAttr +
                ", prdImg=" + prdImg +
                ", inventoryNum=" + inventoryNum +
                ", storeName='" + storeName + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}