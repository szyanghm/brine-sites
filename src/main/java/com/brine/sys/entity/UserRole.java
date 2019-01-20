package com.brine.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer rid;

    private Integer id;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
        "rid=" + rid +
        ", id=" + id +
        "}";
    }
}
