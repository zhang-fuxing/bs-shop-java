package com.zfx.bsshop.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zfx
 * @since 2022-03-12
 */
public class Cimage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户头像图片id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对应的用户id
     */
    private Integer uid;

    /**
     * 图片名
     */
    private String name;

    /**
     * 本机地址，即服务器的绝对地址
     */
    private String localPath;

    /**
     * 项目路径，即静态资源访问地址，域名之后的路径
     */
    private String projectPath;

    /**
     * 域名地址，服务器的域名
     */
    private String domain;

    /**
     * 图片上传时间
     */
    private LocalDateTime createdTime;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedTime;

    /**
     * 上传的用户
     */
    private String createdUser;

    /**
     * 修改的用户
     */
    private String modifiedUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
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
        return "Cimage{" +
            "id=" + id +
            ", uid=" + uid +
            ", name=" + name +
            ", localPath=" + localPath +
            ", projectPath=" + projectPath +
            ", domain=" + domain +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", createdUser=" + createdUser +
            ", modifiedUser=" + modifiedUser +
        "}";
    }
}
