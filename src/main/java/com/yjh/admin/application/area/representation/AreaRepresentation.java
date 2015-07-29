package com.yjh.admin.application.area.representation;

import java.io.Serializable;

/**
 * Created by yjh on 2015/7/28.
 */
public class AreaRepresentation implements Serializable {
    private String id;
    private Integer version;
    private String name;
    private String priority;
    private AreaRepresentation parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public AreaRepresentation getParent() {
        return parent;
    }

    public void setParent(AreaRepresentation parent) {
        this.parent = parent;
    }
}
