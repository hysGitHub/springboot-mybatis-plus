package com.hys.mybatis.mapper.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.sql.Blob;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ahys
 * @since 2019-02-16
 */
public class Myth_inventory_service extends Model<Myth_inventory_service> {

    private static final long serialVersionUID = 1L;

    private String trans_id;

    private String target_class;

    private String target_method;

    private Integer retried_count;

    private LocalDateTime create_time;

    private LocalDateTime last_time;

    private Integer version;

    private Integer status;

    private Blob invocation;

    private Integer role;

    private String error_msg;

    public String getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }
    public String getTarget_class() {
        return target_class;
    }

    public void setTarget_class(String target_class) {
        this.target_class = target_class;
    }
    public String getTarget_method() {
        return target_method;
    }

    public void setTarget_method(String target_method) {
        this.target_method = target_method;
    }
    public Integer getRetried_count() {
        return retried_count;
    }

    public void setRetried_count(Integer retried_count) {
        this.retried_count = retried_count;
    }
    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }
    public LocalDateTime getLast_time() {
        return last_time;
    }

    public void setLast_time(LocalDateTime last_time) {
        this.last_time = last_time;
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
    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    @Override
    protected Serializable pkVal() {
        return this.trans_id;
    }

    @Override
    public String toString() {
        return "Myth_inventory_service{" +
        "trans_id=" + trans_id +
        ", target_class=" + target_class +
        ", target_method=" + target_method +
        ", retried_count=" + retried_count +
        ", create_time=" + create_time +
        ", last_time=" + last_time +
        ", version=" + version +
        ", status=" + status +
        ", invocation=" + invocation +
        ", role=" + role +
        ", error_msg=" + error_msg +
        "}";
    }
}
