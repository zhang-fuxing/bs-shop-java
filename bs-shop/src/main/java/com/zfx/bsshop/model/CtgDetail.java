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
@TableName("ctg_detail")
public class CtgDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 详细商品分类id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 大的商品分类id
     */
    private Integer cid;

    /**
     * 分类名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CtgDetail{" +
            "id=" + id +
            ", cid=" + cid +
            ", name=" + name +
        "}";
    }
}
