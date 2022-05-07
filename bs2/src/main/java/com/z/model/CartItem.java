package com.z.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 购物车表
 * </p>
 *
 * @author z
 * @since 2022-04-26
 */
@TableName("cart_item")
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer productId;

    private Integer uid;
    /**
     * 购买数量
     */
    private Integer quantity;
    /**
     * 添加到购物车的价格
     */
    private BigDecimal price;
    /**
     * 商品主图
     */
    private String productPic;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 会员昵称
     */
    private String nickname;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;
    /**
     * 是否删除
     */
    private Integer deleteStatus;
    /**
     * 商品分类
     */
    private Integer categoryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", uid=" + uid +
                ", quantity=" + quantity +
                ", price=" + price +
                ", productPic='" + productPic + '\'' +
                ", productName='" + productName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", deleteStatus=" + deleteStatus +
                ", categoryId=" + categoryId +
                '}';
    }
}
