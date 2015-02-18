package controleInterno.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * DAO genérico com os métodos necessários para as implementações dos serviços do sistema
 * 
 * @author alan.lohse, felipe.almeida, ivaldo.oliveira - Equipe DATASUS
 * 
 * @param <T>
 *            Classe da entidade
 */
public interface Dao<T> extends Serializable {

	void delete(T obj);

	List<?> find(String queryStr, Object... params);
	
	List<T> findAll(T obj);
	
	T findById(Serializable id);

	List<T> findByNamedParams(String queryname, Map<String, Object> params);

	List<T> findByNamedParams(String queryname, Paginacao paginacao, Map<String, Object> params);

	List<T> findByNamedQuery(String namedQuery, Object... params);

	List<T> findByNamedQuery(String namedQuery, Paginacao paginacao, Object... params);

	List<T> findByNativeQuery(String sql, Object... params);

	List<T> findByNativeQuery(String sql, Paginacao paginacao, Object... params);

	Object findSingleResult(String queryStr, Object... params);

	Object findSingleResult(String queryStr, Paginacao paginacao, Object... params);

	void refresh(T entity);

	void save(T obj);

	void setPersistentClass(Class<T> persistentClass);

	void update(T obj);

}
