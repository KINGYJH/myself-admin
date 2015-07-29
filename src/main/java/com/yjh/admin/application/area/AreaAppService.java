package com.yjh.admin.application.area;

import com.yjh.admin.application.area.command.AreaListCommand;
import com.yjh.admin.application.area.representation.AreaRepresentation;
import com.yjh.admin.application.shared.command.IMappingService;
import com.yjh.admin.domain.model.area.Area;
import com.yjh.admin.domain.service.area.IAreaService;
import com.yjh.admin.infrastructure.persistence.hibernate.generic.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yjh on 2015/7/28.
 */
@Service("areaAppService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class AreaAppService implements IAreaAppService {

    @Autowired
    private IAreaService areaService;

    @Autowired
    private IMappingService mappingService;


    @Override
    public Pagination<AreaRepresentation> listPagination(AreaListCommand command) {

        command.verifyPage();
        command.verifyPageSize(10);
        Pagination<Area> pagination = areaService.listPagination(command);
        List<AreaRepresentation> dataList = mappingService.mapAsList(pagination.getData(), AreaRepresentation.class);
        return new Pagination<AreaRepresentation>(dataList, pagination.getCount(), pagination.getPage(), pagination.getPageSize());
    }
}
