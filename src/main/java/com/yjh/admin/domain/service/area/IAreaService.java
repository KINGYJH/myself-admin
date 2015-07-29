package com.yjh.admin.domain.service.area;

import com.yjh.admin.application.area.command.AreaListCommand;
import com.yjh.admin.domain.model.area.Area;
import com.yjh.admin.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by yjh on 2015/7/28.
 */
public interface IAreaService {

    Pagination<Area> listPagination(AreaListCommand command);
}
