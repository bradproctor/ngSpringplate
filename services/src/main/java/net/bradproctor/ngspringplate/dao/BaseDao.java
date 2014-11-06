package net.bradproctor.ngspringplate.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

public abstract class BaseDao<T>
{
    @Autowired
    protected SessionFactory sessionFactory;

    private Class type;

    public BaseDao(){
        ParameterizedType ptype = (ParameterizedType) getClass().getGenericSuperclass();
        this.type = (Class) ptype.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Criteria createCriteria() throws HibernateException {
        return getSession().createCriteria(type);
    }

    /** crud type methods **/

    public void save(T entity) throws HibernateException
    {
        if(entity != null)
        {
            try {
                Session session = getSession();
                session.saveOrUpdate(entity);
            } catch (HibernateException e) {
                throw e;
            }
        }
    }

    public void saveOrUpdateAll(Collection<T> entities) throws HibernateException
    {
        if(entities != null)
        {
            Session session = getSession();

            for(Object obj : entities) {
                session.saveOrUpdate(obj);
            }
            flushSession();
        }
    }

    /**
     * This method can be used to Copy the state of the given object onto the persistent object with the same identifier.
     * @throws org.hibernate.HibernateException
     */
    @SuppressWarnings("unchecked")
    public T merge(T entity) throws HibernateException {
        T newEntity = null;
        if(entity != null){
            try {
                newEntity = (T) getSession().merge(entity);
            } catch (HibernateException e) {
                throw e;
            }
        }
        return newEntity;
    }

    public void delete(T entity) throws HibernateException {
        if(entity != null){
            try {
                getSession().evict(entity);
                getSession().delete(entity);
            } catch (HibernateException e) {
                throw e;
            }
        }
    }

    public void flushSession() throws HibernateException{
        try {
            getSession().flush();
        } catch(HibernateException he) {
            throw he;
        }
    }

    /** generic lookup methods **/

    @SuppressWarnings("unchecked")
    public List<T> findAll()
    {
        return (List<T>) createCriteria().list();
    }

    public T findByKey(String key) {
        return key == null ? null : findByProperty("key", key);
    }

    @SuppressWarnings("unchecked")
    public T findByPrimaryKey(T entity)
    {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.idEq(getSession().getIdentifier(entity)))
                .setMaxResults(1);
        return (T) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findAllByProperty(String propertyName, Object...value)
    {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in(propertyName, value));
        return (List<T>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public T findByProperty(String propertyName, Object...value)
    {
        Criteria criteria = createCriteria();
        criteria.add(Restrictions.in(propertyName, value));
        List<T> list = criteria.list();
        return ((list.size() > 0) ? list.get(0) : null);
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable object) throws HibernateException {
        T entity = null;
        try {
            if (null != object) {
                Session session = getSession();
                entity = (T) session.get(type, object);
            }
        } catch (HibernateException he) {
            throw he;
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    public T findById(Long id) {
        return (T)getSession().get(type, id);
    }

    @SuppressWarnings("unchecked")
    public T findByProperty(String propertyName, Object value){
        if(null == value || null == propertyName)
            throw new IllegalArgumentException();


        Criteria criteria = createCriteria();
        criteria.add(Restrictions.eq(propertyName, value).ignoreCase());

        List<T> l = criteria.list();

        return l.isEmpty()?null:l.get(0);
    }
}