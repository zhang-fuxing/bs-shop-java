package com.zfx.bsshop.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 1级类别id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1级类别名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name=" + name +
        "}";
    }
}