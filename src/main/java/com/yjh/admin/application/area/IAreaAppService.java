package com.yjh.admin.application.area;

import com.yjh.admin.application.area.command.AreaListCommand;
import com.yjh.admin.application.area.representation.AreaRepresentation;
import com.yjh.admin.domain.model.area.Area;
import com.yjh.admin.infrastructure.persistence.hibernate.generic.Pagination;

import java.util.List;

/**
 * Created by yjh on 2015/7/28.
 */
public interface IAreaAppService {

    Pagination<AreaRepresentation> listPagination(AreaListCommand command);
}
