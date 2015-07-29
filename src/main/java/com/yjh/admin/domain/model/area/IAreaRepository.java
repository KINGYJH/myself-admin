package com.yjh.admin.domain.model.area;

import com.yjh.admin.infrastructure.persistence.hibernate.generic.IHibernateGenericRepository;

import java.io.Serializable;

/**
 * Created by yjh on 2015/7/28.
 */
public interface IAreaRepository<T, ID extends Serializable> extends IHibernateGenericRepository<T, ID> {
}
