package com.hys.mybatis.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ahys
 * @since 2019-02-16
 */
public class MythInventory extends Model<MythInventory> {

    private static final long serialVersionUID = 1L;

    @TableId
    private String transId;

    private String targetClass;

    private String targetMethod;

    private Integer retriedCount;

    private Date createTime;

    private Date lastTime;

    private Integer version;

    private Integer status;

    private Blob invocation;

    private Integer role;

    private String errorMsg;

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }
    public String getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(String targetClass) {
        this.targetClass = targetClass;
    }
    public String getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(String targetMethod) {
        this.targetMethod = targetMethod;
    }
    public Integer getRetriedCount() {
        return retriedCount;
    }

    public void setRetriedCount(Integer retriedCount) {
        this.retriedCount = retriedCount;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Blob getInvocation() {
        return invocation;
    }

    public void setInvocation(Blob invocation) {
        this.invocation = invocation;
    }
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    protected Serializable pkVal() {
        return this.transId;
    }

    @Override
    public String toString() {
        return "MythInventory{" +
        "transId=" + transId +
        ", targetClass=" + targetClass +
        ", targetMethod=" + targetMethod +
        ", retriedCount=" + retriedCount +
        ", createTime=" + createTime +
        ", lastTime=" + lastTime +
        ", version=" + version +
        ", status=" + status +
        ", invocation=" + invocation +
        ", role=" + role +
        ", errorMsg=" + errorMsg +
        "}";
    }
}
