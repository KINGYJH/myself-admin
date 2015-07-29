package com.yjh.admin.infrastructure.persistence.hibernate.area;

import com.yjh.admin.domain.model.area.Area;
import com.yjh.admin.domain.model.area.IAreaRepository;
import com.yjh.admin.infrastructure.persistence.hibernate.generic.AbstractHibernateGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yjh on 2015/7/28.
 */
@Repository("areaRepository")
public class AreaRepository extends AbstractHibernateGenericRepository<Area, String> implements IAreaRepository<Area, String> {
}
