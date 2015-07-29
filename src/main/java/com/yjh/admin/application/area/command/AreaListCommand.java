package com.yjh.admin.application.area.command;

import com.yjh.admin.application.shared.command.BasicPaginationCommand;

/**
 * Created by yjh on 2015/7/29.
 */
public class AreaListCommand extends BasicPaginationCommand {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
