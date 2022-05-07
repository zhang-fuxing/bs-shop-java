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
 * @since 2022-05-05
 */
public class Estimate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评价表
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 评价的商品id
     */
    private Integer pid;

    /**
     * 评价的用户id
     */
    private Integer uid;

    /**
     * 评论的内容
     */
    private String content;

    /**
     * 评价的商品名
     */
    private String pname;

    /**
     * 评价的商品图片url
     */
    private String pimg;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 评论创建时间
     */
    private LocalDateTime createTime;

    /**
     * 评论修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 是否删除；0：未删除；1：已删除
     */
    private Integer isDelete;

    private String nickname;

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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Estimate{" +
            "id=" + id +
            ", pid=" + pid +
            ", uid=" + uid +
            ", content=" + content +
            ", pname=" + pname +
            ", pimg=" + pimg +
            ", description=" + description +
            ", createTime=" + createTime +
            ", modifiedTime=" + modifiedTime +
            ", isDelete=" + isDelete +
            ", nickname=" + nickname +
        "}";
    }
}
