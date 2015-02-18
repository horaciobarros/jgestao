package controleInterno.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import acesso.model.EntidadeDao;

@Repository
public class EntidadeDaoImpl implements EntidadeDao{
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;

	private static final long serialVersionUID = 1L;
	StringBuilder hql;
	
	public boolean existe(Entidade entidade) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("from Entidade e where e.id = :pId ");
		query.setParameter("pId", entidade.getId());
		List lista = query.list();
		tx.commit();

		boolean encontrado = !lista.isEmpty();

		return encontrado;
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void altera(Entidade e) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		getSessionFactory().getCurrentSession().update(e);
		tx.commit();
			
	}
	public List<Entidade> lista() {
		
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession()
				.createQuery("FROM Entidade e ORDER BY e.nome");  
		List<Entidade> objetos = query.list();  
		tx.commit();
		
		return objetos;
		
	}

	public Entidade buscaEntidadeAtiva() {
		// TODO Auto-generated method stub
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		Query query = getSessionFactory().getCurrentSession().createQuery("FROM Entidade e ORDER BY e.nome");  
		List<Entidade> objetos = query.list();  
		tx.commit();
		return objetos.get(0);
	}

}
