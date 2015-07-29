package com.yjh.admin.domain.model.area;

import com.yjh.admin.domain.model.id.ConcurrencySafeEntity;

/**
 * Created by yjh on 2015/7/28.
 */
public class Area extends ConcurrencySafeEntity {

    private String name;
    private String priority;
    private Area parent;

    public Area(){
        super();
    }

    public Area(String name, String priority, Area parent) {
        this.name = name;
        this.priority = priority;
        this.parent = parent;
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

    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Area area = (Area) o;

        if (name != null ? !name.equals(area.name) : area.name != null) return false;
        if (parent != null ? !parent.equals(area.parent) : area.parent != null) return false;
        if (priority != null ? !priority.equals(area.priority) : area.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
