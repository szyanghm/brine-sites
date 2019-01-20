package com.brine.sys.entity;

import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author brine-yang
 * @since 2019-01-14
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
