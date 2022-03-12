package com.zfx.bsshop.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
@TableName("prd_attr")
public class PrdAttr implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品属性id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品属性描述
     */
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PrdAttr{" +
            "id=" + id +
            ", description=" + description +
        "}";
    }
}
