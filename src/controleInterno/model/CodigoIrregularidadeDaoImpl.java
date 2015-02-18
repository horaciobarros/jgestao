package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CodigoIrregularidadeDaoImpl implements CodigoIrregularidadeDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	StringBuilder hql;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean existe(CodigoIrregularidade codigoIrregularidade) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("from CodigoIrregularidade d where d.descricao = :pDescricao ");
		query.setParameter("pDescricao", codigoIrregularidade.getDescricao());
		List lista = query.list();
		tx.commit();

		boolean encontrado = !lista.isEmpty();

		return encontrado;
		
	}

	public void adiciona(CodigoIrregularidade codigoIrregularidade) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().save(codigoIrregularidade);
		tx.commit();	
	}

	public void exclui(CodigoIrregularidade codigoIrregularidade) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().delete(codigoIrregularidade);
		tx.commit();
	}
	
	public void altera(CodigoIrregularidade codigoIrregularidade) {

		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(codigoIrregularidade);
		tx.commit();
			
	}
	public List<CodigoIrregularidade> lista() {
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM CodigoIrregularidade d ORDER BY d.codigo");  
		List<CodigoIrregularidade> objetos = query.list();
		tx.commit();
		
		return objetos;
		
	}

	public CodigoIrregularidade buscaCodigoIrregularidade(CodigoIrregularidade d) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("select d from CodigoIrregularidade d where d.descricao = :pDescricao ");
		
		query.setParameter("pDescricao", d.getDescricao());
		List lista = query.list();
		tx.commit();

		return (CodigoIrregularidade) lista.get(0);
	}

	public Object buscaCodigoIrregularidadePeloId(long id) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery(
				"from CodigoIrregularidade c where c.id = :id ");
		query.setParameter("id", id);
		List lista = query.list();
		tx.commit();

		return (CodigoIrregularidade) lista.get(0);
	}

}

