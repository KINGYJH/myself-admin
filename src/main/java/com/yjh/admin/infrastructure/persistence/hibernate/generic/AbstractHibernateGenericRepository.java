package com.yjh.admin.infrastructure.persistence.hibernate.generic;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;


/**
 * Created by yjh on 2015/7/28.
 */
@Repository
public abstract class AbstractHibernateGenericRepository<T, ID extends Serializable> implements IHibernateGenericRepository<T, ID> {

    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractHibernateGenericRepository() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    @Override
    public void evict(Object obj) {
        getSession().evict(obj);
    }

    @Override
    public void refresh(Object obj) {
        getSession().refresh(obj);
    }

    @Override
    public T loadById(ID id) {
        return (T) getSession().load(getPersistentClass(), id);
    }

    @Override
    public T getById(ID id) {
        return (T) getSession().get(getPersistentClass(), id);
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void save(T entity) {
        getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public List<T> findAll() {
        return getSession().createCriteria(getPersistentClass()).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Order[] orders) {
        return pagination(page, pageSize, criteria, null, orders, null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Order[] orders,
                                    Map<String, FetchMode> fetchModeMap) {
        return pagination(page, pageSize, criteria, null, orders, fetchModeMap);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Map<String, String> aliasMap,
                                    Order[] orders, Map<String, FetchMode> fetchModeMap) {

        return pagination(page, pageSize, criteria, aliasMap, orders, fetchModeMap, null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Pagination<T> pagination(int page, int pageSize, Criterion[] criteria, Map<String, String> aliasMap,
                                    Order[] orders, Map<String, FetchMode> fetchModeMap, ProjectionList projectionList) {

        Criteria criteriaCount = getSession().createCriteria(getPersistentClass()).
                setProjection(Projections.rowCount());

        Criteria criteriaSearch = getSession().createCriteria(getPersistentClass());

        if (null != aliasMap) {
            for (Map.Entry<String, String> entry : aliasMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                criteriaCount.createAlias(key, value);
                criteriaSearch.createAlias(key, value);
            }
        }

        if (null != criteria) {
            for (Criterion criterion : criteria) {
                criteriaCount.add(criterion);
                criteriaSearch.add(criterion);
            }
        }

        if (null != orders) {
            for (Order order : orders) {
                criteriaSearch.addOrder(order);
            }
        }

        if (null != fetchModeMap) {
            for (Map.Entry<String, FetchMode> entry : fetchModeMap.entrySet()) {
                String key = entry.getKey();
                FetchMode value = entry.getValue();
                criteriaCount.setFetchMode(key, value);
                criteriaSearch.setFetchMode(key, value);
            }
        }

        if (null != projectionList) {
            criteriaCount.setProjection(projectionList);
            criteriaSearch.setProjection(projectionList);
        }

        int count = ((Long) criteriaCount.uniqueResult()).intValue();

        int firstResult = (page - 1) * pageSize;

        criteriaSearch.setFirstResult(firstResult).setMaxResults(pageSize);
        return new Pagination<T>(criteriaSearch.list(), count, page, pageSize);
    }
}