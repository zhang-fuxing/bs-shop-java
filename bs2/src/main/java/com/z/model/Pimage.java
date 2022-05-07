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
public class Pimage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品图片id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品图片类型，1代表预览图，2代表详情图
     */
    private Integer imgType;

    /**
     * 图片名
     */
    private String name;

    /**
     * 服务器的绝对路径
     */
    private String serverPath;

    /**
     * 项目访问路径
     */
    private String projectPath;

    /**
     * 项目域名
     */
    private String domain;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 创建的用户
     */
    private String createdUser;

    /**
     * 修改的用户
     */
    private String modifiedUser;

    public Pimage() {
    }

    public Pimage(Integer imgType, String name, String serverPath, String projectPath, String domain, LocalDateTime createdTime, LocalDateTime modifiedTime, String createdUser, String modifiedUser) {
        this.imgType = imgType;
        this.name = name;
        this.serverPath = serverPath;
        this.projectPath = projectPath;
        this.domain = domain;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
        this.createdUser = createdUser;
        this.modifiedUser = modifiedUser;
    }

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
    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }
    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    @Override
    public String toString() {
        return "Pimage{" +
            "id=" + id +
            ", pid=" + pid +
            ", imgType=" + imgType +
            ", name=" + name +
            ", serverPath=" + serverPath +
            ", projectPath=" + projectPath +
            ", domain=" + domain +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", createdUser=" + createdUser +
            ", modifiedUser=" + modifiedUser +
        "}";
    }
}
