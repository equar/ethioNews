package com.ethionews.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ethionews.model.Record;
import com.ethionews.model.User;

@Repository
public class HibernateUtil {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public <T> Serializable create(final T entity) {
		return sessionFactory.getCurrentSession().save(entity);
	}

	public <T> Serializable create(final T entity, int count) {
		if (count % 10 == 0) {
			sessionFactory.getCurrentSession().flush();
		}
		return sessionFactory.getCurrentSession().save(entity);
	}

	public <T> T update(final T entity) {
		sessionFactory.getCurrentSession().update(entity);
		return entity;
	}

	public <T> void update(String query) {
		sessionFactory.getCurrentSession().createNativeQuery(query);

	}

	public <T> void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> fetchAll(Class<T> entityClass) {
		return sessionFactory.getCurrentSession().createQuery(" FROM " + entityClass.getName()).getResultList();
	}

	@SuppressWarnings("rawtypes")
	public <T> List fetchAll(String query) {
		return sessionFactory.getCurrentSession().createNativeQuery(query).getResultList();

	}

	@SuppressWarnings({ "unchecked" })
	public List<User> fetchAllHql(String query) {
		return sessionFactory.getCurrentSession().createQuery(query).getResultList();

	}

	public <T> T fetchById(Serializable id, Class<T> entityClass) {
		return (T) sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Record> getPaginatedResults(Integer offset, Integer maxResults, String query) {
		return sessionFactory.getCurrentSession().createQuery(query).setFirstResult(offset != null ? offset : 0)
				.setMaxResults(maxResults != null ? maxResults : 10).list();
	}

	@SuppressWarnings("deprecation")
	public Long count(Class<Record> className) {
		return (Long) sessionFactory.getCurrentSession().createCriteria(className).setProjection(Projections.rowCount())
				.uniqueResult();
	}

}
