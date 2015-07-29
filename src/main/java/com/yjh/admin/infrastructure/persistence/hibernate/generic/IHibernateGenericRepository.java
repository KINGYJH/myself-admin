package com.yjh.admin.infrastructure.persistence.hibernate.generic;

import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yjh on 2015/7/28.
 */
public interface IHibernateGenericRepository<T, ID extends Serializable> {

    T loadById(ID id);

    T getById(ID id);

    void save(T entity);

    void saveOrUpdate(T entity);

    void update(T entity);

    void delete(T entity);

    void flush();

    void clear();

    void evict(Object obj);

    void refresh(Object obj);

    List<T> findAll();

    //TODO 重构没有传入fetchModeMap的方法
    Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Order[] orders);

    Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Order[] orders,
                             Map<String, FetchMode> fetchModeMap);

    Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Map<String, String> aliasMap, Order[] orders,
                             Map<String, FetchMode> fetchModeMap);

    Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Map<String, String> aliasMap, Order[] orders,
                             Map<String, FetchMode> fetchModeMap,ProjectionList projectionList);
}
