package com.github.wxiaoqi.security.modules.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 微信用户
 * */
@Table(name = "wx_user")
public class WxUser {
    @Id
    private Integer id;

    /**
     * 微信openid，微信内唯一标识码
     * */
    private String openId;

    /**
     *腾讯体系用户唯一表示，包括公众号，小程序
     * */
    private String unionId;

    /**
     * 基础用户id
     * */
    private Integer baseUserId;

    /**
     * '创建用户'
     * */
    private Date createTime;

    /**
     * '编辑时间'
     * */
    private Date modifyTime;

    /**
     * '创建者id'
     * */
    private Integer createUserId;

    /**
     * '编辑者id'
     * */
    private Integer modifyUserId;

    /**
     * 状态，1：正常,0禁用，-1删除
     * */
    private Integer status;

    /**
     * '备注'
     * */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getBaseUserId() {
        return baseUserId;
    }

    public void setBaseUserId(Integer baseUserId) {
        this.baseUserId = baseUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}