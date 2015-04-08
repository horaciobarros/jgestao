package controleInterno.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;


/**
 * Implementação do DAO genérico com os métodos necessários para as implementações de DAO do sistema. É necessário
 * herdar esta classe JpaDao<T> para implementar um DAO específico.
 * 
 * 
 * @author felipe.almeida, ivaldo.oliveira - Equipe DATASUS
 * 
 * @param <T>
 *            Classe da entidade
 * 
 */
@Repository("dao")
@Scope(proxyMode = ScopedProxyMode.NO, value = "prototype")
public class JpaDao<T> implements Dao<T> {

	private static final long serialVersionUID = 6907111403428623938L;

	private Class<T> persistentClass;

	//@PersistenceContext
	//private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> find(String queryStr, Object... params) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryStr);
		setQueryParams(query, params);
		List<?> objetos = query.list();
		tx.commit();
		return objetos;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public T findById(Serializable id) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNamedParams(String queryStr, Map<String, Object> params) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = this.sessionFactory.getCurrentSession().createQuery(queryStr);
		setQueryParams(query, params);
		List<T> objetos = query.list();
		tx.commit();
		return objetos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedParams(String queryname, Paginacao paginacao, Map<String, Object> params) {
		return null;
	}

	@Override
	public List<T> findByNamedQuery(String namedQuery, Object... params) {
		return findByNamedQuery(namedQuery, null, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNamedQuery(String namedQuery, Paginacao paginacao, Object... params) {
		return null;
	}

	@Override
	public List<T> findByNativeQuery(String sql, Object... params) {
		return findByNativeQuery(sql, null, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByNativeQuery(String sql, Paginacao paginacao, Object... params) {
		return null;
	}

	public Object findSingleResult(String queryStr, Object... params) {
		return findSingleResult(queryStr, null, params);
	}

	public Object findSingleResult(String queryStr, Paginacao paginacao, Object... params) {
		return null;
	}

	public final Class<T> getPersistentClass() {
		if (persistentClass == null) {
			throw new RuntimeException("É necessário invocar o método setPersistentClass(Class<T> clazz)");
		}
		return persistentClass;
	}

	/**
	 * Atribuir paginação a query.
	 * 
	 * @param paginacao
	 * @param query
	 */
	private void paginar(Paginacao paginacao, Query query) {
		if (paginacao != null) {
			if (paginacao.getPosicao() != null) {
				query.setFirstResult((int) paginacao.getPosicao());
			}
			if (paginacao.getLimite() != null) {
				query.setMaxResults((int) paginacao.getLimite());
			}
		}
	}

	public void refresh(T entity) {
	}

	@Override
	public void save(T obj) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			this.sessionFactory.getCurrentSession().save(obj);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw e;
		}
		
	}

	public final void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	/**
	 * Atribuir os parâmetros nomeados da query.
	 * 
	 * @param query
	 * @param params
	 */
	private void setQueryParams(Query query, Map<String, Object> params) {
		for (Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Atribuir os parâmetros da query.
	 * 
	 * @param query
	 * @param params
	 */
	private void setQueryParams(Query query, Object... params) {
		if (params != null && params.length > 0) {
			int i = 0;
			for (Object param : params) {
				if (param != null) {
					if ((param instanceof String && ((String) param).trim().isEmpty())) {
						continue;
					}
					i++;
					query.setParameter(i, param);
				}
			}
		}
	}

	/**
	 * Atribuir a Role para as operações solicitadas pelo usuário.
	 * 
	 */
	private void setRole() {
	}

	@Override
	public void update(T obj) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			this.sessionFactory.getCurrentSession().update(obj);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw e;
		}
		
	}
	
	@Override
	public void delete(T obj) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			this.sessionFactory.getCurrentSession().delete(obj);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			throw e;
		}
		
	}

	@Override
	public List<T> findAll(T object) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = this.sessionFactory.getCurrentSession().createQuery("SELECT FROM " + object.getClass().getName());
		List<?> objetos = query.list();
		tx.commit();
		return (List<T>) objetos;
	}

}
