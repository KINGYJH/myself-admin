package com.yjh.admin.domain.service.area;

import com.yjh.admin.application.area.command.AreaListCommand;
import com.yjh.admin.common.util.CoreStringUtils;
import com.yjh.admin.domain.model.area.Area;
import com.yjh.admin.domain.model.area.IAreaRepository;
import com.yjh.admin.infrastructure.persistence.hibernate.generic.Pagination;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yjh on 2015/7/28.
 */
@Service("areaService")
public class AreaService implements IAreaService {

    @Autowired
    private IAreaRepository areaRepository;

    @Override
    public Pagination<Area> listPagination(AreaListCommand command) {

        List<Criterion> restrictionList = new ArrayList();

        if (!CoreStringUtils.isEmpty(command.getName())) {
            restrictionList.add(Restrictions.like("name",
                    command.getName(),
                    MatchMode.ANYWHERE)); //MatchMode.ANYWHERE相当于 like '%value%'
        }

        Criterion[] criteriaArr = null;

        if (!restrictionList.isEmpty()) {
            criteriaArr = new Criterion[restrictionList.size()];
            restrictionList.toArray(criteriaArr);
        }

        Order[] orders = {Order.asc("priority")};

        return areaRepository.pagination(command.getPage(), command.getPageSize(), criteriaArr, orders);
    }
}
